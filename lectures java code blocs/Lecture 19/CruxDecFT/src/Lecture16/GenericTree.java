package Lecture16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GenericTree {
	private class Node {
		int data;
		ArrayList<Node> children;

		public Node(int data) {
			this.data = data;
			this.children = new ArrayList<>();
		}
	}

	private Node root;
	private int size;

	public GenericTree() {
		Scanner scn = new Scanner(System.in);
		this.root = this.takeInput(scn, null, 0);
	}

	private Node takeInput(Scanner scn, Node parent, int ithChild) {
		if (parent == null) {
			System.out.println("Enter the data for root node");
		} else {
			System.out.println("Enter the data for " + ithChild + " child of " + parent.data);
		}

		int childData = scn.nextInt();

		System.out.println("Enter the number of children for " + childData);
		int numGC = scn.nextInt();

		Node child = new Node(childData);
		this.size++;

		for (int i = 0; i < numGC; i++) {
			Node gc = this.takeInput(scn, child, i);
			child.children.add(gc);
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
		System.out.println("************************");
	}

	private void display(Node node) {
		System.out.print(node.data + " => ");
		for (int i = 0; i < node.children.size(); i++) {
			System.out.print(node.children.get(i).data + ", ");
		}

		System.out.println("END");

		for (int i = 0; i < node.children.size(); i++) {
			this.display(node.children.get(i));
		}
	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		int rv = 0;

		for (int i = 0; i < node.children.size(); i++) {
			int csize = this.size2(node.children.get(i));
			rv += csize;
		}

		// for the node itself
		rv += 1;

		return rv;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		int max = node.data;

		for (int i = 0; i < node.children.size(); i++) {
			int cmax = this.max(node.children.get(i));
			if (cmax > max) {
				max = cmax;
			}
		}

		return max;
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		int maxCHeight = -1;

		for (int i = 0; i < node.children.size(); i++) {
			int cheight = this.height(node.children.get(i));
			if (cheight > maxCHeight) {
				maxCHeight = cheight;
			}
		}

		maxCHeight = maxCHeight + 1;

		return maxCHeight;
	}

	public boolean find(int data) {
		return this.find(this.root, data);
	}

	private boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}

		for (int i = 0; i < node.children.size(); i++) {
			boolean foundInChild = this.find(node.children.get(i), data);

			if (foundInChild) {
				return true;
			}
		}

		return false;
	}

	public Integer justLarger(int data) {
		Node jl = justLarger(this.root, data);

		if (jl != null) {
			return jl.data;
		} else {
			return null;
		}
	}

	private Node justLarger(Node node, int data) {
		Node rv = null;

		if (node.data > data) {
			rv = node;
		}

		for (int i = 0; i < node.children.size(); i++) {
			Node cjl = this.justLarger(node.children.get(i), data);

			if (cjl == null) {
				continue;
			} else {
				if (rv == null) {
					rv = cjl;
				} else {
					if (cjl.data < rv.data) {
						rv = cjl;
					}
				}
			}
		}

		return rv;
	}

	public int kthSmallest(int k) {
		int rv = Integer.MIN_VALUE;

		int counter = 0;
		while (counter < k) {
			rv = justLarger(this.root, rv).data;
			counter++;
		}

		return rv;
	}

	public void mirror() {
		this.mirror(this.root);
	}

	private void mirror(Node node) {
		int left = 0, right = node.children.size() - 1;
		while (left <= right) {
			Node temp = node.children.get(left);
			node.children.set(left, node.children.get(right));
			node.children.set(right, temp);

			left++;
			right--;
		}

		for (int i = 0; i < node.children.size(); i++) {
			this.mirror(node.children.get(i));
		}
	}

	public void printAtLevel(int level) {
		this.printAtLevel(this.root, level);
	}

	private void printAtLevel(Node node, int level) {
		if (level == 0) {
			System.out.println(node.data);
			return;
		}

		for (int i = 0; i < node.children.size(); i++) {
			this.printAtLevel(node.children.get(i), level - 1);
		}
	}

	public void preOrder() {
		this.preOrder(this.root);
		System.out.println("END");
	}

	private void preOrder(Node node) {
		System.out.print(node.data + ", ");
		for (int i = 0; i < node.children.size(); i++) {
			this.preOrder(node.children.get(i));
		}
	}

	public void postOrder() {
		this.postOrder(this.root);
		System.out.println("END");
	}

	private void postOrder(Node node) {
		for (int i = 0; i < node.children.size(); i++) {
			this.postOrder(node.children.get(i));
		}
		System.out.print(node.data + ", ");
	}

	public void linearize() {
		this.linearizeWOGT(this.root);
	}

	private void linearize(Node node) {
		for (int i = 0; i < node.children.size(); i++) {
			this.linearize(node.children.get(i));
		}

		Node tail = null;
		while (node.children.size() > 1) {
			Node removed = node.children.remove(1);
			tail = this.getTail(node.children.get(0));
			tail.children.add(removed);
		}
	}

	private Node getTail(Node node) {
		Node rv = node;

		while (rv.children.size() != 0) {
			rv = rv.children.get(0);
		}

		return rv;
	}

	private Node linearizeWOGT(Node node){
		if(node.children.size() == 0){
			return node;
		}
		
		Node tail = this.linearizeWOGT(node.children.get(0));
		while(node.children.size() > 1){
			Node removed = node.children.remove(1);
			Node removedTail = this.linearizeWOGT(removed);
			tail.children.add(removed);
			
			tail = removedTail;
		}
		
		return tail;
	}

	public int maxSONC(){
		return this.maxSONC(this.root).data;
	}
	
	private Node maxSONC(Node node){
		Node max = node;

		for (int i = 0; i < node.children.size(); i++) {
			Node cmax = this.maxSONC(node.children.get(i));
			if(getScore(cmax) > getScore(max)){
				max = cmax;
			}
		}

		return max;
	}
	
	private int getScore(Node node){
		System.out.println("Hi to " + node.data);
		int rv = node.data;
		
		for(int i = 0; i < node.children.size(); i++){
			rv += node.children.get(i).data;
		}
		
		return rv;
	}

	private class HeapMover {
		Node node;
		int score;
		
		private HeapMover(Node node){
			this.node = node;
			this.score = getScore(node);
		}
	}
	
	public int maxSONC2(){
		return this.maxSONC2(this.root).node.data;
	}
	
	private HeapMover maxSONC2(Node node){
		HeapMover max = new HeapMover(node);
		
		for(int i = 0; i < node.children.size(); i++){
			HeapMover cmax = this.maxSONC2(node.children.get(i));
			if(cmax.score > max.score){
				max = cmax;
			}
		}
		
		return max;
	}

	private class HeapMoverTR {
		int max;
		int min;
		
		public HeapMoverTR(Node node) {
			this.max = node.data;
			this.min = node.data;
		}
		
		public HeapMoverTR(){
			this.max = Integer.MIN_VALUE;
			this.min = Integer.MAX_VALUE;
			
		}
	}
	
	public int getRange(){
		HeapMoverTR rm = this.getRange(this.root);
		return rm.max - rm.min;
	}
	
	private HeapMoverTR getRange(Node node){
		HeapMoverTR rv = new HeapMoverTR(node);
		
		for(int i = 0; i < node.children.size(); i++){
			HeapMoverTR cm = this.getRange(node.children.get(i));
			
			if(cm.max > rv.max){
				rv.max = cm.max;
			}
			
			if(cm.min < rv.min){
				rv.min = cm.min;
			}
		}
		
		return rv;
	}

	public int getRangeTD(){
		HeapMoverTR mover = new HeapMoverTR();
		this.getRangeTD(this.root, mover);
		
		return mover.max - mover.min;
	}
	
	private void getRangeTD(Node node, HeapMoverTR mover){
		// work area
		if(node.data > mover.max){
			mover.max = node.data;
		}
		
		if(node.data < mover.min){
			mover.min = node.data;
		}
		
		for (int i = 0; i < node.children.size(); i++) {
			this.getRangeTD(node.children.get(i), mover);
		}
	}

	public void levelOrderIterative(){
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(this.root);
		while(!queue.isEmpty()){
			Node node = queue.remove();
			
			System.out.print(node.data + ", ");
			
			for(int i = 0; i < node.children.size(); i++){
				queue.add(node.children.get(i));
			}
		}
		
		System.out.println("END");
	}

	public void preOrderIterative(){
		Stack<Node> stack = new Stack<>();
		
		stack.push(this.root);
		while(!stack.isEmpty()){
			Node node = stack.pop();
			
			System.out.print(node.data + ", ");
			
			for(int i = node.children.size() - 1; i >= 0; i--){
				stack.push(node.children.get(i));
			}
		}
		
		System.out.println("END");
	}

	private class HML {
		Node head;
		Node tail;
	}
	
	public void linearizeTD(){
		HML mover = new HML();
		
		this.linearizeTD(this.root, mover);
		
		this.root = mover.head;
	}
	
	private void linearizeTD(Node node, HML mover){
		if(node == this.root){
			mover.head = new Node(node.data);
			mover.tail = mover.head;
		} else {
			Node nn = new Node(node.data);
			mover.tail.children.add(nn);
			mover.tail = nn;
		}
		
		for(int i = 0; i < node.children.size(); i++){
			this.linearizeTD(node.children.get(i), mover);
		}
	}
	
	// maxSONC, linearize - BU/TD, getRange - BU/TD, preOP, preOS, postOP, postOS
	
}
