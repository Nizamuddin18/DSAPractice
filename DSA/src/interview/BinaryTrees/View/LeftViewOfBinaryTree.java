package interview.BinaryTrees.View;

import interview.BinaryTrees.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LeftViewOfBinaryTree {
	static int max_level = -1;
	public static void main(String[] args) {
		LeftViewOfBinaryTree tree = new LeftViewOfBinaryTree();
		Node root = new Node(50,null,null);
		/*		LEFT SUB TREE*/		
		root.left = new Node(25,null,null);
		root.left.left = new Node(12,null,null);
		root.left.right = new Node(37,null,null);
		root.left.right.left = new Node(30,null,null);
		/*		RIGHT SUB TREE*/		
		root.right = new Node(75,null,null);
		root.right.left = new Node(62,null,null);
		root.right.right = new Node(87,null,null);
		root.right.left.right = new Node(70,null,null);
		/*System.out.print("Left View of Binary Tree Iterative : ");
		tree.leftViewOfBinaryTreeIterative(root);
		System.out.print("Left View of Binary Tree Recursive : ");
		tree.leftViewOfBinaryTreeRecursive(root , 0);*/
		ArrayList<Integer> ans = tree.leftView(root);
		System.out.println(ans);
	}
	
	public ArrayList<Integer> leftView(Node root) {
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node rem = queue.remove();
				if (i == 0) {
					ans.add(rem.val);
				}
				if (rem.left != null) {
					queue.add(rem.left);
				}
				if (rem.right != null) {
					queue.add(rem.right);
				}
			}
		}
		return ans;
	}
	
	public void leftViewOfBinaryTreeRecursive(Node node , int level){
		if(node == null)
			return;
		if(max_level< level ){
			System.out.print(node.val + " ");
			max_level = level;
		}
		leftViewOfBinaryTreeRecursive(node.left , level+1);
		leftViewOfBinaryTreeRecursive(node.right , level+1); 

	}
	
	private void leftViewOfBinaryTreeIterative(Node root){
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0 ; i < size ; i++){
				Node rem = queue.remove();
				if(i == 0){
					System.out.print(rem.val + " ");
				}
				if(rem.left!=null){
					queue.add(rem.left);
				}
				if(rem.right!=null){
					queue.add(rem.right);
				}
			}
		}
		System.out.println();
	}
	

}
