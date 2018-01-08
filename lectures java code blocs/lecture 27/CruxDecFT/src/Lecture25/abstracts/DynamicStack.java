package Lecture25.abstracts;

public class DynamicStack extends Stack {
	public DynamicStack() {
		this(DEFAULT_CAPACITY);
	}

	public DynamicStack(int capacity) {
		super(capacity);
	}

	@Override
	public void push(int item) {
		if (this.size() == this.data.length) {
			int[] temp = new int[2 * this.data.length];

			for (int i = 0; i < this.data.length; i++) {
				temp[i] = this.data[i];
			}

			this.data = temp;
		}

		try {
			super.push(item);
		} catch (Exception ex) {
			// we are sure, the code won't land here
		}
	}

	@Override
	public int pop() throws Exception {
		if (this.size() == this.data.length / 4) {
			int[] temp = new int[this.data.length / 2];

			for (int i = 0; i < this.size(); i++) {
				temp[i] = this.data[i];
			}

			this.data = temp;
		}

		return super.pop();
	}

}
