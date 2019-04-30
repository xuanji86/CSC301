/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import org.w3c.dom.Node;

/**
 *
 * @author Anji Xu
 */
public class BruteCollinearPoints {
    private int lineNumber;
    private Node last;
    public BruteCollinearPoints(Point[] points){
        if(points == null){
            throw new NullPointerException();
        }
        lineNumber = 0;
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

                            lineNumber++;
                        }
                    }
                }
            }
        }

    }
    public int numberOfSegments(){
        return lineNumber;
    }
    public LineSegment[] segments(){
        LineSegment[] lines = new LineSegment[lineNumber];
        
    }
    


    public static void main(String[] args) {

           
    }

    
}
 