package com.haochang.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 描述：聊天室服务端handler
 * @author: youzhi.gao
 * @date: 2021-01-18 15:01
 */
public class ChatServerHandler extends SimpleChannelInboundHandler {
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    /**
     * 方法功能描述：channel处于就绪状态 提示上线
     * @MethodName: channelInactive
     * @param ctx
     * @Return:
     * @Author: yz.gao
     * @Date: 2021-01-18 16:51
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("客户端---- " + channel.remoteAddress() + "上线了 "
                + simpleDateFormat.format(new Date()) + "\n");
        channelGroup.add(channel);
        System.out.println(ctx.channel().remoteAddress() + "上线了" + "\n");
    }


    /**
     * 方法功能描述：channel处于不活跃状态 提示离线
     * @MethodName: channelInactive
     * @param ctx
     * @Return:
     * @Author: yz.gao
     * @Date: 2021-01-18 16:51
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("客户端---- " + channel.remoteAddress() + " 下线了 "
                + simpleDateFormat.format(new Date()) + "\n");
        System.out.println(ctx.channel().remoteAddress() + " 下线了" + "\n");
        System.out.println("channelGroup size " + channelGroup.size() + "\n");
    }

    /**
     * 方法功能描述：读取数据
     * @MethodName: channelRead0
     * @param channelHandlerContext
     * @param o
     * @Return: 
     * @Author: yz.gao
     * @Date: 2021-01-18 16:56
     */
    public void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        Channel channel = channelHandlerContext.channel();
        channelGroup.forEach(ch -> {
            if (ch != channel){
                ch.writeAndFlush("[ 客户端 ] " + channel.remoteAddress() +  " 发送消息："+ o + "\n");
            } else {
                channel.writeAndFlush("[ 自己 ] " + channel.remoteAddress() +  " 发送消息："+ o + "\n");
            }
        });
    }

    /**
     * 方法功能描述：异常时关闭通道
     * @MethodName: exceptionCaught
     * @param ctx
     * @param cause
     * @Return:
     * @Author: yz.gao
     * @Date: 2021-01-18 17:06
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
