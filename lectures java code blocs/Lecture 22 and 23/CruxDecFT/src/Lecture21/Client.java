package Lecture21;

import java.util.PriorityQueue;

public class Client {

	public static void main(String[] args) {
		Heap<Student> rankList = new Heap<>();
		
		rankList.add(new Student(700, 30, "C"));
		rankList.add(new Student(500, 50, "A"));
		rankList.add(new Student(900, 10, "E"));
		rankList.add(new Student(100, 90, "AK"));
		rankList.add(new Student(400, 60, "NM"));
		rankList.add(new Student(600, 40, "B"));
		rankList.add(new Student(800, 20, "D"));
		rankList.add(new Student(200, 80, "LY"));
		rankList.add(new Student(300, 70, "MY"));
		
		while(!rankList.isEmpty()){
			System.out.println(rankList.remove());
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
			return this.name + ", M = " + this.marks + ", R = " + this.rank; 
		}

		@Override
		public int compareTo(Student o) {
			return this.marks - o.marks;
		}
		
		
	}

}
