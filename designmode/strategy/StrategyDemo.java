/**
 * 
 */
package org.liuyaping.demo.strategy;

import java.math.BigDecimal;

/**
 * @author liuyaping 创建日期：2017年12月22日
 *
 */
public class StrategyDemo {

	public static void main(String[] args) {
		AlgorithmStrategy<BigDecimal> strategy = new DivisionStrategy();
		BigDecimal value = strategy.execute(BigDecimal.valueOf(3), BigDecimal.valueOf(2));
		System.out.println(value);
		strategy = new MultiplicationStrategy();
		value = strategy.execute(BigDecimal.valueOf(3), BigDecimal.valueOf(2));
		System.out.println(value);
	}

	public static void test() {
		AlgorrithmContext<Integer> context = new AlgorrithmContext<Integer>();
		context.setStrategy(new AdditionStrategy());
		int result = context.getResult(3, 4);
		System.out.println(result);
		context.setStrategy(new SubtractionStrategy());
		result = context.getResult(3, 4);
		System.out.println(result);
		AlgorrithmContext<BigDecimal> context2 = new AlgorrithmContext<BigDecimal>();
		context2.setStrategy(new DivisionStrategy());
		BigDecimal value = context2.getResult(BigDecimal.valueOf(3), BigDecimal.valueOf(4));
		System.out.println(value);
	}
}
