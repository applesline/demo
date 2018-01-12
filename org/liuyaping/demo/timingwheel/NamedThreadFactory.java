/**
 * 
 */
package org.liuyaping.demo.timingwheel;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuyaping 创建日期：2017年12月22日
 *
 */
public class NamedThreadFactory implements ThreadFactory {

	AtomicInteger seq = new AtomicInteger(1);

	private String name;
	private boolean daemon;

	public NamedThreadFactory(String name, boolean daemon) {
		this.name = name;
		this.daemon = daemon;
	}

	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setDaemon(daemon);
		thread.setName(name + "-" + seq.getAndIncrement());
		return thread;
	}

}