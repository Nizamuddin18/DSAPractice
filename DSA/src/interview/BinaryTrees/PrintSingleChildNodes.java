package interview.BinaryTrees;

public class PrintSingleChildNodes {
	public static void printSingleChildNodes(Node node, Node parent){
		if(node == null) return;
		if(parent!= null && parent.left == null && parent.right == node){
			System.out.println(node.val);
		}
		
		if(parent!= null && parent.left == node && parent.right == null){
			System.out.println(node.val);
		}
		
		printSingleChildNodes(node.left , node);
		printSingleChildNodes(node.right, node);
	 }
	
	
	
	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Node root = tree.constructBinaryTree();
		printSingleChildNodes(root , null);
	}
}
