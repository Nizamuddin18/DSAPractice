package interview.BinaryTrees;

public class ConstructTreeFromPostOrderAndInOrder {

	public static void main(String[] args) {
		int inorder[] = {12,25,30,37,50,62,70,75,87};
		int postorder[] = {12,30,37,25,70,62,87,75,50};
		TreeNode root = buildTree(inorder , postorder);
		display(root);

	}
	
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		int postStart = 0;
		int postEnd = postorder.length - 1;
		return constructTree(inorder , postorder , 0 , inorder.length - 1 , postStart , postEnd);
	}

	public static TreeNode constructTree(int[] inorder, int[] postorder, 
			int instart, int inend, int postStart, int postEnd) {
		if(postStart > postEnd) return null;
		
		TreeNode root = new TreeNode(postorder[postEnd]);
		int index = instart;
		while(inorder[index] != postorder[postEnd]){
			index++;
		}
		
		int elementCount = index - instart;
		root.left = constructTree(inorder , postorder , instart , index - 1 , 
				postStart , postStart + elementCount - 1);
		root.right = constructTree(inorder , postorder , index + 1 , inend, 
				postStart + elementCount , postEnd - 1);
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
