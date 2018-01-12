/**
 * 
 */
package org.applesline.demo.switchdb;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyaping
 * @date 2017年8月15
 *
 */
public class DataSourceUtil {

	public static final Map<String, DataSource> dataSourceMap = new HashMap<>();
	public static final ThreadLocal<DataSource> THREAD_LOCAL = new ThreadLocal<>();

	public void register(String name, DataSource dataSource) {
		dataSourceMap.put(name, dataSource);
	}
	
	public void init() {
		DataSource mysqlDb = new MySqlDataSource();
		DataSource oracleDb = new OracleDataSource();
		register("write", mysqlDb);
		register("read", oracleDb);
	}
}
