package com.velocity.jwakfu;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.socket.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import org.slf4j.Logger;

import com.velocity.jwakfu.model.WorldInfo;
import com.velocity.jwakfu.net.GameServerInitializer;
import com.velocity.jwakfu.util.LoggingUtil;

public class JWakfu {
	
	//IDENTITY NAME BREED APPEARANCE CREATION_DATA -> char creation

	private static final Logger logger = LoggingUtil.log();

	public JWakfu() {
		logger.info("Starting jWakfu...");
		
		try {
			WorldInfo.loadWorlds("data/worlds.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() throws Exception {
		long start = System.currentTimeMillis();
		ServerBootstrap b = new ServerBootstrap();
		try {
			b.group(new NioEventLoopGroup(), new NioEventLoopGroup()).channel(NioServerSocketChannel.class).localAddress(5558).childHandler(new GameServerInitializer());
			try {
				logger.info("Listening on port 5558.");
				logger.info("Server took " + (System.currentTimeMillis() - start) + " milliseconds to start up.");
				b.bind().awaitUninterruptibly().channel().closeFuture().awaitUninterruptibly();
			} catch (Exception e) {
				logger.error("Could not listen to port 443.", e);
			}
		} finally {
			b.shutdown();
		}
	}

	/**
	 * @param params
	 *            server parameters
	 */
	public static void main(String[] params) {
		try {
			new JWakfu().run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
