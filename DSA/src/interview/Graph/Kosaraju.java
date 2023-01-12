package interview.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju {

	public void addEdge(ArrayList<Integer>[] graph, int src , int dest){
		graph[src].add(dest);
	}
	
	public void topodfs(int src, boolean[] visited, Stack<Integer> stack, ArrayList<Integer>[] graph) {
		visited[src] = true;
		for(Integer nbr : graph[src]){
			if(!visited[nbr])
				topodfs(nbr , visited , stack , graph);
		}
		stack.push(src);
	}
	
	public void topologicalSort(ArrayList<Integer>[] graph, int vertices , boolean visited[], 
								Stack<Integer> stack) {
		System.out.println("Input Graph : ");
		display(graph);
		for(int v = 0 ; v < vertices ; v++){
			if(visited[v] == false)
				topodfs(v , visited , stack , graph);
		}
	}
	
	public void display(ArrayList<Integer>[] graph) {
		String retString = "";
		for (int i = 0; i < graph.length; i++) {
			retString = retString + i + " => " + graph[i] + "\n";
		}
		System.out.println(retString); 
	}

	public void getSCC(int vertices, boolean[] visited, ArrayList<Integer>[] graph,
							Stack<Integer> stack) {
		ArrayList<Integer> graphTrans[] = new ArrayList[vertices];
		transposeGraph(vertices , graphTrans , visited , graph);
		System.out.println("Transposed Graph : ");
		display(graphTrans);
		for(int v = 0 ; v < vertices ; v++)
			visited[v] = false;
		while(!stack.isEmpty()){
			int v = stack.pop();
			if(visited[v] == false){
				System.out.print("SCC : ");
				dfs(v , visited , graphTrans);
				System.out.println();
			}
		}
	}
	
	public void dfs(int src, boolean[] visited, ArrayList<Integer>[] graphTrans) {
		visited[src] = true;
		System.out.print(src + " ");
		for(Integer nbr : graphTrans[src]){
			if(!visited[nbr])
				dfs(nbr , visited , graphTrans);
		}	
	}

	public void transposeGraph(int vertices, ArrayList<Integer>[] graphTrans , boolean[] visited , 
								ArrayList<Integer>[] graph) {
		for(int i = 0 ; i < vertices ; i++)
			graphTrans[i] = new ArrayList<>();
		
		for(int u = 0 ; u < vertices ; u++){
			for(Integer v : graph[u]){
				graphTrans[v].add(u);
			}
		}
	}
	
	public static void main(String[] args) {
		int vertices = 5;
		Kosaraju scc = new Kosaraju();
		ArrayList<Integer> graph[] = new ArrayList[vertices];
		
		for(int  i = 0 ; i < vertices ; i++){
			graph[i] = new ArrayList<>();
		}
		// add Graph Edge
		scc.addEdge(graph , 1,0);
		scc.addEdge(graph , 2,1);
		scc.addEdge(graph , 0,2);
		scc.addEdge(graph , 0,3);
		scc.addEdge(graph , 3,4);
		
		boolean visited[] = new boolean[vertices];
		Stack<Integer> stack = new Stack<>();
		
		scc.topologicalSort(graph , vertices , visited , stack);
		scc.getSCC(vertices , visited , graph , stack);
	}

	
}
