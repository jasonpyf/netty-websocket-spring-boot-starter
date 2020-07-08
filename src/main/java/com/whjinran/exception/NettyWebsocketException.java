package com.whjinran.exception;

/**
 * @ClassName: NettyWebsocketException
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author jason.peng
 * @date 2020年7月3日
 */
public class NettyWebsocketException extends Exception {
	 
	private static final long serialVersionUID = 1L;

	public NettyWebsocketException() {
		super();
	}

	public NettyWebsocketException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NettyWebsocketException(String message, Throwable cause) {
		super(message, cause);
	}

	public NettyWebsocketException(String message) {
		super(message);
	}

	public NettyWebsocketException(Throwable cause) {
		super(cause);
	}

}
