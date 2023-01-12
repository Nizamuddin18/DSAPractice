package interview.BinarySearchTree;

import java.util.Stack;

public class Construct {

	public Node constructBST(){
		int arr[] = {50 ,25 ,12 ,-1 ,-1 ,37, 30 , -1, -1, -1 , 75, 62, -1, 70, -1, -1, 87, -1, -1};
		Node root = constructBST(arr);
		return root;
	}
	
	public static class Pair {
	    Node node;
	    int state;

	    Pair(Node node, int state) {
	      this.node = node;
	      this.state = state;
	    }
	  }
	
	private Node constructBST(int[] arr) {
		Node root = new Node(arr[0], null, null);
	    Pair rtp = new Pair(root, 1);

	    Stack<Pair> st = new Stack<>();
	    st.push(rtp);

	    int idx = 0;
	    while (st.size() > 0) {
	      Pair top = st.peek();
	      if (top.state == 1) {
	        idx++;
	        if (arr[idx] != -1) {
	          top.node.left = new Node(arr[idx], null, null);
	          Pair lp = new Pair(top.node.left, 1);
	          st.push(lp);
	        } else {
	          top.node.left = null;
	        }

	        top.state++;
	      } else if (top.state == 2) {
	        idx++;
	        if (arr[idx] != -1) {
	          top.node.right = new Node(arr[idx], null, null);
	          Pair rp = new Pair(top.node.right, 1);
	          st.push(rp);
	        } else {
	          top.node.right = null;
	        }

	        top.state++;
	      } else {
	        st.pop();
	      }
	    }

	    return root;
	}
	
	public void display(Node node) {
		if (node == null) return;
		String str = "";
		str += node.left == null ? "." : node.left.data + "";
		str += " <- " + node.data + " -> ";
		str += node.right == null ? "." : node.right.data + "";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public static void main(String args[]){
		Construct bst = new Construct();
		Node root = bst.constructBST();
		bst.display(root);
	}

}
