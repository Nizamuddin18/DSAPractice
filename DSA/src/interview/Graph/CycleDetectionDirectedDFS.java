package interview.Graph;

import java.util.ArrayList;

public class CycleDetectionDirectedDFS {
	public static void addEdge(ArrayList<Integer> graph[] , int src , int dest){
		graph[src].add(dest);
	}
	
	public static void display(ArrayList<Integer> graph[]){
		String res = "";
		for(int v = 0 ; v < graph.length ; v++){
			res += "[" + v + " => " + graph[v] + "]\n" ;
		}
		System.out.println(res);
	}
	
	static int cycle;
	public static boolean isCyclicDFS(ArrayList<Integer> graph[] , int src,
							boolean visited[] , boolean dfsvis[]){
		visited[src] = true;	//mark visited
		dfsvis[src] = true;		//mark dfsVisited 
		
		for(Integer nbr : graph[src]){
			if(visited[nbr] == false){
				if(isCyclicDFS(graph , nbr , visited , dfsvis))
					return true;
			}else if(dfsvis[nbr] == true){ 
				/*the idea is to check whether the neighbour of current source has been marked in 
				present iteration */
				cycle = nbr;
				return true;
			}
		}
		dfsvis[src] = false;	//unmark = > backtrack
		return false;
	}
	
	public static boolean isCyclic(ArrayList<Integer> graph[]){
		boolean visited[] = new boolean[graph.length];
		boolean dfsvis[] = new boolean[graph.length];
		
		for(int v = 0 ; v < graph.length ; v++){
			if(visited[v] == false){
				if(isCyclicDFS(graph , v , visited , dfsvis))
					return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> graph[];
		int vertices = 3;
		graph = new ArrayList[vertices];
		
		for(int v = 0; v < vertices ; v++){
			graph[v] = new ArrayList<>();
		}
		addEdge(graph , 0 , 1);
		addEdge(graph , 1 , 2);
		addEdge(graph , 0 , 2);
//		addEdge(graph , 3 , 4);
//		addEdge(graph , 2 , 5);
//		addEdge(graph , 5 , 4);
//		addEdge(graph , 6 , 1);
//		addEdge(graph , 6 , 7);
//		addEdge(graph , 7 , 8);
//		addEdge(graph , 6 , 8);  
		// to see the difference change it to = > addEdge(graph , 8 , 6); 
		display(graph);
		boolean flag = isCyclic(graph);
		System.out.print("Is Cyclic ? " + flag);
		if(flag)
			System.out.print(" Cycle found at vertex : " + cycle);
	}

}
