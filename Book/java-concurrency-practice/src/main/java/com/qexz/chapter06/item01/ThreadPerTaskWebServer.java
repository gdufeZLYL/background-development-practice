package com.qexz.chapter06.item01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 程序清单6-2 在Web服务器中为每个请求启动一个新的线程(不要这么做)
 * @author zzqnxx@foxmail.com
 * @date 2018/5/30 20:33
 */
public class ThreadPerTaskWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                public void run() {
                    handleRequest(connection);
                }
            };
            new Thread(task).start();
        }
    }

    private static void handleRequest(Socket connection) {
        // request-handling logic here
    }
}