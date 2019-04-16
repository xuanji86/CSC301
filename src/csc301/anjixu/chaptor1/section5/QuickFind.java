/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc301.anjixu.chaptor1.section5;

/**
 *
 * @author xuanji
 */
public class QuickFind {

    int[] id;

    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < this.id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }
    public  boolean find(int p,int q){
        return id[p] == id[q];
    }
}
