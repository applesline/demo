/**
 * 
 */
package org.liuyaping.demo.algorithm;

/**
 * 冒泡排序算法
 * 
 * @author liuyaping
 *
 * 创建时间：2016年09月25日
 */
public class BubbleSort {

	/**
	 * 排序
	 * 
	 * @param elements
	 */
	public static void sort(int[] elements) {
		int temp = 0;
		for(int i=0;i<elements.length-1;i++) {
			for(int j=elements.length-1;j>i;j--) {
				if(elements[j] > elements[j-1]) {
					temp = elements[j];
					elements[j] = elements[j-1];
					elements[j-1] = temp;
				}
			}
		}
	}
	
}
