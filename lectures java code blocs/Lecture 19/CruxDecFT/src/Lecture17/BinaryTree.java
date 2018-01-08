package Lecture17;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {
	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private Node root;
	private int size;

	public BinaryTree() {
		Scanner scn = new Scanner(System.in);
		this.root = this.takeInput(scn, null, false);
	}

	private Node takeInput(Scanner scn, Node parent, boolean leftOrRight) {
		if (parent == null) {
			System.out.println("Enter the data for root");
		} else {
			if (leftOrRight) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}
		}

		int cdata = scn.nextInt();

		Node child = new Node(cdata, null, null);
		this.size++;

		boolean choice = false;

		System.out.println("Do you have a left child for " + child.data);
		choice = scn.nextBoolean();

		if (choice) {
			child.left = this.takeInput(scn, child, true);
		}

		System.out.println("Do you have a right child for " + child.data);
		choice = scn.nextBoolean();

		if (choice) {
			child.right = this.takeInput(scn, child, false);
		}

		return child;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		this.display(this.root);
		System.out.println("****************");
	}

	private void display(Node node) {
		if (node.left != null) {
			System.out.print(node.left.data + " => ");
		} else {
			System.out.print("END => ");
		}

		System.out.print(node.data);

		if (node.right != null) {
			System.out.print(" <= " + node.right.data);
		} else {
			System.out.print(" <= END");
		}

		System.out.println();

		if (node.left != null) {
			this.display(node.left);
		}

		if (node.right != null) {
			this.display(node.right);
		}
	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}

		int rv = 0;

		int lsize = this.size2(node.left);
		int rsize = this.size2(node.right);

		rv = lsize + rsize + 1;

		return rv;
	}

	public int min() {
		return this.min(this.root);
	}

	private int min(Node node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}

		int rv = node.data;

		int lmin = this.min(node.left);
		int rmin = this.min(node.right);

		rv = Math.min(rv, Math.min(lmin, rmin));

		return rv;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int rv = node.data;

		int lmax = this.max(node.left);
		int rmax = this.max(node.right);

		rv = Math.max(rv, Math.max(lmax, rmax));

		return rv;
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}

		int rv = 0;

		int lh = height(node.left);
		int rh = height(node.right);

		rv = Math.max(lh, rh) + 1;

		return rv;
	}

	public boolean find(int data) {
		return this.find(this.root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}

		if (node.data == data) {
			return true;
		} else if (this.find(node.left, data) == true) {
			return true;
		} else if (this.find(node.right, data) == true) {
			return true;
		} else {
			return false;
		}
	}

	public void mirror(){
		this.mirror(this.root);
	}
	
	private void mirror(Node node){
		if(node == null){
			return;
		}
		
		this.mirror(node.left);
		this.mirror(node.right);
		
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

	public void preOrder(){
		this.preOrder(this.root);
		System.out.println("END");
	}
	
	private void preOrder(Node node){
		if(node == null){
			return;
		}
		
		System.out.print(node.data + ", ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void postOrder(){
		this.postOrder(this.root);
		System.out.println("END");
	}
	
	private void postOrder(Node node){
		if(node == null){
			return;
		}
		
		postOrder(node.left);
		postOrder(node.right);
		
		System.out.print(node.data + ", ");
	}
	
	public void inOrder(){
		this.inOrder(this.root);
		System.out.println("END");
	}
	
	private void inOrder(Node node){
		if(node == null){
			return;
		}
		
		inOrder(node.left);
		System.out.print(node.data + ", ");
		inOrder(node.right);
	}

	public void levelOrder(){
		LinkedList<Node> queue = new LinkedList<>();
		
		queue.addLast(this.root);
		while(!queue.isEmpty()){
			Node temp = queue.removeFirst();
			
			System.out.print(temp.data + ", ");
			
			if(temp.left != null){
				queue.addLast(temp.left);
			}
			
			if(temp.right != null){
				queue.addLast(temp.right);
			}
		}
		
		System.out.println("END");
	}
	
	public void preOrderI(){
		LinkedList<Node> stack = new LinkedList<>();
		
		stack.addFirst(this.root);
		while(!stack.isEmpty()){
			Node temp = stack.removeFirst();
			
			System.out.print(temp.data + ", ");
			
			if(temp.right != null){
				stack.addFirst(temp.right);
			}
			
			if(temp.left != null){
				stack.addFirst(temp.left);
			}
		}
		
		System.out.println("END");
	}

	public Integer postOrderPred(int data){
		HeapMover mover = new HeapMover();
		this.postOrderPredSucc(this.root, data, mover);
		
		return mover.pred == null? null: mover.pred.data;
	}
	
	private void postOrderPredSucc(Node node, int data, 
							   HeapMover mover)	{
		
		if(node == null){
			return;
		}
		
		postOrderPredSucc(node.left, data, mover);
		postOrderPredSucc(node.right, data, mover);
		
		// work
		if(mover.item == null){
			if(node.data == data){
				mover.item = node;
			} else {
				mover.pred = node;
			}
		} else {
			if(mover.succ == null){
				mover.succ = node;
			}
		}
	}
	
	public Integer postOrderSucc(int data){
		HeapMover mover = new HeapMover();
		this.postOrderPredSucc(this.root, data, mover);
		
		return mover.succ == null? null: mover.succ.data;
	}
	
	private class HeapMover {
		Node pred;
		Node item;
		Node succ;
	}
	
	private void multiCalculator(Node node, HeapMoverMulti multi, int level){
		if(node == null){
			return;
		}
		
		// work area
		
		multi.size += 1;
		multi.sum += node.data;
		
		if(level > multi.level){
			multi.level = level;
		}
		
		if(node.data < multi.min){
			multi.min = node.data;
		}
		
		if(node.data > multi.max){
			multi.max = node.data;
		}
		
		multiCalculator(node.left, multi, level + 1);
		multiCalculator(node.right, multi, level + 1);
	}
	
	public void multiCalculator(){
		HeapMoverMulti multi = new HeapMoverMulti();
		
		multi.max = Integer.MIN_VALUE;
		multi.min = Integer.MAX_VALUE;
		
		this.multiCalculator(this.root, multi, 0);
		
		System.out.println(multi.size);
		System.out.println(multi.level);
		System.out.println(multi.min);
		System.out.println(multi.max);
		System.out.println(multi.sum);
	}
	
	private class HeapMoverMulti {
		int size;
		int sum;
		int min;
		int max;
		int level;

	}
}
