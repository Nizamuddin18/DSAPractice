package interview.BinarySearchTree;

public class ConstructBSTFromInorder {

	public static TreeNode sortedArray(int inorder[]) {
		return constructBSTfromInorder(inorder, 0, inorder.length - 1);
	}

	public static TreeNode constructBSTfromInorder(int inorder[], int low, int high) {
		if (low > high)
			return null;
		int mid = low + (high - low) / 2;
		TreeNode root = new TreeNode(inorder[mid]);
		root.left = constructBSTfromInorder(inorder, low, mid - 1);
		root.right = constructBSTfromInorder(inorder, mid + 1, high);
		return root;

	}
	
	public static void display(TreeNode node) {
		if (node == null) {
			return;
		}
		String str = "";
		str += node.left == null ? "." : node.left.val + "";
		str += " <- " + node.val + " -> ";
		str += node.right == null ? "." : node.right.val + "";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	
	public static void main(String[] args) {
		int inorder[] = {12,25,30,37,50,62,70,75,87};
		TreeNode root = sortedArray(inorder);
		display(root);
	}

}
