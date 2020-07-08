package com.whjinran.standard;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName: NettyWebsocketProperties
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author jason.peng
 * @date 2020年7月3日
 */
@ConfigurationProperties(NettyWebsocketProperties.NETTY_WEBSOCKET_PREFIX)
public class NettyWebsocketProperties {
	
	public static final String NETTY_WEBSOCKET_PREFIX = "netty.websocket";

	private String host = "0.0.0.0";
	
	private int port = 8989;
	
	private String path = "/";
	
	private int bossLoopGroupThreads = 0;
	
	private int workerLoopGroupThreads = 0;
	
	private boolean useCompressionHandler = false;
	
	//------------------------- option -------------------------
	
	private int connectTimeoutMillis = 30000;
	
	private int soBacklog = 128;
	
	//------------------------- childOption -------------------------
	
	private int writeSpinCount = 16;
	
	private int writeBufferHighWaterMark = 65536;
	
	private int writeBufferLowWaterMark = 32768;
	
	private int soRcvbuf = -1;
	
	private int soSndbuf = -1;
	
	private boolean tcpNodelay = true;
	
	private boolean soKeepalive = false;
	
	private int soLinger = -1;
	
	private boolean allowHalfClosure = false;
	
	//------------------------- idleEvent -------------------------
	
	private int readerIdleTimeSeconds = 0;
	
	private int writerIdleTimeSeconds = 0;
	
	private int allIdleTimeSeconds = 0;
	
	//------------------------- handshake -------------------------
	
	private int maxFramePayloadLength = 65536;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getBossLoopGroupThreads() {
		return bossLoopGroupThreads;
	}

	public void setBossLoopGroupThreads(int bossLoopGroupThreads) {
		this.bossLoopGroupThreads = bossLoopGroupThreads;
	}

	public int getWorkerLoopGroupThreads() {
		return workerLoopGroupThreads;
	}

	public void setWorkerLoopGroupThreads(int workerLoopGroupThreads) {
		this.workerLoopGroupThreads = workerLoopGroupThreads;
	}

	public boolean isUseCompressionHandler() {
		return useCompressionHandler;
	}

	public void setUseCompressionHandler(boolean useCompressionHandler) {
		this.useCompressionHandler = useCompressionHandler;
	}

	public int getConnectTimeoutMillis() {
		return connectTimeoutMillis;
	}

	public void setConnectTimeoutMillis(int connectTimeoutMillis) {
		this.connectTimeoutMillis = connectTimeoutMillis;
	}

	public int getSoBacklog() {
		return soBacklog;
	}

	public void setSoBacklog(int soBacklog) {
		this.soBacklog = soBacklog;
	}

	public int getWriteSpinCount() {
		return writeSpinCount;
	}

	public void setWriteSpinCount(int writeSpinCount) {
		this.writeSpinCount = writeSpinCount;
	}

	public int getWriteBufferHighWaterMark() {
		return writeBufferHighWaterMark;
	}

	public void setWriteBufferHighWaterMark(int writeBufferHighWaterMark) {
		this.writeBufferHighWaterMark = writeBufferHighWaterMark;
	}

	public int getWriteBufferLowWaterMark() {
		return writeBufferLowWaterMark;
	}

	public void setWriteBufferLowWaterMark(int writeBufferLowWaterMark) {
		this.writeBufferLowWaterMark = writeBufferLowWaterMark;
	}

	public int getSoRcvbuf() {
		return soRcvbuf;
	}

	public void setSoRcvbuf(int soRcvbuf) {
		this.soRcvbuf = soRcvbuf;
	}

	public int getSoSndbuf() {
		return soSndbuf;
	}

	public void setSoSndbuf(int soSndbuf) {
		this.soSndbuf = soSndbuf;
	}

	public boolean isTcpNodelay() {
		return tcpNodelay;
	}

	public void setTcpNodelay(boolean tcpNodelay) {
		this.tcpNodelay = tcpNodelay;
	}

	public boolean isSoKeepalive() {
		return soKeepalive;
	}

	public void setSoKeepalive(boolean soKeepalive) {
		this.soKeepalive = soKeepalive;
	}

	public int getSoLinger() {
		return soLinger;
	}

	public void setSoLinger(int soLinger) {
		this.soLinger = soLinger;
	}

	public boolean isAllowHalfClosure() {
		return allowHalfClosure;
	}

	public void setAllowHalfClosure(boolean allowHalfClosure) {
		this.allowHalfClosure = allowHalfClosure;
	}

	public int getReaderIdleTimeSeconds() {
		return readerIdleTimeSeconds;
	}

	public void setReaderIdleTimeSeconds(int readerIdleTimeSeconds) {
		this.readerIdleTimeSeconds = readerIdleTimeSeconds;
	}

	public int getWriterIdleTimeSeconds() {
		return writerIdleTimeSeconds;
	}

	public void setWriterIdleTimeSeconds(int writerIdleTimeSeconds) {
		this.writerIdleTimeSeconds = writerIdleTimeSeconds;
	}

	public int getAllIdleTimeSeconds() {
		return allIdleTimeSeconds;
	}

	public void setAllIdleTimeSeconds(int allIdleTimeSeconds) {
		this.allIdleTimeSeconds = allIdleTimeSeconds;
	}

	public int getMaxFramePayloadLength() {
		return maxFramePayloadLength;
	}

	public void setMaxFramePayloadLength(int maxFramePayloadLength) {
		this.maxFramePayloadLength = maxFramePayloadLength;
	}
	
}
