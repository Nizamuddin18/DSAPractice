package interview.BinaryTrees;

public class WidthOfShadow {

    static class Pair{
        int min;
        int max;

        Pair(){
            this.min = Integer.MAX_VALUE;
            this.max =  Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) {
        // Build tree
        ConstructBinaryTree tree = new ConstructBinaryTree();
        Node root = tree.constructBinaryTree();
        System.out.println("Width of Shadow using Pair : " + widthUsingPairClass(root));
        System.out.println("Width of Shadow using Array : " + widthUsingArray(root));
    }

    private static int widthUsingPairClass(Node root) {
        if (root == null) return 0;
        int hlevel = 0; // horizontal level of root
        Pair pair = width(root, hlevel);
        int width = (pair.max - pair.min) + 1;
        return width;
    }

    private static int widthUsingArray(Node root) {
        if (root == null) return 0;
        int hlevel = 0;
        int minmax[] = new int[2];
        width(root, hlevel, minmax);
        int width = (minmax[1] - minmax[0]) + 1;
        return width;
    }

    private static void width(Node node, int hlevel, int[] minmax) {
        if (node == null) return;
        minmax[0] = Math.min(minmax[0], hlevel);
        minmax[1] = Math.max(minmax[1], hlevel);
        width(node.left, hlevel - 1, minmax);
        width(node.right, hlevel + 1, minmax);
    }

    private static Pair width(Node node, int hlevel) {
        if (node == null) return new Pair();
        Pair leftPair = width(node.left, hlevel - 1);
        Pair rightPair = width(node.right, hlevel + 1);
        Pair myPair = new Pair();
        myPair.min = Math.min(leftPair.min, hlevel);
        myPair.max = Math.max(rightPair.max, hlevel);
        return myPair;
    }

}
