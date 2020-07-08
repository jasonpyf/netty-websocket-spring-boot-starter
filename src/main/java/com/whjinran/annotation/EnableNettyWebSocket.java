package com.whjinran.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

/**
 * @ClassName: EnableWebSocket
 * @Description: TODO(激活EnableWebSocket)
 * @author jason.peng
 * @date 2020年7月3日
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(NettyWebSocketImportSelector.class)
public @interface EnableNettyWebSocket {
	
}