package Lecture15;

import Lecture15.stacks.*;
import Lecture15.queues.*;

public class Client {

	public static void main(String[] args) throws Exception {
		IQueue q1 = new QueueUsingLL();
		IQueue q2 = new QueueUsingLL();

		IStack stack;

		stack = new StackUsingQueuesPse(q1, q2);
		// stack = new StackUsingLL();

		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);

		// System.out.println(stack.pop());
		// System.out.println(stack.pop());
		// System.out.println(stack.pop());
		// System.out.println(stack.pop());
		// System.out.println(stack.pop());

		// System.out.println(stack.pop());

		stack.display();
		reverse(stack, new StackUsingLL(), false);
		stack.display();

		System.out.println("Thanks for using");
	}

	public static void reverse(QueueUsingLL qu) {

	}

	public static void reverse(IStack stack, IStack helper, int level) throws Exception {
		if (stack.isEmpty()) {
			return;
		}

		int data = stack.pop();
		reverse(stack, helper, level + 1);

		helper.push(data);

		if (level == 0) {
			while (!helper.isEmpty()) {
				stack.push(helper.pop());
			}
		}
	}

	public static void reverse(IStack stack, IStack helper, boolean flag) throws Exception {
		if (flag == false) {
			if (stack.isEmpty()) {
				reverse(stack, helper, true);
				return;
			}
		} else {
			if (helper.isEmpty()) {
				return;
			}
		}

		if (flag == false) {
			int data = stack.pop();
			helper.push(data);
			reverse(stack, helper, flag);
		} else {
			int data = helper.pop();
			reverse(stack, helper, flag);
			stack.push(data);
		}
	}

	public static boolean IsBalanced(String str) {
		return false;
	}

	public static boolean IsDuplicate(String str) {
		return false;
	}
}
