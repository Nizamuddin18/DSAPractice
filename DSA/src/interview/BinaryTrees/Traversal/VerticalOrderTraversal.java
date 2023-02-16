package interview.BinaryTrees.Traversal;

import interview.BinaryTrees.Node;

import java.util.*;

public class VerticalOrderTraversal {
    static class Pair implements Comparable<Pair>{
        Node node;
        int hlevel;

        Pair(Node node , int hlevel){
            this.node = node;
            this.hlevel = hlevel;
        }
        Pair(){}

        @Override
        public int compareTo(Pair o) {
            if(this.hlevel == o.hlevel)
                return this.node.val - o.node.val;
            return 0;
        }
    }

    public static void main(String[] args) {
        // Build tree
//        ConstructBinaryTree tree = new ConstructBinaryTree();
//        Node root = tree.constructBinaryTree();

        Node root = new Node(1, null, null);
        /* LEFT SUB TREE */
        root.left = new Node(2, null, null);
        root.left.left = new Node(4, null, null);
        root.left.right = new Node(5, null, null);
        /* RIGHT SUB TREE */
        root.right = new Node(3, null, null);
        root.right.left = new Node(6, null, null);
        root.right.right = new Node(7, null, null);

        int hlevel = 0;
        int minmax[] = new int[2];
        width(root, hlevel, minmax);
        int width = (minmax[1] - minmax[0]) + 1;
        List<List<Integer>> ans = verticalOrderTraversal(width, minmax, root);
        System.out.println("Vertical order Traversal : " + ans);
    }

    private static List<List<Integer>> verticalOrderTraversal(int width, int[] minmax, Node node) {
        if (node == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            ans.add(new ArrayList<>());
        }
        Queue<Pair> queue = new PriorityQueue<>();
        int minHorizontalLevel = Math.abs(minmax[0]);
        Pair rootpair = new Pair(node, minHorizontalLevel);
        queue.add(rootpair);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair rem = queue.remove();
                ans.get(rem.hlevel).add(rem.node.val);
                if (rem.node.left != null)
                    queue.add(new Pair(rem.node.left, rem.hlevel - 1));
                if (rem.node.right != null)
                    queue.add(new Pair(rem.node.right, rem.hlevel + 1));
            }
        }
        return ans;
    }

    private static List<List<Integer>> verticalOrderTraversal2(int width, int[] minmax, Node node) {
        if (node == null)
            return new ArrayList<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new ArrayDeque<>();
        int minHorizontalLevel = Math.abs(minmax[0]);
        Pair rootpair = new Pair(node, minHorizontalLevel);
        queue.add(rootpair);
        while (!queue.isEmpty()) {
            Pair rem = queue.remove();
            if (map.containsKey(rem.hlevel)) {
                map.get(rem.hlevel).add(rem.node.val);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(rem.node.val);
                map.put(rem.hlevel, temp);
            }
            if (rem.node.left != null)
                queue.add(new Pair(rem.node.left, rem.hlevel - 1));
            if (rem.node.right != null)
                queue.add(new Pair(rem.node.right, rem.hlevel + 1));

        }

        List<List<Integer>> ans = new ArrayList<>();
        for(Map.Entry<Integer , ArrayList<Integer>> entry : map.entrySet()){
            List<Integer> list = new ArrayList<>();
            list.addAll(entry.getValue());
            ans.add(list);
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
