package interview.Graph;

import java.util.ArrayList;

public class MotherVertex {

	public static void main(String[] args) {
		int vertices = 5;
		MotherVertex obj = new MotherVertex();
		ArrayList<Integer> graph[] = new ArrayList[vertices];
		
		for(int  i = 0 ; i < vertices ; i++){
			graph[i] = new ArrayList<>();
		}
		// add Graph Edge
		obj.addEdge(graph , 1,0);
		obj.addEdge(graph , 2,1);
		obj.addEdge(graph , 0,2);
		obj.addEdge(graph , 0,3);
		obj.addEdge(graph , 3,4);
		System.out.println("Input Graph : ");
		obj.display(graph);
		boolean visited[] = new boolean[vertices];
		int motherVertex = obj.motherVertex(graph , visited , vertices);
		System.out.println("Output : " + motherVertex);
	}

	public void display(ArrayList<Integer>[] graph) {
		String retString = "";
		for (int i = 0; i < graph.length; i++) {
			retString = retString + i + " => " + graph[i] + "\n";
		}
		System.out.println(retString); 
	}
	
	public int motherVertex(ArrayList<Integer>[] graph, boolean[] visited, int vertices) {
		int mothervertex = -1; 
		for(int i = 0 ; i < vertices ; i++){
			if(!visited[i]){
				dfs(i , visited , graph);
				mothervertex = i; //potential Mother Vertex
			}
		}
	
		for(int i = 0 ; i < vertices ; i++)
			visited[i] = false;
		// Run DFS on Potential Mother Vertex
		dfs(mothervertex , visited , graph);
		// Check if all the vertices are reachable from The Potental Mother Vertex
		for(int i = 0 ; i < vertices ; i++){
			if(visited[i] == false)
				return -1;
		}
		return mothervertex;
	}

	public void dfs(int src, boolean[] visited, ArrayList<Integer>[] graph) {
		visited[src] = true;
		for(Integer nbr : graph[src]){
			if(!visited[nbr])
				dfs(nbr , visited , graph);
		}
	}

	public void addEdge(ArrayList<Integer>[] graph, int src, int dest) {
		graph[src].add(dest);
	}

}
