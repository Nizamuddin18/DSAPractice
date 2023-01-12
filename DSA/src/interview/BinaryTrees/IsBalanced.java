package interview.BinaryTrees;

public class IsBalanced {
	static boolean isBalanced = true;
	private static int isBalanced1(Node node) {
		if(node == null){
			return 0; // Height Node wise
		}
		int leftHeight = isBalanced1(node.left);
		int rightHeight = isBalanced1(node.right);
		int height = Math.max(leftHeight, rightHeight) + 1;
		int gap = Math.abs(leftHeight - rightHeight);
		if(gap > 1)
			isBalanced = false;
		return height;
	}
	
	static class BalPair{
		int height;
		boolean isBal;
		BalPair(){
			this.height = 0;
			this.isBal = true;
		}
	}
	
	private static BalPair isBalanced2(Node node) {
		if(node == null){
			BalPair basepair = new BalPair();
			return basepair;
		}
		
		BalPair leftpair = isBalanced2(node.left);
		BalPair rightpair = isBalanced2(node.right);
		BalPair mypair = new BalPair();
		mypair.isBal = (Math.abs(leftpair.height - rightpair.height) <= 1) &&
						leftpair.isBal && rightpair.isBal;
		mypair.height = Math.max(leftpair.height, rightpair.height) + 1;
		return mypair;
	}
	
	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Node root = tree.constructBinaryTree();
		isBalanced1(root);
		BalPair pair = isBalanced2(root);
		//System.out.println("Is Balanced ? : " + isBalanced);
		System.out.println("Is Balanced ? : " + pair.isBal);
	}
}
