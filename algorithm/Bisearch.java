/**
 * 
 */
package org.liuyaping.demo.algorithm;

/**
 * 折半查找算法
 * 
 * @author liuyaping
 *
 * 创建时间：2017年12月23日
 */
public class Bisearch {
	/**
	 * 折半查找
	 * 
	 * @param elements 已排序的数组
	 * @param element  待查找的数字
	 * @return 返回数字所在索引
	 */
	public static Integer search(int[] elements,int element) {
		int start = 0,end = elements.length-1,middle = 0;
		while(start <= end) {
			middle = (start + end)/2;
			if(elements[middle] == element) {
				return middle;
			} else if(elements[middle] > element) {
				start = middle + 1;
			} else {
				end = middle - 1;
			}
		}
		return null;
	}
}
