package interview.BinaryTrees.Traversal;

import interview.BinaryTrees.ConstructBinaryTree;
import interview.BinaryTrees.Node;

public class TraversalRecursive {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Node root = tree.constructBinaryTree();
		System.out.println("Binary Tree Traversal(Recursive) : ");
		System.out.print("Inorder :  ");
		inOrderTraversal(root);
		System.out.println();
		System.out.print("Preorder : ");
		preOrderTraversal(root);
		System.out.println();
		System.out.print("Postorder: ");
		postOrderTraversal(root);
		System.out.println();
	}
	
	  public static void inOrderTraversal(Node node){
		  if(node == null){
			  return;
		  }
		  inOrderTraversal(node.left);
		  System.out.print(node.val + " ");
		  inOrderTraversal(node.right);
	  }
	  
	  public static void preOrderTraversal(Node node){
		  if(node == null){
			  return;
		  }
		  System.out.print(node.val + " ");
		  preOrderTraversal(node.left);
		  preOrderTraversal(node.right);
	  }
	  
	  public static void postOrderTraversal(Node node){
		  if(node == null){
			  return;
		  }
		  postOrderTraversal(node.left);
		  postOrderTraversal(node.right);
		  System.out.print(node.val + " ");
	  }

}
