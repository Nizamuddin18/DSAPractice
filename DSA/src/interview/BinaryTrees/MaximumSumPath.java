package interview.BinaryTrees;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
class PairPath implements Comparable <PairPath>{
	Node node;
	String psf;
	int val;
	public PairPath(Node node , String psf , int val){
		this.node = node;
		this.psf = psf; 
		this.val = val;
	}
	@Override
	public int compareTo(PairPath o) {
		if(this.val > o.val)
			return 1;
		else if(this.val < o.val)
			return -1;
		else
			return 0;
	}	
}
public class MaximumSumPath {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Node root = new Node(10,null,null);
		root.left = new Node(2,null,null);
		root.right = new Node(9,null,null);
		root.left.left = new Node(20,null,null);
		root.left.right = new Node(1,null,null);
		root.right.right = new Node(-25,null,null);
		root.right.right.left = new Node(3,null,null);
		root.right.right.right = new Node(4,null,null); 
		//tree.display(root);
		getMaxPath(root,"");
	}
	
	public static void getMaxPath(Node node , String psf){
		if(node == null)
			return;
		PriorityQueue<PairPath> q = new PriorityQueue<>(Collections.reverseOrder());
		//Queue<PairPath> q = new ArrayDeque<PairPath>();
		PairPath root_pair= new PairPath(node , psf + node.val , node.val);
		q.add(root_pair);
		while(!q.isEmpty()){
			PairPath rem = q.remove();
			System.out.println("[ Node " + rem.node.val + " travelled via " + rem.psf + " with weight " + rem.val +" ]");
			if(rem.node.left!=null){
				PairPath left = new PairPath(rem.node.left , rem.psf + "-"+rem.node.left.val, rem.val + rem.node.left.val);
				q.add(left);
			}
			if(rem.node.right!=null){
				PairPath right = new PairPath(rem.node.right , rem.psf + "-"+rem.node.right.val, rem.val + rem.node.right.val);
				q.add(right);
			}
		}
		
	}
}