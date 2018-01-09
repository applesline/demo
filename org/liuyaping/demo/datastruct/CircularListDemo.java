/**
 * 
 */
package org.liuyaping.demo.datastruct;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.liuyaping.demo.timingwheel.NamedThreadFactory;

/**
 * 循环列表测试。
 * 
 * @author liuyaping
 *
 * 创建时间：2018年1月5日
 */
public class CircularListDemo {
	
	public static void main(String[] args) throws InterruptedException {
		int count = 1000;
		final CountDownLatch countDownLatch = new CountDownLatch(count);
		
		CircularList circularList = new CircularList();
		circularList.add(new Node("192.168.1.1"));
		circularList.add(new Node("192.168.1.2"));
		circularList.add(new Node("192.168.1.3"));
		circularList.add(new Node("192.168.1.4"));
		circularList.add(new Node("192.168.1.5"));
		circularList.add(new Node("192.168.1.6"));
		
		ExecutorService executor = Executors.newCachedThreadPool(new NamedThreadFactory("cached-factory",false));
		for(int i=0;i<count;i++) {
			executor.execute(new Thread(){
				int count = 0;
				public void run() {
					while(true) {
						count ++;
						if(count >= 2000) {
							break;
						}
						circularList.getNextNode();
					}
					countDownLatch.countDown();
				}
			});
		}
		countDownLatch.await();
		System.out.println(CircularList.valueMap);
	}
	
}
