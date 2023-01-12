package interview.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteDFS {
	class Edge{
		int nbr;
		int wt;
		Edge(int nbr , int wt){
			this.nbr = nbr;
			this.wt = wt;
		}
		public String toString(){
			return "(" + nbr + "," + wt +")";
		}
	}

	ArrayList<ArrayList<Integer>> graph;
	public BipartiteDFS(int vertices){
		graph = new ArrayList(vertices);
		for(int i = 0 ; i < vertices; i++){
			graph.add(i , new ArrayList<>());
		}
	}
	
	public void addEdge(int src , int dest){
		graph.get(src).add(dest);
		graph.get(dest).add(src);
	}
	
	public String toString(){
		String retString = "";
		for(int i = 0 ; i < graph.size() ; i++){
			retString += i +" => " + graph.get(i) + "\n";
		}
		return retString;
	}
	
	private boolean checkBipartiteDFS(int vertices , int colors[]) {
		for(int v = 0 ; v < vertices ; v++){
			if(colors[v] == -1){
				if(isComponentBipartiteDFS(v , colors , vertices) == false)
					return false;
			}
		}
		return true;
	}
	
	private boolean isComponentBipartiteDFS(int src, int[] colors, int vertices) {
		if(colors[src] == -1)
			colors[src] = 1;
		
		for(Integer nbr : graph.get(src)){
			if(colors[nbr] == -1){
				colors[nbr] = 1 - colors[src];
				
				if(isComponentBipartiteDFS(nbr , colors , vertices) == false)
					return false;
			}
			else if(colors[nbr] == colors[src])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int vertices = 5;
		BipartiteDFS graph = new BipartiteDFS(vertices);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(4, 3);
		graph.addEdge(3, 2);
	
		
//		graph.addEdge(0, 1);
//		graph.addEdge(0, 2);
//		graph.addEdge(1, 3);
//		graph.addEdge(2, 4);
//		graph.addEdge(3, 5);
//		graph.addEdge(4, 5);
		int colors[] = new int[vertices];
		Arrays.fill(colors, -1);
		System.out.print("IS Graph Bipartite : ");
		boolean checkBipartite = graph.checkBipartiteDFS(vertices , colors);
		if(checkBipartite == true)
			System.out.println(true);
		else
			System.out.println(false);
	}
}
