/**
 * 
 */
package org.liuyaping.demo.datastruct;

/**
 * ѭ���б�ڵ�
 * 
 * @author liuyaping
 *
 * ����ʱ�䣺2018��1��5��
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