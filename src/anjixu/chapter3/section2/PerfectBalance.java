/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anjixu.chapter3.section2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 *
 * @author Anji Xu
 */
public class PerfectBalance {
    private static void perfect(BST bst, int[] a){
        Arrays.sort(a);
        perfect(bst,a,0,a.length-1);
        StdOut.println();      
    }
    private static void perfect(BST bst, int[] a,int lo,int hi){
        if(hi<lo){
            return;
        }
        int mid = lo + (hi - lo)/2;
        bst.put(a[mid],mid);
        StdOut.print(a[mid] + " ");
        perfect(bst,a,lo,mid-1);
        perfect(bst,a,mid+1, hi);
        
    }
    public static void main(String args[]){
        int [] words = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        perfect(bst, words);
    }
}
