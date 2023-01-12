package interview.Graph;

import java.util.ArrayList;

public class DisjointSetGraph {
	class Edge{
		int src; 
		int dest;
		
		Edge(){
			
		}
		
		Edge(int src , int dest){
			this.src = src;
			this.dest = dest;
		}
		
		@Override
		public String toString() {
			return "(" + src + "," + dest + ")";
		}

	}

	ArrayList<Edge> graph = new ArrayList<>();
	int edges = 0;
	public int find(int [] parent , int src){
		if (parent[src] == src)
			return src;
		return find(parent, parent[src]);
	}
	 
	public void union(int [] parent , int srcroot , int destroot){
		int xset = find(parent, srcroot);
		int yset = find(parent, destroot);
		parent[yset] = xset;
	}
	
	public boolean isCyclic(int vertices){
		int[] parent = new int[vertices];
		for (int i = 0; i < vertices; ++i) {
			parent[i] = i;
		}

		for (int i = 0; i < graph.size(); ++i) {
			int srcroot = find(parent, graph.get(i).src);
			int destroot = find(parent, graph.get(i).dest);
			if (srcroot == destroot)
				return true;

			union(parent, srcroot, destroot);
		}
		return false;
	}
	
	public void addEdge(int src , int dest){
		graph.add(new Edge(src , dest));
		edges++;
	}
	
	
	@Override
	public String toString() {
		return graph + "";
	}

	public static void main(String[] args) {
		int vertices = 5;
		DisjointSetGraph set = new DisjointSetGraph();
		
		set.addEdge(0, 1);	// add edge 0-1
		set.addEdge(1, 2); 	// add edge 1-2
		set.addEdge(2, 3);	// add edge 2-3
        set.addEdge(3, 4);  // add edge 3-4
        set.addEdge(0, 4);	// add edge 0-4
        System.out.println(set);
        System.out.print("Is Graph Cyclic ? ");
        if(set.isCyclic(vertices))
        	System.out.println(true);
        else
        	System.out.println(false);
	}

}
