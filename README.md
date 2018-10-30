

# Asynchronous Programing

关于 js 和 kotlin 异步编程的分享内容


### 开始播放

```bash
npm run slide
```

暂时只支持 Mac 或 Linux


或者执行 `npm i` 后，本地启动一个 http 静态文件服务（假设端口为 8001），访问以下路径即可


> <http://127.0.0.1:8001/slide/>

如果使用 safari 或 firefox 浏览器，也可直接打开本地文件 `slide/index.html` 浏览,
但 chrome 因为不支持 file 协议的 xhr 从而不能直接支持


### 编译 / 执行示例代码

1. 可直接执行 js 代码, 比如

    ```bash
    node js/step-by-step/4-cps-transformed.js
    ```
    ```
    got avatar image data: [massive of data url1 ...]
    something wrong: Error: url can not be load: url2
    done sequentially in time: 4035
    
    got avatar image data: [massive of data url1 ...]
    something wrong: Error: url can not be load: url2
    done parallelly in time: 2010 
    ```

2. kotlin 代码

    ```bash
    mvn clean compile
    ```
    ```bash
    mvn exec:java -D"exec.mainClass"="com.github.lwr.learningasync.coroutine.Profile_image_demoKt"
    ```
    ```
    [INFO] Scanning for projects...
    ... ...
    [INFO] --- exec-maven-plugin:1.6.0:java (default-cli) @ learning-async ---
    got avatar image data: [massive of data url1 ...]
    something wrong: java.lang.Exception: url can not be load: url2
    done sequentially in time: 4023
    
    got avatar image data: [massive of data url1 ...]
    something wrong: java.lang.Exception: url can not be load: url2
    done parallelly in time: 2029
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time: 7.268 s
    [INFO] Finished at: 2018-10-30T09:41:09+08:00
    [INFO] Final Memory: 12M/309M
    [INFO] ------------------------------------------------------------------------    
    ```
    
