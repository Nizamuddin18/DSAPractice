package interview.BinarySearchTree;

public class LCA {
	public static int lca(Node node, int d1, int d2) {

		if (node.data > d1 && node.data > d2) {
			return lca(node.left, d1, d2);
		} else if (node.data < d1 && node.data < d2) {
			return lca(node.right, d1, d2);
		} else {
			return node.data;
		}
	}

	public static void main(String[] args) {
		Construct bst = new Construct();
		Node root = bst.constructBST();
		bst.display(root);
		int d1 = 70;
		int d2 = 75;
		System.out.println("d1 : " + d1);
		System.out.println("d2 : " + d2);
		int lca = lca(root , d1 , d2);
		System.out.println("Lowest Common Ancestor (LCA) : " + lca);
	}

}
