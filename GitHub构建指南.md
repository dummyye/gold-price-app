# 🚀 GitHub Actions 自动构建 APK 指南

## 📋 步骤总览

```
1. 创建 GitHub 账号 → 2. 创建仓库 → 3. 推送代码 → 4. 自动构建 → 5. 下载 APK
```

---

## 步骤 1：创建 GitHub 账号

如果你还没有 GitHub 账号：

1. 访问 https://github.com
2. 点击 "Sign up"
3. 填写邮箱、密码、用户名
4. 验证邮箱
5. 完成！

**已有账号可跳过此步骤**

---

## 步骤 2：创建新仓库

### 2.1 登录 GitHub
访问 https://github.com 并登录

### 2.2 创建仓库
1. 点击右上角 **+** → **New repository**
2. 填写仓库信息：
   - **Repository name**: `gold-price-app`（或其他你喜欢的名字）
   - **Description**: `黄金价格安卓应用`
   - **Visibility**: 选择 **Public**（公开）或 **Private**（私有）
   - **不要勾选** "Initialize this repository with a README"
3. 点击 **Create repository**

---

## 步骤 3：推送代码到 GitHub

### 方法 A：使用 Git 命令行（推荐）

#### 3.1 安装 Git
- **Windows**: https://git-scm.com/download/win
- **macOS**: `brew install git`
- **Linux**: `sudo apt install git` 或 `sudo yum install git`

#### 3.2 打开终端/命令提示符

#### 3.3 进入项目目录
```bash
cd /home/admin/.openclaw/workspace/gold-price-app
```

#### 3.4 初始化 Git 仓库
```bash
git init
```

#### 3.5 添加所有文件
```bash
git add .
```

#### 3.6 提交代码
```bash
git commit -m "初始提交：黄金价格应用"
```

#### 3.7 关联远程仓库
```bash
git remote add origin https://github.com/YOUR_USERNAME/gold-price-app.git
```
> ⚠️ 将 `YOUR_USERNAME` 替换为你的 GitHub 用户名

#### 3.8 推送代码
```bash
git branch -M main
git push -u origin main
```

### 方法 B：使用 GitHub Desktop（图形界面）

#### 3.1 下载 GitHub Desktop
- 访问 https://desktop.github.com
- 下载并安装

#### 3.2 添加项目
1. 打开 GitHub Desktop
2. 点击 **File** → **Add Local Repository**
3. 选择 `gold-price-app` 文件夹
4. 点击 **Add repository**

#### 3.3 提交并推送
1. 在左下角填写摘要：`初始提交：黄金价格应用`
2. 点击 **Commit to main**
3. 点击 **Publish repository**
4. 选择仓库名称和可见性
5. 点击 **Publish repository**

### 方法 C：直接上传文件（最简单，适合新手）

#### 3.1 在仓库页面
1. 进入你刚创建的仓库
2. 点击 **uploading an existing file**

#### 3.2 上传文件
1. 将 `gold-price-app` 文件夹中的所有文件拖拽到上传区域
2. 等待上传完成
3. 填写提交信息：`初始提交：黄金价格应用`
4. 点击 **Commit changes**

> ⚠️ 注意：确保上传包括 `.github` 隐藏文件夹！

---

## 步骤 4：自动构建

### 4.1 触发构建

推送代码后，GitHub Actions 会**自动触发构建**！

你也可以手动触发：
1. 进入仓库页面
2. 点击 **Actions** 标签
3. 点击左侧 **Build Android APK**
4. 点击 **Run workflow** → **Run workflow**

### 4.2 查看构建进度

1. 点击 **Actions** 标签
2. 点击正在运行的工作流（绿色/黄色/红色圆点）
3. 查看实时日志

构建过程：
- ✅ 检出代码
- ✅ 设置 Java JDK 17
- ✅ 设置 Gradle
- ✅ 构建 APK
- ✅ 上传 APK

**首次构建约需 5-10 分钟**（需要下载 Android SDK 和依赖）

### 4.3 构建成功

看到绿色 ✅ 表示构建成功！

---

## 步骤 5：下载 APK

### 方式 A：从 Actions 下载（每次构建）

1. 进入 **Actions** 标签
2. 点击成功的构建（绿色 ✅）
3. 在页面底部找到 **Artifacts**
4. 点击 **app-debug** 下载 APK
5. 解压 ZIP 文件得到 `app-debug.apk`

> ⚠️ 注意：Artifacts 保留 30 天

### 方式 B：从 Releases 下载（推荐，永久保存）

每次推送到 main/master 分支会自动创建 Release：

1. 进入仓库页面
2. 点击右侧 **Releases**
3. 选择最新版本
4. 点击 **app-debug.apk** 下载

---

## 📱 安装到手机

### 1. 传输 APK 到手机
- 微信/QQ 文件传输
- USB 数据线
- 云盘下载

### 2. 允许安装未知来源
- 进入手机设置
- 搜索"未知来源"或"安装未知应用"
- 允许文件管理器/微信安装应用

### 3. 安装
- 找到 APK 文件
- 点击安装
- 完成！

---

## 🔄 更新应用

### 修改代码后重新构建

#### 1. 修改代码
编辑项目中的任何文件

#### 2. 提交更改
```bash
git add .
git commit -m "更新说明"
git push
```

#### 3. 自动构建
GitHub Actions 会自动触发新的构建

#### 4. 下载新 APK
从 Actions 或 Releases 下载最新版本

---

## ⚙️ 自定义构建配置

### 修改应用名称
编辑 `app/src/main/res/values/strings.xml`
```xml
<string name="app_name">你的应用名称</string>
```

### 修改版本号
编辑 `app/build.gradle.kts`
```kotlin
versionCode = 2
versionName = "1.1"
```

### 修改 API 端点
编辑 `MainActivity.kt` 中的 `fetchGoldPrice` 函数

---

## 🐛 常见问题

### Q: Actions 显示红色 ❌ 构建失败？

**A**: 点击失败的构建查看详情，常见原因：
- 网络连接问题（重试即可）
- 代码有语法错误（检查 MainActivity.kt）
- Gradle 配置问题（检查 build.gradle.kts）

### Q: 找不到 .github 文件夹？

**A**: 这是隐藏文件夹，显示隐藏文件：
- **Windows**: 文件资源管理器 → 查看 → 勾选"隐藏的项目"
- **macOS**: Finder 中按 `Cmd + Shift + .`
- **Linux**: `ls -la`

### Q: 构建太慢？

**A**: 
- 首次构建需要下载大量依赖（正常）
- 后续构建会使用缓存（快很多）
- 可以使用 GitHub Codespaces 加速

### Q: 如何构建 Release 版本（正式签名版）？

**A**: 需要配置签名密钥，详见：
https://docs.github.com/en/actions/deployment/deploying-to-your-customer

---

## 📚 相关资源

- [GitHub Actions 文档](https://docs.github.com/en/actions)
- [Android 开发文档](https://developer.android.com)
- [Gradle 文档](https://docs.gradle.org)

---

## 🎉 完成！

现在你已经掌握了：
- ✅ 创建 GitHub 仓库
- ✅ 推送代码
- ✅ 自动构建 APK
- ✅ 下载和安装

**享受你的黄金价格应用吧！** 💰

---

**创建日期**: 2026-03-18  
**作者**: OpenClaw Assistant
