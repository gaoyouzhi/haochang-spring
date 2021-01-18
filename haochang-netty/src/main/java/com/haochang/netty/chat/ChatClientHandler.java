package com.haochang.netty.chat;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;


/**
 * @description: 描述：客户端handler
 * @author: youzhi.gao
 * @date: 2021-01-18 17:00
 */
public class ChatClientHandler extends SimpleChannelInboundHandler<String> {



    /**
     * 方法功能描述：异常关闭
     * @MethodName: exceptionCaught
     * @param ctx
     * @param cause
     * @Return:
     * @Author: yz.gao
     * @Date: 2021-01-18 17:15
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    /**
     * 方法功能描述：处理服务端数据
     * @MethodName: channelRead0
     * @param channelHandlerContext
     * @param msg+
     * @Return:
     * @Author: yz.gao
     * @Date: 2021-01-18 17:24
     */
    @Override
    public void channelRead0(ChannelHandlerContext channelHandlerContext, String msg) throws Exception {
        System.out.println(msg);
    }
}
