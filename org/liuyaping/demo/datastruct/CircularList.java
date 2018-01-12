/**
 * 
 */
package org.liuyaping.demo.datastruct;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 循环列表
 * 
 * @author liuyaping
 *
 * 创建时间：2018年1月5日
 */
public class CircularList {

	private final Node head = new Node("#");
	private final Node tail = new Node("$");
	private volatile Node currentNode;
	private AtomicInteger count = new AtomicInteger(0);
	public final static Map<Object,Integer> valueMap = new ConcurrentHashMap<>(100);
	private final ReentrantLock LOCK = new ReentrantLock();
	
	public CircularList() {
		head.setNextNode(tail);
		head.setPreNode(tail);
		tail.setNextNode(head);
		tail.setPreNode(head);
		currentNode = head;
	}
	
	public void add(Node node) {
		final ReentrantLock LOCK = this.LOCK;
		LOCK.lock();
		try {
			Node lastNode = this.getLastNode();
			lastNode.setNextNode(node);
			node.setPreNode(lastNode);
			node.setNextNode(tail);
			tail.setPreNode(node);
			count.incrementAndGet();
		} finally {
			LOCK.unlock();
		}
	}
	
	public Node getNextNode() {
		final ReentrantLock LOCK = this.LOCK;
		LOCK.lock();
		try {
			this.currentNode = currentNode.getNextNode();
			while(currentNode.getData().equals(head.getData()) || currentNode.getData().equals(tail.getData())) {
				this.currentNode = currentNode.getNextNode();
			}
			Integer value = valueMap.get(currentNode.getData());
			if(value == null) {
				valueMap.put(currentNode.getData(), 1);
			} else {
				valueMap.put(currentNode.getData(), ++value);
			}
			return currentNode;
		} finally {
			LOCK.unlock();
		}
	}
	
	public Node getNextNode(String data) {
		return null;
	}
	
	public Node getLastNode() {
		final ReentrantLock LOCK = this.LOCK;
		LOCK.lock();
		try {
			Node node = this.head;
			while(!"$".equals(node.getNextNode().getData())) {
				node = node.getNextNode();
			}
			return node;
		} finally {
			LOCK.unlock();
		}
	}
	
	public void printNodes() {
		Node node = this.head;
		while(!"$".equals(node.getNextNode().getData())) {
			node = node.getNextNode();
			System.out.println(node.getData());
		}
	}
	
	public int getSize() {
		return count.get();
	}
	
}