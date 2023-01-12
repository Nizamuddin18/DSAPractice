package interview.BinaryTrees;


public class LargestBST {
	public static class BSTPair{
		boolean isBST;
		int max;
		int min;
		Node root;
		int size;
		BSTPair(){
			this.isBST = true;
			this.max = Integer.MIN_VALUE;
			this.min = Integer.MAX_VALUE;
			this.root = null;
			this.size = 0;
		}
	}
	
	private static Node constructTree() {
		Node root = new Node(50,null,null);
		
		root.left = new Node(25,null,null);
		root.left.left = new Node(12,null,null);
		root.left.right = new Node(37,null,null);
		root.left.right.left = new Node(30,null,null);
		root.left.right.right = new Node(40,null,null);
		
		root.right = new Node(75,null,null);
		root.right.left = new Node(62,null,null);
		root.right.right = new Node(87,null,null);
		root.right.left.left = new Node(60,null,null);
		root.right.left.right = new Node(77,null,null);
		
		return root;
	}
	
	private static BSTPair isBST(Node node) {
		if(node == null){
			BSTPair basepair = new BSTPair();
			 return basepair;
		}
		BSTPair leftpair = isBST(node.left);
		BSTPair rightpair = isBST(node.right);
		BSTPair mypair = new BSTPair();
		mypair.isBST = leftpair.isBST && rightpair.isBST &&
						(node.val >= leftpair.max && node.val <= rightpair.min);
		
		mypair.max = Math.max(node.val, Math.max(leftpair.max, rightpair.max));
		mypair.min = Math.min(node.val, Math.min(leftpair.min , rightpair.min));
		if(mypair.isBST){
			mypair.root = node;
			mypair.size = leftpair.size + rightpair.size + 1;
		}else if(leftpair.size > rightpair.size){
			mypair.root = leftpair.root;
			mypair.size = leftpair.size;
		}else if(leftpair.size < rightpair.size){
			mypair.root = rightpair.root;
			mypair.size = rightpair.size;
		}
		return mypair;
	}
	
	public static void main(String[] args) {
		Node root = constructTree();
		BSTPair bst = isBST(root);
		System.out.println("Largest BST Node (" + bst.root.val + ") of size " + bst.size);
	}

}
