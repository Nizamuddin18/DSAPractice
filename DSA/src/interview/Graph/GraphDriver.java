package interview.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class GraphDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = 7;
		Graph g = new Graph(vertices);
		System.out.println("1.Breadth First Search");
		System.out.println("2.Depth First Search");
		System.out.println("3.Has Path");
		System.out.println("4.Print All Paths");
		System.out.println("5.Connected Components");
		System.out.println("6.Is Graph Connected");
		System.out.println("7.Hamiltonian Path/Cycle");
		System.out.println("8.Dijkstra's");
		System.out.println("9.Prims");
		System.out.println("10.Is Graph Cyclic");
		System.out.println("11.No of Islands : ");
		System.out.println("12.Spread Of Infections : ");
		while(true){
			System.out.println("Enter Your Choice(Press -1 to Exit) : ");
			int choice = sc.nextInt();
			switch(choice){
			case 1 :
				bfs(g , vertices);
				break;
			case 2 : 
				dfs(g , vertices);
				break;
			case 3 : 
				hasPathCheck(g , vertices);
				break;
			case 4 : 
				printAllPathCheck(g , vertices);
				break;
			case 5 :
				getConnectedComponents(g , vertices);
				break;
			case 6 : 
				isGraphConnected(g , vertices);
				break;
			case 7 : 
				hamiltonian(g , vertices);
				break;
			case 8 :
				dijkstra(g , vertices);
				break;
			case 9 : 
				prim(g , vertices);
				break;
			case 10 :
				cycle(g , vertices);
				break;
			case 11 :			 
				noofIslands(g);
				break;
			case 12 :
				spreadOfInfections(g , vertices);
				break;
			default : 
				System.exit(0);
			}
		}
		
	}

	private static void cycle(Graph g, int vertices){
		g.addEdge(0, 1, 15);
		g.addEdge(2, 3, 15);
		g.addEdge(3, 4, 15);
		g.addEdge(5, 6, 15);
		g.addEdge(4, 6, 15);
		boolean visited[] = new boolean[vertices];
		System.out.print("IS CYCLIC USING BFS : ");
		for(int v = 0; v < vertices ; v++){
			if(visited[v] == false){
				boolean cycle = g.isCycle(v, visited);
				if(cycle){
					System.out.println("TRUE");
					return;
				}
			}
		}
		System.out.println("FALSE");	
	}
	
	private static void prim(Graph g, int vertices){
		g.addEdge(0, 1, 10);
		g.addEdge(0, 3, 25);
		g.addEdge(1, 2, 10);
		g.addEdge(2, 3, 10);
		g.addEdge(3, 4, 2);
		g.addEdge(4, 5, 3);
		g.addEdge(4, 6, 8);
		g.addEdge(5, 6, 3);
		boolean visited[] = new boolean[vertices];
		g.prims(0, -1, 0, visited);
	}
	
	private static void spreadOfInfections(Graph g, int vertices){
		g.addEdge(0, 1, 10);
		g.addEdge(0, 3, 25);
		g.addEdge(1, 2, 10);
		g.addEdge(2, 3, 10);
		g.addEdge(3, 4, 2);
		g.addEdge(4, 5, 3);
		g.addEdge(4, 6, 8);
		g.addEdge(5, 6, 3);
		int visited[] = new int[vertices];
		int t = 3;
		int count = g.spreadOfInfection(6, visited , t);
		System.out.println("Total no of Vertices Infrected at time t = " + t + " : " + count);
	}
	
	private static void dijkstra(Graph g , int vertices){
		g.addEdge(0, 1, 10);
		g.addEdge(0, 3, 40);
		g.addEdge(1, 2, 10);
		g.addEdge(2, 3, 10);
		g.addEdge(3, 4, 2);
		g.addEdge(4, 5, 3);
		g.addEdge(4, 6, 8);
		g.addEdge(5, 6, 3);
		boolean visited[] = new boolean[vertices];
		g.dijkstras(0, 0 + "", 0, visited);
	}
	private static void hamiltonian(Graph g, int vertices) {
		g.addEdge(0, 1, 10);
		g.addEdge(0, 3, 10);
		g.addEdge(1, 2, 10);
		g.addEdge(2, 3, 10);
		g.addEdge(2, 5, 10);
		g.addEdge(3, 4, 10);
		g.addEdge(4, 5, 10);
		g.addEdge(4, 6, 10);
		g.addEdge(5, 6, 10);
		HashSet <Integer> visited = new HashSet<>();
		g.isHamiltonian(0, visited, 0+"", 0);
		
	}

	private static void dfs(Graph g , int vertices){
		/*g.addEdge(0, 1, 10);
		g.addEdge(0, 3, 10);
		g.addEdge(1, 2, 10);
		g.addEdge(2, 3, 10);
		g.addEdge(3, 4, 10);
		g.addEdge(4, 5, 10);
		g.addEdge(4, 6, 10);
		g.addEdge(5, 6, 10);*/
		
		g.addEdge(0, 1, 10);
		g.addEdge(0, 2, 10);
		g.addEdge(1, 3, 10);
		g.addEdge(1, 4, 10);
		g.addEdge(2, 5, 10);
		g.addEdge(2, 6, 10);
		boolean visited[] = new boolean[vertices];
		System.out.println("DFS : ");
		g.depthFirstSearch(0 , visited);
		System.out.println();
	}
	
	
	private static void bfs(Graph g, int vertices) {
		/*vertices = 6;
		g.addEdge(0, 1, 10);
		g.addEdge(0, 2, 10);
		g.addEdge(1, 3, 12);
		g.addEdge(2, 4, 10);
		g.addEdge(1, 4, 15);
		g.addEdge(3, 4, 12);
		g.addEdge(3, 5, 10);
		g.addEdge(4, 5, 12);*/
		
		/*g.addEdge(0, 1, 10);
		g.addEdge(0, 3, 10);
		g.addEdge(1, 2, 10);
		g.addEdge(2, 3, 10);
		g.addEdge(3, 4, 10);
		g.addEdge(4, 5, 10);
		g.addEdge(4, 6, 10);
		g.addEdge(5, 6, 10);*/
		
		g.addEdge(0, 1, 10);
		g.addEdge(0, 2, 10);
		g.addEdge(1, 3, 10);
		g.addEdge(1, 4, 10);
		g.addEdge(2, 5, 10);
		g.addEdge(2, 6, 10);
		boolean visited[] = new boolean[vertices];
		System.out.println("BFS : ");
		g.breadthFirstSearch(0, visited);
		System.out.println();
	}

	private static void isGraphConnected(Graph g, int vertices) {
		g.addEdge(0, 1, 15);
		g.addEdge(2, 3, 15);
		g.addEdge(4, 5, 15);
		g.addEdge(5, 6, 15);
		g.addEdge(4, 6, 15);
		System.out.println(g);
		boolean visited[] = new boolean[vertices];
		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
		for(int  i = 0; i < vertices;i++){
			if(visited[i] == false){
				ArrayList <Integer> comp = new ArrayList<>();
				g.drawTreeAndGenerateComp(i , comp , visited); 
				comps.add(comp);
			}	
		}
		if(comps.size() == 1)
			System.out.println("true");
		else
			System.out.println("false");
		
	}

	private static void getConnectedComponents(Graph g, int vertices) {
		g.addEdge(0, 1, 15);
		g.addEdge(2, 3, 15);
		g.addEdge(4, 5, 15);
		g.addEdge(5, 6, 15);
		g.addEdge(4, 6, 15);
		System.out.println(g);
		boolean visited[] = new boolean[vertices];
		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
		for(int  i = 0; i < vertices;i++){
			if(visited[i] == false){
				ArrayList <Integer> comp = new ArrayList<>();
				g.drawTreeAndGenerateComp(i , comp , visited); 
				comps.add(comp);
			}	
		}
		System.out.println(comps);
	}

	private static void printAllPathCheck(Graph g , int vertices) {
		g.addEdge(0, 1, 10);
		g.addEdge(0, 3, 15);
		g.addEdge(1, 2, 12);
		g.addEdge(2, 3, 10);
		g.addEdge(3, 4, 15);
		g.addEdge(4, 5, 12);
		g.addEdge(4, 6, 10);
		g.addEdge(5, 6, 12);
		System.out.println(g);
		boolean visited[] = new boolean[vertices];
		g.printAllPaths(0, 6, visited, 0 + "");
	}

	private static void hasPathCheck(Graph g , int vertices) {
		g.addEdge(0, 1, 10);
		g.addEdge(0, 3, 15);
		g.addEdge(1, 2, 12);
		g.addEdge(2, 3, 10);
		g.addEdge(3, 4, 15);
		g.addEdge(4, 5, 12);
		g.addEdge(4, 6, 10);
		g.addEdge(5, 6, 12);
		System.out.println(g);
		boolean visited[] = new boolean[vertices];
		int src = 0;
		int dest = 6;
		boolean hasPath = g.hasPath(src, dest, visited);
		System.out.println("Has Path between " + src + " and " + dest + " : "+ hasPath);
	}

	private static void noofIslands(Graph g) {
		int arr[][] = {
		{0,0,1,1,1,1,1,1},
		{0,0,1,1,1,1,1,1},
		{1,1,1,1,1,1,1,0},
		{1,1,0,0,0,1,1,0},
		{1,1,1,1,0,1,1,0},
		{1,1,1,1,0,1,1,0},
		{1,1,1,1,1,1,1,0},
		{1,1,1,1,1,1,1,0}};

		int count = 0;
		for(int i = 0 ; i <arr.length ; i++){
			for(int j = 0 ; j < arr[i].length ; j++){
				if(arr[i][j] == 0){
					count++;
					g.gccForIslands(arr , i , j);
				}
			}
		}
		System.out.println(count);
	}
	
}
