/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anjixu.chapter2.section2;

/**
 *
 * @author xuanji
 */
public class inversion {
    
    private inversion(){}

    private static long merge(int[] a, int[] aux, int lo, int mid, int hi) {
        long inver= 0;
        
        for (int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }
        int i = lo;
        int j = mid+1;
        for(int k = lo; k<= hi; k++){
            if(i>mid){
                a[k] = aux[j++];
            }
            else if(j>mid){
                a[k] = aux[i++];
            }
            else if(aux[j]< aux[i]){
                a[k] = aux[j++];
                inver = (mid-i+1)+inver;
            }
            else{
                a[k] = aux[i++];
            }
        }
        return inver;
    }
    
    private static long count(int[] a, int[] b, int[] aux, int lo, int hi) {
        long inver = 0;
        if(hi<=lo){
            return 0;
        }
        int mid = lo + (hi-lo)/2;
        inver = count(a,b,aux,lo,mid) + inver;
        inver = count(a,b,aux,mid+1,hi) + inver;
        inver = merge(b,aux,lo,mid,hi);
        assert inver == brute(a,lo,hi);
        return inver;
    }
    
}
