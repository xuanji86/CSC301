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
    public Item deleteFirst(){
        Item item = (Item) first.item;
        if(isEmpty()){
            throw new RuntimeException("List is empty!");
        }
        else if (first.next != null){
            first.next.prev= null;
            
        }
        else{
            last = null;
        }
        first = first.next;
        N--;
        return item;
    }
    public Item deleteLast(){
        Item item = (Item) first.item;
        if(isEmpty()){
            throw new RuntimeException("List is empty!");
        }
        else if(last.prev != null){
            last.prev.next = null;
        }
        else{
            first = null;
        }
        last = last.prev;
        N--;
        return item;
    }
    public void insertAfter(Item afterNode, Item item){
        if (isEmpty()){
            throw new RuntimeException("List is empty");
        }
        DoubleNode currentNode;
        
        for(currentNode = first; currentNode != null; currentNode = currentNode.next){
            if(currentNode.item == afterNode){
                break;
            }
        }
        if (currentNode != null){
            DoubleNode newNode = new DoubleNode();
            newNode.item = item;
            
            DoubleNode nextNode = currentNode.next;
            currentNode.next = newNode;
            newNode.next = nextNode;
            newNode.next = nextNode;
            
            if(newNode.next == null){
                last = newNode;
            } 
            else{
                newNode.next.prev = newNode;
            }
            N++;
        }
    }
    
}
