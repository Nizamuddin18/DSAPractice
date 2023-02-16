package interview.BinaryTrees.View;

import interview.BinaryTrees.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class RightViewOfBinaryTree {
	static int max_level = -1;

	public static void main(String[] args) {
		RightViewOfBinaryTree tree = new RightViewOfBinaryTree();
		Node root = new Node(50, null, null);
		/* LEFT SUB TREE */
		root.left = new Node(25, null, null);
		root.left.left = new Node(12, null, null);
		root.left.right = new Node(37, null, null);
		root.left.right.left = new Node(30, null, null);
		/* RIGHT SUB TREE */
		root.right = new Node(75, null, null);
		root.right.left = new Node(62, null, null);
		root.right.right = new Node(87, null, null);
		root.right.left.right = new Node(70, null, null);
		System.out.print("Right View of Binary Tree Iterative : ");
		tree.rightViewOfBinaryTreeIterative(root);
		System.out.print("Right View of Binary Tree Recursive : ");
		tree.rightViewOfBinaryTreeRecursive(root, 0);
	}

	private void rightViewOfBinaryTreeRecursive(Node node, int level) {
		if (node == null)
			return;
		if (max_level < level) {
			System.out.print(node.val + " ");
			max_level = level;
		}
		rightViewOfBinaryTreeRecursive(node.right, level + 1);
		rightViewOfBinaryTreeRecursive(node.left, level + 1);
	}

	private void rightViewOfBinaryTreeIterative(Node root) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node rem = queue.remove();
				if (i == size - 1) {
					System.out.print(rem.val + " ");
				}
				if (rem.left != null) {
					queue.add(rem.left);
				}
				if (rem.right != null) {
					queue.add(rem.right);
				}
			}
		}
		System.out.println();
	}

}
