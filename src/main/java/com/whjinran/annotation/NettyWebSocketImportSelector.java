package com.whjinran.annotation;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.whjinran.standard.NettyWebsocketChannelInitializer;
import com.whjinran.standard.NettyWebsocketHandler;
import com.whjinran.standard.NettyWebsocketProperties;
import com.whjinran.standard.NettyWebsocketServer;
import com.whjinran.websocket.DefaultWebsocketHandler;
import com.whjinran.websocket.WebsocketHandler;

/**
 * @ClassName: NettyWebSocketImportSelector
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author jason.peng
 * @date 2020年7月3日
 */
@Configuration
@ConditionalOnMissingBean(NettyWebsocketServer.class)
@EnableConfigurationProperties(NettyWebsocketProperties.class)
public class NettyWebSocketImportSelector {
	
	/**
	 * @Title: websocketHandler
	 * @Description: TODO(默认WebsocketHandler)
	 * @param @return    参数
	 * @return WebsocketHandler    返回类型
	 * @throws
	 */
	@Bean
	@ConditionalOnMissingBean(WebsocketHandler.class)
	public WebsocketHandler websocketHandler() {
		return new DefaultWebsocketHandler();
	}
	
	/**
	 * @Title: nettyWebsocketHandler
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param nettyWebsocketProperties
	 * @param @param websocketHandler
	 * @param @return    参数
	 * @return NettyWebsocketHandler    返回类型
	 * @throws
	 */
	@Bean
	public NettyWebsocketHandler nettyWebsocketHandler(
			NettyWebsocketProperties nettyWebsocketProperties,
			WebsocketHandler websocketHandler) {
		return new NettyWebsocketHandler(nettyWebsocketProperties,
										 websocketHandler);
	}
	
	/**
	 * @Title: nettyWebsocketChannelInitializer
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param nettyWebsocketProperties
	 * @param @param nettyWebsocketHandler
	 * @param @return    参数
	 * @return NettyWebsocketChannelInitializer    返回类型
	 * @throws
	 */
	@Bean
	public NettyWebsocketChannelInitializer nettyWebsocketChannelInitializer(
			NettyWebsocketProperties nettyWebsocketProperties,
			NettyWebsocketHandler nettyWebsocketHandler) {
		return new NettyWebsocketChannelInitializer(nettyWebsocketProperties,
													nettyWebsocketHandler);
	}

	/**
	 * @Title: nettyWebsocketServer
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param nettyWebsocketProperties
	 * @param @param nettyWebsocketChannelInitializer
	 * @param @return    参数
	 * @return NettyWebsocketServer    返回类型
	 * @throws
	 */
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public NettyWebsocketServer nettyWebsocketServer(
    		NettyWebsocketProperties nettyWebsocketProperties,
    		NettyWebsocketChannelInitializer nettyWebsocketChannelInitializer) {
        return new NettyWebsocketServer(nettyWebsocketProperties,
        								nettyWebsocketChannelInitializer);
    }
}