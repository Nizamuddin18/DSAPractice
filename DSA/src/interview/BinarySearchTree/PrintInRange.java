package interview.BinarySearchTree;

public class PrintInRange {
	public static void pir(Node node, int d1, int d2) {
		if (node == null)
			return;

		pir(node.left, d1, d2);
		if (node.data >= d1 && node.data <= d2)
			System.out.println(node.data);
		pir(node.right, d1, d2);
	}

	public static void main(String[] args) {
		Construct tree = new Construct();
		Node root = tree.constructBST();
		System.out.println("Input Tree : ");
		tree.display(root);
		int d1 = 12;
		int d2 = 62;
		System.out.println("Output : ");
		pir(root , d1 , d2);
	}

}
