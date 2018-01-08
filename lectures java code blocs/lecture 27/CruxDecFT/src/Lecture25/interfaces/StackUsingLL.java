package Lecture25.interfaces;

import Lecture14.LinkedList;

public class StackUsingLL implements IStack {
private LinkedList list;
	
	public StackUsingLL() {
		this.list = new LinkedList();
	}

	public void push(int item) {
		this.list.addFirst(item);
	}

	public int pop() throws Exception {
		int rv = 0;

		try {
			rv = this.list.removeFirst();
		} catch (Exception ex) {
			throw new Exception("Stack is empty");
		}
		return rv;
	}

	public int top() throws Exception {
		int rv = 0;

		try {
			rv = this.list.getFirst();
		} catch (Exception ex) {
			throw new Exception("Stack is empty");
		}

		return rv;
	}

	public int size() {
		return this.list.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		this.list.display();
	}

}
