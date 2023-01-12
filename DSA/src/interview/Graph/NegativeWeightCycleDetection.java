package interview.Graph;

public class NegativeWeightCycleDetection {
	
	public boolean bellmanFord(int src, int edges , int vertices, int[][] graph){
		int dist[] = new int[vertices];
		/*distance[] - > [INF , INF , INF , INF , INF , INF];*/
		for(int i = 0 ; i < dist.length ; i++)
			dist[i] = Integer.MAX_VALUE;
		
		dist[src] = 0;
		for(int i = 0 ; i < vertices - 1; i++){
			for(int j = 0 ; j < edges ; j++){
				int u = graph[j][0];
				int v = graph[j][1];
				int wt = graph[j][2];
				if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) // Relaxation
					dist[v] = dist[u] + wt;
			}
		}
		
		// 1 Extra Relaxation
		for (int j = 0; j < edges; ++j) { 
			int u = graph[j][0];
			int v = graph[j][1];
			int wt = graph[j][2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) { 
                return true; // If -ve Weight Cycle Exist
            } 
        }
		return false; // NO -ve Weight Cycle exist
	}
	
	public static void main(String[] args) {
		System.out.println(":::Negative Weight Cycle Detection using Bellman Ford:::");
		int edges = 3;
		int vertices = 3;
		NegativeWeightCycleDetection g = new NegativeWeightCycleDetection();
		int graph[][] = { // {src , dest , weight}
				{0 ,  1  ,-1},
				{1  , 2  , -4},
				{2  , 0  , 3}};
		/*{0 , 1 , 1},
		{1 , 2 , 2},
		{2 , 3 , 3},
		{3 , 4 , -4},
		{4 , 1 , -5},
		{3 , 5 , 6}};*/
        boolean isNegativeCyclic = g.bellmanFord(0 , edges , vertices , graph);
        System.out.print("Does Graph Contains -ve Edge Weight Cycle ? ");
        if(isNegativeCyclic)
        	System.out.println(true); 
        else
        	System.out.println(false);
	}

}
