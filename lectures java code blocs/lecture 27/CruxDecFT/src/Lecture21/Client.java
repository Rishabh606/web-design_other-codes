package Lecture21;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Client {

	public static void main(String[] args) {
//		Student[] students = new Student[9];
//		
//		students[0] = new Student(700, 30, "C");
//		students[1] = new Student(500, 50, "A");
//		students[2] = new Student(900, 10, "E");
//		students[3] = new Student(100, 90, "AK");
//		students[4] = new Student(400, 60, "NM");
//		students[5] = new Student(600, 40, "B");
//		students[6] = new Student(800, 20, "D");
//		students[7] = new Student(200, 80, "LY");
//		students[8] = new Student(300, 70, "MY");
//		
//		Heap<Student> rankList = new Heap<>(students, false);
		
//		rankList.add(new Student(700, 30, "C"));
//		rankList.add(new Student(500, 50, "A"));
//		rankList.add(new Student(900, 10, "E"));
//		rankList.add(new Student(100, 90, "AK"));
//		rankList.add(new Student(400, 60, "NM"));
//		rankList.add(new Student(600, 40, "B"));
//		rankList.add(new Student(800, 20, "D"));
//		rankList.add(new Student(200, 80, "LY"));
//		rankList.add(new Student(300, 70, "MY"));
		
//		rankList.display();
		
//		while(!rankList.isEmpty()){
//			System.out.println(rankList.remove());
//		}
		
		Integer[] arr = {10, 20, 80, 30, 14, 19, 22};
		heapSort(arr);
		
		for(int val: arr){
			System.out.println(val);
		}
	}
	
	public static class Student implements Comparable<Student> {
		int marks;
		int rank;
		String name;
		
		Student(int marks, int rank, String name){
			this.marks = marks;
			this.rank = rank;
			this.name = name;
		}
		
		@Override
		public String toString(){
			return "{" + this.name + ", M = " + this.marks + ", R = " + this.rank + "}"; 
		}

		@Override
		public int compareTo(Student o) {
			return this.marks - o.marks;
		}
		
		
	}

	public static void heapSort(Integer[] arr){
		for(int i = arr.length / 2 - 1; i >= 0; i--){
			downHeapify(arr, i, arr.length);
		}
		
		for(int i = 0; i < arr.length; i++){
			Integer temp = arr[0];
			arr[0] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
			
			downHeapify(arr, 0, arr.length - 1 - i);
		}
	}
	
	private static void downHeapify(Integer[] arr, int pi, int lp) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mi = pi;

		if (lci < lp && arr[lci] > arr[mi]) {
			mi = lci;
		}

		if (rci < lp && arr[rci] > arr[mi]) {
			mi = rci;
		}

		if (mi != pi) {
			int temp = arr[mi];
			arr[mi] = arr[pi];
			arr[pi] = temp;
			
			downHeapify(arr, mi, lp);
		}
	}

	private static ArrayList<Integer> mergeKSortedLists(
			ArrayList<ArrayList<Integer>> sortedLists){
		return null;
	}
}
