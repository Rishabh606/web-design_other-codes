package Lecture16;

import java.util.ArrayList;

public class Client {
// 10 3 20 2 50 0 60 0 30 3 70 0 80 0 90 0 40 1 100 0
	public static void main(String[] args) {
		GenericTree tree = new GenericTree();
		tree.display();
		
		System.out.println(tree.justLarger(-1));
		
		System.out.println(tree.kthSmallest(1));
		
//		ArrayList<Integer> list = new ArrayList<>();
//		
//		int temp = list.get(0);
//		list.set(0, list.get(10));
//		list.set(10, temp);
//		
		tree.mirror();
		tree.display();
	}

}
