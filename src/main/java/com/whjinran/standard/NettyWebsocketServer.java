package com.whjinran.standard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @ClassName: NettyWebsocketServer
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author jason.peng
 * @date 2020年7月3日
 */
public class NettyWebsocketServer {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 配置信息
	 */
	private final NettyWebsocketProperties config;
	
	/**
	 * Channel初始化
	 */
	private final NettyWebsocketChannelInitializer initializer;
	
	private final EventLoopGroup boss;
      
	private final EventLoopGroup worker;
	
	/**
	 * 创建一个新的实例 NettyWebsocketServer.
	 *
	 * @param config
	 * @param initializer
	 */
	public NettyWebsocketServer(NettyWebsocketProperties config,
							    NettyWebsocketChannelInitializer initializer) {
		this.config = config;
		this.initializer = initializer;
		boss = new NioEventLoopGroup(config.getBossLoopGroupThreads());
		worker = new NioEventLoopGroup(config.getWorkerLoopGroupThreads());
	}

	/**
	 * @Title: init
	 * @Description: TODO(初始化)
	 * @param     参数
	 * @return void    返回类型
	 * @throws
	 */
    public void init() {
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, config.getConnectTimeoutMillis())
                .option(ChannelOption.SO_BACKLOG, config.getSoBacklog())
                .childOption(ChannelOption.WRITE_SPIN_COUNT, config.getWriteSpinCount())
                .childOption(ChannelOption.WRITE_BUFFER_WATER_MARK, 
                		new WriteBufferWaterMark(config.getWriteBufferLowWaterMark(), 
                								 config.getWriteBufferHighWaterMark()))
                .childOption(ChannelOption.TCP_NODELAY, config.isTcpNodelay())
                .childOption(ChannelOption.SO_KEEPALIVE, config.isSoKeepalive())
                .childOption(ChannelOption.SO_LINGER, config.getSoLinger())
                .childOption(ChannelOption.ALLOW_HALF_CLOSURE, config.isAllowHalfClosure())
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .childHandler(initializer);

        if (config.getSoRcvbuf() != -1) {
            bootstrap.childOption(ChannelOption.SO_RCVBUF, config.getSoRcvbuf());
        }

        if (config.getSoSndbuf() != -1) {
            bootstrap.childOption(ChannelOption.SO_SNDBUF, config.getSoSndbuf());
        }

        ChannelFuture channelFuture;
        if ("0.0.0.0".equals(config.getHost())) {
            channelFuture = bootstrap.bind(config.getPort());
        } else {
        	channelFuture = bootstrap.bind(config.getHost(), config.getPort());
        }

        channelFuture.addListener(future -> {
            if (!future.isSuccess()){
                future.cause().printStackTrace();
            }
        });
        
        logger.info("Netty websocket started on port(s): {} with path '{}'.", 
        		config.getPort(), config.getPath());
    }
    
    /**
     * @Title: destroy
     * @Description: TODO(销毁)
     * @param     参数
     * @return void    返回类型
     * @throws
     */
    public void destroy() {
    	if(boss != null) {
    		 boss.shutdownGracefully().syncUninterruptibly();
    	}
    	if(worker != null) {
    		  worker.shutdownGracefully().syncUninterruptibly();
    	}
    	
    	logger.info("Netty websocket shutdown success.");
    }
}
