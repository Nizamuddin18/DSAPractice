package interview.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class BreadthFirstSearch {
	static class Edge{
		int nbr;
		int wt;
		Edge(int nbr , int wt){
			this.nbr = nbr;
			this.wt = wt;
		}
		@Override
		public String toString() {
			return "(" + nbr + "," + wt + ")";
		}
	}
	
	public static void addEdge(int src , int dest , int wt, ArrayList<Edge>[] graph){
		graph[src].add(new Edge(dest , wt));
	}

	private static void display(ArrayList<Edge>[] graph) {
		String res = "";
		for(int i = 0 ; i < graph.length ; i++){
			res += "[" + i + " => " + graph[i] + "]\n";
		}
		System.out.println(res);
		
	}
	
	public static void bfs(int src , boolean visited[] , ArrayList<Edge>[] graph){
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(src);
		while(!queue.isEmpty()){
			int data = queue.remove(); 		//Remove
			if(visited[data] == true)
				continue;
			visited[data] = true; 			//Mark*
			System.out.print(data + " ");	//Work
			for(Edge e : graph[data]){		//Add*
				if(visited[e.nbr] == false)
					queue.add(e.nbr);
			}
		}
	}
	
	public static void main(String[] args) {
		int vertices = 7;
		ArrayList<Edge>[] graph;
		graph = new ArrayList[vertices];
		for(int i = 0 ; i < graph.length ; i++)
			graph[i] = new ArrayList<>();
		
		addEdge(0, 1, 10 , graph);
		addEdge(0, 3, 15 , graph);
		addEdge(1, 2, 12 , graph);
		addEdge(2, 3, 10 , graph);
		addEdge(3, 4, 15 , graph);
		addEdge(4, 5, 12 , graph);
		addEdge(4, 6, 10 , graph);
		addEdge(5, 6, 12 , graph);
		System.out.println("-------------- Breadth First Traversal ----------------");
		System.out.println("Input : ");
		display(graph);
		boolean visited[] = new boolean[vertices];
		System.out.print("Output  : ");
		bfs(0 , visited , graph);
	}
}
