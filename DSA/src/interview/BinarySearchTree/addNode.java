package interview.BinarySearchTree;

public class addNode {
	public static Node add(Node node, int data) {
		if(node == null){
			Node newNode = new Node(data , null , null);
			return newNode;
		}
		
		if(node.data < data)
			node.right = add(node.right , data);
		else if(node.data > data)
			node.left = add(node.left , data);
		
		return node;
	}
	
	public static void main(String[] args) {
		Construct bst = new Construct();
		Node root = bst.constructBST();
		System.out.println("Before new Node addition : ");
		bst.display(root);
		add(root , 55);
		System.out.println("After new Node addition : ");
		bst.display(root);
	}

}
