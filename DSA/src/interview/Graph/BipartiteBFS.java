package interview.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

import com.prep.interview.Graph.MColoringProblem.Edge;

public class BipartiteBFS {
	class Pair{
		int src;
		int level;
		Pair(int src , int level){
			this.src = src;
			this.level = level;
		}
	}
	
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
	
	ArrayList<ArrayList<Edge>> graph; // graph is an ArrayList of ArrayList of Edges
	public BipartiteBFS(int vertices){
		graph = new ArrayList(vertices); // set size of graph
		for(int i = 0 ; i < vertices ; i++)
			graph.add(i, new ArrayList<>());
	}
	
	public String toString(){
		String retString = "";
		for(int i = 0 ; i < graph.size() ; i++){
			retString += i +" => " + graph.get(i) + "\n";
		}
		return retString;
	}
	
	public void addEdge(int src , int dest , int wt){
		graph.get(src).add(new Edge(dest , wt));
		graph.get(dest).add(new Edge(src , wt));

	}
	
	public boolean checkBipartiteBFS(int vertices , int visited[]){
		for(int v = 0 ; v < vertices ; v++){
			if(visited[v] == -1){
				if(isComponentBipartiteBFS(vertices , visited , v) == false)
					return false;
			}
		}
		return true;
	}
	
	public boolean isComponentBipartiteBFS(int vertices , int visited[] , int src){
		ArrayDeque<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(src , 0));
		while(queue.size() > 0){
			Pair rem = queue.removeFirst();
			if(visited[rem.src] != -1){ //already visited
				if(rem.level != visited[rem.src]){
					return false;
				}
			}else{
				visited[rem.src] = rem.level;
			}
			for(Edge edge : graph.get(rem.src)){
				if(visited[edge.nbr] == -1){
					queue.add(new Pair(edge.nbr, rem.level+1));
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int vertices = 5;
		BipartiteBFS graph = new BipartiteBFS(vertices);
		graph.addEdge(0, 1 , 10);
		graph.addEdge(0, 2 , 10);
		graph.addEdge(0, 4 , 10);
		graph.addEdge(1, 2 , 10);
		graph.addEdge(4, 3 , 10);
		graph.addEdge(3, 2 , 10);
		
//		graph.addEdge(0, 1, 10);
//		graph.addEdge(0, 2, 10);
//		graph.addEdge(1, 3, 10);
//		graph.addEdge(2, 4, 10);
//		graph.addEdge(3, 5, 10);
//		graph.addEdge(4, 5, 10);
		int visited[] = new int[vertices];
		Arrays.fill(visited, -1);
		System.out.print("IS Graph Bipartite : ");
		boolean checkBipartite = graph.checkBipartiteBFS(vertices, visited);
		if(checkBipartite == true)
			System.out.println(true);
		else
			System.out.println(false);
	}

}
