package interview.BinaryTrees;

public class PrintKLevelsDown {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Node root = tree.constructBinaryTree();
		int k = 2;
		System.out.print("Print " + k + " levels down from Root("+root.val+") : ");
		printKLevelsDown(root , k);

	}
	
	public static void printKLevelsDown(Node node , int k){
		if(node == null || k < 0) return;
		if(k == 0)
			System.out.print(node.val + " ");
		
		printKLevelsDown(node.left , k-1);
		printKLevelsDown(node.right , k-1);
	}

}
