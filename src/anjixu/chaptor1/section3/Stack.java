package anjixu.chaptor1.section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

/**
 * Created by Rene Argento on 19/08/17.
 */
public class Stack<Item> implements Iterable<Item> {

    private class Node {

        Item item;
        Node next;
    }

    private Node first;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        Node newNode = new Node();
        newNode.item = item;
        newNode.next = first;

        first = newNode;
        size++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }

        Item item = first.item;
        first = first.next;
        size--;

        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            return null;
        }

        return first.item;
    }

    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        String[] input = StdIn.readLine().split(" ");
        
        for (String s:input) {
            
            StdOut.println(s);
            if (s.equals("(")) {
            } else if (s.equals("+")) {
                ops.push(s);
            } else if (s.equals("-")) {
                ops.push(s);
            } else if (s.equals("*")) {
                ops.push(s);
            } else if (s.equals("/")) {
                ops.push(s);
            } else if (s.equals(")")) {
                String op = ops.pop();
                if (op.equals("+")) {
                    vals.push(vals.pop() + vals.pop());
                } else if (op.equals("-")) {
                    vals.push(vals.pop() - vals.pop());
                } else if (op.equals("*")) {
                    vals.push(vals.pop() * vals.pop());
                } else if (op.equals("/")) {
                    vals.push(vals.pop() / vals.pop());
                }
            } else {
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }

}
