package trees;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class BinaryTree {

    private IntNode root;

    public BinaryTree(int[] unsortedArray) {
        root = _binaryTree(order(noDuplicates(unsortedArray)));
    }

    private Integer[] order(Integer[] intArray) {
        Arrays.sort(intArray);
        return intArray;
    }

    private Integer[] noDuplicates(int[] intArray) {
        Set<Integer> arrayToSet = new HashSet<>();
        for (int number : intArray) {
            arrayToSet.add(number);
        }
        return arrayToSet.toArray(new Integer[arrayToSet.size()]);
    }

    public IntNode _binaryTree(Integer[] sortedArray) {
        if (sortedArray == null || sortedArray.length == 0)
            return null;
        int length = sortedArray.length;
        IntNode node = new IntNode();
        node.value = sortedArray[length / 2];
        node.left = _binaryTree(Arrays.copyOfRange(sortedArray, 0, length / 2));
        node.right = _binaryTree(Arrays.copyOfRange(sortedArray, length / 2 + 1, length));
        return node;
    }

    public String binaryTreeSearch(int number) {
        return searchFor(number, root);
    }

    private String searchFor(int number, IntNode currentNode) {
        if (currentNode == null)
            return "null (it is not here)";
        String current = currentNode.value.toString();
        if (number == currentNode.value)
            return current;
        else if (number < currentNode.value)
            return current + " -> " + searchFor(number, currentNode.left);
        else
            return current + " -> " + searchFor(number, currentNode.right);
    }

    public String toString() {
        return treeFrom(root);
    }

    private String treeFrom(IntNode node) {
        if (node == null || node.value == null)
            return "empty";
        String nodeValues = node.value.toString();
        if (node.left != null || node.right != null) {
            nodeValues += " --> " + treeFrom(node.left) + ", " + treeFrom(node.right);
            nodeValues = "(" + nodeValues + ")";
        }
        return nodeValues;
    }

    public static void main(String[] args) {
        int[] unsorted = new int[]{10, 2, 12, 34, 20, 14, 27, 8, 15, 45, 32, 18, 43, 6, 23};
        BinaryTree tree = new BinaryTree(unsorted);
        System.out.println(tree.toString());
        System.out.println(tree.binaryTreeSearch(34));
        System.out.println(tree.binaryTreeSearch(15));
        System.out.println(tree.binaryTreeSearch(21));
    }

}