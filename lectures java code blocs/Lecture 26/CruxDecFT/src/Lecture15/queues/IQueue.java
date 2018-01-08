package Lecture15.queues;

public interface IQueue {
	void display();
	boolean isEmpty();
	int size();
	void enqueue(int data);
	int dequeue() throws Exception;
	int front() throws Exception;
}
