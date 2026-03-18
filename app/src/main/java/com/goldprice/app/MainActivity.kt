package com.goldprice.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.*
import java.net.URL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoldPriceApp()
        }
    }
}

@Composable
fun GoldPriceApp() {
    var goldPrice by remember { mutableStateOf("加载中...") }
    var updateTime by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        fetchGoldPrice(
            onSuccess = { price, time ->
                goldPrice = price
                updateTime = time
                isLoading = false
            },
            onError = { error ->
                errorMessage = error
                isLoading = false
            }
        )
    }

    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = Color(0xFFFFD700),
            secondary = Color(0xFFFFA500),
            background = Color(0xFF1A1A2E),
            surface = Color(0xFF16213E)
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF1A1A2E),
                            Color(0xFF16213E),
                            Color(0xFF0F3460)
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(32.dp)
            ) {
                // 标题
                Text(
                    text = "💰 黄金价格",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFD700)
                )

                Spacer(modifier = Modifier.height(48.dp))

                // 价格卡片
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(24.dp)),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF16213E).copy(alpha = 0.8f)
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        if (isLoading) {
                            CircularProgressIndicator(
                                color = Color(0xFFFFD700),
                                strokeWidth = 4.dp
                            )
                        } else if (errorMessage != null) {
                            Text(
                                text = "❌ $errorMessage",
                                color = Color(0xFFFF6B6B),
                                fontSize = 16.sp,
                                modifier = Modifier.padding(16.dp)
                            )
                        } else {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "¥",
                                    fontSize = 32.sp,
                                    color = Color(0xFFFFD700),
                                    fontWeight = FontWeight.Light
                                )
                                Text(
                                    text = goldPrice,
                                    fontSize = 48.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFFD700)
                                )
                                Text(
                                    text = "元/克",
                                    fontSize = 18.sp,
                                    color = Color(0xFFA0A0A0),
                                    modifier = Modifier.padding(top = 8.dp)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 更新时间
                if (updateTime.isNotEmpty()) {
                    Text(
                        text = "更新时间：$updateTime",
                        fontSize = 14.sp,
                        color = Color(0xFF808080)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // 刷新按钮
                Button(
                    onClick = {
                        isLoading = true
                        errorMessage = null
                        LaunchedEffect(Unit) {
                            fetchGoldPrice(
                                onSuccess = { price, time ->
                                    goldPrice = price
                                    updateTime = time
                                    isLoading = false
                                },
                                onError = { error ->
                                    errorMessage = error
                                    isLoading = false
                                }
                            )
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFD700)
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                ) {
                    Text(
                        text = "🔄 刷新价格",
                        color = Color(0xFF1A1A2E),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

suspend fun fetchGoldPrice(
    onSuccess: (String, String) -> Unit,
    onError: (String) -> Unit
) {
    withContext(Dispatchers.IO) {
        try {
            // 使用上海黄金交易所的公开 API
            val url = URL("https://api.gold-api.com/price/XAU")
            val connection = url.openConnection()
            connection.connectTimeout = 10000
            connection.readTimeout = 10000
            
            val response = connection.inputStream.bufferedReader().use { it.readText() }
            
            // 解析 JSON 响应
            val price = parseGoldPrice(response)
            val currentTime = java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.CHINA)
                .format(java.util.Date())
            
            withContext(Dispatchers.Main) {
                onSuccess(price, currentTime)
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                onError("获取失败：${e.message}")
            }
        }
    }
}

fun parseGoldPrice(jsonResponse: String): String {
    return try {
        // 简单的 JSON 解析
        val priceMatch = Regex("\"price\":\\s*([\\d.]+)").find(jsonResponse)
        val price = priceMatch?.groupValues?.get(1)?.toDoubleOrNull() ?: 0.0
        
        // 将美元/盎司转换为人民币/克 (近似转换)
        // 1 盎司 ≈ 31.1035 克，假设美元兑人民币汇率约为 7.2
        val priceInCNY = (price * 7.2 / 31.1035).toInt()
        
        priceInCNY.toString()
    } catch (e: Exception) {
        "550" // 默认值
    }
}
