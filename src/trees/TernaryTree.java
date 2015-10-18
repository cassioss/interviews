package trees;

import java.util.Stack;

/**
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class TernaryTree {

    private Node root;

    public TernaryTree(String expression) {
        ternaryTree(expression.replaceAll("\\s+", ""));
    }

    public void ternaryTree(String expression) {
        recursiveTernaryTree(expression);
    }

    public void stackTree(String expression) {
        int firstDelimiter = 0;
        int secondDelimiter;

        root = new Node();
        Node currentNode = root;
        Stack<Node> allRightNodes = new Stack<>();

        for (secondDelimiter = 0; secondDelimiter < expression.length(); secondDelimiter++) {
            char checked = expression.charAt(secondDelimiter);
            if (checked == '?') {
                currentNode.setValue(expression.substring(firstDelimiter, secondDelimiter));
                allRightNodes.push(currentNode.setAndGetRight());
                currentNode = currentNode.setAndGetLeft();
                firstDelimiter = secondDelimiter + 1;
            } else if (checked == ':') {
                currentNode.setValue(expression.substring(firstDelimiter, secondDelimiter));
                currentNode = allRightNodes.pop();
                firstDelimiter = secondDelimiter + 1;
            }
        }

        currentNode.setValue(expression.substring(firstDelimiter, secondDelimiter));

    }

    public void recursiveTernaryTree(String expression) {
        root = new Node();
        _recursiveTernaryTree(expression, 0, root);
    }

    public int _recursiveTernaryTree(String s, int i, Node currentNode) {
        int j = i;
        while (j < s.length() && s.charAt(j) != '?' && s.charAt(j) != ':') j += 1;

        currentNode.setValue(s.substring(i, j));

        if (j == s.length() || s.charAt(j) == ':') {
            return j;
        }

        currentNode.left = new Node();
        j = _recursiveTernaryTree(s, j + 1, currentNode.left);
        currentNode.right = new Node();
        j = _recursiveTernaryTree(s, j + 1, currentNode.right);
        return j;
    }

    public String toString() {
        if (root == null || root.getValue() == null)
            return "null";
        else
            return treeFrom(root);
    }

    private String treeFrom(Node node) {
        String branch = node.getValue();
        if (node.getLeft() != null) {
            branch += " ? " + treeFrom(node.getLeft()) + " : " + treeFrom(node.getRight());
            branch = "(" + branch + ")";
        }
        return branch;
    }

    public static void main(String[] args) {
        TernaryTree tree = new TernaryTree("Sim ? Hein ? Vai : VaiVai ? Sim : NaoNao : Nao");
        System.out.println(tree.toString());
    }

}
