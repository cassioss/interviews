package trees;

/**
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class BinaryTree {

    private IntNode root;

    public BinaryTree(int[] unsortedArray) {
        root = new IntNode();
        _binaryTree(unsortedArray, 0, root);
    }

    public void _binaryTree(int[] unsortedArray, int it, IntNode current) {
        if (it == unsortedArray.length) return;
        if (current.value == null) {
            current.value = unsortedArray[it];
            _binaryTree(unsortedArray, it + 1, current);
        } else {
            if (unsortedArray[it] < current.value) {
                if (current.left == null) {
                    current.left = new IntNode();
                    current.left.value = unsortedArray[it];
                    _binaryTree(unsortedArray, it + 1, current);
                } else {
                    _binaryTree(unsortedArray, it + 1, current.left);
                }
            } else {
                if (current.right == null) {
                    current.right = new IntNode();
                    current.right.value = unsortedArray[it];
                    _binaryTree(unsortedArray, it + 1, current);
                } else {
                    _binaryTree(unsortedArray, it, current.right);
                }
            }
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
        int[] unsorted = new int[]{10, 2, 12, 34, 20};
        BinaryTree tree = new BinaryTree(unsorted);
        System.out.println(tree.toString());
    }

}