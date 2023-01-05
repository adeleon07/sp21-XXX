package deque;

import java.util.LinkedList;

public class LinkedListDeque<T> {
    private class Node {
        public T item;
        public Node next;
        public Node prev;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }
    private Node sentinel;
    private int size;
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T i) {
        size += 1;
        Node newNode = new Node(null, i, sentinel.next);
        newNode.prev = sentinel;
        sentinel.next = newNode;
        sentinel.prev = newNode.next;
        newNode.next.prev = newNode;
    }

    public void addLast(T i) {
        size += 1;
        Node newNode = new Node(sentinel.next, i, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
    }











    /* initial starter code
    private class tNode {
        public T item;
        public tNode next;
        public tNode prev; //Should I have this?
        public tNode(T i, tNode n) {
            item = i;
            next = n;
        }
    }
    private tNode sentinel;
    private tNode last; // Would this be replaced by prev?
    private int size;

    //Creates an empty LinkedListDeque
    public LinkedListDeque() {
        sentinel = new tNode(null, null);
        sentinel.next = sentinel;
        //sentinel.prev = sentinel;
        size = 0;
    }
    public LinkedListDeque(T x) {
     sentinel = new tNode(63, null);
     sentinel.next = new tNode(x, null);
     size = 1;
    }
    public void addFirst(T item) {
        sentinel.next = new tNode(item, sentinel.next);
        size += 1;
    }

    public void addLast(T item) {
        last.next = new tNode(item, null);
        last = last.next;
        size += 1;
    }
    public boolean isEmpty() {
        //DO Something
        return false;
    }
    public T get(int index) {
        //DO Something

    }
    public T getRecursive(int index) {
        //DO Something

    }
    public int size() {
        return size;
    }

     */
    public static void main(String[] args) {
        LinkedListDeque<Integer> newNode = new LinkedListDeque<Integer>();
        newNode.addFirst(1);
        newNode.addFirst(2);
    }
}