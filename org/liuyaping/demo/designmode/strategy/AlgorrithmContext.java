/**
 * 
 */
package org.liuyaping.demo.strategy;

/**
 * 算法上下文，用于切换策略（非线程安全）
 * 
 * @author liuyaping 创建日期：2017年12月22日
 *
 */
public class AlgorrithmContext<T> {

	private AlgorithmStrategy<T> strategy;

	public AlgorithmStrategy<T> getStrategy() {
		return strategy;
	}

	public void setStrategy(AlgorithmStrategy<T> strategy) {
		this.strategy = strategy;
	}
	
	public T getResult(T factorA, T factorB) {
		return strategy.execute(factorA, factorB);
	}
	
}
