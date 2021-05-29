package com.example.thread.newIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 功能描述：
 *
 * @Author： cqx
 * @Date: 2021/5/15 22:04
 */
public class NioServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(8080));

            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();

                if (socketChannel != null) {
                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                    int read = socketChannel.read(allocate);
                    System.out.println(new String(allocate.array()));

                } else {
                    System.out.println("连接为空");
                }
            }
            } catch(IOException e){
                e.printStackTrace();
            }

    }
}
