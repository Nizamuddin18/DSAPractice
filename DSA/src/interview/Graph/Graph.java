package interview.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Edge {
	int v; // v is the neighbour vertex of the source vertex
	int wt; // wt is weight between source and neighbour vertex

	public Edge(int v, int wt) {
		this.v = v;
		this.wt = wt;
	}

	@Override
	public String toString() {
		return "[" + v + "," + wt + "]";
	}

}

class PairDijkstra implements Comparable<PairDijkstra> {
	int v;
	String psf;
	int wsf;

	PairDijkstra(int v, String psf, int wsf) {
		this.v = v;
		this.psf = psf;
		this.wsf = wsf;
	}

	@Override
	public int compareTo(PairDijkstra p) {
		if (this.wsf > p.wsf)
			return 1;
		else if (this.wsf < p.wsf)
			return -1;
		else
			return 0;
	}

}

class PairPrism implements Comparable<PairPrism> {
	int v;
	int parent;
	int w;

	PairPrism(int v, int parent, int w) {
		this.v = v;
		this.parent = parent;
		this.w = w;
	}

	@Override
	public int compareTo(PairPrism o) {
		if (this.w > o.w)
			return 1;
		else if (this.w < o.w)
			return -1;
		else
			return 0;
	}
}

class PairCycle {
	int v;
	String psf;

	PairCycle(int v, String psf) {
		this.v = v;
		this.psf = psf;
	}
}

public class Graph {
	LinkedList<Edge> G[]; // G is an array of LinkedList that is of custom type
							// Edge

	/*
	 * This constructor takes in vertices as input and sets the memory for G
	 * array
	 */
	public Graph(int vertices) {
		G = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			G[i] = new LinkedList(); // This creates a new LinkedList for all
										// the vertices of array G.
		}
	}

	public void addEdge(int u, int v, int wt) {
		G[u].add(new Edge(v, wt)); // add a new Edge between a source u and
									// neighbour v with weight wt
		// G[v].add(new Edge(u , wt));
	}

// ============================================================= HAS PATH ========================================================================
	/*
	 * This method checks whether a Path exists between a source src and
	 * destination dest
	 */
	public boolean hasPath(int src, int dest, boolean visited[]) {
		if (src == dest)
			return true;
		visited[src] = true; // mark the source vertex as true
		for (Edge edge : G[src]) {
			/*
			 * if the connected neighbour of the source is not visited, then
			 * check for that neighbour whether that is connected to destination
			 */
			if (visited[edge.v] == false) { //
				boolean hasNbrPath = hasPath(edge.v, dest, visited);
				if (hasNbrPath)
					return true;
			}
		}
		return false;
	}
	
// ================================================================================================================================================
// ============================================================= PRINT ALL PATH ===================================================================

	public void printAllPaths(int src, int dest, boolean visited[], String psf) {
		if (src == dest) {
			System.out.println(psf);
			return;
		}
		visited[src] = true;
		for (Edge edge : G[src]) {
			if (visited[edge.v] == false) {
				printAllPaths(edge.v, dest, visited, psf + edge.v);
			}
		}
		visited[src] = false;
	}
	
// ================================================================================================================================================
// ============================================================= DRAW COMPONENT ===================================================================

	public void drawTreeAndGenerateComp(int src, ArrayList<Integer> comp, boolean[] visited) {
		visited[src] = true;
		comp.add(src);
		for (Edge edge : G[src]) {
			if (visited[edge.v] == false) {
				drawTreeAndGenerateComp(edge.v, comp, visited);
			}
		}
	}
	// ================================================================================================================================================
// =============================================================== DFS ============================================================================

	public void depthFirstSearch(int src, boolean visited[]) {
		visited[src] = true;
		System.out.print(src + " ");
		for (Edge edge : G[src]) {
			if (visited[edge.v] == false) {
				depthFirstSearch(edge.v, visited);
			}
		}
	}

// ================================================================================================================================================
// =========================================================== HAMILTONIAN ========================================================================

	public void isHamiltonian(int src, HashSet<Integer> visited, String psf, int osrc) {
		if (visited.size() == G.length - 1) {
			psf += src;
			System.out.print(psf);
			boolean EdgeClosingOut = false;
			for (Edge e : G[src]) {
				if (e.v == osrc) {
					EdgeClosingOut = true;
					break;
				}
			}

			if (EdgeClosingOut == true) {
				System.out.println("*");
			} else {
				System.out.println(".");
			}
			return;
		}

		visited.add(src);
		for (Edge edge : G[src]) {
			if (visited.contains(edge.v) == false) {
				isHamiltonian(edge.v, visited, psf + edge.v, osrc);
			}
		}
		visited.remove(src);
	}

// ================================================================================================================================================
// =============================================================== BFS ============================================================================

	public void breadthFirstSearch(int src, boolean visited[]) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(src);
		while (!queue.isEmpty()) {
			int data = queue.remove(); // Remove
			if (visited[data] == true)
				continue;
			visited[data] = true; // Mark*
			System.out.print(data + " "); // Work
			for (Edge e : G[data]) { // Add*
				if (visited[e.v] == false)
					queue.add(e.v);
			}
		}
	}

// ================================================================================================================================================
// ================================================================ DIJKSTRA'S ====================================================================

	public void dijkstras(int src, String psf, int wsf, boolean visited[]) {

		PriorityQueue<PairDijkstra> pq = new PriorityQueue<PairDijkstra>();
		pq.add(new PairDijkstra(src, psf, wsf));
		while (!pq.isEmpty()) {
			PairDijkstra rem = pq.remove();
			if (visited[rem.v] == true)
				continue;
			visited[rem.v] = true;
			System.out.println("[ Node " + rem.v + " travelled via " + rem.psf + " with weight " + rem.wsf + " ]");
			for (Edge edge : G[rem.v]) {
				if (visited[edge.v] == false) {
					pq.add(new PairDijkstra(edge.v, rem.psf + edge.v, rem.wsf + edge.wt));
				}
			}
		}
	}

// ================================================================================================================================================
// =============================================================== PRIMS ==========================================================================

	public void prims(int src, int parent, int wt, boolean visited[]) {
		PriorityQueue<PairPrism> pq = new PriorityQueue<PairPrism>();
		pq.add(new PairPrism(src, parent, wt));
		while (!pq.isEmpty()) {
			PairPrism rem = pq.remove();
			if (visited[rem.v] == true)
				continue;
			visited[rem.v] = true;
			if (rem.parent != -1)
				System.out.println("[ Node " + rem.v + " parent is " + rem.parent + " of weight " + rem.w + " ]");
			for (Edge edge : G[rem.v]) {
				if (visited[edge.v] == false) {
					pq.add(new PairPrism(edge.v, rem.v, edge.wt));
				}
			}
		}
	}

// ================================================================================================================================================
// ============================================================= CYCLE DETECTION ==================================================================

	public boolean isCycle(int src, boolean visited[]) {
		ArrayDeque<PairCycle> pq = new ArrayDeque<PairCycle>();
		pq.add(new PairCycle(src, src + ""));
		while (pq.size() > 0) {
			PairCycle rem = pq.removeFirst();
			if (visited[rem.v] == true)
				return true;
			visited[rem.v] = true;
			for (Edge edge : G[rem.v]) {
				if (visited[edge.v] == false) {
					pq.add(new PairCycle(edge.v, rem.psf + edge.v));
				}
			}
		}
		return false;
	}

// ================================================================================================================================================
// ======================================================== No of Islands =========================================================================

	static int xdir[] = { -1, 0, 1, 0 };
	static int ydir[] = { 0, -1, 0, 1 };

	public void gccForIslands(int[][] arr, int i, int j) {
		arr[i][j] = -1;
		for (int dir = 0; dir < xdir.length; dir++) {
			int r = i + xdir[dir];
			int c = j = ydir[dir];
			if (r >= 0 && r < arr.length && c >= 0 && c < arr[0].length && arr[r][c] == 0) {
				gccForIslands(arr, r, c);
			}
		}
	}

// ================================================================================================================================================
// ======================================================== Spread of Infection ===================================================================
	static class Pair{
		int vrtx;
		int time;
		Pair(int vrtx , int time){
			this.vrtx = vrtx;
			this.time = time;
		}
		
		
	}

	public int spreadOfInfection(int src, int visited[], int t) {
		int count = 0;
		Queue<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(src, 1));
		while (!queue.isEmpty()) {
			Pair rem = queue.remove();
			if (visited[rem.vrtx] > 0)
				continue;
			visited[rem.vrtx] = rem.time;
			if (rem.time > t)
				break;
			count++;
			for (Edge e : G[rem.vrtx]) {
				if (visited[e.v] == 0)
					queue.add(new Pair(e.v, rem.time + 1));
			}
		}
		return count;
	}
	
// ================================================================================================================================================
	
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < G.length; i++) {
			result = result + i + " => " + G[i] + "\n";
		}
		return result;
	}

}
