/**
 * 
 */
package org.liuyaping.demo.timingwheel;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定时任务每秒启动一次，时间轮每60秒一个轮回（每轮60次，每次跳动时间为1秒，刚好模拟了一个时钟周期）
 * 
 * @author liuyaping 创建日期：2017年12月22日
 *
 */
public class TimingWheelRetryDemo {

	final static TimingWheel<Map<String, Integer>> timingWheel = new TimingWheel<Map<String, Integer>>(1000, 6,
			TimeUnit.MILLISECONDS);

	static {
		for (int i = 1; i < 20; i++) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put(String.valueOf(i), 1);
			timingWheel.add(map);
		}
	}

	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(1,
				new NamedThreadFactory("timewheel-demo", false));
		service.scheduleWithFixedDelay(new Runnable() {

			public void run() {
				System.out.println("[" + Thread.currentThread().getName() + "]" + timingWheel);
			}
		}, 1, 1000, TimeUnit.MILLISECONDS);
		timingWheel.addExpirationListener(new ExpirationListenerHandler(timingWheel));
		timingWheel.start();
	}

}
