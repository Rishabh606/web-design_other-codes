package Lecture14;

public class Client {

	public static void main(String[] args) throws Exception {
		// // TODO Auto-generated method stub
		// System.out.println(Add("1", "2"));
		//
		// String s = "";

		LinkedList list = new LinkedList();

		list.addFirst(20);
		list.display();

		list.addFirst(10);
		list.display();

		list.addLast(30);
		list.display();

		list.addLast(40);
		list.display();

		list.addAt(50, 0);
		list.display();

		list.addAt(60, 5);
		list.display();

		list.addAt(70, 6);
		list.display();

		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.getAt(2));

		System.out.println(list.removeFirst());
//		System.out.println(list.removeLast());
//		System.out.println(list.removeAt(2));
		
		
		list.display();
		list.reverseDI();
		list.display();
		list.reversePI();
		list.display();
		list.reversePR();
		list.display();
		
		list.reverseDR();
		list.display();
		
		System.out.println(list.kthFromLast(2));
		System.out.println(list.mid());
		
		list.display();
		LinkedList other = new LinkedList();
		other.addLast(11);
		other.addLast(15);
		other.addLast(19);
		other.addLast(34);
		other.addLast(49);
		other.addLast(101);
		
		other.display();
		
		LinkedList merged = list.merge(other);
		merged.display();
		
		LinkedList test = new LinkedList();
		test.addLast(50);
		test.addLast(10);
		test.addLast(40);
		test.addLast(70);
		test.addLast(90);
		test.addLast(-10);
//		test.addLast(-20);
		
		test.display();
		test.mergeSort();
		test.display();
		
		test.fold();
		test.display();

		System.out.println("Thanks");
	}

	public static int Add(int one, int two) {
		System.out.println("hi");
		return one + two;
	}

	public static String Add(String one, String two) {
		return one + two;
	}

	public static float Add(float one, float two) {
		return one + two;
	}

	// Return type not part of signature for function overlaoding
	// public static void Add(int one, int two){
	// System.out.println(one + two);
	// }

	// varargs
	public static int Add(int... arguments) {
		int rv = 0;

		for (int val : arguments) {
			rv += val;
		}

		return rv;
	}

}
