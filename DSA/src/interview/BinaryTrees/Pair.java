package interview.BinaryTrees;

public class Pair {
    public Node node;
    public int state;

    public Pair(Node node, int state) {
        this.node = node;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Pair [node=" + node + ", state=" + state + "]";
    }
}