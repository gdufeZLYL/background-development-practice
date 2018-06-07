package com.qexz.chapter06.item01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 程序清单6-1 串行的Web服务器
 * @author zzqnxx@foxmail.com
 * @date 2018/5/30 20:23
 */
public class SingleThreadWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Socket connection = socket.accept();
            handleRequest(connection);
        }
    }

    private static void handleRequest(Socket connection) {
        // request-handling logic here
    }
}
