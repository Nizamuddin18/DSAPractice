package interview.Graph;
import java.util.*;

public class Dijkstra {
	static class Edge{
		int v;
		int wt;
		Edge(int v , int wt){
			this.v = v;
			this.wt = wt;
		}
	}
	
	static class Pair implements Comparable<Pair>{
		int nbr;
		int wsf;
		String psf;
		Pair(int nbr , int wsf , String psf){
			this.nbr = nbr;
			this.wsf = wsf;
			this.psf = psf;
		}
		@Override
		public int compareTo(Pair o) {
			return this.nbr - o.nbr;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		// create list
		int vertices = 7;
		graph = new ArrayList<>();
		for(int v = 0 ; v < vertices ; v++){
			graph.add(new ArrayList<>());
		}
		addEdge(graph , 0, 1, 10);
		addEdge(graph , 0, 3, 25);
		addEdge(graph , 1, 2, 10);
		addEdge(graph , 3, 4, 2);
		addEdge(graph , 4, 5, 3);
		addEdge(graph , 4, 6, 8);
		addEdge(graph , 5, 6, 3);	
		dijkstras(graph , 0 , 0 , "" , vertices);
	}

	private static void dijkstras(ArrayList<ArrayList<Edge>> graph, int src , int wsf , String psf , int vertices) {
		boolean visited[] = new boolean[vertices];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(src , wsf , psf));
		while(!pq.isEmpty()){
			Pair rem = pq.remove();
			if(visited[rem.nbr] == true)
				continue;
			System.out.println("[ Node " + rem.nbr + " travelled via " + rem.psf + " with weight " + rem.wsf + " ]");
			visited[rem.nbr] = true;
			for(Edge edge : graph.get(rem.nbr)){
				pq.add(new Pair(edge.v , edge.wt + rem.wsf , edge.v + rem.psf));
			}
		}
	}

	private static void addEdge(ArrayList<ArrayList<Edge>> graph, int src , int dest, int wt) {
		graph.get(src).add(new Edge(dest , wt));
		graph.get(dest).add(new Edge(src , wt));
		
	}
	
}
