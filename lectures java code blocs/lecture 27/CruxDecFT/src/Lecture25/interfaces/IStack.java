package Lecture25.interfaces;

public interface IStack {
	void push(int item) throws Exception;
	int pop() throws Exception;
	int top() throws Exception;
	int size();
	boolean isEmpty();
	void display();
}
