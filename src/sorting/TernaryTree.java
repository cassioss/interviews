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
        ternaryTree(expression.replaceAll("\\s+", ""));
    }

    public Node getRoot() {
        return root;
    }

    public void ternaryTree(String expression) {

        int firstDelimiter = 0;
        int secondDelimiter;

        root = new Node(null);          // No parent for the root
        Node currentNode = root;
        Stack<Node> allRightNodes = new Stack<>();

        for (secondDelimiter = 0; secondDelimiter < expression.length(); secondDelimiter++) {
            char checked = expression.charAt(secondDelimiter);
            if (checked == '?') {
                currentNode.setValue(expression.substring(firstDelimiter, secondDelimiter));
                allRightNodes.push(currentNode.getRight());
                currentNode = currentNode.getLeft();
                firstDelimiter = secondDelimiter + 1;
            } else if (checked == ':') {
                currentNode.setValue(expression.substring(firstDelimiter, secondDelimiter));
                currentNode = allRightNodes.pop();
                firstDelimiter = secondDelimiter + 1;
            }
        }

        currentNode.setValue(expression.substring(firstDelimiter, secondDelimiter));
    }

    public String toString() {
        if (root == null)
            return "null";
        String ternaryExpression = "";
        Node currentNode = root;
        ternaryExpression += currentNode.getValue();
        ternaryExpression += " ? (";
        currentNode = currentNode.getLeft();
        ternaryExpression += currentNode.getValue();
        ternaryExpression += " : ";
        currentNode = currentNode.getParent().getRight();
        ternaryExpression += currentNode.getValue();
        ternaryExpression += ")";
        return ternaryExpression;
    }

    public static void main(String[] args) {
        TernaryTree tree = new TernaryTree("Sim ? Hein : Nao");
        System.out.println(tree.toString());
    }

}
