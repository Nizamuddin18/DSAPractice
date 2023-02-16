package interview.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class CycleDetectionUndirectedBFS {
	class Edge{
		int nbr;
		int wt;
		public Edge(int nbr , int wt){
			this.nbr = nbr;
			this.wt = wt;
		}	
		public String toString(){
			return "(" + nbr + "," + wt + ")";	
		}	
	}
	
	class Pair{
		int v;
		String psf;
		public Pair(int v , String psf){
			this.v = v;
			this.psf = psf;
		}
	}
	
	ArrayList<Integer> graph[];
	public CycleDetectionUndirectedBFS(int vertices){
		graph = new ArrayList[vertices];
		for(int i = 0; i < vertices ; i++)
			graph[i] = new ArrayList<>();
	}
	
	public String toString(){
		String ret_val = "";
		for(int i = 0 ; i < graph.length ; i++){
			ret_val += i + " => " + graph[i] + "\n";
		}
		return ret_val;
	}
	
	public void addEdge(int src , int dest){
		graph[src].add(dest);
		graph[dest].add(src);

	}
	
	public boolean isCycleHelperBFS(int src , boolean visited[]){
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(src);
		while(!queue.isEmpty()){
			Integer rem = queue.remove();
			if(visited[rem] == true){
				return true;
			}
			visited[rem] = true;
			for(Integer nbr : graph[rem]){
				if(visited[nbr] == false){
					queue.add(nbr);
				}
			}
		}
		return false;
	}
	
	public boolean isCycle(int vertices){
		boolean visited[] = new boolean[vertices];
		for(int v = 0 ; v < vertices ; v++){
			if(visited[v] == false){
				if(isCycleHelperBFS(v , visited))
					return true;	
			}
		}
		return false;		
	}
	
	public static void main(String[] args) {
		int vertices = 5;
		CycleDetectionUndirectedBFS graph = new CycleDetectionUndirectedBFS(vertices);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 0);
		System.out.println("Undirected Graph : ");
		System.out.println(graph);
		boolean isCycle = graph.isCycle(vertices);
		if(isCycle)
			System.out.println("Cycle Detected ");
		else
			System.out.println("No Cycle Detected ");	
	}

}
