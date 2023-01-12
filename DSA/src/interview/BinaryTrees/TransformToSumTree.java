package interview.BinaryTrees;

public class TransformToSumTree {

	public static void main(String[] args) {
		Node root = new Node(10,null,null);
		ConstructBinaryTree tree = new ConstructBinaryTree();
		//Left Sub Tree
		root.left = new Node(-2,null,null);
		root.left.left = new Node(8,null,null);
		root.left.right = new Node(-4,null,null);
		
		//Right Sub Tree
		root.right= new Node(6,null,null);
		root.right.left = new Node(7,null,null);
		root.right.right = new Node(5,null,null);
		tree.display(root);
		transormedToSumTree(root);
		tree.display(root);
	}
	private static int transormedToSumTree(Node node){
		if(node == null){
			return 0;
		}
		int leftSubTreeVal = transormedToSumTree(node.left);
		int rightSubTreeVal = transormedToSumTree(node.right);
		int nodeVal = node.val;
		node.val = leftSubTreeVal + rightSubTreeVal;
		return nodeVal + leftSubTreeVal + rightSubTreeVal;
	}

}
