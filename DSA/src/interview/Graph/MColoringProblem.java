package interview.Graph;

import java.util.ArrayList;

public class MColoringProblem {
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
	ArrayList<Edge> graph[];
	public MColoringProblem(int vertices){
		graph = new ArrayList[vertices];
		for(int i = 0 ; i < vertices ; i++)
			graph[i] = new ArrayList<>();
	}
	
	public String toString(){
		String retString = "";
		for(int i = 0 ; i < graph.length ; i++){
			retString += i +" => " +graph[i] + "\n";
		}
		return retString;
	}
	public void addEdge(int src , int dest , int wt){
		graph[src].add(new Edge(dest , wt));
		graph[dest].add(new Edge(src , wt));

	}
	
	
	public boolean isValid(int c , int v , int colors[]){
		for(Edge edge : graph[v]){
			if(colors[edge.nbr] == c)
				return false;
		}
		return true;
	}
	
	public boolean canBeColored(int color, int vertices , int colors[] , int v){
		if(v == vertices)
			return true; 
		for(int c = 1 ; c <= color ; c++){
			if(isValid(c , v , colors)){
				colors[v] = c;
				boolean retVal = canBeColored(color , vertices , colors , v+1);
				if(retVal)
					return true;
				colors[v] = 0;
			}
		}
		return false;
	}
	

	public static void main(String[] args) {
		int vertices = 10;
		MColoringProblem graph = new MColoringProblem(vertices);
		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 4, 10);
		graph.addEdge(1, 2, 10);
		graph.addEdge(1, 6, 10);
		graph.addEdge(2, 8, 10);
		graph.addEdge(6, 7, 10);
		graph.addEdge(5, 8, 10);
		graph.addEdge(5, 9, 10);
		graph.addEdge(6, 9, 10);
		graph.addEdge(7, 8, 10);
		graph.addEdge(9, 3, 10);
		graph.addEdge(3, 4, 10);
		graph.addEdge(4, 7, 10);
		graph.addEdge(0, 5, 10);
		System.out.println(graph);
		
		int noOfColor = 3;
		int colors[] = new int[vertices];
		boolean canBeColored = graph.canBeColored(noOfColor, vertices, colors, 0);
		System.out.println("Is Coloring possible with " + noOfColor + " colors ? " + canBeColored);
		
		






		

	}

}
