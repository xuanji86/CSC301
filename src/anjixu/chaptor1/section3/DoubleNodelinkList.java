/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anjixu.chaptor1.section3;

/**
 *
 * @author xuanji
 */
public abstract class DoubleNodelinkList<Item> implements Iterable<Item> {

    private DoubleNode first;
    private DoubleNode last;
    private int N;

    public static class DoubleNode<Item> {

        Item item;
        DoubleNode prev;
        DoubleNode next;

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insertFirst(Item item) {
        DoubleNode<Item> node = new DoubleNode<Item>();
        node.item = item;
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first.prev = node;
            first = node;
        }
        N++;
    }

    public void inserLast(Item item) {
        DoubleNode<Item> node = new DoubleNode<Item>();
        node.item = item;
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        N++;
    }

}
