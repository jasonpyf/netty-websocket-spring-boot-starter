package com.whjinran.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler.HandshakeComplete;

/**
 * @ClassName: WebsocketHandshake
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author jason.peng
 * @date 2020年7月3日
 */
public class WebsocketHandshake extends WebsocketContext {
	
	private final HandshakeComplete handshakeComplete;
	
	/**
	 * 创建一个新的实例 WebsocketHandshake.
	 *
	 * @param ctx
	 * @param handshakeComplete
	 */
	public WebsocketHandshake(ChannelHandlerContext ctx, 
			HandshakeComplete handshakeComplete) {
		super(ctx);
		this.handshakeComplete = handshakeComplete;
	}
	
	/**
	 * @Title: requestUri
	 * @Description: TODO(请求地址)
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	public String requestUri() {
		
		return this.handshakeComplete.requestUri();
	}
	
	/**
	 * @Title: requestHeader
	 * @Description: TODO(请求头信息)
	 * @param @param name
	 * @param @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	public String requestHeader(String name) {
		return this.handshakeComplete.requestHeaders().get(name);
	}
}
