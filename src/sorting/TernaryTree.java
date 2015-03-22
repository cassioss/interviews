package sorting;

import java.util.Stack;

/**
 * @author Cassio
 * @version 1.0
 */
public class TernaryTree {

    private Node root;

    public TernaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public TernaryTree createTreeFromExpression(String expression) {
        String[] splitBySpace = expression.split(" ");
        Node root = new Node(splitBySpace[0]);
        TernaryTree tree = new TernaryTree(root);

        Node leftReference = root.left;

        Stack<Node> allRightNodes = new Stack<Node>();

        boolean leftTrueRightFalse = false;

        for (int i = 1; i < splitBySpace.length; i++) {

            if (splitBySpace[i].equals("?")) {
                leftTrueRightFalse = true;          // Inserts on a left node
            } else {
                if (splitBySpace[i].equals(":")) {
                    leftTrueRightFalse = false;     // Inserts on a right node
                } else {
                    if (leftTrueRightFalse) {
                        leftReference.left = new Node(splitBySpace[i]);
                        allRightNodes.push(leftReference.right);
                        leftReference = leftReference.left;
                    } else {
                        Node right = allRightNodes.pop();
                        right.value = splitBySpace[i];
                        leftReference = right;
                    }
                }
            }
        }

        return tree;
    }


    public boolean validValue(String value) {
        return !value.isEmpty() && !value.equals("?") && !value.equals(":");
    }


    private class Node {
        private String value;
        private Node left, right;

        public Node(String value) {
            this.value = value;
        }

        public void insertOnLeft(Node leftNode) {
            this.left = leftNode;
        }

        public void insertOnRight(Node rightNode) {
            this.right = rightNode;
        }

    }

}
