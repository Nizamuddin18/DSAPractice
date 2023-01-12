package interview.BinaryTrees;

public class TransformToLeftClonedTree {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Node root = tree.constructBinaryTree();
		System.out.println("INITIAL TREE : ");
		System.out.println();
		tree.display(root);
		TransformToLeftClonedTree leftClone = new TransformToLeftClonedTree();
		Node newRoot = leftClone.transformToLeftCloned(root);
		System.out.println("=============================");
		System.out.println("LEFT CLONED TREE : ");
		System.out.println();
		tree.display(newRoot);
	}
	
	public Node transformToLeftCloned(Node node){
		if(node == null){
			return null;
		}
		Node leftCloneRoot = transformToLeftCloned(node.left);
		Node rightCloneRoot = transformToLeftCloned(node.right);
		Node newNode = new Node(node.val , leftCloneRoot , null);
		node.left = newNode;
		node.right = rightCloneRoot;
		return node;
	}
}
