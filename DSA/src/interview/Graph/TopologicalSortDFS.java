package interview.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {

	ArrayList<Integer> graph[];

	public TopologicalSortDFS(int vertices) {
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

	public void topolocialSort(int src, boolean[] visited, Stack<Integer> stack) {
		visited[src] = true;
		for (Integer e : graph[src]) {
			if (visited[e] == false) {
				topolocialSort(e, visited, stack);
			}
		}
		stack.push(src);
	}

	public static void main(String[] args) {
		System.out.println("Toplogical Sort(DFS)");
		int vertices = 7;
		TopologicalSortDFS graph = new TopologicalSortDFS(vertices);
		Stack<Integer> stack = new Stack<>();
		boolean visited[] = new boolean[vertices];
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		// graph.addEdge(4, 3, 20);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(4, 6);
		System.out.println(graph);
		for (int v = 0; v < vertices; v++) {
			if (visited[v] == false) {
				graph.topolocialSort(v, visited, stack);
			}
		}
		System.out.println("Output : ");
		while (!stack.isEmpty())
			System.out.print(stack.pop() + "  ");
	}

}
