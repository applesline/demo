/**
 * 
 */
package org.liuyaping.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页工具。
 * 
 * @author liuyaping
 *
 * 创建时间：2018年3月7日
 */
public class Pagination<T> {

	private long firstPage = 1;
	private long prePage;
	private long currentPage;
	private long nextPage;
	private long lastPage;
	private long pageSize = 10;
	private long total = 0;
	private long totalPage;
	private List<T> datas;
	
	public static <T> Pagination<T> create(Class<T> t) {
		return new Pagination<T>();
	}
	/**
	 * 默认每页10条数据。
	 */
	private Pagination() {
		datas = new ArrayList<T>();
		total = 0;
		prePage = 1;
		nextPage = 1;
		lastPage = 1;
		totalPage = 1;
	}
	
	public Pagination<T> init() {
		totalPage = total % pageSize == 0? total/pageSize : total/pageSize + 1;
		if(currentPage > totalPage) 
			currentPage = totalPage;
		if(currentPage <= 1 && totalPage > 1) {
			prePage = 1;
			nextPage = currentPage + 1;
			lastPage = totalPage;
		} else if(currentPage > 1 && totalPage > 1) {
			prePage = currentPage - 1;
			if(currentPage < totalPage) {
				nextPage = currentPage + 1;;
			} else {
				nextPage = totalPage;
			}
			lastPage = totalPage;
		}
		return this;
	}
	
	public long getPrePage() {
		return prePage;
	}
	public long getCurrentPage() {
		return currentPage;
	}
	public Pagination<T> setCurrentPage(long currentPage) {
		this.currentPage = currentPage <= 0 ? 1 : currentPage;
		return this;
	}
	public long getNextPage() {
		return nextPage;
	}
	public long getLastPage() {
		return lastPage;
	}
	public long getPageSize() {
		return pageSize;
	}
	public Pagination<T> setPageSize(long pageSize) {
		this.pageSize = pageSize <= 0 ? 10 : pageSize;
		return this;
	}
	public long getTotalPage() {
		return totalPage;
	}
	
	public long getTotal() {
		return total;
	}

	public Pagination<T> setTotal(long total) {
		this.total = total <= 0 ? 0 : total;
		return this;
	}

	public List<T> getDatas() {
		return datas;
	}
	public Pagination<T> setDatas(List<T> datas) {
		this.datas = datas == null ? new ArrayList<T>() : datas;
		return this;
	}
	
	public long getFirstPage() {
		return firstPage;
	}
	@Override
	public String toString() {
		return "Pagination [firstPage=" + firstPage + ", prePage=" + prePage + ", currentPage=" + currentPage
				+ ", nextPage=" + nextPage + ", lastPage=" + lastPage + ", pageSize=" + pageSize + ", total=" + total
				+ ", totalPage=" + totalPage + ", datas=" + datas + "]";
	}
	
}
