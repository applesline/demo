/**
 * 
 */
package org.liuyaping.demo.strategy;

/**
 * 减法运算策略。
 * 
 * @author liuyaping
 * 创建日期：2017年12月22日
 *
 */
public class SubtractionStrategy implements AlgorithmStrategy<Integer> {

	public Integer execute(Integer factorA, Integer factorB) {
		return factorA - factorB;
	}

}
