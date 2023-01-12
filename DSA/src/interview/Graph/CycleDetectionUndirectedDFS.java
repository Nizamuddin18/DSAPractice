package interview.Graph;
import java.util.ArrayList;

public class CycleDetectionUndirectedDFS {
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
	
	ArrayList<Integer> graph[];
	public CycleDetectionUndirectedDFS(int vertices){
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
	
	public boolean isCycle(int vertices){
		boolean visited[] = new boolean[vertices];
		for(int v = 0 ; v < vertices ; v++){
			if(visited[v] == false){
				if(isCycleHelperDFS(v , visited , -1)){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isCycleHelperDFS(int src , boolean visited[] , int parent){
		visited[src] = true;
		for(Integer nbr : graph[src]){
			if(visited[nbr] == false){
				if(isCycleHelperDFS(nbr , visited , src) == true)
					return true;
			}else if(nbr != parent){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int vertices = 5;
		CycleDetectionUndirectedDFS graph = new CycleDetectionUndirectedDFS(vertices);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 0);
		System.out.println("Undirected Graph : ");
		System.out.println(graph);
		boolean isCycle = graph.isCycle(vertices);
		if(isCycle)
			System.out.println("Cycle Detected");
		else
			System.out.println("No Cycle Detected");
	}

}
