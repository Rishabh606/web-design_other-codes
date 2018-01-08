package Lecture25.stacks;

import java.util.Scanner;

import Lecture12.storystacks.Stack;
import Lecture12A.queuesStory.DynamicQueue;
import Lecture12A.stacksStory.DynamicStack;

public class StackClient {

	public static void main(String[] args) throws Exception {
//		StackUsingLL stack = new StackUsingLL();
//
//		Scanner scn = new Scanner(System.in);
//		char choice = '\0';
//
//		do {
//			try {
//				System.out.println("***************Menu****************");
//				System.out.println("Enter 1 for push");
//				System.out.println("Enter 2 for pop");
//				System.out.println("Enter 3 for top");
//				System.out.println("Enter 4 for size");
//				System.out.println("Enter 5 for isempty");
//				System.out.println("Enter 6 for display");
//				System.out.println("Enter x for exit");
//
//				choice = scn.next().charAt(0);
//				switch (choice) {
//				case '1':
//					System.out.println("Enter data");
//					stack.push(scn.nextInt());
//					break;
//				case '2':
//					System.out.println(stack.pop());
//					break;
//				case '3':
//					System.out.println(stack.top());
//					break;
//				case '4':
//					System.out.println(stack.size());
//					break;
//				case '5':
//					System.out.println(stack.isEmpty());
//					break;
//				case '6':
//					stack.display();
//					break;
//				case 'x':
//					break;
//				default:
//					System.out.println("Wrong choice. Try again.");
//					break;
//				}
//			} catch (Exception ex) {
//				System.out.println(ex.getMessage());
//			} finally {
//
//			}
//		} while (choice != 'x');
//
//		System.out.println("Thanks for using");

		// try {
		// System.out.println("Main");
		//
		// DemoExceptions();
		// System.out.println("Back in main 1");
		// } catch (Exception ex) {
		// System.out.println(ex.getMessage());
		// }
		//
		// System.out.println("Back in main 2");
		
		DynamicQueue q = new DynamicQueue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		
		q.display();
		reverseAQueue(q);
		q.display();
	}

	public static void DemoExceptions() throws Exception {
		try {
			System.out.println("Line 1");
			System.out.println("Line 2");
			System.out.println(4 / 0);
			System.out.println("Line 3");

			return;

		} catch (Exception ex) {
			if (6 % 2 == 1) {
				throw new Exception("Hi There");
			}
			System.out.println("Line 4");
			System.out.println("Line 5");
		} finally {
			System.out.println("Important stuff - file closing");
		}
		System.out.println("Line 6");
	}

	public static void reverseAQueue(DynamicQueue q) throws Exception{
		if(q.isEmpty()){
			return;
		}
		
		int item = q.dequeue();
		reverseAQueue(q);
		q.enqueue(item);
	}
	
	public static void reverseAStack(StackUsingLL s, StackUsingLL h, int floor){
		
		
		
		// recursion
		
		
		
	}
}
