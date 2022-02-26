# selenium-demo

使用 selenium 连接到 electron。

- browser 是带有窗口最大化支持的 electron 定制版
- selenium-demo 是 java 实现的连接代码。通过 remote webdrvier 方式连接，需要先启动 electron 专用 webdrvier。

相关文档可以看这里：https://www.electronjs.org/docs/latest/tutorial/automated-testing

🚧🚧 有网页自动需求，推荐使用 selenium + chrome 组合，这个只是 demo，用于功能演示 🚧🚧

## 构建

```sh
# just 命令可以到 https://github.com/casey/just 下载
just
```

## 部署

需要安装的软件有 jdk11、electron、electron 对于版本的 webdriver。

### Windows

windows 平台下像普通应用一样安装即可。jdk11 可以使用 openjdk 代替。

### Linux

linux 需要 x-window 支持。服务器环境，可以使用 Xvfb。Xvfb 是一个虚拟显示器服务器，将显示结果输出到内存而非显示器。Xvfb 具体安装可以参与网络上的一些文章。部署这个 demo 有几个要点：

- 需要设置 `DISPLAY` 环境变量。`DISPLAY` 变量应于指定输出显示服务器。
    - 用这个命令行启动 Xvfb: `Xvfb :1 -ac -screen 0 1980x1080x24&`，那么 `DISPLAY` 应该设置为 `:1`，然后再启动这个 demo。
- 启动 chrome driver 也需要设置 `DISPLAY` 变量。
- 需要显示中文，需要自行安装中文字体。

本地测试的话，可以使用行内变量：`DISPLAY=:1 chromedriver`。

### macOS

未测试。理论上安装过程像 Windows 系统。

## License

MIT
