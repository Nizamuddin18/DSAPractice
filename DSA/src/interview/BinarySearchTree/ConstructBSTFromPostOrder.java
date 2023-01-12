package interview.BinarySearchTree;

public class ConstructBSTFromPostOrder {
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
	
	static int indx = 0;
	public static TreeNode bstFromPostorder(int[] post, int leftRange, int rightRange) {
		if (indx < 0 || post[indx] < leftRange || rightRange < post[indx]) {
			return null;
		}
		int val = post[indx--];
		TreeNode root = new TreeNode(val);
		root.right = bstFromPostorder(post, val, rightRange);
		root.left = bstFromPostorder(post, leftRange, val);
		return root;
	}

	public static TreeNode bstFromPostorder(int post[]) {
		indx = post.length - 1;
		return bstFromPostorder(post, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static void main(String[] args) {
		int postorder[] = {30,20,10,15,25,23,39,35,42};
		TreeNode root = bstFromPostorder(postorder);
		display(root);
	}

}
