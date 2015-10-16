package sorting;

/**
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class Node {
    private String value;
    private Node left, right, parent;

    public Node(String value, Node parent) {
        this.value = value;
        this.parent = parent;
    }

    public Node(Node parent) {
        this.parent = parent;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Node getLeft() {
        if (left == null)
            left = new Node(this);
        return left;
    }

    public Node getRight() {
        if (right == null)
            right = new Node(this);
        return right;
    }

    public Node getParent() {
        return parent;
    }

}
