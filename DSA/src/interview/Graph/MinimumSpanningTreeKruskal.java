package interview.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinimumSpanningTreeKruskal {
	class Edge implements Comparable<Edge>{
		int src;
		int dest;
		int wt;
		
		public Edge(){
			
		}
		
		public Edge(int src , int dest , int wt){
			this.src = src;
			this.dest = dest;
			this.wt = wt;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.wt - o.wt;
		}
	
		@Override
		public String toString() {
			return "(" + src + " , " + dest + " , "  + wt + ")\n";
		}
	}
	
	public MinimumSpanningTreeKruskal(){}

	public int findParent(int src, int[] parent) {
		if (src == parent[src])
			return src;
		return parent[src] = findParent(parent[src], parent);
	}

	public void union(int src , int dest , int parent[] , int rank[]){
		int srcroot = findParent(src, parent);
		int destroot = findParent(dest, parent);
		if (rank[srcroot] < rank[destroot]) {
			parent[srcroot] = destroot;
		} else if (rank[destroot] < rank[srcroot]) {
			parent[destroot] = srcroot;
		} else {
			parent[destroot] = srcroot;
			rank[srcroot]++;
		}
	}
	
	public int mstKruskal(ArrayList<Edge> graph, int vertices){
		Collections.sort(graph); // Sort the graph based on Weight in Ascending order
		int parent[] = new int[vertices]; 	// create Parent array
		int rank[] = new int[vertices];		// create Rank array
		for (int i = 0; i < vertices; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

		int minimumCost = 0;
		ArrayList<Edge> mst = new ArrayList<>(); // create mst tree
		for (Edge edge : graph) {
			 // belongs to different components
			if (findParent(edge.src, parent) != findParent(edge.dest, parent)) {
				minimumCost += edge.wt;
				mst.add(edge);
				union(edge.src, edge.dest, parent, rank);
			}
		}
		System.out.println(mst);
		return minimumCost;
	}
	
	public void addEdge(ArrayList<Edge> graph, int src , int dest , int wt){
		graph.add(new Edge(src , dest , wt));
	}
	
	public static void main(String[] args) {
		int vertices = 6;
		MinimumSpanningTreeKruskal kruskal = new MinimumSpanningTreeKruskal();
		ArrayList<Edge> graph = new ArrayList<>();
		//add edges
		kruskal.addEdge(graph , 0 , 1 , 5);
		kruskal.addEdge(graph , 0 , 2 , 3);
		kruskal.addEdge(graph , 0 , 3 , 1);
		kruskal.addEdge(graph , 1 , 2 , 3);
		kruskal.addEdge(graph , 1 , 5 , 8);
		kruskal.addEdge(graph , 2 , 3 , 2);
		kruskal.addEdge(graph , 2 , 5 , 7);
		kruskal.addEdge(graph , 3 , 4 , 4);	
		kruskal.addEdge(graph , 4 , 0 , 9);	
	
		System.out.println("Minimum Spanning Tree(Cost) using Kruskals : ");
		int minimumCost = kruskal.mstKruskal(graph , vertices);
		System.out.println("Output : " + minimumCost);
	}

}
