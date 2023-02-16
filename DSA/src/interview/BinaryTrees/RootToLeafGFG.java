package interview.BinaryTrees;

import java.util.Scanner;
/*https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
*/public class RootToLeafGFG {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Scanner sc = new Scanner(System.in);
		Node root = new Node(10,null,null);
		root.left = new Node(8,null,null);
		root.right = new Node(7,null,null);
		root.left.left = new Node(3,null,null);
		root.left.right = new Node(5,null,null);
		root.right.left = new Node(4,null,null);
		//tree.display(root);
		System.out.println("Enter Sum : ");
		int sum = sc.nextInt();
		rootToLeaf(root , 0 , "" , sum);
		
	}
	
	public static void rootToLeaf(Node node , int mysum , String psf , int sum){
		if(node == null)
			return;
		if(node.left == null && node.right == null){
			mysum  = node.val + mysum;
			if(sum == mysum){
				System.out.println("Path : " + psf + "-"+node.val);
			}
			return;
		}
		rootToLeaf(node.left , mysum + node.val , psf + "-"+node.val , sum);
		rootToLeaf(node.right , mysum + node.val , psf + "-"+node.val , sum);

		
	}

}
