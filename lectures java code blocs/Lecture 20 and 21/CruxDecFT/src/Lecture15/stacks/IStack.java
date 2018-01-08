package Lecture15.stacks;

public interface IStack {
	void display();
	boolean isEmpty();
	int size();
	void push(int data);
	int pop() throws Exception;
	int top() throws Exception;
}
