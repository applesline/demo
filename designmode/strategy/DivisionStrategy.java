/**
 * 
 */
package org.liuyaping.demo.strategy;

import java.math.BigDecimal;

/**
 * 除法运算策略。
 * 
 * @author liuyaping 创建日期：2017年12月22日
 *
 */
public class DivisionStrategy implements AlgorithmStrategy<BigDecimal> {

	public BigDecimal execute(BigDecimal factorA, BigDecimal factorB) {
		if (factorB.compareTo(BigDecimal.ZERO) == 0) {
			throw new IllegalArgumentException("paramter:" + factorB + ",factorB can not be zero");
		}
		return factorA.divide(factorB);
	}

}
