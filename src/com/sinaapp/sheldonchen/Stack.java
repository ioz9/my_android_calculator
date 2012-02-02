package com.sinaapp.sheldonchen;

import java.util.LinkedList;

/**
 * @author Sheldon Chen
 *
 * Stack类表示后进先出（LIFO）的对象堆栈。它有五个操作，封装了一个LinkedList对象。提供了通常的push和pop操作，
 * 以及取堆栈顶点的peek方法、测试堆栈是否为空的empty方法、在堆栈中查找项并确定到堆栈顶距离的search方法。
 */
public class Stack<E> {
	
	private LinkedList<E> stack = new LinkedList<E>();

	/**
	 * 测试堆栈是否为空。
	 */
	public boolean empty() {
		return stack.isEmpty();
	}
	
	/**
	 * 查看堆栈顶部的对象，但不从堆栈中移除它。
	 */
	public E peek() {
		return stack.peek();
	}
	
	/**
	 * 移除堆栈顶部的对象，并作为此函数的值返回该对象。
	 */
	public E pop() {
		return stack.removeFirst();
	}
	
	/**
	 * 把项压入堆栈顶部
	 */
	public E push(E item) {
		stack.addFirst(item);
		return item;
	}
	
	/**
	 * 返回对象在堆栈中的位置，以0为基数<br/>
	 * 暂不支持此方法
	 */
	public int search(E item) {
		throw new UnsupportedOperationException();
	}
}
