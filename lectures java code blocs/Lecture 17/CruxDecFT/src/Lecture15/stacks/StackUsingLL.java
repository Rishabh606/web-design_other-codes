package Lecture15.stacks;

import Lecture14.LinkedList;

public class StackUsingLL implements IStack {
	private LinkedList list;

	public StackUsingLL() {
		this.list = new LinkedList();
	}

	@Override
	public void display() {
		this.list.display();
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public int size() {
		return this.list.size();
	}

	@Override
	public void push(int data) {
		this.list.addFirst(data);
	}

	@Override
	public int pop() throws Exception {
		try {
			return this.list.removeFirst();
		} catch (Exception ex) {
			throw new Exception("Stack is empty");
		}
	}

	@Override
	public int top() throws Exception  {
		try {
			return this.list.getFirst();
		} catch (Exception ex) {
			throw new Exception("Stack is empty");
		}
	}

}
