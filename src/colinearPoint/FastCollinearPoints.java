/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import edu.princeton.cs.algs4.In;
import java.util.Arrays;

/**
 *
 * @author Anji Xu
 */
public class FastCollinearPoints {

    public FastCollinearPoints(Point[] points) {
        if (points == null) {
            throw new NullPointerException();
        }
        int num = points.length;
        Point[] clone = new Point[num];
        for (int i = 0; i < num; i++) {
            if (points[i] == null) {
                throw new NullPointerException();
            }
            for (int j = i + 1; j < num; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException();
                }
            }
            clone[i] = points[i];
        }
        Arrays.sort(clone);
        if (num < 4) {
            return;
        }
        for (int i = 0; i < num - 1; i++) {
            int tempPointsNum = 0;
            Point[] tempPoints = new Point[num - 1];

            for (int j = 0; j < num; j++) {
                if (i != j) {
                    tempPoints[tempPointsNum++] = clone[j];
                }
            }
            Arrays.sort(tempPoints, clone[i].slopeOrder());

            Point min = null;
            Point max = null;
            for (int j = 0; j < tempPointsNum - 1; j++) {
                if (clone[i].slopeTo(tempPoints[j]) == clone[i].slopeTo(tempPoints[j + 1])) {
                    if (min == null) {
                        if (clone[i].compareTo(tempPoints[j]) > 0) {
                            max = clone[i];
                            min = tempPoints[j];
                        } else {
                            max = tempPoints[j];
                            min = clone[i];
                        }
                    }
                    if (min.compareTo(tempPoints[j + 1]) > 0) {
                        min = tempPoints[j + 1];
                    }
                    if (max.compareTo(tempPoints[j + 1]) < 0) {
                        max = tempPoints[j + 1];
                    }


                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
