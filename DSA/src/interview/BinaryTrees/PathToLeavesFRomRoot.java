package interview.BinaryTrees;

public class PathToLeavesFRomRoot {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		
		Node root = new Node(10,null,null);
		root.left = new Node(5,null,null);
		root.left.left = new Node(1,null,null);
		root.left.right = new Node(7,null,null);
		root.right = new Node(15,null,null);
		root.right.left = new Node(12,null,null);
		root.right.right = new Node(17,null,null);
		
		int low = 22,high = 37;
		System.out.println("Path to Leaf from Root where sum lies in the range of " + low + " to " + high);
		pathToLeaves(root , "" , 0, low, high);
	}

	private static void pathToLeaves(Node node, String path, int sum, int low, int high) {
		if(node == null) // base case
			return;
		
		if(node.left == null && node.right == null){//checking for Leaf nodes
			sum = sum + node.val; // store the leaf value
			if(sum >= low && sum <= high){
				System.out.println(path.concat(Integer.toString(node.val)));
			}
			return;
		}
		pathToLeaves(node.left , path + node.val + " " , sum + node.val , low , high);
		pathToLeaves(node.right , path + node.val + " " , sum + node.val , low , high);

	}

}
