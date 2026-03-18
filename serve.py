#!/usr/bin/env python3
"""
简单的 HTTP 文件服务器
用于提供 APK 下载链接
"""

import http.server
import socketserver
import os
import sys

PORT = 8888
DIRECTORY = os.path.dirname(os.path.abspath(__file__))

class Handler(http.server.SimpleHTTPRequestHandler):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, directory=DIRECTORY, **kwargs)
    
    def do_GET(self):
        # 添加 CORS 头
        self.send_response(200)
        self.send_header('Access-Control-Allow-Origin', '*')
        self.end_headers()
        return super().do_GET()

if __name__ == "__main__":
    with socketserver.TCPServer(("", PORT), Handler) as httpd:
        print(f"🚀 文件服务器已启动")
        print(f"📁 目录：{DIRECTORY}")
        print(f"🌐 访问地址:")
        print(f"   预览页面：http://localhost:{PORT}/preview.html")
        print(f"   项目文件：http://localhost:{PORT}/")
        print(f"\n按 Ctrl+C 停止服务器")
        
        try:
            httpd.serve_forever()
        except KeyboardInterrupt:
            print("\n✅ 服务器已停止")
            sys.exit(0)
