/**
 * 
 */
package org.liuyaping.demo.timingwheel;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuyaping 创建日期：2017年12月22日
 *
 */
public class ExpirationListenerHandler implements ExpirationListener<Map<String, Integer>> {

	private TimingWheel<Map<String, Integer>> timingWheel;
	final ReentrantLock lock;

	public ExpirationListenerHandler(TimingWheel<Map<String, Integer>> timingWheel) {
		this.timingWheel = timingWheel;
		lock = new ReentrantLock();
	}

	public void expired(Map<String, Integer> expiredObject) {
		Entry<String, Integer> entry = expiredObject.entrySet().iterator().next();
		lock.lock();
		try {
			int value = entry.getValue();
			if (value <= 3) {
				value++;
				expiredObject.put(entry.getKey(), value);
				timingWheel.add(expiredObject);
			}
		} finally {
			lock.unlock();
		}

	}

}
