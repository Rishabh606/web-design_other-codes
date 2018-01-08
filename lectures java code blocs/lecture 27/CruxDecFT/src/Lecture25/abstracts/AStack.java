package Lecture25.abstracts;

public abstract class AStack {
	public abstract void push(int item) throws Exception;
	public abstract int pop() throws Exception;
	public abstract int top() throws Exception;
	public abstract int size();
	public final boolean isEmpty(){
		return this.size() == 0;
	}
	public abstract void display();
}
