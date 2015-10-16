package sorting;

import java.util.Stack;

/**
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class TernaryTree {

    private Node root;

    public TernaryTree(Node root) {
        this.root = root;
    }

    public TernaryTree(String expression) {
        createTreeFrom(expression);
    }

    public Node getRoot() {
        return root;
    }

    public TernaryTree createTreeFrom(String expression) {

        String[] splitBySpace = expression.split("\\s+");
        Node root = new Node(splitBySpace[0]);

        Node leftReference = root.getLeft();

        Stack<Node> allRightNodes = new Stack<>();

        boolean leftTrueRightFalse = false;

        for (int i = 1; i < splitBySpace.length; i++) {

            if (splitBySpace[i].equals("?")) {
                leftTrueRightFalse = true;          // Inserts on a left node
            } else {
                if (splitBySpace[i].equals(":")) {
                    leftTrueRightFalse = false;     // Inserts on a right node
                } else {
                    if (leftTrueRightFalse) {
                        leftReference.insertOnLeft(splitBySpace[i]);
                        allRightNodes.push(leftReference.getRight());
                        leftReference = leftReference.getLeft();
                    } else {
                        Node right = allRightNodes.pop();
                        right.setValue(splitBySpace[i]);
                        leftReference = right;
                    }
                }
            }
        }

        return new TernaryTree(root);
    }

    public static void main(String[] args) {

    }

}
