# selenium-demo

使用 selenium 连接到 electron。

- browser 是带有窗口最大化支持的 electron 定制版
- selenium-demo 是 java 实现的连接代码。通过 remote webdrvier 方式连接，需要先启动 electron 专用 webdrvier。

相关文档可以看这里：https://www.electronjs.org/docs/latest/tutorial/automated-testing

## 构建

```sh
# just 命令可以到 https://github.com/casey/just 下载
just
```

## 部署

基础软件：java11。

windows 平台下像普通应用一样安装即可。

linux 平台需要先配置 Xvfb，需要显示中文时也需要安装相应的字体。linux 平台需要解决 `DISPLAY` 环境变量问题。

比如在用这个命令行启动 Xvfb: `Xvfb :1 -ac -screen 0 1980x1080x24&`，那么 `DISPLAY` 应该设置为 `:1`。electron 会显示在 `DISPLAY` 指向的地址（因为 x11 的特性）。在使用 chromedriver 启动时，也需要设置 `DISPLAY` 变量。本地测试的话，可以使用行内变量：`DISPLAY=:1 chromedriver`。

## License

MIT
