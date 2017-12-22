/**
 * 
 */
package org.liuyaping.demo.strategy;

import java.math.BigDecimal;

/**
 * 乘法策略。
 * 
 * @author liuyaping
 * 创建日期：2017年12月22日
 *
 */
public class MultiplicationStrategy implements AlgorithmStrategy<BigDecimal> {

	public BigDecimal execute(BigDecimal factorA, BigDecimal factorB) {
		return factorA.multiply(factorB);
	}

}
