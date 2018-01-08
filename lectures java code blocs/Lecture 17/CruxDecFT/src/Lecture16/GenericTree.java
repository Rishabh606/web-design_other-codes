package Lecture16;

import java.util.ArrayList;
import java.util.Scanner;

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
	
	public GenericTree(){
		Scanner scn = new Scanner(System.in);
		this.root = this.takeInput(scn, null, 0);
	}
	
	private Node takeInput(Scanner scn, Node parent, int ithChild){
		if(parent == null){
			System.out.println("Enter the data for root node");
		} else {
			System.out.println("Enter the data for " + ithChild + " child of " + parent.data);
		}
		
		int childData = scn.nextInt();
		
		System.out.println("Enter the number of children for " + childData);
		int numGC = scn.nextInt();
		
		Node child = new Node(childData);
		this.size++;
		
		for(int i = 0; i < numGC; i++){
			Node gc = this.takeInput(scn, child, i);
			child.children.add(gc);
		}
		
		return child;
	}

	public int size(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return this.size() == 0;
	}
	
	public void display(){
		this.display(this.root);
	}
	
	private void display(Node node){
		System.out.print(node.data + " => ");
		for(int i = 0; i < node.children.size(); i++){
			System.out.print(node.children.get(i).data + ", ");
		}
		
		System.out.println("END");
		
		for(int i = 0; i < node.children.size(); i++){
			this.display(node.children.get(i));
		}
	}
	
	
	public int size2(){
		return this.size2(this.root);
	}
	
	private int size2(Node node){
		int rv = 0;
		
		for(int i = 0; i < node.children.size(); i++){
			int csize = this.size2(node.children.get(i));
			rv += csize;
		}
		
		// for the node itself
		rv += 1;
		
		return rv;
	}
	
	public int max(){
		return this.max(this.root);
	}
	
	private int max(Node node){
		int max = node.data;
		
		for(int i = 0; i < node.children.size(); i++){
			int cmax = this.max(node.children.get(i));
			if(cmax > max){
				max = cmax;
			}
		}
		
		return max;
	}
	
	public int height(){
		return this.height(this.root);
	}
	
	private int height(Node node){
		int maxCHeight = -1;
		
		for(int i = 0; i < node.children.size(); i++){
			int cheight = this.height(node.children.get(i));
			if(cheight > maxCHeight){
				maxCHeight = cheight;
			}
		}
		
		maxCHeight = maxCHeight + 1;
		
		return maxCHeight;
	}
	
	public boolean find(int data){
		return this.find(this.root, data);
	}
	
	private boolean find(Node node, int data){
		if(node.data == data){
			return true;
		}
		
		for(int i = 0; i < node.children.size(); i++){
			boolean foundInChild = this.find(node.children.get(i), data);
			
			if(foundInChild){
				return true;
			}
		}
		
		return false;
	}
	
	public Integer justLarger(int data){
		Node jl = justLarger(this.root, data);
		
		if(jl != null){
			return jl.data;
		}else {
			return null;
		}
	}
	
	private Node justLarger(Node node, int data){
		Node rv = null;
		
		if(node.data > data){
			rv = node;
		}
		
		for(int i = 0; i < node.children.size(); i++){
			Node cjl = this.justLarger(node.children.get(i), data);
			
			if(cjl == null){
				continue;
			} else {
				if(rv == null){
					rv = cjl;
				} else {
					if(cjl.data < rv.data){
						rv = cjl;
					}
				}
			}
		}
		
		return rv;
	}
	
	public int kthSmallest(int k){
		int rv = Integer.MIN_VALUE;
		
		int counter = 0;
		while(counter < k){
			rv = justLarger(this.root, rv).data;
			counter++;
		}
		
		return rv;
	}
	
	public void mirror(){
		this.mirror(this.root);
	}
	
	private void mirror(Node node){
		int left = 0, right = node.children.size() - 1;
		while(left <= right){
			Node temp = node.children.get(left);
			node.children.set(left, node.children.get(right));
			node.children.set(right, temp);
			
			left++;
			right--;
		}
		
		for(int i = 0; i < node.children.size(); i++){
			this.mirror(node.children.get(i));
		}
	}

	public void printAtLevel(int level){
		this.printAtLevel(this.root, level);
	}
	
	private void printAtLevel(Node node, int level){
		if(level == 0){
			System.out.println(node.data);
			return;
		}
		
		for(int i = 0; i < node.children.size(); i++){
			this.printAtLevel(node.children.get(i), level - 1);
		}
	}
}
