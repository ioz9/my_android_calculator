package com.sinaapp.sheldonchen;

import java.util.LinkedList;

/**
 * @author Sheldon Chen
 *
 * Stack���ʾ����ȳ���LIFO���Ķ����ջ�����������������װ��һ��LinkedList�����ṩ��ͨ����push��pop������
 * �Լ�ȡ��ջ�����peek���������Զ�ջ�Ƿ�Ϊ�յ�empty�������ڶ�ջ�в����ȷ������ջ�������search������
 */
public class Stack<E> {
	
	private LinkedList<E> stack = new LinkedList<E>();

	/**
	 * ���Զ�ջ�Ƿ�Ϊ�ա�
	 */
	public boolean empty() {
		return stack.isEmpty();
	}
	
	/**
	 * �鿴��ջ�����Ķ��󣬵����Ӷ�ջ���Ƴ�����
	 */
	public E peek() {
		return stack.peek();
	}
	
	/**
	 * �Ƴ���ջ�����Ķ��󣬲���Ϊ�˺�����ֵ���ظö���
	 */
	public E pop() {
		return stack.removeFirst();
	}
	
	/**
	 * ����ѹ���ջ����
	 */
	public E push(E item) {
		stack.addFirst(item);
		return item;
	}
	
	/**
	 * ���ض����ڶ�ջ�е�λ�ã���0Ϊ����<br/>
	 * �ݲ�֧�ִ˷���
	 */
	public int search(E item) {
		throw new UnsupportedOperationException();
	}
}
