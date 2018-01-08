package Lecture23;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import Lecture21.Heap;

public class HCoder {
	private HashMap<Character, String> encoder;
	private HashMap<String, Character> decoder;
	
	public HCoder(String feeder){
		// Step 1 - Create a freq map
		HashMap<Character, Integer> freqMap = new HashMap<>();
		for(int i = 0; i < feeder.length(); i++){
			Character ch = feeder.charAt(i);
			
			if(freqMap.containsKey(ch)){
				int ov = freqMap.get(ch);
				freqMap.put(ch, ov + 1);
			} else {
				freqMap.put(ch, 1);
			}
		}
		
		// Create a minHeap of Trees
		Heap<Node> minHeap = new Heap<>(true);
		Set<Map.Entry<Character, Integer>> fmEntries = freqMap.entrySet();
		for(Map.Entry<Character, Integer> fmEntry: fmEntries){
			Node bt = new Node(fmEntry.getKey(), fmEntry.getValue());
			minHeap.add(bt);
		}
		
		// Remove two, add one until size == 1
		while(minHeap.size() != 1){
			Node minOne = minHeap.remove();
			Node minTwo = minHeap.remove();
			
			Node toBeAdded = new Node(minOne, minTwo);
			minHeap.add(toBeAdded);
		}
		
		// Retrieve the fullt tree
		Node ft = minHeap.remove();
		
		// init encoder and decoder
		this.encoder = new HashMap<>();
		this.decoder = new HashMap<>();
		this.initEncoderDecoder(ft, "");
	}
	
	public String encode(String source){
		String rv = "";
		
		for(int i = 0; i < source.length(); i++){
			String code = encoder.get(source.charAt(i));
			rv += code;
		}
		
		return rv;
	}
	
	public String decode(String codedString){
		String rv = "";
		
		String key = "";
		for(int i = 0; i < codedString.length(); i++){
			key += codedString.charAt(i);
			
			if(decoder.containsKey(key)){
				rv += decoder.get(key);
				key = "";
			}
		}
		
		return rv;
	}
	
	private void initEncoderDecoder(Node node, String osf){
		if(node == null){
			return;
		}
		
		// leaf
		if(node.left == null && node.right == null){
			encoder.put(node.data, osf);
			decoder.put(osf, node.data);
		}
		
		this.initEncoderDecoder(node.left, osf + "0");
		this.initEncoderDecoder(node.right, osf + "1");
	}
	
	private class Node implements Comparable<Node>{
		Character data;
		int cost;
		Node left;
		Node right;
		
		Node(Character data, int cost){
			this.data = data;
			this.cost = cost;
			this.left = null;
			this.right = null;
		}
		
		Node (Node left, Node right){
			this.data = '\0';
			this.cost = left.cost + right.cost;
			this.left = left;
			this.right = right;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
}
