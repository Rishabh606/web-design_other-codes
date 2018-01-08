package Lecture23;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Trie {
	private class Node {
		Character data;
		boolean isTerminal;
		HashMap<Character, Node> children;
		
		Node(Character data, boolean isTerminal){
			this.data = data;
			this.isTerminal = isTerminal;
			this.children = new HashMap<>();
		}
	}
	
	private Node root;
	private int numWords;
	
	Trie(){
		this.root = new Node('\0', false);
		this.numWords = 0;
	}
	
	public int numWords(){
		return this.numWords;
	}
	
	public boolean isEmpty(){
		return this.numWords() == 0;
	}
	
	public void displayAsTree(){
		this.displayAsTree(this.root);
	}
	
	private void displayAsTree(Node node){
		String str = "";
		
		str += node.data + " => ";
		
		Set<Map.Entry<Character, Node>> children = node.children.entrySet();
		for(Map.Entry<Character, Node> child: children){
			str += child.getKey() + ", ";
		}
		
		str += "END";
		
		System.out.println(str);
		
		for(Map.Entry<Character, Node> child: children){
			this.displayAsTree(child.getValue());
		}
	}
	
	public void displayWords(){
		this.displayWords(this.root, "");
	}
	
	private void displayWords(Node node, String osf){
		// parent process
		if(node.isTerminal){
			String toPrint = osf.substring(1) + node.data;
			System.out.println(toPrint);
		}
		
		Set<Map.Entry<Character, Node>> children = node.children.entrySet();
		for(Map.Entry<Character, Node> child: children){
			this.displayWords(child.getValue(), osf + node.data);
		}
	}
	
	public void addWord(String word){
		this.addWord(this.root, word);
	}
	
	private void addWord(Node parent, String word){
		if(word.length() == 0){
			if(parent.isTerminal){
				// word already existed
			} else {
				parent.isTerminal = true;
				this.numWords++;
			}
			
			return;
		}
		
		Character ch = word.charAt(0);
		String ros = word.substring(1);
		
		Node child = parent.children.get(ch);
		
		if(child == null){
			child = new Node(ch, false);
			parent.children.put(ch, child);
		}
		
		this.addWord(child, ros);
	}

	public boolean searchWord(String word){
		return this.searchWord(this.root, word);
	}
	
	private boolean searchWord(Node parent, String word){
		if(word.length() == 0){
			if(parent.isTerminal){
				return true;
			} else {
				return false;
			}
		}
		
		Character ch = word.charAt(0);
		String ros = word.substring(1);
		
		Node child = parent.children.get(ch);
		
		if(child == null){
			return false;
		}
		
		return this.searchWord(child, ros);
	}
	
	public void removeWord(String word){
		this.removeWord(this.root, word);
	}
	
	private void removeWord(Node parent, String word){
		if(word.length() == 0){
			if(parent.isTerminal){
				parent.isTerminal = false;
				this.numWords--;
			} else {
				
			}
			
			return;
		}
		
		Character ch = word.charAt(0);
		String ros = word.substring(1);
		
		Node child = parent.children.get(ch);
		
		if(child == null){
			return;
		}
		
		this.removeWord(child, ros);
		
		// The child is neither part of a word, nor a word itself
		if(!child.isTerminal && child.children.size() == 0){
			parent.children.remove(ch);
		}
	}
}
