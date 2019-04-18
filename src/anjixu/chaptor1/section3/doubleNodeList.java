/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anjixu.chaptor1.section3;

/**
 *
 * @author xuanji
 * @param <Item>
 */
public class doubleNodeList<Item> {

    private DoubleNode<Item> first;
    private DoubleNode<Item> last;

    private static class DoubleNode<E> {

        public E item;
        public DoubleNode<E> next;
        public DoubleNode<E> prev;
    }

    public doubleNodeList() {
        first = null;
        last = null;
    }

    public static <T> void insertAsFirst(doubleNodeList<T> d1, T e) {
        DoubleNode<T> node = new DoubleNode<T>();
        node.item = e;
        node.prev = null;
        node.next = d1.first;
        if (d1.first == null) {
            d1.last = node;
        } else {
            d1.first.prev = node;
        }
        d1.first = node;
    }

    public static <T> void insertAsLast(doubleNodeList<T> d1, T e) {
        DoubleNode<T> node = new DoubleNode<T>();
        node.item = e;
        node.prev = d1.last;
        node.next = null;
        if (d1.last == null) {
            d1.first = node;
        } else {
            d1.last.next = node;
        }
        d1.last = node;
    }

    public static <T> void deleteFirst(doubleNodeList<T> d1) {
        if (d1.first == null) {
            return;
        }
        if (d1.first == d1.last) {
            d1.first = null;
            d1.last = null;
        } else {
            d1.first = d1.first.next;
            d1.first.prev.next = null;
            d1.first.prev = null;
        }

    }

    public static <T> void deleteLast(doubleNodeList<T> d1) {
        if (d1.last == null) {
            return;
        }
        if (d1.last == d1.first) {
            d1.first = null;
            d1.last = null;
        } else {
            d1.last = d1.last.prev;
            d1.first.next.prev = null;
            d1.last.next = null;
        }
    }

    public static <T> void insertBefore(doubleNodeList<T> d1, DoubleNode<T> node, T e) {
        if (node == null) {
            return;
        }
        if (d1.first == node) {
            insertAsFirst(d1, e);
        }
        else{
            DoubleNode<T> newNode = new DoubleNode<T>();
            newNode.item = e;
            newNode.prev = node.prev;
            newNode.next = node;
            node.prev.next = newNode;
            node.prev = newNode;
        }
    }
    public static <T> void insertAfter(doubleNodeList<T> d1, DoubleNode<T> node, T e){
        if (node == null){
            return;
        }
        if(d1.last == node){
            insertAsLast(d1,e);
        }
        else{
            DoubleNode<T> newNode = new DoubleNode<T>();
            newNode.item = e;
            newNode.prev = node;
            newNode.next = node.next;
            node.next.prev = newNode;
            node.next = newNode;
        }
    }
    public static <T> void deleteNode(doubleNodeList<T> d1, DoubleNode<T> node){
        if (node == null){
            return;
        }
        else if  (node == d1.first){
            deleteFirst(d1);
        }
        else if (node == d1.last){
            deleteLast(d1);
        }
        else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
    }
    public static <T> DoubleNode<T> search(doubleNodeList<T> d1, T e){
        DoubleNode<T> node = d1.first;
        while(node != null){
            if(node.item.equals(e)){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public static <T> void print(doubleNodeList<T> d1){
        DoubleNode<T> node = d1.first;
        while(node != null){
            System.out.println(node.item);
            node = node.next;
        }
    }
}
