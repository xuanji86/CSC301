/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anjixu.chapter3.section2;

import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author Anji Xu
 */
public class SelectRankCheck {
    private boolean checkRankAndSelect(BST<Integer, String> binarySearchTree){
        int size = binarySearchTree.size();
        for( int i =0; i< size; i++){
            if(i != binarySearchTree.rank(binarySearchTree.select(i))){
                return false;
            }
        }
        for(Integer key : binarySearchTree.keys()){
            if(key.compareTo(binarySearchTree.select(binarySearchTree.rank(key))) != 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        BST<Integer, String> binarySearchTree = new BST<>();
        binarySearchTree.put(10, "Value 10");
        binarySearchTree.put(4, "Value 4");
        binarySearchTree.put(6, "Value 6");
        binarySearchTree.put(1, "Value 1");
        binarySearchTree.put(15, "Value 15");
        binarySearchTree.put(12, "Value 12");
        binarySearchTree.put(20, "Value 20");
        binarySearchTree.put(25, "Value 25");

        SelectRankCheck selectRankCheck = new SelectRankCheck();
        StdOut.println(selectRankCheck.checkRankAndSelect(binarySearchTree) + " Expected: true");
    }    
}
