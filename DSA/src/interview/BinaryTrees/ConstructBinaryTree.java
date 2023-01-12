package interview.BinaryTrees;
import java.util.*;

public class ConstructBinaryTree {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Node root = tree.constructBinaryTree();
		tree.display(root);
	}
	
	public Node constructBinaryTree(){
		Integer arr[] = {50 ,25 ,12 ,null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
		Node root = construct(arr);
		return root;
	}
	
	public Node construct(Integer[] arr) {
		Stack<Pair> st = new Stack<>();
		int root_val = arr[0];
		Node root = new Node(root_val);
		Pair root_pair = new Pair(root, 0);
		st.push(root_pair);
		int idx = 0;
		while (!st.isEmpty()) {
			Pair top = st.peek();
			if (top.state == 0) {
				idx++;
				if (arr[idx] != null) {
					Node newLeft = new Node(arr[idx]);
					top.node.left = newLeft;
					Pair leftPair = new Pair(newLeft, 0);
					st.push(leftPair);
				}
				top.state++;
			} else if (top.state == 1) {
				idx++;
				if (arr[idx] != null) {
					Node newRight = new Node(arr[idx]);
					top.node.right = newRight;
					Pair rightPair = new Pair(newRight, 0);
					st.push(rightPair);
				}
				top.state++;
			} else {
				st.pop();
			}
		}
		return root;
	}
	
	public void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";
		str += node.left == null ? "." : node.left.val + "";
		str += " <- " + node.val + " -> ";
		str += node.right == null ? "." : node.right.val + "";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	  
	public Node getTreeRoot() {
		Node root = new Node(50, null, null);
		// Left Sub Tree
		root.left = new Node(25, null, null);
		root.left.left = new Node(12, null, null);
		root.left.right = new Node(37, null, null);
		root.left.right.left = new Node(30, null, null);

		// Right Sub Tree
		root.right = new Node(75, null, null);
		root.right.left = new Node(62, null, null);
		root.right.right = new Node(87, null, null);
		root.right.left.left = new Node(60, null, null);
		root.right.left.right = new Node(65, null, null);
		root.right.left.right.right = new Node(70, null, null);

		return root;
	}
}
