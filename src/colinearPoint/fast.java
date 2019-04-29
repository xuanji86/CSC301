/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colinearPoint;

import edu.princeton.cs.algs4.In;
import java.util.Arrays;

/**
 *
 * @author Anji Xu
 */
public class fast {

    public fast(Point[] points) {
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
                if(points[i].compareTo(points[j])==0){
                    throw new IllegalArgumentException();
                }
            }
            clone[i]=points[i];
        }
        Arrays.sort(clone);
        if(num<4){
            return;
        }
        for(int i = 0; i < num-1;i++){
            int tempPointNum = 0;
            Point[] tempPoints = new Point[num-1];
            
            for(int j= 0; j< num; j++){
                if(i != j)
            }
        }
    }

}
