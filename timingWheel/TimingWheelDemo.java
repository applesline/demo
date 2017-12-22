/**
 * 
 */
package org.liuyaping.demo.timingwheel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author liuyaping 创建日期：2017年12月22日
 *
 */
public class TimingWheelDemo {
	final static TimingWheel<String> timingWheel = new TimingWheel<String>(500, 10, TimeUnit.MILLISECONDS);

	public static void main(String[] args) {
		timingWheel.addExpirationListener(new StringExpirationListener(timingWheel));
		timingWheel.start();
		for (int i = 0; i < 20; i++) {
			timingWheel.add(String.valueOf(i));
		}
		System.out.println("element add finished ! ["
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()) + "]  -- " + timingWheel);
	}

}

class StringExpirationListener implements ExpirationListener<String> {

	TimingWheel<String> timingWheel;

	public StringExpirationListener(TimingWheel<String> timingWheel) {
		this.timingWheel = timingWheel;
	}

	public void expired(String expiredObject) {
		System.out.println("[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()) + "]" + " value: "
				+ expiredObject + ", remain:" + timingWheel);

	}

}