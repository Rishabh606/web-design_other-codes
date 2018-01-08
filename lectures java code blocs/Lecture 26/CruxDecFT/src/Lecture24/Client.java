package Lecture24;

public class Client {

	public static void main(String[] args) {
		Graph g = new Graph();
		
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");
		
		g.addEdge("A", "B", 40);
		g.addEdge("A", "C", 10);
		g.addEdge("C", "D", 10);
		g.addEdge("B", "D", 10);
		g.addEdge("D", "E", 2);
		g.addEdge("E", "F", 8);
		g.addEdge("E", "G", 4);
		g.addEdge("F", "G", 3);
		
		g.display();
		
//		g.removeVertex("E");
//		g.display();
		
//		g.removeEdge("E", "F");
//		g.display();
		
//		System.out.println(g.numEdges());
//		System.out.println(g.numVertices());
//		
//		System.out.println(g.hasPath("A", "G"));
//		g.dft();
//		
//		System.out.println(g.isConnected());
//		System.out.println(g.isBipartite());
//		System.out.println(g.isAcyclic());
//		
//		g.removeEdge("A", "B");
//		System.out.println(g.isAcyclic());
//		g.removeEdge("F", "G");
//		
//		System.out.println(g.isAcyclic());
		
		System.out.println(g.djikstra("A"));
	}

}
