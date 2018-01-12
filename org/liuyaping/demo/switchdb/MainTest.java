/**
 * 
 */
package org.applesline.demo.switchdb;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liuyaping
 * @date 2017年8月15
 *
 */
public class MainTest {

	public static void main(String[] args) {
		DataSourceUtil util = new DataSourceUtil();
		util.init();
		
		DealBusiness dealBusiness = new DealBusiness();
		Method[] methods = dealBusiness.getClass().getDeclaredMethods();
		
		for(Method method : methods) {
			DataSourceRouter router = method.getAnnotation(DataSourceRouter.class);
			if (router == null) {
				continue;
			}
			if ("read".equals(router.name())) {
				DataSource dataSource = DataSourceUtil.dataSourceMap.get("read");
				DataSourceUtil.THREAD_LOCAL.set(dataSource);
			} else {
				DataSource dataSource = DataSourceUtil.dataSourceMap.get("write");
				DataSourceUtil.THREAD_LOCAL.set(dataSource);
			}
			try {
				method.invoke(dealBusiness, new Object[]{});
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
