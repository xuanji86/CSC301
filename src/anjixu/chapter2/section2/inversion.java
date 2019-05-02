/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anjixu.chapter2.section2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author xuanji
 */
public class inversion {

    private inversion() {
    }

    private static long merge(int[] a, int[] aux, int lo, int mid, int hi) {
        long inver = 0;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > mid) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
                inver = (mid - i + 1) + inver;
            } else {
                a[k] = aux[i++];
            }
        }
        return inver;
    }

    private static <Key extends Comparable<Key>> long merge(Key[] a, Key[] aux, int lo, int mid, int hi) {
        long inver = 0;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
                inver += (mid - i + 1);
            } else {
                a[k] = aux[i++];
            }
        }
        return inver;
    }

    private static long count(int[] a, int[] b, int[] aux, int lo, int hi) {
        long inver = 0;
        if (hi <= lo) {
            return 0;
        }
        int mid = lo + (hi - lo) / 2;
        inver = count(a, b, aux, lo, mid) + inver;
        inver = count(a, b, aux, mid + 1, hi) + inver;
        inver = merge(b, aux, lo, mid, hi);
        assert inver == brute(a, lo, hi);
        return inver;
    }

    private static <Key extends Comparable<Key>> long count(Key[] a, Key[] b, Key[] aux, int lo, int hi) {
        long inver = 0;
        if (hi <= lo) {
            return 0;
        }
        int mid = lo + (hi - lo) / 2;
        inver = count(a, b, aux, lo, mid) + inver;
        inver = count(a, b, aux, mid + 1, hi) + inver;
        inver = merge(b, aux, lo, mid, hi) + inver;
        assert inver == brute(a, lo, hi);
        return inver;
    }

    public static long count(int[] a) {
        int[] b = new int[a.length];
        int[] aux = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        long inver = count(a, b, aux, 0, a.length - 1);
        return inver;
    }

    public static <Key extends Comparable<Key>> long count(Key[] a) {
        Key[] b = a.clone();
        Key[] aux = a.clone();
        long inver = count(a, b, aux, 0, a.length - 1);
        return inver;
    }

    private static <Key extends Comparable<Key>> boolean less(Key v, Key w) {
        return (v.compareTo(w) < 0);
    }

    private static <Key extends Comparable<Key>> long brute(Key[] a, int lo, int hi) {
        long inver = 0;
        for (int i = lo; i <= hi; i++) {
            for (int j = i + 1; j <= hi; j++) {
                if (less(a[j], a[i])) {
                    inver++;
                }
            }
        }
        return inver;
    }

    private static long brute(int[] a, int lo, int hi) {
        long inver = 0;
        for (int i = lo; i <= hi; i++) {
            for (int j = i + 1; j <= hi; j++) {
                if (a[j] < a[i]) {
                    inver++;
                }
            }
        }
        return inver;
    }

    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        int n = a.length;
        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        StdOut.println(inversion.count(a));
        StdOut.println(inversion.count(b));
    }
}
