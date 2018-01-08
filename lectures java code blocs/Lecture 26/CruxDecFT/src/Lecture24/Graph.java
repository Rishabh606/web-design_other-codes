package Lecture24;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import Lecture21.Heap;

public class Graph {
	private class Edge {
		Vertex one;
		Vertex two;
		int weight;

		Edge(Vertex one, Vertex two, int weight) {
			this.one = one;
			this.two = two;
			this.weight = weight;
		}
	}

	private class Vertex {
		String name;
		HashMap<Vertex, Edge> neighbors;

		Vertex(String name) {
			this.name = name;
			this.neighbors = new HashMap<>();
		}

		@Override
		public boolean equals(Object other) {
			Vertex ov = (Vertex) other;
			return this.name.equals(ov.name);
		}

		@Override
		public int hashCode() {
			return this.name.hashCode();
		}
	}

	private HashMap<String, Vertex> vertices;

	public Graph() {
		this.vertices = new HashMap<>();
	}

	public int numVertices() {
		return this.vertices.size();
	}

	public void addVertex(String v) {
		if (this.containsVertex(v)) {
			return;
		}

		Vertex vtx = new Vertex(v);
		this.vertices.put(v, vtx);
	}

	public void removeVertex(String v) {
		if (!this.containsVertex(v)) {
			return;
		}

		Vertex vtx = this.getVertex(v);
		Set<Vertex> nbrVertices = vtx.neighbors.keySet();
		for (Vertex nbrVtx : nbrVertices) {
			nbrVtx.neighbors.remove(vtx);
		}

		this.vertices.remove(v);
	}

	public boolean containsVertex(String v) {
		Vertex vtx = this.getVertex(v);

		if (vtx != null) {
			return true;
		} else {
			return false;
		}
	}

	private Vertex getVertex(String v) {
		return this.vertices.get(v);
	}

	public int numEdges() {
		int rv = 0;

		Collection<Vertex> allVertices = this.vertices.values();
		for (Vertex vtx : allVertices) {
			rv += vtx.neighbors.size();
		}

		rv = rv / 2;

		return rv;
	}

	public void addEdge(String v1, String v2, int weight) {
		Vertex vtx1 = this.getVertex(v1), vtx2 = this.getVertex(v2);

		if (vtx1 == null || vtx2 == null || this.containsEdge(v1, v2)) {
			return;
		}

		Edge commonEdge = new Edge(vtx1, vtx2, weight);
		vtx1.neighbors.put(vtx2, commonEdge);
		vtx2.neighbors.put(vtx1, commonEdge);
	}

	public void removeEdge(String v1, String v2) {
		Vertex vtx1 = this.getVertex(v1), vtx2 = this.getVertex(v2);

		if (vtx1 == null || vtx2 == null || !this.containsEdge(v1, v2)) {
			return;
		}

		vtx1.neighbors.remove(vtx2);
		vtx2.neighbors.remove(vtx1);
	}

	public boolean containsEdge(String v1, String v2) {
		Vertex vtx1 = this.getVertex(v1), vtx2 = this.getVertex(v2);

		if (vtx1 == null || vtx2 == null) {
			return false;
		}

		return vtx1.neighbors.containsKey(vtx2);
	}

	public void display() {
		Set<Map.Entry<String, Vertex>> allEntries = this.vertices.entrySet();
		for (Map.Entry<String, Vertex> entry : allEntries) {
			Vertex vtx = entry.getValue();

			String toPrint = vtx.name + " => ";
			Set<Vertex> nbrs = vtx.neighbors.keySet();

			for (Vertex nbr : nbrs) {
				toPrint += nbr.name + ", ";
			}

			toPrint += "END";
			System.out.println(toPrint);
		}

		System.out.println("**************************************");
	}

	/* Questions */
	public boolean hasPath(String v1, String v2) {
		Vertex vtx1 = this.getVertex(v1), vtx2 = this.getVertex(v2);

		if (vtx1 == null || vtx2 == null) {
			return false;
		}

		// HashMap<Vertex, Vertex> visited = new HashMap<>();
		// visited.put(vtx1, null);
		//
		// return this.hasPathDFS(vtx1, vtx2, visited);
		// return this.hasPathBFS(vtx1, vtx2);
		return this.hasPathDFSI(vtx1, vtx2);
	}

	private boolean hasPathDFS(Vertex vtx1, Vertex vtx2, HashMap<Vertex, Vertex> visited) {
		if (vtx1.neighbors.containsKey(vtx2)) {
			return true;
		}

		Set<Vertex> nbrs = vtx1.neighbors.keySet();
		for (Vertex nbr : nbrs) {
			if (!visited.containsKey(nbr)) {
				visited.put(nbr, null);

				if (this.hasPathDFS(nbr, vtx2, visited)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean hasPathBFS(Vertex vtx1, Vertex vtx2) {
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();

		visited.put(vtx1, vtx1);
		queue.addLast(vtx1);

		while (!queue.isEmpty()) {
			Vertex vtx = queue.removeFirst();

			// work area
			if (vtx.neighbors.containsKey(vtx2)) {
				return true;
			}

			Set<Vertex> nbrs = vtx.neighbors.keySet();
			for (Vertex nbr : nbrs) {
				if (!visited.containsKey(nbr)) {
					visited.put(nbr, nbr);
					queue.addLast(nbr);
				}
			}
		}

		return false;
	}

	private boolean hasPathDFSI(Vertex vtx1, Vertex vtx2) {
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> stack = new LinkedList<>();

		visited.put(vtx1, vtx1);
		stack.addFirst(vtx1);

		while (!stack.isEmpty()) {
			Vertex vtx = stack.removeFirst();

			// work area
			if (vtx.neighbors.containsKey(vtx2)) {
				return true;
			}

			Set<Vertex> nbrs = vtx.neighbors.keySet();
			for (Vertex nbr : nbrs) {
				if (!visited.containsKey(nbr)) {
					visited.put(nbr, nbr);
					stack.addFirst(nbr);
				}
			}
		}

		return false;
	}

	public void bft() {
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();
		
		Collection<Vertex> allVertices = this.vertices.values();
		for(Vertex vtx: allVertices){
			if(!visited.containsKey(vtx)){
				visited.put(vtx, vtx);
				queue.addLast(vtx);
				
				while(!queue.isEmpty()){
					Vertex ovtx = queue.removeFirst();
					
					System.out.println(ovtx.name);
					
					Set<Vertex> nbrs = ovtx.neighbors.keySet();
					for(Vertex nbr: nbrs){
						if(!visited.containsKey(nbr)){
							visited.put(nbr, nbr);
							queue.addLast(nbr);
						}
					}
				}
			}
		}
	}

	public void dft() {
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> stack = new LinkedList<>();

		Collection<Vertex> allVertices = this.vertices.values();

		for (Vertex vtx : allVertices) {
			if (!visited.containsKey(vtx)) {
				visited.put(vtx, vtx);
				stack.addFirst(vtx);

				while (!stack.isEmpty()) {
					vtx = stack.removeFirst();

					// work area
					System.out.println(vtx.name);

					Set<Vertex> nbrs = vtx.neighbors.keySet();
					for (Vertex nbr : nbrs) {
						if (!visited.containsKey(nbr)) {
							visited.put(nbr, nbr);
							stack.addFirst(nbr);
						}
					}
				}
			}
		}
	}

	public boolean isConnected() {
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();

		Vertex[] allVertices = new Vertex[this.vertices.size()];
		this.vertices.values().toArray(allVertices);

		visited.put(allVertices[0], allVertices[0]);
		queue.addLast(allVertices[0]);

		while (!queue.isEmpty()) {
			Vertex vtx = queue.removeFirst();

			// work area
			System.out.println(vtx.name);

			Set<Vertex> nbrs = vtx.neighbors.keySet();
			for (Vertex nbr : nbrs) {
				if (!visited.containsKey(nbr)) {
					visited.put(nbr, nbr);
					queue.addLast(nbr);
				}
			}
		}

		return this.vertices.size() == visited.size();
	}

	public ArrayList<ArrayList<String>> getConnectedComponents() {
		ArrayList<ArrayList<String>> rv = new ArrayList<>();
		
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> stack = new LinkedList<>();

		Collection<Vertex> allVertices = this.vertices.values();

		for (Vertex vtx : allVertices) {
			if (!visited.containsKey(vtx)) {
				ArrayList<String> cc = new ArrayList<>();
				
				visited.put(vtx, vtx);
				stack.addFirst(vtx);

				while (!stack.isEmpty()) {
					vtx = stack.removeFirst();

					// work area
					cc.add(vtx.name);

					Set<Vertex> nbrs = vtx.neighbors.keySet();
					for (Vertex nbr : nbrs) {
						if (!visited.containsKey(nbr)) {
							visited.put(nbr, nbr);
							stack.addFirst(nbr);
						}
					}
				}
				
				rv.add(cc);
			}
		}
		
		return rv;
	}

	public boolean isBipartite(){
		HashMap<Vertex, String> visited = new HashMap<>();
		LinkedList<Vertex> stack = new LinkedList<>();

		Collection<Vertex> allVertices = this.vertices.values();

		for (Vertex vtx : allVertices) {
			if (!visited.containsKey(vtx)) {
				visited.put(vtx, "Red");
				stack.addFirst(vtx);

				while (!stack.isEmpty()) {
					vtx = stack.removeFirst();

					Set<Vertex> nbrs = vtx.neighbors.keySet();
					for (Vertex nbr : nbrs) {
						String covtx = visited.get(vtx);
						String cToApplyOnNbr = covtx.equals("Red")? "Green": "Red";
						
						if (!visited.containsKey(nbr)) {
							visited.put(nbr, cToApplyOnNbr);
							stack.addFirst(nbr);
						} else {
							String actualCOnNbr = visited.get(nbr);
							
							if(actualCOnNbr.equals(cToApplyOnNbr)){
								continue;
							}
							
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}
	
	public boolean isAcyclic(){
		HashMap<Vertex, Vertex> visited = new HashMap<>();
		LinkedList<Vertex> stack = new LinkedList<>();

		Collection<Vertex> allVertices = this.vertices.values();

		for (Vertex vtx : allVertices) {
			if (!visited.containsKey(vtx)) {
				visited.put(vtx, null);
				stack.addFirst(vtx);

				while (!stack.isEmpty()) {
					vtx = stack.removeFirst();

					Set<Vertex> nbrs = vtx.neighbors.keySet();
					for (Vertex nbr : nbrs) {
						if (!visited.containsKey(nbr)) {
							visited.put(nbr, vtx);
							stack.addFirst(nbr);
						} else {
							Vertex reasonForVtx = visited.get(vtx);
							
							if(reasonForVtx == nbr){
								continue;
							}
							
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}
	
	public HashMap<String, Integer> djikstra(String src) {
		Heap<Pair> vtxHeap = new Heap<>(true);
		HashMap<Vertex, Pair> vtxPairMap = new HashMap<>();

		Set<Map.Entry<String, Vertex>> allEntries = this.vertices.entrySet();
		for (Map.Entry<String, Vertex> entry : allEntries) {
			Vertex vtx = entry.getValue();

			if (vtx.name.equals(src)) {
				Pair p = new Pair(0, vtx);
				
				vtxHeap.add(p);
				vtxPairMap.put(vtx, p);
			} else {
				Pair p = new Pair(Integer.MAX_VALUE, vtx);
				
				vtxHeap.add(new Pair(Integer.MAX_VALUE, vtx));
				vtxPairMap.put(vtx, p);
			}
		}
		
		while(!vtxHeap.isEmpty()){
			Pair pair = vtxHeap.remove();
//			Vertex tvtx = pair.vtx;
			
			Set<Map.Entry<Vertex, Edge>> nbrs = pair.vtx.neighbors.entrySet();
			
			for(Map.Entry<Vertex, Edge> nbr: nbrs){
				Vertex ovtx = nbr.getKey();
				Edge oEdge = nbr.getValue();
				Pair oPair = vtxPairMap.get(ovtx);
				
				int ns = oEdge.weight + vtxPairMap.get(ovtx).cost;
				int os = oPair.cost;
				
				if(ns < os){
					oPair.cost = ns;
					vtxHeap.updatePriority(oPair);
				}
			}
		}

		HashMap<String, Integer> rv = new HashMap<>();
		
		Set<Map.Entry<Vertex, Pair>> entries = vtxPairMap.entrySet();
		for(Map.Entry<Vertex, Pair> entry: entries){
			rv.put(entry.getKey().name, entry.getValue().cost);
		}
		
		return rv;
	}

	public Graph prims(){
		Graph rv = new Graph();
		
//		Heap<Pair> vtxHeap = new Heap<>(true);
//		HashMap<String, Integer> vtxCostMap = new HashMap<>();
//		HashMap<String, Pair> vtxPairMap = new HashMap<>();
//		HashMap<String, Edge> vtxAquireMap = new HashMap<>();
//		
//		Set<Map.Entry<String, Vertex>> allEntries = this.vertices.entrySet();
//		boolean first = true;
//		for (Map.Entry<String, Vertex> entry : allEntries) {
//			Vertex vtx = entry.getValue();
//
//			if (first) {
//				first = !first;
//				vtxCostMap.put(vtx.name, 0);
//				
//				Pair p = new Pair(0, vtx);
//				vtxHeap.add(p);
//				vtxMap.put(vtx, p);
//			} else {
//				vtxCostMap.put(vtx.name, Integer.MAX_VALUE);
//				
//				Pair p = new Pair(Integer.MAX_VALUE, vtx);
//				vtxHeap.add(new Pair(Integer.MAX_VALUE, vtx));
//				vtxMap.put(vtx, p);
//			}
//		}
		
		return rv;
	}
	
	private class Pair implements Comparable<Pair> {
		int cost;
		Vertex vtx;

		Pair(int cost, Vertex vtx) {
			this.cost = cost;
			this.vtx = vtx;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	
		public boolean equals(Object other){
			Pair op = (Pair)other;
			return this.vtx.equals(op.vtx);
		}
		
		public int hashCode(){
			return this.vtx.hashCode();
		}
	}
}
