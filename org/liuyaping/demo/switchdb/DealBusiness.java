/**
 * 
 */
package org.applesline.demo.switchdb;

/**
 * @author liuyaping
 * @date 2017年8月15
 *
 */
public class DealBusiness {

	@DataSourceRouter(name="write")
	public void save() {
		DataSource dataSource = DataSourceUtil.THREAD_LOCAL.get();
		System.out.println("[write]--use database:"+dataSource.getDataSourceName()+" to save data");
	}
	
	@DataSourceRouter(name="read")
	public int getInfo() {
		DataSource dataSource = DataSourceUtil.THREAD_LOCAL.get();
		System.out.println("[read]--use database:"+dataSource.getDataSourceName()+" to get data");
		return 1;
	}
	
	@DataSourceRouter(name="write")
	public int deleteInfo() {
		DataSource dataSource = DataSourceUtil.THREAD_LOCAL.get();
		System.out.println("[write]--use database:"+dataSource.getDataSourceName()+" to delete data");
		return 1;
	}
}
