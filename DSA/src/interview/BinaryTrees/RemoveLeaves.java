package interview.BinaryTrees;

public class RemoveLeaves {
	private static Node removeLeaves(Node node) {
		if(node == null) return null;
		if(node.left == null && node.right == null) return null;
		removeLeaves(node.left);
		removeLeaves(node.right);
		return node;
	}
	
	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Node root = tree.constructBinaryTree();
		System.out.println("Tree Before Removal : ");
		tree.display(root);
		Node newRoot = removeLeaves(root);
		System.out.println("Tree After Removal : ");
		tree.display(newRoot);
	}
}
