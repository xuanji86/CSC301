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
    public fast(Point[] points){
        if(points == null){
            throw new NullPointerException();
        }
        int num = points.length;
        Arrays.sort(points);
    }
    
    
    
}
