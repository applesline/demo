/**
 * 
 */
package org.liuyaping.demo.algorithm;

/**
 * @author liuyaping
 *
 * 创建时间：2017年12月23日
 */
public class AlgorithmDemo {

	public static void main(String[] args) {
		int[] elements = new int[]{5,3,7,9,8,0,1,6,2,4,-1,-10,2,11};
		BubbleSort.sort(elements);
		for(int n : elements) {
			System.out.print(n+" ");
		}
		System.out.println();
		int index = Bisearch.search(elements, 2);
		System.out.println(index+"的索引為："+elements[index]);
	}
}
