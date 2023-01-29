package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    public class Node {
        public Node prev;
        public T item;
        public Node next;


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
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T i) {
        size += 1;
        Node newNode = new Node(null, i, sentinel.next);
        newNode.prev = sentinel;
        sentinel.next = newNode;
        newNode.next.prev = newNode;
    }

    @Override
    public void addLast(T i) {
        size += 1;
        Node newNode = new Node(sentinel.prev, i, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
    }

    @Override
    public void printDeque() {
        Node toPrint = sentinel.next;
        while (toPrint.item != null) {
            System.out.print(toPrint.item + " ");
            toPrint = toPrint.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        } else {
            sentinel.next = sentinel.next.next;
            T first = sentinel.next.prev.item;
            sentinel.next.prev = sentinel;
            size -= 1;
            return first;
        }
    }

    @Override
    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        } else {
            sentinel.prev = sentinel.prev.prev;
            T last = sentinel.prev.next.item;
            sentinel.prev.next = sentinel;
            size -= 1;
            return last;
        }
    }

    @Override
    public T get(int index) {
        if (index > size) {
            return null;
        }
        Node travel = sentinel.next;
        if (index == 0) {
            return travel.item;
        } else {
            for (int i = 0; i < index; i++) {
                travel = travel.next;
            }
            return travel.item;
        }

    }

    public T getRecursive(int index) {
        return helper(index, sentinel, 0);
    }

    private T helper(int index, Node s, int count) {
        Node pointer = s.next;
        if (index == 0) {
            return pointer.item;
        }
        while (count < index) {
            pointer = pointer.next;
            count++;
        }
        return pointer.item;
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private int wizPos;

        private LinkedListDequeIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        public T next() {
            T item = get(wizPos);
            wizPos += 1;
            return item;
        }
    }
    public int size() {
        return size;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Deque)) {
            return false;
        }

        if (this == o) {
            return true;
        }

        Deque<T> ol = (Deque<T>) o;
        if (ol.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (!(ol.get(i).equals(this.get(i)))) {
                return false;
            }
        }
        return true;

    }
}
