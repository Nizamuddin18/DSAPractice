package interview.BinaryTrees.View;

import interview.BinaryTrees.ConstructBinaryTree;
import interview.BinaryTrees.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TopViewOfBinaryTree {

    static class Pair {
        Node node;
        int hlevel;

        Pair(Node node, int hlevel) {
            this.node = node;
            this.hlevel = hlevel;
        }

        Pair() {
        }
    }

    public static void main(String[] args) {
        ConstructBinaryTree tree = new ConstructBinaryTree();
        Node root = tree.constructBinaryTree();
        ArrayList<Integer> ans = topView(root);
        System.out.println(ans);
    }

    private static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        int[] minMax = new int[2];
        width(root, 0, minMax);
        int len = (minMax[1] - minMax[0] + 1);
        for (int i = 0; i < len; i++)
            ans.add(null);
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, Math.abs(minMax[0])));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair rem = queue.remove();
                Node remnode = rem.node;
                int remlevel = rem.hlevel;
                if (ans.get(remlevel) == null)
                    ans.set(remlevel, remnode.val);
                if (remnode.left != null)
                    queue.add(new Pair(remnode.left, remlevel - 1));
                if (remnode.right != null)
                    queue.add(new Pair(remnode.right, remlevel + 1));
            }
        }
        return ans;
    }

    private static void width(Node node, int hlevel, int[] minmax) {
        if (node == null) return;
        minmax[0] = Math.min(minmax[0], hlevel);
        minmax[1] = Math.max(minmax[1], hlevel);
        width(node.left, hlevel - 1, minmax);
        width(node.right, hlevel + 1, minmax);
    }

}
