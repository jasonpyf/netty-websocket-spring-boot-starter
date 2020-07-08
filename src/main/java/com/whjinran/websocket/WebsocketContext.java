package com.whjinran.websocket;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * @ClassName: WebsocketContext
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author jason.peng
 * @date 2020年7月3日
 */
public class WebsocketContext {
	
	private final ChannelHandlerContext ctx;
	
	private final Channel channel;

	public WebsocketContext(ChannelHandlerContext ctx) {
		this.ctx = ctx;
		this.channel = ctx.channel();
	}
	
	/**
	 * @Title: name
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	public String name() {
		return this.ctx.name();
	}
	
	/**
	 * @Title: sendText
	 * @Description: TODO(发送文本消息)
	 * @param @param text    参数
	 * @return void    返回类型
	 * @throws
	 */
	public void sendText(String text) {
		 TextWebSocketFrame frame = new TextWebSocketFrame(text);
		 if(channel.isActive()) {
			 channel.writeAndFlush(frame);
		 }
	}
	
	/**
	 * @Title: send
	 * @Description: TODO(发送二进制文本)
	 * @param @param array    参数
	 * @return void    返回类型
	 * @throws
	 */
	public void send(byte[] array) {
		BinaryWebSocketFrame frame = new BinaryWebSocketFrame(Unpooled.wrappedBuffer(array));
		if(channel.isActive()) {
			 channel.writeAndFlush(frame);
		 }
	}
}
