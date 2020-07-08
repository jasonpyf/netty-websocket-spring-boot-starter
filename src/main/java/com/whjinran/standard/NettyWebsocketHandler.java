package com.whjinran.standard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.whjinran.exception.NettyWebsocketException;
import com.whjinran.websocket.DefaultWebsocketHandler;
import com.whjinran.websocket.WebsocketContext;
import com.whjinran.websocket.WebsocketHandler;
import com.whjinran.websocket.WebsocketHandshake;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler.HandshakeComplete;

/**
 * @ClassName: NettyWebsocketHandler
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author jason.peng
 * @date 2020年7月3日
 *
 */
@Sharable
public class NettyWebsocketHandler extends SimpleChannelInboundHandler<WebSocketFrame> {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 配置信息
	 */
	@SuppressWarnings("unused")
	private final NettyWebsocketProperties config;
	
	/**
	 * handler处理器
	 */
	private final WebsocketHandler handler;
	
	public NettyWebsocketHandler(NettyWebsocketProperties config,
								 WebsocketHandler handler) {
		this.config = config;
		this.handler = handler;
		
		if(this.handler instanceof DefaultWebsocketHandler) {
			logger.warn("use com.whjinran.websocket.DefaultWebsocketHandler,"
					  + " please implements com.whjinran.websocket.WebsocketHandler interface.");
		}
	}
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, 
								WebSocketFrame msg) throws Exception {
		if(msg instanceof TextWebSocketFrame) {
			// 处理文本帧
			TextWebSocketFrame textWebSocketFrame = (TextWebSocketFrame) msg;
			WebsocketContext context = new WebsocketContext(ctx);
			handler.onMessage(context , textWebSocketFrame.text());
		} else if(msg instanceof BinaryWebSocketFrame) {
			// 处理二进制帧
			BinaryWebSocketFrame binaryWebSocketFrame = (BinaryWebSocketFrame) msg;
			WebsocketContext context = new WebsocketContext(ctx);
			handler.onMessage(context , binaryWebSocketFrame.content().array());
		} else {
			// 类型不支持
			throw new NettyWebsocketException("msg type not support.");
		}
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		WebsocketContext context = new WebsocketContext(ctx);
		handler.onOpen(context);
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		WebsocketContext context = new WebsocketContext(ctx);
		handler.onClose(context);
	}
	
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, 
								   Object evt) throws Exception {
		if(evt instanceof HandshakeComplete) {
			// 处理握手事件
    		HandshakeComplete handshakeComplete = (HandshakeComplete) evt;
    		WebsocketHandshake handshake = new WebsocketHandshake(ctx, handshakeComplete);
    		handler.onHandshake(handshake);
    	}
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,
								Throwable cause) throws Exception {
		WebsocketContext context = new WebsocketContext(ctx);
		handler.onError(context, cause);
	}

}
