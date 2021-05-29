package com.example.thread.newIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 功能描述：
 *
 * @Author： cqx
 * @Date: 2021/5/15 22:04
 */
public class NioClient {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("localhost", 8080));
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("哈哈哈，我是serverClient".getBytes());
            byteBuffer.flip();

            socketChannel.write(byteBuffer);




        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
