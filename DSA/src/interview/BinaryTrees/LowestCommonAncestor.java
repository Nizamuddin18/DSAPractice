package interview.BinaryTrees;

import java.util.ArrayList;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		Node root = new Node(50,null,null);
		root.left = new Node(25,null,null);
		root.left.left = new Node(12,null,null);
		root.left.right = new Node(37,null,null);
		root.left.right.left = new Node(30,null,null);
		root.right = new Node(75,null,null);
		root.right.left = new Node(62,null,null);
		root.right.right = new Node(87,null,null);
		root.right.left.right = new Node(70,null,null);
		ArrayList<Node> path1 = new ArrayList<>();
		ArrayList<Node> path2 = new ArrayList<>();
		nodeToRootPath(root , 70 , path1);
		nodeToRootPath(root , 87 , path2);
		Node lca = lowestCommonAncestor(path1, path2);
		System.out.println("Lowest Common Ancestor : " + lca);
	}
	private static Node lowestCommonAncestor(ArrayList<Node> path1 , ArrayList<Node> path2){
		int index1 = path1.size() - 1;
		int index2 = path2.size() - 1;
		boolean flag = false;
		while(flag == false){
			if(path1.get(index1).val == path2.get(index2).val){
				index1--;
				index2--;
			}else{
				flag = true;
			}
		}
		Node temp = path1.get(index1+1);
		return temp;
	}
	private static boolean nodeToRootPath(Node node , int value , ArrayList<Node> path){
		if(node == null)
			return false;
		if(node.val == value){
			path.add(node);
			return true;
		}
		if(nodeToRootPath(node.left , value , path)){
			path.add(node);
			return true;
		}
		if(nodeToRootPath(node.right , value , path)){
			path.add(node);
			return true;
		}
		return false;
	}

}
