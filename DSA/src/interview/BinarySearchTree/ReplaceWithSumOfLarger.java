package interview.BinarySearchTree;

public class ReplaceWithSumOfLarger {
	static int sum = 0; // global variable sum to store the overall sum of visited nodes

	public static void rwsol(Node node) {
		if(node == null) return;
		//Reverse Inorder Traversal
		
		rwsol(node.right); 		// move to right node
		int data = node.data; 	// store the current node[data] in data
		node.data = sum;		// node[data] is replaced by sum (global variable)
		sum += data;			// increment sum by adding node[data] to sum
		rwsol(node.left);		// move to left node
		
	}
	public static void main(String[] args) {
		Construct bst = new Construct();
		Node root = bst.constructBST();
		System.out.println("Before Replace with Sum Of Larger Value : ");
		bst.display(root);
		rwsol(root);
		System.out.println("After Replace with Sum Of Larger Value : ");
		bst.display(root);
		
	}

}
