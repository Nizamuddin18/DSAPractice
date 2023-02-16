package interview.BinaryTrees.Traversal;

import interview.BinaryTrees.ConstructBinaryTree;
import interview.BinaryTrees.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ReverseDiagonalTraversal {
    public static void main(String[] args) {
        ConstructBinaryTree tree = new ConstructBinaryTree();
        Node root = tree.constructBinaryTree();
        List<List<Integer>> ans = reversedDiagonalOrderTravresal(root);
        System.out.println(ans);
    }

    private static List<List<Integer>> reversedDiagonalOrderTravresal(Node root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                Node factor = queue.remove();
                List<Integer> list = new ArrayList<>();
                while (factor != null){
                    list.add(factor.val);
                    if(factor.right != null)
                        queue.add(factor.right);
                    factor = factor.left;
                }
                ans.add(list);
            }
        }
        return ans;
    }
}
