#!/bin/bash

# 黄金价格应用 - 一键推送到 GitHub
# 使用指南：./一键推送.sh 你的 GitHub 用户名

set -e

RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

echo -e "${BLUE}================================${NC}"
echo -e "${BLUE}  黄金价格应用 - GitHub 推送脚本${NC}"
echo -e "${BLUE}================================${NC}"
echo ""

# 检查参数
if [ -z "$1" ]; then
    echo -e "${RED}❌ 错误：请提供 GitHub 用户名${NC}"
    echo ""
    echo "用法：$0 <GitHub 用户名>"
    echo "例如：$0 dummyye"
    echo ""
    exit 1
fi

GITHUB_USERNAME=$1
REPO_NAME="gold-price-app"
REPO_URL="https://github.com/${GITHUB_USERNAME}/${REPO_NAME}.git"

echo -e "${YELLOW}📋 配置信息:${NC}"
echo "   GitHub 用户名：${GITHUB_USERNAME}"
echo "   仓库名称：${REPO_NAME}"
echo "   仓库地址：${REPO_URL}"
echo ""

# 检查 Git 是否安装
if ! command -v git &> /dev/null; then
    echo -e "${RED}❌ 错误：未找到 Git${NC}"
    echo ""
    echo "请先安装 Git:"
    echo "  - Windows: https://git-scm.com/download/win"
    echo "  - macOS: brew install git"
    echo "  - Linux: sudo apt install git 或 sudo yum install git"
    echo ""
    exit 1
fi

echo -e "${GREEN}✅ Git 已安装${NC}"
echo ""

# 检查是否在正确的目录
if [ ! -f "app/build.gradle.kts" ]; then
    echo -e "${RED}❌ 错误：请在项目根目录运行此脚本${NC}"
    echo "   当前目录：$(pwd)"
    echo ""
    exit 1
fi

echo -e "${GREEN}✅ 项目目录正确${NC}"
echo ""

# 初始化 Git 仓库（如果还没有）
if [ ! -d ".git" ]; then
    echo -e "${YELLOW}📦 初始化 Git 仓库...${NC}"
    git init
    echo -e "${GREEN}✅ Git 仓库已初始化${NC}"
    echo ""
else
    echo -e "${GREEN}✅ Git 仓库已存在${NC}"
    echo ""
fi

# 添加所有文件
echo -e "${YELLOW}📝 添加文件...${NC}"
git add .
echo -e "${GREEN}✅ 文件已添加${NC}"
echo ""

# 提交
echo -e "${YELLOW}💾 提交代码...${NC}"
git commit -m "初始提交：黄金价格应用" || {
    echo -e "${YELLOW}⚠️  没有需要提交的更改（可能已经提交过）${NC}"
}
echo ""

# 设置默认分支为 main
echo -e "${YELLOW}🔧 设置默认分支...${NC}"
git branch -M main 2>/dev/null || true
echo -e "${GREEN}✅ 分支已设置${NC}"
echo ""

# 添加远程仓库
echo -e "${YELLOW}🔗 关联远程仓库...${NC}"
if git remote | grep -q "^origin$"; then
    echo -e "${YELLOW}⚠️  origin 远程仓库已存在，更新地址...${NC}"
    git remote set-url origin "${REPO_URL}"
else
    git remote add origin "${REPO_URL}"
fi
echo -e "${GREEN}✅ 远程仓库已关联${NC}"
echo ""

# 推送
echo -e "${YELLOW}🚀 推送到 GitHub...${NC}"
echo ""
echo -e "${BLUE}💡 提示：${NC}"
echo "   首次推送需要输入 GitHub 用户名和密码"
echo "   如果使用双因素认证，需要使用 Personal Access Token"
echo ""
echo -e "${YELLOW}   创建 Token: https://github.com/settings/tokens${NC}"
echo ""

git push -u origin main

# 检查推送结果
if [ $? -eq 0 ]; then
    echo ""
    echo -e "${GREEN}================================${NC}"
    echo -e "${GREEN}  ✅ 推送成功！${NC}"
    echo -e "${GREEN}================================${NC}"
    echo ""
    echo -e "${BLUE}📱 下一步操作:${NC}"
    echo ""
    echo "   1. 访问仓库查看代码:"
    echo -e "      ${BLUE}${REPO_URL}${NC}"
    echo ""
    echo "   2. 查看构建进度:"
    echo -e "      ${BLUE}${REPO_URL}/actions${NC}"
    echo ""
    echo "   3. 等待 5-10 分钟，构建完成后下载 APK"
    echo ""
    echo -e "${YELLOW}🎉 恭喜！你的应用正在自动构建中！${NC}"
    echo ""
else
    echo ""
    echo -e "${RED}================================${NC}"
    echo -e "${RED}  ❌ 推送失败${NC}"
    echo -e "${RED}================================${NC}"
    echo ""
    echo "可能的原因:"
    echo "  1. 网络连接问题"
    echo "  2. GitHub 账号密码错误"
    echo "  3. 仓库不存在"
    echo "  4. 需要 Personal Access Token"
    echo ""
    echo "解决方案:"
    echo "  1. 检查网络连接"
    echo "  2. 确认 GitHub 账号密码正确"
    echo "  3. 在 GitHub 上手动创建仓库"
    echo "  4. 使用 Token 代替密码:"
    echo "     https://github.com/settings/tokens"
    echo ""
    exit 1
fi
