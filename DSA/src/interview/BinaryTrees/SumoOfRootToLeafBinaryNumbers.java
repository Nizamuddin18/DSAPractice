package interview.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class SumoOfRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        Node root = new Node(1, null, null);
        root.left = new Node(0, null, null);
        root.left.left = new Node(0, null, null);
        root.left.right = new Node(1, null, null);
        root.right = new Node(1, null, null);
        root.right.left = new Node(0, null, null);
        root.right.right = new Node(1, null, null);
        System.out.println(sumRootToLeaf(root));
    }

    public static int sumRootToLeaf(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs(root, list, res);
        return calculate(list);
    }

    private static int calculate(List<List<Integer>> list) {
        double sum = 0;
        for (List<Integer> paths : list) {
            int size = paths.size();
            double pathSum = 0;
            for (int i = 0; i < size; i++) {
                int power = (int) Math.pow(2, size - 1 - i);
                power *= paths.get(i);
                pathSum += power;
            }
            sum += pathSum;
        }
        return (int) sum;
    }

    private static void dfs(Node node, List<List<Integer>> ans, List<Integer> res) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            List<Integer> base = new ArrayList<>();
            base.addAll(res);
            base.add(node.val);
            ans.add(base);
        }
        res.add(node.val);
        dfs(node.left, ans, res);
        dfs(node.right, ans, res);
        res.remove(res.size() - 1);
    }
}
