package Lecture12A.queuesStory;

import java.util.Scanner;
import Lecture12.storyqueues.Queue;


public class DynamicQueueClient {

	public static void main(String[] args) {
		Queue qu;
		
		boolean useDynamic = Boolean.parseBoolean(args[0]);
		
		if(useDynamic){
			qu = new DynamicQueue();
		} else {
			qu = new Queue();
		}
		
		Scanner scn = new Scanner(System.in);
		char ch = '\0';

		do {
			try {
				System.out.println("******************* Menu *******************");
				System.out.println("1 for enqueue");
				System.out.println("2 for dequeue");
				System.out.println("3 for front");
				System.out.println("4 for size");
				System.out.println("5 for Is Empty");
				System.out.println("6 for display");
				System.out.println("X/x for exit");

				ch = scn.next().charAt(0);
				switch (ch) {
				case '1':
					System.out.println("Enter the item to push");
					qu.enqueue(scn.nextInt());
					break;
				case '2':
					System.out.println(qu.dequeue());
					break;
				case '3':
					System.out.println(qu.front());
					break;
				case '4':
					System.out.println(qu.size());
					break;
				case '5':
					System.out.println(qu.isEmpty());
					break;
				case '6':
					qu.display();
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
