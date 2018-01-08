package Lecture12A.stacksStory;

import java.util.Scanner;

import Lecture12.storystacks.Stack;

public class DynamicStackClient {

	public static void main(String[] args) {
		Stack st;
		
		boolean useDynamic = Boolean.parseBoolean(args[0]);
		
		if(useDynamic){
			st = new DynamicStack();
		} else {
			st = new Stack();
		}
		
		Scanner scn = new Scanner(System.in);
		char ch = '\0';

		do {
			try {
				System.out.println("******************* Menu *******************");
				System.out.println("1 for push");
				System.out.println("2 for pop");
				System.out.println("3 for top");
				System.out.println("4 for size");
				System.out.println("5 for Is Empty");
				System.out.println("6 for display");
				System.out.println("X/x for exit");

				ch = scn.next().charAt(0);
				switch (ch) {
				case '1':
					System.out.println("Enter the item to push");
					st.push(scn.nextInt());
					break;
				case '2':
					System.out.println(st.pop());
					break;
				case '3':
					System.out.println(st.top());
					break;
				case '4':
					System.out.println(st.size());
					break;
				case '5':
					System.out.println(st.isEmpty());
					break;
				case '6':
					st.display();
					break;
				case 'x':
				case 'X':
					break;
				default:
					System.out.println("Wrong option. Try again.");
					break;
				}
			} catch (Exception ex) {
				System.out.println("Some error. Details => " + ex.getMessage());
				System.out.println("Try again.");
			}
		} while (ch != 'X' && ch != 'x');

		System.out.println("Thanks");
	}

}
