/**
 * 
 */
package org.liuyaping.demo.strategy;

/**
 * 算法策略。
 * 
 * @author liuyaping 创建日期：2017年12月22日
 *
 */
public interface AlgorithmStrategy<T> {

	/**
	 * 
	 * 
	 * @param factorA 因数A
	 * @param factorB 因数B
	 * @return 运算结果。
	 */
	T execute(T factorA, T factorB);
}
