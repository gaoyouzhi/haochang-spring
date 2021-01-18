package com.haochang.netty.client;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @description: 描述：客户端handler
 * @author: youzhi.gao
 * @date: 2021-01-18 13:53
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * 方法功能描述：当客户端加入服务端时发送消息
     * @MethodName: channelInactive
     * @param ctx
     * @Return:
     * @Author: yz.gao
     * @Date: 2021-01-18 13:55
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf buf = Unpooled.copiedBuffer("HelloServer", CharsetUtil.UTF_8);
        ctx.writeAndFlush(buf);
    }

    /**
     * 方法功能描述：客户端收到消息时
     * @MethodName: channelRead
     * @param ctx
     * @param msg
     * @Return:
     * @Author: yz.gao
     * @Date: 2021-01-18 13:56
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("收到服务端的消息:" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("服务端的地址： " + ctx.channel().remoteAddress());
    }

    /**
     * 方法功能描述：异常时关闭通道
     * @MethodName: exceptionCaught
     * @param ctx
     * @param cause
     * @Return:
     * @Author: yz.gao
     * @Date: 2021-01-18 13:57
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
