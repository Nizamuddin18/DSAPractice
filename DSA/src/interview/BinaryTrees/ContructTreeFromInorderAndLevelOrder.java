package interview.BinaryTrees;

import java.util.ArrayList;
import java.util.HashSet;

public class ContructTreeFromInorderAndLevelOrder {
	public static Node buildTree(int[] lvl, int[] inorder) {
		ArrayList<Integer> level = new ArrayList<>();
		for (int val : lvl) {
			level.add(val);
		}
		return constructBinaryTree(level, inorder, 0, level.size() - 1);
	}

	public static Node constructBinaryTree(ArrayList<Integer> level, int[] inorder, int stIndex, int endIndex) {
		if (level.size() == 0)
			return null;
		Node root = new Node(level.get(0));
		int index = stIndex;
		HashSet<Integer> set = new HashSet<>();
		while (inorder[index] != level.get(0)) {
			set.add(inorder[index]);
			index++;
		}

		ArrayList<Integer> lst = new ArrayList<>();
		ArrayList<Integer> rst = new ArrayList<>();

		for (int i = 1; i < level.size(); i++) {
			int val = level.get(i);
			if (set.contains(val)) {
				lst.add(val);
			} else {
				rst.add(val);
			}
		}
		
		root.left = constructBinaryTree(lst , inorder , stIndex , index - 1);
		root.right = constructBinaryTree(rst , inorder , index + 1 , level.size() - 1);
		return root;
	}
	
	public static void display(Node node) {
		if (node == null) return;
		String str = "";
		str += node.left == null ? "." : node.left.val + "";
		str += " <- " + node.val + " -> ";
		str += node.right == null ? "." : node.right.val + "";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	
	public static void main(String[] args) {
		int inorder[] = {12,25,30,37,50,62,70,75,87};
		int levelorder[] = {50,25,75,12,37,62,87,30,70};
		Node root = buildTree(inorder , levelorder);
		display(root);
	}

}
