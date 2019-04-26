/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

import java.util.Arrays;

/**
 *
 * @author Anji Xu
 */
public class Sort {

    public static void selectSort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }

    }

    public static void insertSort(int[] a) {
        int N = a.length;
        int j;//已排序列表下标
        int t;//未排序元素
        for (int i = 1; i < N; i++) {
            if (a[i] < a[i-1]) {
                t = a[i];
                for(j = i-1; j>= 0 && a[j] > t; j--){
                    a[j+1] = a[j];
                }
                a[j+1] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 23, 42, 13, 11, 55, 43};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }
}
