package interview.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class TopologicalSortBFS {
	ArrayList<Integer> graph[];
	
	public TopologicalSortBFS(int vertices) {
		graph = new ArrayList[vertices];
		for (int i = 0; i < vertices; i++) {
			graph[i] = new ArrayList(); // This creates a new LinkedList for all
										// the vertices of array G.
		}
	}

	@Override
	public String toString() {
		String retString = "";
		for (int i = 0; i < graph.length; i++) {
			retString = retString + i + " => " + graph[i] + "\n";
		}
		return retString;
	}

	public void addEdge(int u, int v) {
		graph[u].add(v);
	}
	
	public static void main(String [] args){
		System.out.println("Toplogical Sort(BFS)...Kahn's Algorithm");
		int vertices = 7;
		TopologicalSortBFS obj = new TopologicalSortBFS(vertices);
		obj.addEdge(0, 1);
		obj.addEdge(0, 3);
		obj.addEdge(1, 2);
		obj.addEdge(2, 3);
		obj.addEdge(4, 3);
		obj.addEdge(4, 5);
		obj.addEdge(5, 6);
		obj.addEdge(4, 6);
		System.out.println(obj);
		System.out.println("Output : ");
		boolean visited[] = new boolean[vertices];
		obj.topologicalSortBFS(vertices , visited);
	}

	public void topologicalSortBFS(int vertices, boolean[] visited) {
		int indegree[] = new int[vertices];
		for(int src = 0 ; src < vertices ; src++){
			for(Integer dest : graph[src]){
				indegree[dest]++;
			}
		}
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for(int i = 0 ; i < vertices ; i++){
			if(indegree[i] == 0)
				queue.add(i);
		}
		while(!queue.isEmpty()){
			Integer rem = queue.removeFirst();
			System.out.print(rem + " ");
			for(Integer nbr : graph[rem]){
				indegree[nbr]--;
				if(indegree[nbr] == 0)
					queue.add(nbr);
			}
		}
	}
	
}
