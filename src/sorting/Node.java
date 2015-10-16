package sorting;

/**
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class Node {
    private String value;
    private Node left, right;

    public Node(String value) {
        this.value = value;
    }

    public void insertOnLeft(String value) {
        this.left = new Node(value);
    }

    public void insertOnRight(String value) {
        this.left = new Node(value);
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

}
