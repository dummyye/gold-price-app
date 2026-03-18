# 🚀 Quick Start - Build APK in 3 Steps

## 📋 Choose Your Method

| Method | Difficulty | Time | Recommended |
|--------|------------|------|-------------|
| **GitHub Actions** | ⭐⭐ | 5-10 min | ✅ Best |
| **One-Click Script** | ⭐ | 5-10 min | ✅ Easiest |
| **Android Studio** | ⭐⭐⭐ | 10-15 min | For developers |

---

## 🚀 Method 1: One-Click Push Script (Easiest)

### Prerequisites
- GitHub account
- Git installed

### Steps

#### 1️⃣ Create GitHub Repository
1. Visit https://github.com/new
2. Repository name: `gold-price-app`
3. Choose **Public** or **Private**
4. **DO NOT** check "Initialize with README"
5. Click **Create repository**

#### 2️⃣ Run Push Script
```bash
cd /home/admin/.openclaw/workspace/gold-price-app
./一键推送.sh your-github-username
```

Example:
```bash
./一键推送.sh dummyye
```

#### 3️⃣ Wait for Build
1. Visit `https://github.com/your-username/gold-price-app/actions`
2. Wait 5-10 minutes
3. Green ✅ means build successful

#### 4️⃣ Download APK
- **Option A**: Actions → Click build → Artifacts at bottom → app-debug
- **Option B**: Releases → Select version → app-debug.apk

---

## 🚀 Method 2: Manual Push (For Git users)

### Steps

#### 1️⃣ Create GitHub Repository
Same as above

#### 2️⃣ Push Code
```bash
cd /home/admin/.openclaw/workspace/gold-price-app

# Initialize
git init

# Add files
git add .

# Commit
git commit -m "Initial commit: Gold Price App"

# Set branch
git branch -M main

# Add remote (replace username)
git remote add origin https://github.com/your-username/gold-price-app.git

# Push
git push -u origin main
```

#### 3️⃣ Wait & Download
Same as above

---

## 🚀 Method 3: Android Studio (For developers)

### Steps

#### 1️⃣ Download Android Studio
https://developer.android.com/studio

#### 2️⃣ Open Project
- File → Open → Select `gold-price-app` folder

#### 3️⃣ Wait for Gradle Sync
First time: 5-10 minutes to download dependencies

#### 4️⃣ Build APK
- Build → Build Bundle(s) / APK(s) → Build APK(s)

#### 5️⃣ Find APK
`app/build/outputs/apk/debug/app-debug.apk`

---

## 📱 Install to Phone

### 1. Transfer APK
- WeChat/QQ file transfer
- USB cable
- Cloud storage

### 2. Allow Installation
Settings → Security → Allow Unknown Sources

### 3. Install
Click APK file → Install

---

## ⚠️ Troubleshooting

### Q: Password required when pushing?

**A**: 
- Enter GitHub password
- If 2FA enabled, use [Personal Access Token](https://github.com/settings/tokens)
- Token permissions: check `repo` and `workflow`

### Q: Build failed?

**A**:
1. Click failed build to see details
2. Common issues:
   - Network problem → Retry
   - Code error → Check logs
3. I can help if you need

### Q: Can't find .github folder?

**A**: It's a hidden folder
- Windows: View → Check "Hidden items"
- macOS: Cmd + Shift + .
- Linux: ls -la

---

## 🎉 Done!

After successful build you get:
- ✅ `app-debug.apk` file
- ✅ Installable on any Android phone
- ✅ Real-time gold price display

---

## 📞 Need Help?

If you encounter issues:
1. Check [GitHub 构建指南.md](GitHub 构建指南.md) (Chinese guide)
2. Check [README.md](README.md)
3. Check Actions build logs

---

**Good luck!** 🚀
