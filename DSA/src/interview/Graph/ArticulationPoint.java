package interview.Graph;

import java.util.ArrayList;

public class ArticulationPoint {
	static int parent[];
	static int disc[];
	static int low[];
	static int time; 		// initializing discovery of low 
	static boolean visited[];
	static boolean ap[];
	
	public void addEdge(ArrayList<ArrayList<Integer>> graph , int src , int dest){
		graph.get(src).add(dest);
		graph.get(dest).add(src);
	}
	
	public void dfs(int src, ArrayList<ArrayList<Integer>> graph) {
		disc[src] = low[src] = time;
		time++;
		visited[src] = true;
		int count = 0;
		ArrayList<Integer> nbrs = graph.get(src);
		for(int i = 0 ; i < nbrs.size() ; i++){
			int nbr = nbrs.get(i);
			if(parent[src] == nbr)
				continue;
			else if(visited[nbr] = true){
				low[src] = Math.min(low[src], disc[nbr]);
			}else{
				parent[nbr] = src;
				count++;
				dfs(nbr , graph);
				low[src] = Math.min(low[src] , low[nbr]);
				if(parent[src] == -1){
					if(count >= 2)
						ap[src] = true;
				}else{
					if(low[nbr] >= disc[src]){
						ap[src] = true;
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		ArticulationPoint obj = new ArticulationPoint();
		int vertices = 5;
		int edges = 5;
	
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0 ; i < vertices ; i++){
			graph.add(new ArrayList<>());
		}
		obj.addEdge(graph, 0 , 1);
		obj.addEdge(graph, 0 , 2);
		obj.addEdge(graph, 2 , 1);
		obj.addEdge(graph, 2 , 3);
		obj.addEdge(graph, 4 , 3);
		parent = new int[vertices];
		disc =  new int[vertices];
		low =  new int[vertices];
		time = 0;
		visited =  new boolean[vertices];
		ap =  new boolean[vertices];
		parent[0] = -1;
		obj.dfs(0 , graph);
		
		int count = 0;
		for(int i = 0 ; i < vertices ; i++){
			if(ap[i] == true)
				count++;
		}
		System.out.println(count);
	}


}
