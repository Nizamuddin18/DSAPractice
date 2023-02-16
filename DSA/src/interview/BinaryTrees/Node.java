/**
 *
 */
package interview.BinaryTrees;

public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Node(int data) {
        this.val = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "" + val;
    }

}
