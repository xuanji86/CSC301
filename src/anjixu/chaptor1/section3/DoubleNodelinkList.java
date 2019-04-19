/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anjixu.chaptor1.section3;

import java.util.Iterator;

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

    public void insertLast(Item item) {
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

    public Item deleteFirst() {
        Item item = (Item) first.item;
        if (isEmpty()) {
            throw new RuntimeException("List is empty!");
        } else if (first.next != null) {
            first.next.prev = null;

        } else {
            last = null;
        }
        first = first.next;
        N--;
        return item;
    }

    public Item deleteLast() {
        Item item = (Item) first.item;
        if (isEmpty()) {
            throw new RuntimeException("List is empty!");
        } else if (last.prev != null) {
            last.prev.next = null;
        } else {
            first = null;
        }
        last = last.prev;
        N--;
        return item;
    }

    public void insertbefore(DoubleNode beforeNode, Item item) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        DoubleNode currentNode = new DoubleNode();
        currentNode.item = item;
        if (beforeNode.prev != null) {
            currentNode.prev = beforeNode.prev;
            currentNode.next = beforeNode;
            beforeNode.prev = currentNode;
            currentNode.prev.next = currentNode;
            N++;
        } else {
            insertFirst(item);
        }
    }

    public void insertAfter(DoubleNode afterNode, Item item) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        DoubleNode currentNode = new DoubleNode();
        currentNode.item = item;
        if (afterNode != null) {
            currentNode.prev = afterNode;
            currentNode.next = afterNode.next;
            afterNode.next.prev = currentNode;
            afterNode.next = currentNode;
            N++;
        } else {
            insertLast(item);
        }
    }

    public void deleteNode(DoubleNode currentNode) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DoublyLinkedListIterator();
    }

    private class DoublyLinkedListIterator implements Iterator<Item> {

        int index = 0;
        DoubleNode currentNode = first;

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public Item next() {
            Item item = (Item) currentNode.item;
            currentNode = currentNode.next;

            index++;

            return item;
        }
    }
    public static void main(String[] arg){
        
    }
}
