package com.haochang.netty.chat;

import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @description: 描述：客户端
 * @author: youzhi.gao
 * @date: 2021-01-18 16:53
 */
public class ChatClient {
    public static void main(String[] args) throws Exception {
        EventLoopGroup loopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        try {
            bootstrap.group(loopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast("encoder", new StringEncoder());
                            pipeline.addLast("decoder", new StringDecoder());
                            pipeline.addLast(new ChatClientHandler());
                        }
                    });

            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9000).sync();
            Channel channel = channelFuture.channel();
            System.out.println("==========" + channel.remoteAddress() + "==========");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){
                String msg = scanner.nextLine();
                channel.writeAndFlush(msg);
            }

        } finally {
            loopGroup.shutdownGracefully();
        }
    }
}
