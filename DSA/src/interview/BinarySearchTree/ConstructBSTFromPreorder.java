package interview.BinarySearchTree;

public class ConstructBSTFromPreorder {
	public static void display(TreeNode node) {
		if (node == null) return;
		String str = "";
		str += node.left == null ? "." : node.left.val + "";
		str += " <- " + node.val + " -> ";
		str += node.right == null ? "." : node.right.val + "";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	
	public static TreeNode bstFromPreorder(int[] pre) {
		indx = 0;
		return bstFromPreorder(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	static int indx = 0;
	public static TreeNode bstFromPreorder(int[] pre, int minRange, int maxRange) {
		if (indx >= pre.length || pre[indx] < minRange || maxRange < pre[indx]) {
			return null;
		}
		int val = pre[indx++];
		TreeNode root = new TreeNode(val);

		root.left = bstFromPreorder(pre, minRange, val);
		root.right = bstFromPreorder(pre, val, maxRange);
		return root;
	}
	       
	public static void main(String[] args) {
		int preorder[] = {30,20,10,15,25,23,39,35,42};
		TreeNode root = bstFromPreorder(preorder);
		display(root);
	}
}
