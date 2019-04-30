/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labTest1;

import java.util.Arrays;

/**
 *
 * @author Anji Xu
 */
public class BinarySearch {

    public static int[] binarySearch2D(int[][] data, int key, int low, int high) {
        //Arrays.sort(data);
        int length = data[0].length;
        int middleX = 0;
        while (high >= low) {
            middleX = (low + high) / 2;
            if (data[middleX][0] <= key && data[middleX][length-1]>=key) {
                break;
            } else if (data[middleX][0] < key && data[middleX][length-1]<key) {
                low = middleX + 1;
            } else if (data[middleX][0] > key) {
                high = middleX - 1;
            }
            
        }
        int lowY = 0;
        int highY = data[middleX].length;
        int middleY = 0;
        while (highY > lowY) {
            middleY = (lowY + highY) / 2;
            if (data[middleX][middleY] == key) {
                break;
            } else if (data[middleX][middleY] < key) {
                lowY = middleY + 1;
            } else if (data[middleX][middleY] > key) {
                highY = middleY + 1;
            }
            
        }
        
        return new int[]{middleX,middleY};

    }

    public static void main(String[] args) {
        int[][] data = {{1, 2, 3, 4, 5}, {11, 12, 13, 14, 15}, {21, 22, 23, 24, 25}, {31, 32, 33, 34, 35}, {41, 42, 43, 44, 45}};
        int[] index = binarySearch2D(data, 43, 0, data.length - 1);
        System.out.println(index[0] + " " + index[1]);

    }
}
