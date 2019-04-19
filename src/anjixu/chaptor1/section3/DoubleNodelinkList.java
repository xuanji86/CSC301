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
public class DoubleNodelinkList<Item> implements Iterable<Item> {

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

    public void insertbefore(Item A, Item item) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        DoubleNode Node = first;
        while (Node.item != A) {
            Node = Node.next;
            if (Node == null) {
                return;
            }
        }
        DoubleNode currentNode = new DoubleNode();
        currentNode.item = item;
        currentNode.prev = Node.prev;
        currentNode.next = Node;
        Node.prev.next = currentNode;
        Node.prev = currentNode;
        N++;
    }

    public void insertAfter(Item A, Item item) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        DoubleNode Node = first;
        while (Node.item != A) {
            Node = Node.next;
            if (Node == null) {
                return;
            }
        }
        DoubleNode currentNode = new DoubleNode();
        currentNode.item = item;
        currentNode.prev = Node;
        currentNode.next = Node.next;
        Node.next.prev = currentNode;
        Node.next = currentNode;
        N++;
    }

    public void deleteNode(Item A) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        DoubleNode currentNode = first;
        while(currentNode.item != A){
            currentNode = currentNode.next;
            if(currentNode == null){
                return;
            }
        }
        if(currentNode != last){
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
        N--;
        }
        else{
            deleteLast();
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new DoubleLinkedlistIterator();
    }

    private class DoubleLinkedlistIterator implements Iterator<Item> {

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

    public static void main(String[] arg) {
        DoubleNodelinkList<String> doublelinkedlist = new DoubleNodelinkList<>();
        doublelinkedlist.insertFirst("1");
        doublelinkedlist.insertLast("10");
        doublelinkedlist.insertbefore("10", "5");
        doublelinkedlist.insertAfter("1", "2");
        for (String item : doublelinkedlist) {
            System.out.println(item);
        }
        System.out.println("--------------");
        doublelinkedlist.deleteFirst();
        doublelinkedlist.deleteLast();
        doublelinkedlist.insertFirst("1");
        doublelinkedlist.deleteNode("2");
        for (String item : doublelinkedlist) {
            System.out.println(item);
        }

    }
}
