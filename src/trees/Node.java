package trees;

/**
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class Node {
    private String value;
    public Node left, right;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Node setAndGetLeft() {
        left = new Node();
        return left;
    }

    public Node setAndGetRight() {
        right = new Node();
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

}
