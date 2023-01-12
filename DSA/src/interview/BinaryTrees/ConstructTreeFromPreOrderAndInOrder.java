package interview.BinaryTrees;

public class ConstructTreeFromPreOrderAndInOrder {

	public static void main(String[] args) {
		int inorder[] = {12,25,30,37,50,62,70,75,87};
		int preorder[] = {50,25,12,37,30,75,62,70,87};
		TreeNode root = buildTree(inorder , preorder);
		display(root);
	}

	public static TreeNode buildTree(int[] inorder, int[] preorder) {
		return constructTree(inorder , preorder , 0 , inorder.length - 1 , 0 , preorder.length-1);
	}

	public static TreeNode constructTree(int[] inorder, int[] preorder, 
			int instart, int inend, int prestart, int preend) {
		if(prestart > preend) return null;
		
		TreeNode root = new TreeNode(preorder[prestart]);
		int index = instart;
		while(inorder[index] != preorder[prestart]){
			index++;
		}
		
		int elementCount = index - instart;
		root.left = constructTree(inorder , preorder , instart , index - 1 , 
									prestart + 1 , prestart + elementCount);
		root.right = constructTree(inorder , preorder , index + 1 , inend , 
				prestart + elementCount + 1 , preend);
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
}
