/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 *
 * @author Anji Xu
 */
public class BruteCollinearPoints {
    public BruteCollinearPoints(Point[] points){
        if(points == null){
            throw new NullPointerException();
        }
        int num = points.length;
        Arrays.sort(points);
        for(int i = 0;i < num; i++){
            for(int j = i+1; j<num;j++){
                for(int k = j+1; k<num;k++){
                    for(int l = k+1; l< num; l++){
                        Point p = points[i];
                        Point q = points[j];
                        Point r = points[k];
                        Point s = points[l];
                        if(p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(q) == p.slopeTo(s)){
                            StdOut.println(p+" -> "+ q + "->" + r + "->" + s);
                            p.drawTo(s);
                        }
                    }
                }
            }
        }

    }
    
    
    


    public static void main(String[] args) {

           
    }

    
}
 