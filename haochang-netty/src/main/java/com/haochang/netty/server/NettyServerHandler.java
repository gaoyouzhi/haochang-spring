package com.haochang.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @description: 描述：netty 服务端处理器
 * @author: youzhi.gao
 * @date: 2021-01-18 11:19
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 方法功能描述：处理通道读数据
     * @MethodName: channelRead
     * @param ctx 上下文
     * @param msg 消息
     * @Return:
     * @Author: yz.gao
     * @Date: 2021-01-18 11:24
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("服务器读取线程 " + Thread.currentThread().getName());
         //Channel channel = ctx.channel();
        //ChannelPipeline pipeline = ctx.pipeline(); //本质是一个双向链接, 出站入站
         //将 msg 转成一个 ByteBuf，类似NIO 的 ByteBuffer
         ByteBuf buf = (ByteBuf) msg;
         System.out.println("客户端发送消息是:" + buf.toString(CharsetUtil.UTF_8));
    }

    /**
     * 方法功能描述：数据读取完毕处理方法
     * @MethodName: channelReadComplete
     * @param ctx
     * @Return:
     * @Author: yz.gao
     * @Date: 2021-01-18 11:27
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ByteBuf buf = Unpooled.copiedBuffer("HelloClient", CharsetUtil.UTF_8);
        ctx.writeAndFlush(buf);
    }

    /**
     * 方法功能描述：处理异常 一般需要关闭客户端
     * @MethodName: exceptionCaught
     * @param ctx
     * @param cause
     * @Return:
     * @Author: yz.gao
     * @Date: 2021-01-18 11:30
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
