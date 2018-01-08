package Lecture15.queues;

import Lecture14.LinkedList;

public class QueueUsingLL implements IQueue {
	private LinkedList list;

	public QueueUsingLL() {
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
	public void enqueue(int data) {
		this.list.addLast(data);
	}

	@Override
	public int dequeue() throws Exception {
		try {
			return this.list.removeFirst();
		} catch (Exception ex) {
			throw new Exception("Queue is empty");
		}
	}

	@Override
	public int front() throws Exception {
		try {
			return this.list.getFirst();
		} catch (Exception ex) {
			throw new Exception("Queue is empty");
		}
	}

}
