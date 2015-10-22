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
        root = new IntNode();
        Set<Integer> arrayToSet = new HashSet<>();
        for (int number : unsortedArray) {
            arrayToSet.add(number);
        }
        Integer[] noDuplicates = arrayToSet.toArray(new Integer[arrayToSet.size()]);
        Arrays.sort(noDuplicates);
        _binaryTree(noDuplicates, root);
    }

    public void _binaryTree(Integer[] sortedArray, IntNode current) {
        int length = sortedArray.length;
        if (length == 1) {
            current.value = sortedArray[0];
        } else if (length == 2 || length == 3) {
            current.value = sortedArray[1];
            current.left = new IntNode();
            current.left.value = sortedArray[0];
            if (length == 3) {
                current.right = new IntNode();
                current.right.value = sortedArray[2];
            }
        } else {
            current.value = sortedArray[length / 2];
            current.left = new IntNode();
            current.right = new IntNode();
            _binaryTree(Arrays.copyOfRange(sortedArray, 0, length / 2), current.left);
            _binaryTree(Arrays.copyOfRange(sortedArray, length / 2 + 1, length), current.right);
        }
    }

    public String toString() {
        return treeFrom(root);
    }

    private String treeFrom(IntNode node) {
        if (node == null || node.value == null)
            return "empty";
        String nodeValues = node.value.toString();
        if (node.left != null || node.right != null) {
            nodeValues += " --> left: " + treeFrom(node.left) + ", right: " + treeFrom(node.right);
            nodeValues = "(" + nodeValues + ")";
        }
        return nodeValues;
    }

    public static void main(String[] args) {
        int[] unsorted = new int[]{10, 2, 12, 34, 20, 14, 27, 27};
        BinaryTree tree = new BinaryTree(unsorted);
        System.out.println(tree.toString());
    }

}