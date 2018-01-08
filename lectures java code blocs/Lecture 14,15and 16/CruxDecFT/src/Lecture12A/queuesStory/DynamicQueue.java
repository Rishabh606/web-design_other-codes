package Lecture12A.queuesStory;

import Lecture12.storyqueues.Queue;

public class DynamicQueue extends Queue {
	public DynamicQueue() {
		this(DEFAULT_CAPACITY);
	}

	public DynamicQueue(int capacity) {
		super(capacity);
	}

	@Override
	public void enqueue(int item) {
		if (this.size() == this.data.length) {
			int[] temp = new int[2 * this.data.length];

			for (int i = 0; i < this.size(); i++) {
				int ai = (i + this.front) % this.data.length;
				temp[i] = this.data[ai];
			}

			this.data = temp;
			this.front = 0;
		}

		try {
			super.enqueue(item);
		} catch (Exception ex) {
			// only a placeholder, no reasons to land here.
		}
	}
	
	@Override
	public int dequeue() throws Exception {
		if(this.size() == this.data.length / 4){
			int[] temp = new int[this.data.length / 2];

			for (int i = 0; i < this.size(); i++) {
				int ai = (i + this.front) % this.data.length;
				temp[i] = this.data[ai];
			}
			
			this.data = temp;
			this.front = 0;
		}
		
		return super.dequeue();
	}
}
