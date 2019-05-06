/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anjixu.chapter3.section2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author Anji Xu
 */
public class LevelOrderTraversal {
    private void printLevel(BST.Node node){
        Queue<BST.Node> queue = new Queue<>();
        queue.enqueue(node);
        
        while(!queue.isEmpty()){
            BST.Node current = queue.dequeue();
            StdOut.print(current.key + " ");
            if(current.left != null){
                queue.enqueue(current.left);
            }
            if(current.right != null){
                queue.enqueue(current.right);
            }
        }
    }
    public static void main(String[] args){
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        BST<Integer, String> binarySearchTree = new BST<>();
        binarySearchTree.put(10, "Value 10");
        binarySearchTree.put(4, "Value 4");
        binarySearchTree.put(6, "Value 6");
        binarySearchTree.put(1, "Value 1");
        binarySearchTree.put(2, "Value 2");
        binarySearchTree.put(15, "Value 15");
        binarySearchTree.put(12, "Value 12");
        binarySearchTree.put(20, "Value 20");
        binarySearchTree.put(25, "Value 25");
        binarySearchTree.put(30, "Value 30");
        
        StdDraw.clear(StdDraw.WHITE);
        binarySearchTree.draw();

        levelOrderTraversal.printLevel(binarySearchTree.root);
        StdOut.println("\nExpected: 10 4 15 1 6 12 20 2 25");
    }
}
