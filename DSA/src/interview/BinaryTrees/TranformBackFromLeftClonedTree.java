package interview.BinaryTrees;

public class TranformBackFromLeftClonedTree {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		TransformToLeftClonedTree leftClone = new TransformToLeftClonedTree();
		Node root = tree.constructBinaryTree();
		Node newRoot = leftClone.transformToLeftCloned(root);
		System.out.println("Left Cloned Tree : ");
		tree.display(root);
		System.out.println("Transformed tree");
		newRoot = tranformBackFromLeftClonedTree(newRoot);
		tree.display(newRoot);
	}
	
	public static Node tranformBackFromLeftClonedTree(Node node){
		if(node == null) return null;
		
		Node ltr = tranformBackFromLeftClonedTree(node.left.left);
		Node rtr = tranformBackFromLeftClonedTree(node.right);
		node.left = ltr;
		node.right = rtr;
		return node;
	}

}
