package com.whjinran.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: DefaultWebsocketHandler
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author jason.peng
 * @date 2020年7月3日
 */
public class DefaultWebsocketHandler implements WebsocketHandler {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void onOpen(WebsocketContext context) {
		logger.warn("use com.whjinran.websocket.DefaultWebsocketHandler,"
				+ " please implements com.whjinran.websocket.WebsocketHandler interface,"
				+ " trigger onOpen event.");
	}
	
	@Override
	public void onClose(WebsocketContext context) {
		logger.warn("use com.whjinran.websocket.DefaultWebsocketHandler,"
				+ " please implements com.whjinran.websocket.WebsocketHandler interface,"
				+ " trigger onClose event.");
	}
	
	@Override
	public void onError(WebsocketContext context, Throwable cause) {
		logger.warn("use com.whjinran.websocket.DefaultWebsocketHandler,"
				+ " please implements com.whjinran.websocket.WebsocketHandler interface,"
				+ " trigger onError event.");
		cause.printStackTrace();
	}
	
	@Override
	public void onHandshake(WebsocketHandshake handshake) {
		logger.warn("use com.whjinran.websocket.DefaultWebsocketHandler,"
				+ " please implements com.whjinran.websocket.WebsocketHandler interface,"
				+ " trigger onHandshake event.");
	}
	
	@Override
	public void onMessage(WebsocketContext context, byte[] data) {
		logger.warn("use com.whjinran.websocket.DefaultWebsocketHandler,"
				+ " please implements com.whjinran.websocket.WebsocketHandler interface,"
				+ " trigger onMessage event.");
	}
	
	@Override
	public void onMessage(WebsocketContext context, String data) {
		logger.warn("use com.whjinran.websocket.DefaultWebsocketHandler,"
				+ " please implements com.whjinran.websocket.WebsocketHandler interface,"
				+ " trigger onMessage event.");
	}
}
