package anjixu.chapter3.section2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author Anji Xu
 */
public class certification {

    private boolean isBST(BST.Node root) {
        return isBST(root, null, null);
    }

    private boolean isBST(BST.Node node, Comparable low, Comparable high) {
        if (node == null) {
            return true;
        }
        if (low != null && low.compareTo(node.key) >= 0) {
            return true;
        }
        if (high != null && high.compareTo(node.key) <= 0) {
            return false;
        }
        return isBST(node.left, low, node.key) && isBST(node.right, node.key, high);
    }

    public static void main(String[] args) {
        certification certification = new certification();
        BST bst = new BST();
        bst.root = bst.new Node(10, "Value 10", 7);
        bst.root.left = bst.new Node(5, "Value 5", 4);
        bst.root.left.left = bst.new Node(2, "Value 2", 1);
        bst.root.left.right = bst.new Node(7, "Value 7", 2);
        bst.root.left.right.right = bst.new Node(9, "Value 9", 1);

        bst.root.right = bst.new Node(14, "Value 14", 2);
        bst.root.right.left = bst.new Node(11, "Value 11", 1);

        StdOut.println(certification.isBST(bst.root) + " Expected: true");

        BST bst2 = new BST();
        bst2.root = bst.new Node(20, "Value 1", 7);
        bst2.root.left = bst.new Node(5, "Value 5", 4);
        bst2.root.left.left = bst.new Node(2, "Value 2", 1);
        bst2.root.left.right = bst.new Node(1, "Value 1", 2); //Not a BST
        bst2.root.left.right.right = bst.new Node(9, "Value 9", 1);

        bst2.root.right = bst.new Node(24, "Value 24", 2);
        bst2.root.right.left = bst.new Node(21, "Value 21", 1);

        StdOut.println(certification.isBST(bst2.root) + " Expected: false");
        StdDraw.clear(StdDraw.WHITE);
        //bst.draw();
        bst2.draw();
    }
}
