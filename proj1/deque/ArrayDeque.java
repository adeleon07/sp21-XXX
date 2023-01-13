package deque;

import java.awt.datatransfer.SystemFlavorMap;

public class ArrayDeque<T> {
    private T [] items;
    private int size;
    private T front;
    private T back;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    public void addFirst(T item) {

    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = item;
        size += 1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {

    }

    public T removeFirst() {

    }

    //still need to determine circular usage
    public T removeLast() {
        if ((size > 16) && (items.length * .25 > size)) {
            reducesize(4);
        }
        T lastItem = getLast();
        items[size - 1] = null;
        size -= 1;
        return lastItem;
    }

    public T get(int index) {
        return items[index];
    }

    public T getLast() {
        return items[size-1];
    }

    /* Resizes the underlying array to target capacity */
    private void resize(int capacity) {
        T[] a = (T []) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    private void reducesize(int factor) {
        T[] a = (T[]) new Object[items.length / factor];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }
}