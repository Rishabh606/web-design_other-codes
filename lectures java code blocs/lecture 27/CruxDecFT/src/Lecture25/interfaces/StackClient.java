package Lecture25.interfaces;

import java.util.Scanner;

public class StackClient {

	public static void main(String[] args) {
		IStack stack = new IStack() {
			
			@Override
			public int top() throws Exception {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public void push(int item) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public int pop() throws Exception {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void display() {
				// TODO Auto-generated method stub
				
			}
		};

		Scanner scn = new Scanner(System.in);
		char choice = '\0';

		do {
			try {
				System.out.println("***************Menu****************");
				System.out.println("Enter 1 for push");
				System.out.println("Enter 2 for pop");
				System.out.println("Enter 3 for top");
				System.out.println("Enter 4 for size");
				System.out.println("Enter 5 for isempty");
				System.out.println("Enter 6 for display");
				System.out.println("Enter x for exit");

				choice = scn.next().charAt(0);
				switch (choice) {
				case '1':
					System.out.println("Enter data");
					stack.push(scn.nextInt());
					break;
				case '2':
					System.out.println(stack.pop());
					break;
				case '3':
					System.out.println(stack.top());
					break;
				case '4':
					System.out.println(stack.size());
					break;
				case '5':
					System.out.println(stack.isEmpty());
					break;
				case '6':
					stack.display();
					break;
				case 'x':
					break;
				default:
					System.out.println("Wrong choice. Try again.");
					break;
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			} finally {

			}
		} while (choice != 'x');

		System.out.println("Thanks for using");
	}

}
