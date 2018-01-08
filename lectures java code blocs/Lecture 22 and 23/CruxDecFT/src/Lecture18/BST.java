package Lecture18;

import java.util.LinkedList;
import java.util.Scanner;

public class BST {
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

	public BST() {
		this.root = null;
		this.size = 0;
	}

	public BST(int... sa) {
		this.root = this.construct(sa, 0, sa.length - 1);
	}

	private Node construct(int[] sa, int lo, int hi) {
		if (lo > hi) {
			return null;
		}

		int mid = (hi + lo) / 2;

		Node rv = new Node(sa[mid], null, null);
		this.size++;

		rv.left = this.construct(sa, lo, mid - 1);
		rv.right = this.construct(sa, mid + 1, hi);

		return rv;
	}

	public void add(int data) {
		if (this.isEmpty()) {
			this.root = new Node(data, null, null);
			this.size++;
		} else {
			this.addNode(this.root, data);
		}
	}

	private void addNode(Node node, int data) {
		if (data > node.data) {
			if (node.right != null) {
				this.addNode(node.right, data);
			} else {
				node.right = new Node(data, null, null);
				this.size++;
			}
		} else if (data < node.data) {
			if (node.left != null) {
				this.addNode(node.left, data);
			} else {
				node.left = new Node(data, null, null);
				this.size++;
			}
		} else {
			// won't do anthing - already exists
		}
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
		int rv = node.data;

		if (node.left != null) {
			rv = min(node.left);
		}

		return rv;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		// if (node == null) {
		// return Integer.MIN_VALUE;
		// }
		//
		// int rv = node.data;
		//
		// int lmax = this.max(node.left);
		// int rmax = this.max(node.right);
		//
		// rv = Math.max(rv, Math.max(lmax, rmax));
		//
		// return rv;

		int rv = node.data;

		if (node.right != null) {
			rv = max(node.right);
		}

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

		if (data < node.data) {
			return this.find(node.left, data);
		} else if (data > node.data) {
			return this.find(node.right, data);
		} else {
			return true;
		}
	}

	public void preOrder() {
		this.preOrder(this.root);
		System.out.println("END");
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + ", ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void postOrder() {
		this.postOrder(this.root);
		System.out.println("END");
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}

		postOrder(node.left);
		postOrder(node.right);

		System.out.print(node.data + ", ");
	}

	public void inOrder() {
		this.inOrder(this.root);
		System.out.println("END");
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.data + ", ");
		inOrder(node.right);
	}

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<>();

		queue.addLast(this.root);
		while (!queue.isEmpty()) {
			Node temp = queue.removeFirst();

			System.out.print(temp.data + ", ");

			if (temp.left != null) {
				queue.addLast(temp.left);
			}

			if (temp.right != null) {
				queue.addLast(temp.right);
			}
		}

		System.out.println("END");
	}

	public void preOrderI() {
		LinkedList<Node> stack = new LinkedList<>();

		stack.addFirst(this.root);
		while (!stack.isEmpty()) {
			Node temp = stack.removeFirst();

			System.out.print(temp.data + ", ");

			if (temp.right != null) {
				stack.addFirst(temp.right);
			}

			if (temp.left != null) {
				stack.addFirst(temp.left);
			}
		}

		System.out.println("END");
	}

	public int diameter() {
		return this.diameter(this.root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}

		int lh = this.height(node.left);
		int rh = this.height(node.right);

		int ld = this.diameter(node.left);
		int rd = this.diameter(node.right);

		int f1 = ld, f2 = rd, f3 = lh + rh + 2;

		return Math.max(f1, Math.max(f2, f3));
	}

	private class DiaPair {
		int height;
		int diameter;
	}

	public int diameterBtr() {
		DiaPair rootpair = this.diameterBtr(this.root);
		return rootpair.diameter;
	}

	private DiaPair diameterBtr(Node node) {
		if (node == null) {
			DiaPair basepair = new DiaPair();

			basepair.height = -1;
			basepair.diameter = 0;

			return basepair;
		}

		DiaPair lpair = this.diameterBtr(node.left);
		DiaPair rpair = this.diameterBtr(node.right);

		DiaPair mypair = new DiaPair();

		mypair.height = Math.max(lpair.height, rpair.height) + 1;

		int f1 = lpair.diameter;
		int f2 = rpair.diameter;
		int f3 = lpair.height + rpair.height + 2;

		mypair.diameter = Math.max(f1, Math.max(f2, f3));

		return mypair;
	}

	private class LinPair {
		Node head;
		Node tail;
	}

	public void linearize(){
		LinPair rp = this.linearize(this.root);
		this.root = rp.head;
	}

	private LinPair linearize(Node node) {
		if (node == null) {
			return null;
		}

		LinPair lp = this.linearize(node.left);
		LinPair rp = this.linearize(node.right);

		node.left = null;

		if (lp != null) {
			lp.tail.right = node;
		}

		if(rp != null){
			node.right = rp.head;
		}

		LinPair mp = new LinPair();
		
		mp.head = lp == null? node: lp.head;
		mp.tail = rp == null? node: rp.tail;

		return mp;
	}

	public void pir(int sno, int lno){
		this.pir(this.root, sno, lno);
	}
	
	private void pir(Node node, int sno, int lno){
		if(node == null){
			return;
		}
		
		if(node.data > lno){
			this.pir(node.left, sno, lno);
		} else if(node.data < sno){
			this.pir(node.right, sno, lno);
		} else {
			this.pir(node.left, sno, lno);
			
			System.out.println(node.data);
			
			this.pir(node.right, sno, lno);
		}
	}

	public void remove(int data){
		this.remove(this.root, null, false, data);
	}
	
	private void remove(Node node, Node parent, boolean ilc, int data){
		if(node == null){
			return;
		}
		
		if(data > node.data){
			this.remove(node.right, node, false, data);
		} else if(data < node.data){
			this.remove(node.left, node, true, data);
		} else {
			// this node is to be removed;
			if(node.left != null && node.right != null){
				int lmax = this.max(node.left);
				node.data = lmax;
				this.remove(node.left, node, true, lmax);
				
			} else if(node.left != null){
				
			} else if(node.right != null){
				
			} else {
				if(ilc){
					parent.left = null;
				} else {
					parent.right = null;
				}
				
				this.size--;
			}
						
						
		}
		
	}
}
