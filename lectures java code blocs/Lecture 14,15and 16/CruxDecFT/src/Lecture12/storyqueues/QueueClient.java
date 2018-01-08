package Lecture12.storyqueues;

public class QueueClient {

	public static void main(String[] args) throws Exception {
		Queue q = new Queue();
		
		q.enqueue(10);
		displayQueueInfo(q);
		
		q.enqueue(20);
		displayQueueInfo(q);
		
		q.enqueue(30);
		displayQueueInfo(q);
		
		q.enqueue(40);
		displayQueueInfo(q);
		
		q.enqueue(50);
		displayQueueInfo(q);
		
//		q.enqueue(10);
//		displayQueueInfo(q);
		
		System.out.println(q.front());
		System.out.println(q.dequeue());
		displayQueueInfo(q);
		
		System.out.println(q.front());
		System.out.println(q.dequeue());
		displayQueueInfo(q);
		
		q.enqueue(60);
		displayQueueInfo(q);
		
		q.enqueue(70);
		displayQueueInfo(q);
		
		System.out.println("Thanks");
	}
	
	public static void displayQueueInfo(Queue q){
		System.out.println("Size = " + q.size());
		System.out.println("Empty = " + q.isEmpty());
		q.display();
	}

}
