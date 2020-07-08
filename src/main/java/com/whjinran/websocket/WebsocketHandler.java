package com.whjinran.websocket;

/**
 * @ClassName: WebsocketHandler
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author jason.peng
 * @date 2020年7月3日
 *
 */
public interface WebsocketHandler {

	/**
	 * @Title: onOpen
	 * @Description: TODO(连接建立时触发)
	 * @param @param context    参数
	 * @return void    返回类型
	 * @throws
	 */
	default void onOpen(WebsocketContext context) {
		
	}
	
	/**
	 * @Title: onClose
	 * @Description: TODO(	连接关闭时触发)
	 * @param @param context    参数
	 * @return void    返回类型
	 * @throws
	 */
	default void onClose(WebsocketContext context) {
		
	}
	
	/**
	 * @Title: onError
	 * @Description: TODO(通信发生错误时触发)
	 * @param @param context
	 * @param @param cause    参数
	 * @return void    返回类型
	 * @throws
	 */
	default void onError(WebsocketContext context, Throwable cause) {
		
	}
	
	/**
	 * @Title: onHandshake
	 * @Description: TODO(连接握手时触发)
	 * @param @param handshake    参数
	 * @return void    返回类型
	 * @throws
	 */
	default void onHandshake(WebsocketHandshake handshake) {
		
	}
	
	/**
	 * @Title: onMessage
	 * @Description: TODO(客户端接收服务端文本数据时触发)
	 * @param @param context
	 * @param @param data    参数
	 * @return void    返回类型
	 * @throws
	 */
	default void onMessage(WebsocketContext context, String data) {
		
	}
	
	/**
	 * @Title: onMessage
	 * @Description: TODO(客户端接收服务端二进制数据时触发)
	 * @param @param context
	 * @param @param data    参数
	 * @return void    返回类型
	 * @throws
	 */
	default void onMessage(WebsocketContext context, byte[] data) {
		
	}
}
