package com.whjinran.standard;

import java.util.concurrent.TimeUnit;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;

/**
 * @ClassName: NettyWebsocketChannelInitializer
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author jason.peng
 * @date 2020年7月3日
 */
public class NettyWebsocketChannelInitializer extends ChannelInitializer<NioSocketChannel> {
	
	/**
	 * 配置信息
	 */
	private final NettyWebsocketProperties config;
	/**
	 * 业务handler
	 */
	private final NettyWebsocketHandler handler;
	
	/**
	 * 创建一个新的实例 NettyWebsocketChannelInitializer.
	 *
	 * @param config
	 */
	public NettyWebsocketChannelInitializer(NettyWebsocketProperties config,
			NettyWebsocketHandler handler) {
		this.config = config;
		this.handler = handler;
	}

	@Override
	protected void initChannel(NioSocketChannel ch) throws Exception {
		 ChannelPipeline pipeline = ch.pipeline();
		 
		 /**
		  * 设置解码器
		  */
		 pipeline.addLast(new HttpServerCodec());
		 
		 /**
		  * 聚合器，使用websocket会用到
		  */
		 pipeline.addLast(new HttpObjectAggregator(65536));
		 
		 /**
		  * 用于大数据的分区传输
		  */
		 pipeline.addLast(new ChunkedWriteHandler());
        
		 /**
		  * 读超时
		  */
		 pipeline.addLast(new ReadTimeoutHandler(config.getReaderIdleTimeSeconds(), 
				 								 TimeUnit.SECONDS));
		 
		 /**
		  * Websocket协议
		  */
		 pipeline.addLast("protocol", new WebSocketServerProtocolHandler(config.getPath()));
		 
		 /**
		  * 自定义的业务handler
		  */
		 pipeline.addLast(handler);
	}

}
