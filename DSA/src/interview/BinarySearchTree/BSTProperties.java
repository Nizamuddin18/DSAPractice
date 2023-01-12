package interview.BinarySearchTree;

public class BSTProperties {
	public static int size(Node node){
		if(node == null) return 0;
		int lsize = size(node.left);
		int rsize = size(node.right);
		int size = lsize + rsize + 1;
		return size;
	}
	
	public static int min(Node node){
		int min = Integer.MAX_VALUE;
		if(node.left!=null){
			min =  min(node.left);
		}else if(node.left == null){
			min = node.data;
		}
		return min;
	}
	
	public static boolean find(Node node , int target){
		if(node == null) return false;
		if(target < node.data){
			return find(node.left , target);
		}else if(target > node.data){
			return find(node.right , target);
		}else{
			return true;
		}
	}
	
	public static void main(String[] args) {
		Construct bst = new Construct();
		Node root = bst.constructBST();
		int size = size(root);
		int min = min(root);
		boolean flag = find(root , 62);
		System.out.println("Size of BST : " +size);
		System.out.println("Min in BST : " + min);
		System.out.println("Does Node exist in BST ? : " + flag);
	}

}
