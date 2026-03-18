# 💰 黄金价格 App

一个简洁美观的安卓应用，实时显示黄金价格。

## 🚀 快速构建

### 方式一：GitHub Actions 自动构建（推荐）

无需安装任何软件，自动构建并下载 APK！

📖 **详细指南**: [GitHub 构建指南.md](GitHub 构建指南.md)

**步骤概览**：
```bash
# 1. 创建 GitHub 仓库
# 2. 推送代码
git init
git add .
git commit -m "初始提交"
git remote add origin https://github.com/用户名/gold-price-app.git
git push -u origin main

# 3. 等待自动构建（5-10 分钟）
# 4. 从 Actions 或 Releases 下载 APK
```

### 方式二：Android Studio 本地构建

1. 下载安装 [Android Studio](https://developer.android.com/studio)
2. 打开项目文件夹
3. 点击 `Build → Build APK(s)`

## 📱 界面预览

## ✨ 特性

- 🎨 **精美 UI 设计** - 采用渐变色背景和卡片式设计
- 📊 **实时价格** - 从国际黄金 API 获取实时数据
- 📱 **多机型适配** - 兼容 Android 7.0+ 的主流机型
- 🔄 **一键刷新** - 手动刷新价格数据
- 🌙 **深色主题** - 护眼深色模式

## 🛠️ 技术栈

- **语言**: Kotlin
- **UI 框架**: Jetpack Compose
- **最低版本**: Android 7.0 (API 24)
- **目标版本**: Android 14 (API 34)

## 📦 构建 APK

### 方法一：Android Studio（推荐）

1. **安装 Android Studio**
   - 下载地址：https://developer.android.com/studio

2. **打开项目**
   ```
   文件 → 打开 → 选择 gold-price-app 文件夹
   ```

3. **等待 Gradle 同步**
   - 首次打开会自动下载依赖，可能需要几分钟

4. **构建 APK**
   ```
   Build → Build Bundle(s) / APK(s) → Build APK(s)
   ```

5. **获取 APK 文件**
   - 位置：`app/build/outputs/apk/debug/app-debug.apk`

### 方法二：命令行构建

```bash
cd gold-price-app

# macOS/Linux
./gradlew assembleDebug

# Windows
gradlew.bat assembleDebug
```

APK 输出位置：`app/build/outputs/apk/debug/app-debug.apk`

## 📲 安装到手机

1. 将 APK 文件传输到手机
2. 在手机设置中允许"安装未知来源应用"
3. 点击 APK 文件进行安装

## 🎨 界面设计

### 配色方案
- **背景渐变**: #1A1A2E → #16213E → #0F3460
- **主色调**: #FFD700 (金色)
- **强调色**: #FFA500 (橙金色)

### 布局结构
```
┌─────────────────┐
│   💰 黄金价格    │
│                 │
│  ┌───────────┐  │
│  │    ¥      │  │
│  │   550     │  │
│  │  元/克    │  │
│  └───────────┘  │
│                 │
│ 更新时间：...   │
│                 │
│ [🔄 刷新价格]   │
└─────────────────┘
```

## 🔧 自定义

### 修改应用名称
编辑 `app/src/main/res/values/strings.xml`
```xml
<string name="app_name">你的应用名称</string>
```

### 修改颜色
编辑 `app/src/main/res/values/colors.xml`

### 修改 API 端点
编辑 `MainActivity.kt` 中的 `fetchGoldPrice` 函数

## 📝 注意事项

1. **网络权限**: 应用需要联网获取黄金价格
2. **API 限制**: 免费 API 可能有调用次数限制
3. **价格单位**: 显示为人民币/克（由美元/盎司转换）

## 📄 许可证

MIT License

## 🤝 贡献

欢迎提交 Issue 和 Pull Request！

---

**开发者**: OpenClaw Assistant  
**创建日期**: 2026-03-18
