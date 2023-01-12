package interview.BinaryTrees;
import java.util.*;
public class PrintKDistanceFar {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		NodeToRootPath ntrp = new NodeToRootPath();
		PrintKDistanceFar p = new PrintKDistanceFar();
		Node root = tree.getTreeRoot();	
		int k = 3;
		int inputElement = 75;
		System.out.println("::::: K Distance Far :::::");
		System.out.println("Input  k : " + k  + " and " + " Input Node : " + inputElement);
		ArrayList<Node> path = ntrp.findNodeToRootPath(root, inputElement);
		System.out.print("Nodes that are " + k + " levels far from " + inputElement + " are : ");
		p.printklevelsFar(root, path, k);
	}
	
	private void printklevelsFar(Node node, ArrayList<Node> path , int k){
		for(int  i = 0 ; i < path.size() ; i++){
			printKLevelsDown(path.get(i), k-i , i==0 ? null : path.get(0));
		}
		
	}
	
	private static void printKLevelsDown(Node node , int k , Node blocker){
		if(node == null || k < 0 || node == blocker){
			return;
		}
		if(k==0){
			System.out.print(node.val + " ");
		}
		printKLevelsDown(node.left , k-1 , blocker);
		printKLevelsDown(node.right , k-1 , blocker);
	}

}
