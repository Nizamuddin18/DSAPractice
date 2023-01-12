package interview.BinaryTrees;

public class CheckIfSumTree {
	private static boolean checkIfSumTree(Node node){
		int leftSum = 0 , rightSum = 0;
		if(node == null || isLeafNode(node))
			return true;
		if(checkIfSumTree(node.left) && checkIfSumTree(node.right)){
			
			if(node.left == null)
				leftSum = 0;
			else if(isLeafNode(node.left))
				leftSum = node.left.val;
			else
				leftSum = 2*node.left.val;
			
			if(node.right == null)
				rightSum = 0;
			else if(isLeafNode(node.right))
				rightSum = node.right.val;
			else
				rightSum = 2*node.right.val;
			
			if(node.val == leftSum + rightSum)
				return true;
			else
				return false;
		}
		return false;
	}
	private static boolean isLeafNode(Node node){
		if(node == null)
			return false;
		if(node.left == null && node.right == null)
			return true;
		return false;
	}
	public static void main(String[] args) {
		Node root = new Node(120,null,null);
		 root.left = new Node(40,null,null);
		 root.left.left = new Node(10,null,null);
		 root.left.right = new Node(30,null,null);
		 
		 root.right = new Node(20,null,null);
		 root.right.right = new Node(20,null,null);
		 boolean retVal = checkIfSumTree(root);
		 System.out.println("Check If Tree is SumTree : " + retVal);
	}

}
