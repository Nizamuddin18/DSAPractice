package interview.Graph;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinimumSpanningTreePrims {
	class Edge implements Comparable<Edge>{
		int v;
		int wt;
		Edge(int v , int wt){
			this.v = v;
			this.wt = wt;
		}
		public String toString(){
			return "(" + this.v + ", " + this.wt + ")";
		}
		public int compareTo(Edge o){
			return this.wt - o.wt;
		}
	}
	
	ArrayList<ArrayList<Edge>> graph;
	
	public MinimumSpanningTreePrims(int vertices){
		graph = new ArrayList<>();
		for(int v = 0 ; v < vertices ; v++){
			graph.add(new ArrayList<>());
		}
	}
	
	public String toString(){
		String str = "";
		for(int i = 0 ; i < graph.size() ; i++){
			str = str + i + " => " + graph.get(i) + "\n";
		}
		return str;
	}
	
	public int getMinimumCostPrims(int vertices){
		int mst = 0;
		boolean visited[] = new boolean[vertices];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0 , 0));
		while(!pq.isEmpty()){
			Edge rem = pq.remove();
			if(visited[rem.v] == true)
				continue;
			visited[rem.v] = true;
			mst = mst + rem.wt;
			for(Edge e : graph.get(rem.v)){
				if(visited[e.v] == false){
					pq.add(e);
				}
			}
		}
		return mst;
	}
	
	public void addEdge(int src , int dest , int wt){
		graph.get(src).add(new Edge(dest , wt));
		graph.get(dest).add(new Edge(src , wt));
	}
	
	public static void main(String[] args) {
		int vertices = 7;
		MinimumSpanningTreePrims prims = new MinimumSpanningTreePrims(vertices);
		//add Edges
		prims.addEdge(0, 1, 10);
		prims.addEdge(0, 3, 25);
		prims.addEdge(1, 2, 10);
		prims.addEdge(2, 3, 10);
		prims.addEdge(3, 4, 2);
		prims.addEdge(4, 5, 3);
		prims.addEdge(4, 6, 8);
		prims.addEdge(5, 6, 3);		
		System.out.println("Minimum Spanning Tree(Cost) using Prims : ");
		int minimumCost = prims.getMinimumCostPrims(vertices);
		System.out.println("Output : " + minimumCost);
	}
}
