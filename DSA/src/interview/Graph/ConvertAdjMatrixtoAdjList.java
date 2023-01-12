package interview.Graph;

import java.util.ArrayList;

public class ConvertAdjMatrixtoAdjList {

	static ArrayList<Integer> graph[];
	
	public static void displayMatrix(int arr[][]){
		for(int i = 0 ; i < arr.length ; i++){
			for(int j = 0 ; j < arr[0].length ; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void convertToList(int arr[][]){
		graph = new ArrayList[arr.length];
		for(int v = 0 ; v < arr.length ; v++){
			graph[v] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < arr.length ; i++){
			for(int j = 0 ; j < arr[i].length ; j++){
				if(arr[i][j] == 1){
					addEdge(i , j);
				}
			}
		}
	}
	
	public static void addEdge(int src , int dest){
		graph[src].add(dest);
	}
	
	public static void displayList(){
		for (int v = 0; v < graph.length; v++) {
            System.out.print(v);
            for (int nbr : graph[v]) {
                System.out.print(" -> " + nbr);
            }
            System.out.println();
        }
	}
	
	public static void main(String[] args) {
		int arr[][] = {{0,0,1},{0,0,1},{1,1,0}};
		System.out.println("Adjacency Matrix Representation of Graph : ");
		displayMatrix(arr);
		convertToList(arr);
		System.out.println("Adjacency List Representation of Graph   : ");
		displayList();
	}
}
