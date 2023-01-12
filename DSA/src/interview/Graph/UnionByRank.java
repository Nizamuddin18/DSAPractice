package interview.Graph;

public class UnionByRank {
	class Edge{
		int src;
		int dest;
	}
	
	class subset{
		int parent;
		int rank;
	}
	int V, E;
	Edge edge[];
	
	public UnionByRank(int v , int e){
		V = v;
		E = e;
		edge = new Edge[E];
		for(int i = 0 ; i < E ; i++)
			edge[i] = new Edge();
	}
	
	public static int find(subset[] subsets , int i){
		if(subsets[i].parent!=i)
			subsets[i].parent = find(subsets , subsets[i].parent);
		return subsets[i].parent;
	}
	
	public static void unionByRank(subset[] subsets , int x , int y){
		int xroot = find(subsets , x);
		int yroot = find(subsets , y);
		if(subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if(subsets[xroot].rank > subsets[yroot].rank)
			subsets[yroot].parent = xroot;
		else{
			subsets[xroot].parent = yroot;
			subsets[yroot].rank++;
		}
	}
	public boolean isCycle(UnionByRank graph){
		int v = graph.V;
		int e = graph.E;
		subset[] subsets = new subset[v];
		for(int i = 0 ; i < v ; i++){
			subsets[i] = new subset();
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}
		for(int i = 0 ; i < e ; i++){
			int x = find(subsets , graph.edge[i].src);
			int y = find(subsets , graph.edge[i].dest);
			if(x == y)
				return true;	
			unionByRank(subsets , x , y);
		}
		return false;
	}
	public static void main(String[] args) {
		int vertices = 5;
		int edges = 4;
		UnionByRank graph = new UnionByRank(vertices , edges);
		// add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
 
        // add edge 2-3
        graph.edge[1].src = 2;
        graph.edge[1].dest = 3;
 
        // add edge 1-2
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        
        // add edge 0-4
        graph.edge[3].src = 0;
        graph.edge[3].dest = 4;
        
        // add edge 4-3
        /*graph.edge[4].src = 4;
        graph.edge[4].dest = 3;*/
        
        if (graph.isCycle(graph) == true)
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");

	}

}
