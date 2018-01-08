package Lecture15.stacks;

import Lecture15.queues.IQueue;

public class StackUsingQueuesPse implements IStack {
	private IQueue qp;
	private IQueue qh;

	public StackUsingQueuesPse(IQueue qp, IQueue qh) {
		this.qp = qp;
		this.qh = qh;
	}

	@Override
	public void display() {
		this.displayHelper();

		System.out.println("END");

		IQueue temp = this.qp;
		this.qp = this.qh;
		this.qh = temp;
	}

	private void displayHelper() {
		try {
			if (this.qp.isEmpty()) {
				return;
			}

			int data = this.qp.dequeue();
			this.qh.enqueue(data);

			this.displayHelper();

			System.out.print(data + " => ");
		} catch (Exception ex) {
			// never going to land here
		}
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public int size() {
		return this.qp.size();
	}

	@Override
	public void push(int data) {
		this.qp.enqueue(data);
	}

	@Override
	public int pop() throws Exception {
		try {
			while (this.qp.size() != 1) {
				this.qh.enqueue(this.qp.dequeue());
			}

			int rv = this.qp.dequeue();

			IQueue temp = this.qh;
			this.qh = this.qp;
			this.qp = temp;

			return rv;
		} catch (Exception ex) {
			throw new Exception("Stack is empty");
		}
	}

	@Override
	public int top() throws Exception {
		try {
			while (this.qp.size() != 1) {
				this.qh.enqueue(this.qp.dequeue());
			}

			int rv = this.qp.dequeue();
			this.qh.enqueue(rv);

			IQueue temp = this.qh;
			this.qh = this.qp;
			this.qp = temp;

			return rv;
		} catch (Exception ex) {
			throw new Exception("Stack is empty");
		}
	}

}
