/**
 * 
 */
package org.applesline.demo.switchdb;

/**
 * 数据源定义。
 * 
 * @author liuyaping
 * @date 2017年8月15
 *
 */
public interface DataSource {

	Connection getConnection();
	
	String getDataSourceName();
}
