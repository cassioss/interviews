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

    public void insertOnLeft(String value) {
        this.left = new Node(value, this);
    }

    public void insertOnRight(String value) {
        this.left = new Node(value, this);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Node getParent() {
        return parent;
    }

}
