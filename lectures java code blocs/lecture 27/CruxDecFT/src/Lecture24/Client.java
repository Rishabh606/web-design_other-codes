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
		
		g.addEdge("A", "B", 10);
		g.addEdge("A", "D", 40);
		g.addEdge("C", "D", 10);
		g.addEdge("B", "C", 10);
		g.addEdge("C", "E", 2);
		g.addEdge("E", "F", 4);
		g.addEdge("E", "G", 8);
		g.addEdge("F", "G", 2);
		
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
		
//		System.out.println(g.djikstra("A"));
//		Graph primsMSG = g.prims();
//		primsMSG.display();
		
		Graph kruskalsMSG = g.kruskals();
		kruskalsMSG.display();
	}

	// baakio ke liye nai hai - equalize
	public static int equalize1(Integer[] arr) {
		int ops = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}

		int[] farr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			int delta = arr[i] - min;

			farr[delta % 5] += 1;
			ops += delta / 5;
		}

		int f1 = 0 * farr[0] + 1 * farr[1] + 1 * farr[2] + 2 * farr[3] + 2 * farr[4];
		int f2 = 1 * farr[0] + 1 * farr[1] + 2 * farr[2] + 2 * farr[3] + 1 * farr[4];
		int f3 = 1 * farr[0] + 2 * farr[1] + 2 * farr[2] + 1 * farr[3] + 2 * farr[4];

		ops = ops + Math.min(f1, Math.min(f2, f3));

		return ops;
	}
}
