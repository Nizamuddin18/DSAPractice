package interview.BinaryTrees;

public class BinaryTreeProperties {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Node root = tree.constructBinaryTree();
		int size = size(root);
		int sum = sum(root);
		int max = max(root);
		int height = height(root);
		System.out.println("Size of Binary Tree : " + size);
		System.out.println("Sum of Binary Tree : " + sum);
		System.out.println("Max of Binary Tree : " + max);
		System.out.println("Height of Binary Tree(Edge-Wise) : " + height);
	}

	private static int height(Node node) {
		if(node == null) return -1;
		int lheight = height(node.left);
		int rheight = height(node.right);
		return Math.max(lheight, rheight) + 1;
	}

	private static int max(Node node) {
		if(node == null) return Integer.MIN_VALUE;
		int lmax = max(node.left);
		int rmax = max(node.right);
		return Math.max(node.val, Math.max(lmax, rmax));
	}

	private static int sum(Node node) {
		if(node == null) return 0;
		int lsum = sum(node.left);
		int rsum = sum(node.right);
		return lsum + rsum + node.val;
	}

	private static int size(Node node) {
		if(node == null) return 0;
		int lsize = size(node.left);
		int rsize = size(node.right);
		return lsize + rsize + 1;
	}

}
