package Lecture20.story_genericll;

public class LinkedList<T> {

	private class Node {
		T data;
		Node next;

		Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	// O(n)
	public void display() {
		Node node = this.head;

		while (node != null) {
			System.out.print(node.data + " => ");
			node = node.next;
		}

		System.out.println("END");
		System.out.println("**************************************");
	}

	public void addFirst(T data) {
		Node node = new Node(data, this.head);
		this.head = node;

		if (this.isEmpty()) {
			this.tail = this.head;
		}

		this.size++;
	}

	public void addLast(T data) {
		Node node = new Node(data, null);

		if (this.isEmpty()) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}

		this.size++;
	}

	// O(n)
	public void addAt(T data, int idx) throws Exception {
		if (idx < 0 || idx > this.size()) {
			throw new Exception("Argument invalid");
		}

		if (idx == 0) {
			this.addFirst(data);
		} else if (idx == this.size()) {
			this.addLast(data);
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;

			Node node = new Node(data, n);
			nm1.next = node;
			this.size++;
		}
	}

	// O(n)
	private Node getNodeAt(int idx) throws Exception {
		if (idx < 0 || idx >= this.size()) {
			throw new Exception("Argument invalid");
		}

		int counter = 0;
		Node rv = this.head;
		while (counter < idx) {

			rv = rv.next;
			counter++;
		}

		return rv;
	}

	public T getFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		return this.head.data;
	}

	public T getLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		return this.tail.data;
	}

	// O(n)
	public T getAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		if (idx < 0 || idx >= this.size()) {
			throw new Exception("Index out of bound exception");
		}

		Node node = this.getNodeAt(idx);
		return node.data;
	}

	public T removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		Node node = this.head;

		if (this.size == 1) {
			this.head = this.tail = null;
		} else {
			this.head = this.head.next;
		}

		this.size--;

		return node.data;
	}

	// O(n)
	public T removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		Node rv = this.tail;

		if (this.size == 1) {
			this.head = this.tail = null;
		} else {
			Node nm2 = this.getNodeAt(this.size - 2);
			nm2.next = null;
			this.tail = nm2;
		}

		this.size--;

		return rv.data;
	}

	// O(n)
	public T removeAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		if (idx < 0 || idx >= this.size()) {
			throw new Exception("Index out of bound exception");
		}

		if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size() - 1) {
			return this.removeLast();
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;
			this.size--;

			return n.data;
		}
	}

	// O(n^2)
	public void reverseDI() throws Exception {
		int li = 0, ri = this.size - 1;

		while (li <= ri) {
			Node left = this.getNodeAt(li);
			Node right = this.getNodeAt(ri);

			// swap
			T temp = left.data;
			left.data = right.data;
			right.data = temp;

			li++;
			ri--;
		}
	}

	// O(n)
	public void reversePI() {
		Node prev = this.head;
		Node curr = prev.next;

		while (curr != null) {
			Node tempPrev = prev;
			Node tempCurr = curr;

			prev = curr;
			curr = curr.next;

			tempCurr.next = tempPrev;
		}

		// swap head and tail
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		// manage tail
		this.tail.next = null;
	}

	// O(n)
	public void reversePR() {
		this.reversePR(this.head);

		// swap head and tail
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		// manage tail
		this.tail.next = null;
	}

	private void reversePR(Node node) {
		if (node == this.tail) {
			return;
		}

		reversePR(node.next);
		node.next.next = node;
	}

	// O(n)
	public void reverseDR() {
		// this.reverseDR(this.head, this.head);
		HeapMover left = new HeapMover(this.head);
		this.reverseDR(left, this.head, 0);
	}

	// private void reverseDR(Node left, Node right){
	// if(right == null){
	// return;
	// }
	//
	// reverseDR(left, right.next);
	//
	// int temp = left.data;
	// left.data = right.data;
	// right.data = temp;
	//
	// left = left.next;
	// }

	private void reverseDR(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}

		reverseDR(left, right.next, floor + 1);

		if (floor >= this.size / 2) {
			T temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;

			left.node = left.node.next;
		}
	}

	private class HeapMover {
		Node node;

		HeapMover(Node node) {
			this.node = node;
		}
	}

	public T kthFromLast(int k) throws Exception {
		if (k < 1 || k > this.size) {
			throw new Exception("Invalid arguments");
		}

		Node fast = this.head, slow = this.head;

		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;
	}

	public T mid() {
		return this.midNode().data;
	}

	private Node midNode() {
		Node slow = this.head, fast = this.head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public void fold() {
		this.tail = this.fold(this.head, this.head, 0);
		this.tail.next = null;
	}

	private Node fold(Node left, Node right, int floor) {
		if (right == null) {
			return left;
		}

		left = fold(left, right.next, floor + 1);

		if (floor >= this.size / 2) {
			if (floor == this.size / 2 && this.size % 2 == 1) {
				return left;
			} else {
				Node oln = left.next;
				left.next = right;
				right.next = oln;

				return oln;
			}
		} else {
			return left;
		}
	}

	public int find(T data){
		int idx = 0;
		for(Node temp = this.head; temp != null; temp = temp.next){
			if(temp.data.equals(data)){
				return idx;
			}
		}
		
		return -1;
	}
}
