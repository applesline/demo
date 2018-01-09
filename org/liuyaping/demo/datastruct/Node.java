/**
 * 
 */
package org.liuyaping.demo.datastruct;

/**
 * 循环列表节点
 * 
 * @author liuyaping
 *
 * 创建时间：2018年1月5日
 */
public class Node {

	private Node preNode;
	private Node nextNode;
	private Object data;
	
	public Node(Object data) {
		this.data = data;
	}
	
	public Node getPreNode() {
		return preNode;
	}
	public void setPreNode(Node preNode) {
		this.preNode = preNode;
	}
	public Node getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
