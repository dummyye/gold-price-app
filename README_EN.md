# 💰 Gold Price App

A clean and beautiful Android app that displays real-time gold prices.

## 🚀 Quick Build

### Option 1: GitHub Actions (Recommended) ⭐

No software installation needed, automatic build and download!

**Steps**:
```bash
# 1. Create GitHub repository
# 2. Push code
git init
git add .
git commit -m "Initial commit"
git remote add origin https://github.com/username/gold-price-app.git
git push -u origin main

# 3. Wait for auto-build (5-10 min)
# 4. Download APK from Actions or Releases
```

📖 **Detailed Guide**: [QUICKSTART.md](QUICKSTART.md)

### Option 2: Android Studio

1. Download [Android Studio](https://developer.android.com/studio)
2. Open `gold-price-app` folder
3. Click `Build → Build APK(s)`

## ✨ Features

- 🎨 **Beautiful UI** - Material Design 3 with dark theme
- 📊 **Real-time Price** - Live gold price from international API
- 📱 **Wide Compatibility** - Works on Android 7.0+ (99% of phones)
- 🔄 **One-tap Refresh** - Manual price update
- 🌐 **Multi-language** - Chinese interface

## 📱 Compatibility

- ✅ Huawei, Xiaomi, OPPO, vivo, Samsung
- ✅ OnePlus, Honor, Meizu, Sony, LG
- ✅ Google Pixel and more
- ✅ Android 7.0 (API 24) and above

## 📦 Project Structure

```
gold-price-app/
├── app/                          # Android app code
│   ├── src/main/java/.../        # Kotlin source
│   ├── src/main/res/             # Resources
│   └── build.gradle.kts          # Build config
├── .github/workflows/            # GitHub Actions
│   └── build-apk.yml             # Auto-build config
├── index.html                    # Preview page
├── README.md                     # Documentation (Chinese)
├── README_EN.md                  # This file (English)
└── QUICKSTART.md                 # Quick start guide
```

## 🎨 UI Design

- **Background**: Dark gradient (#1A1A2E → #16213E → #0F3460)
- **Primary Color**: Gold (#FFD700)
- **Style**: Material Design 3 cards
- **Layout**: Centered price display with refresh button

## 🔧 Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Design**: Material Design 3
- **Min SDK**: Android 7.0 (API 24)
- **Target SDK**: Android 14 (API 34)

## 📖 Documentation

- [开始构建.md](开始构建.md) - Chinese build guide
- [QUICKSTART.md](QUICKSTART.md) - English quick guide
- [GitHub 构建指南.md](GitHub 构建指南.md) - Detailed Chinese guide
- [使用说明.md](使用说明.md) - User manual (Chinese)
- [项目说明.md](项目说明.md) - Project overview (Chinese)

## 🌐 Online Preview

**Preview Page**: http://47.103.43.217:8888/index.html

## 📱 Installation

1. **Download APK** from GitHub Actions or Releases
2. **Transfer to phone** via USB/WeChat/QQ/Cloud
3. **Allow installation** - Settings → Security → Unknown Sources
4. **Install** - Click APK → Install
5. **Open** - Find "黄金价格" icon

## ⚠️ Notes

- Network permission required for fetching prices
- Price is for reference only (not for trading)
- Manual refresh recommended

## 📄 License

MIT License

---

**Created**: 2026-03-18  
**Developer**: OpenClaw Assistant  
**Tech Stack**: Kotlin + Jetpack Compose + Material Design 3 + GitHub Actions
