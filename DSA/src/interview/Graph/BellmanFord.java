package interview.Graph;
import java.util.*;

public class BellmanFord {
	public static void printGraph(int src, int dist[], int vertices) {
		System.out.println("Vertex Distance from Source(" + src + ")");
		for (int i = 0; i < vertices; ++i) {
			if (dist[i] != Integer.MAX_VALUE)
				 System.out.println(i + "\t\t" + dist[i]);
			else
				System.out.println((int) 1e9);
		}
	}
	
	public boolean bellmanFord(int src, int edges , int vertices, int[][] graph){
		int dist[] = new int[vertices];
		for(int i = 0 ; i < dist.length ; i++)
			dist[i] = Integer.MAX_VALUE;
		dist[src] = 0;
		for(int i = 0 ; i < vertices - 1; i++){
			for(int j = 0 ; j < edges ; j++){
				int u = graph[j][0];
				int v = graph[j][1];
				int wt = graph[j][2];
				if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
					dist[v] = dist[u] + wt;
			}
		}
		
		//Extra Relaxation
		for (int j = 0; j < edges; ++j) { 
			int u = graph[j][0];
			int v = graph[j][1];
			int wt = graph[j][2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) { 
                return false; 
            } 
        }
		printGraph(src , dist ,vertices);
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Bellman Ford Algorithm");
		int edges = 8;
		int vertices = 5;
		BellmanFord g = new BellmanFord();
		int graph[][] = { // {src , dest , weight}
		{0 , 1 , -1},
		{0 , 2 , 4},
		{1 , 2 , 3},
		{1 , 3 , 2},
		{1 , 4 , 2},
		{3 , 2 , 5},
		{3 , 1 , 1},
    	{4 , 3 , -3}};
        boolean ans = g.bellmanFord(0 , edges , vertices , graph);
        if(ans == false){
        	System.out.println("Graph contains negative weight cycle"); 
        }
	}

}