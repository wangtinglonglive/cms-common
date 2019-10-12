package com.wangting.utils;

import java.io.Closeable;
import java.io.IOException;

public class StreamUtils {

	/**
	 *  �ر����е���
	 * @param n
	 * @param streams
	 * @throws IOException
	 */
	public static void closeStream(Closeable ... streams) throws IOException {
		
		for (int i = 0; i < streams.length; i++) {
			streams[i].close();
		}
		
	}

}
