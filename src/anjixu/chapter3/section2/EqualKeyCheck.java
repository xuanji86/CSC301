/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anjixu.chapter3.section2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author Anji Xu
 */
public class EqualKeyCheck {

    private boolean duplicateCheck(BST bst) {
        return duplicateCheck(bst.root, null, null);
    }

    private boolean duplicateCheck(BST.Node node, Comparable low, Comparable high) {

        if (node == null) {
            return true;
        }

        if (low != null && low.compareTo(node.key) == 0) {
            return false;
        }
        if (high != null && high.compareTo(node.key) == 0) {
            return false;
        }

        return duplicateCheck(node.left, low, node.key) && duplicateCheck(node.right, node.key, high);
    }

    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        bst.root = bst.new Node(10, "Value 10", 8);
        bst.root.left = bst.new Node(5, "Value 5", 4);
        bst.root.left.left = bst.new Node(2, "Value 2", 1);
        bst.root.left.right = bst.new Node(7, "Value 7", 2);
        bst.root.left.right.right = bst.new Node(9, "Value 9", 1);

        bst.root.right = bst.new Node(14, "Value 14", 3);
        bst.root.right.left = bst.new Node(11, "Value 11", 2);
        bst.root.right.left.left = bst.new Node(10, "Value 10", 1);

        EqualKeyCheck eqCheck = new EqualKeyCheck();
        StdOut.println(eqCheck.duplicateCheck(bst) + " Expected: false");

        BST<Integer, String> bst2 = new BST<>();
        bst2.root = bst.new Node(10, "Value 10", 7);
        bst2.root.left = bst.new Node(5, "Value 5", 4);
        bst2.root.left.left = bst.new Node(2, "Value 2", 1);
        bst2.root.left.right = bst.new Node(7, "Value 7", 2);
        bst2.root.left.right.right = bst.new Node(9, "Value 9", 1);

        bst2.root.right = bst.new Node(14, "Value 14", 2);
        bst2.root.right.left = bst.new Node(11, "Value 11", 1);

        StdOut.println(eqCheck.duplicateCheck(bst2) + " Expected: true");

        StdDraw.clear(StdDraw.WHITE);
        //bst.draw();
        bst2.draw();
    }
}
