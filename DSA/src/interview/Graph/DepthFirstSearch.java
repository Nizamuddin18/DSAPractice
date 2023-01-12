package interview.Graph;

import java.util.ArrayList;

class Edges{
	int nbr; 	// nbr is the neighbour vertex of the source vertex
	int wt; 	// wt is weight between source and neighbour vertex
	public Edges(int nbr , int wt){
		this.nbr = nbr;
		this.wt = wt;
	}
	@Override
	public String toString() {
		return "(" + nbr + "," + wt + ")";
	}
}
public class DepthFirstSearch {
	ArrayList<Edges> graph[];  
	public DepthFirstSearch(int vertices){
		graph = new ArrayList[vertices];
		for(int  i = 0; i < vertices ; i++){
			graph[i] = new ArrayList<>(); 
		}
	}	
	public void addEdge(int u , int v , int wt){
		graph[u].add(new Edges(v , wt)); // add a new Edge between a source u and neighbour v with weight wt
		graph[v].add(new Edges(u , wt)); // add a new Edge between a source v and neighbour u with weight wt
	}
	public String toString(){
		String retString = "";
		for(int i = 0 ; i < graph.length ; i++){
			retString += i +" => " +graph[i] + "\n";
		}
		return retString;
	}
	public void depthFirstSearch(int src , boolean visited[]){
		visited[src] = true;
		System.out.print(src + " ");
		for(Edges edge : graph[src]){
			if(visited[edge.nbr] == false){
				depthFirstSearch(edge.nbr , visited);
			}
		}
	}
	public static void main(String[] args) {
		System.out.println("----------- Depth First Search ----------------");
		int vertices = 7;
		DepthFirstSearch graph = new DepthFirstSearch(vertices);
		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 2, 10);
		graph.addEdge(1, 3, 10);
		graph.addEdge(1, 4, 10);
		graph.addEdge(2, 5, 10);
		graph.addEdge(2, 6, 10);
		boolean visited[] = new boolean[vertices];
		System.out.println("Input : ");
		System.out.println(graph);
		System.out.print("Output  : ");
		graph.depthFirstSearch(0, visited);

	}
}
