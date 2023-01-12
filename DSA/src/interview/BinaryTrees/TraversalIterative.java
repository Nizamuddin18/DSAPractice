package interview.BinaryTrees;
import java.util.*;
public class TraversalIterative {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Node root = tree.constructBinaryTree();
		System.out.println("Binary Tree Traversal(Iterative) : ");
		inPrePostOrderTraversalIterative(root);
	}
	
	public static void inPrePostOrderTraversalIterative(Node node) {
		if (node == null) {
			return;
		}
		String inorder = "";
		String preorder = "";
		String postorder = "";
		Pair root_pair = new Pair(node, 0);
		Stack<Pair> stack = new Stack<>();
		stack.push(root_pair);
		while (!stack.isEmpty()) {
			Pair top = stack.peek();
			if (top.state == 0) {
				preorder = preorder + top.node.val + " ";
				top.state++;
				if (top.node.left != null) {
					Pair left = new Pair(top.node.left, 0);
					stack.push(left);
				}
			} else if (top.state == 1) {
				inorder = inorder + top.node.val + " ";
				top.state++;
				if (top.node.right != null) {
					Pair right = new Pair(top.node.right, 0);
					stack.push(right);
				}
			} else {
				postorder = postorder + top.node.val + " ";
				stack.pop();
			}
		}

		System.out.println("Inorder :   " + inorder);
		System.out.println("Preorder :  " + preorder);
		System.out.println("Postorder : " + postorder);
	}
}
