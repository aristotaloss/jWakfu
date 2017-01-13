package com.velocity.jwakfu.util;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingUtil {

	public static Logger log() {
		StackTraceElement caller = Thread.currentThread().getStackTrace()[2];
		Logger logger = LoggerFactory.getLogger(caller.getClassName());
		return logger;
	}
	
	static {
		PropertyConfigurator.configure("data/log4j.properties");
	}
	
}
