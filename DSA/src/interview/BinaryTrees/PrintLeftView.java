package interview.BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class PrintLeftView {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Node root = tree.constructBinaryTree();
		//tree.display(root);
		printleftView(root);
	}
	
	public static void printleftView(Node node){
		Queue<Node> q = new ArrayDeque<Node>();
		q.add(node);
		while(!q.isEmpty()){
			int count = q.size();
			for(int i = 0 ; i < count ; i++){
				Node rem = q.remove();	
				if(i ==0)
					System.out.print(rem.val + " ");
				if(rem.left!=null){
					q.add(rem.left);
				}
				if(rem.right!=null){
					q.add(rem.right);
				}
			}
			System.out.println();
		}
	}
}
