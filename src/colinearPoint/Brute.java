/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colinearPoint;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 *
 * @author Anji Xu
 */
public class Brute {
    public Brute(Point[] points){
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
                        if(p.slopeTo(q) == q.slopeTo(r) && q.slopeTo(r) == r.slopeTo(s)){
                            StdOut.println(p+" -> "+ q + "->" + r + "->" + s);
                            p.drawTo(s);
                        }
                    }
                }
            }
        }
        StdDraw.show(0);
    }
    
    
    


    public static void main(String[] args) {

            In in = new In(args[0]); 
            int n = in.readInt();
            StdOut.println("total "+n+" points");
            Point[] points = new Point[n];
            for (int i = 0; i < n; i++) {
                int x = in.readInt();
                int y = in.readInt();
                StdOut.println("("+x+","+y+")"); 
                points[i] = new Point(x,y);
            }       

            StdDraw.setXscale(0, 32768);
            StdDraw.setYscale(0, 32768);
            for(Point p:points){
                p.draw();
            }
            StdDraw.show();
       
    }

    
}
 