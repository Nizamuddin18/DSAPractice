package interview.BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Node root = tree.constructBinaryTree();
		System.out.println(" ::::: Level Order Traversal of Tree ::::: " );
		//levelOrder(root);
		List<List<Integer>> list = levelOrder2(root);
		
		System.out.println(list);
	}
	
	public static void levelOrder(Node node){
		Queue<Node> q = new ArrayDeque<Node>();
		q.add(node);
		while(!q.isEmpty()){
			int size = q.size();
			for(int i = 0 ; i < size ; i++){
				Node rem = q.remove();	
				System.out.print(rem.val + " ");
				if(rem.left!=null){
					q.add(rem.left);
				}
				if(rem.right!=null){
					q.add(rem.right);
				}
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> levelOrder2(Node root) {
        if(root == null) return new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
            	Node rem = queue.remove();
                list.add(rem.val);  
                if(rem.left != null){
                    queue.add(rem.left);
                }
                if(rem.right != null){
                    queue.add(rem.right);
                }
            }
            res.add(list);
        }
        Collections.reverse(res);
        return res;
    }

}
