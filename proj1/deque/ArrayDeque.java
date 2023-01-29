package deque;

import java.util.Iterator;
public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
        size = 0;
    }
    @Override
    public void addFirst(T item) {
        if (size == items.length - 1) {
            resize(items.length * 2);
        }

        items[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst -= 1;
        }
        size += 1;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length - 1) {
            resize(items.length * 2);
        }
        items[nextLast] = item;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
        size += 1;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[arrayInd(i)] + " ");
        }
        System.out.println(" ");
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T firstItem = items[arrayInd(0)];

        items[arrayInd(0)] = null;

        if ((items.length > 16) && (items.length * .25 >= size)) {
            reducesize(2);
        }
        nextFirst += 1;
        if (nextFirst > items.length - 1) {
            nextFirst = 0;
        }
        size -= 1;
        return firstItem;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        if (nextLast == 0) {
            nextLast = items.length;
        }
        T lastItem = items[nextLast - 1];
        items[nextLast - 1] = null;

        if ((items.length > 16) && (items.length * .25 >= size)) {
            reducesize(2);
        }

        nextLast -= 1;
        size -= 1;
        return lastItem;
    }

    @Override
    public T get(int index) {
        return items[arrayInd(index)];
    }

    public boolean equals(Object o) {
        if (!(o instanceof Deque)) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        Deque<T> ol = (Deque<T>) o;
        if (ol.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < ol.size(); i++) {
            if (!(ol.get(i).equals(this.get(i)))) {
                return false;
            }
        }
        return true;
    }
    private int arrayInd(int ind) {
        if (nextFirst + 1 + ind >= items.length) {
            return nextFirst + 1 + ind - items.length;
        } else {
            return nextFirst + 1 + ind;
        }
    }

    /* Resizes the underlying array to target capacity */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        //System.arraycopy(items, 0, a, 0, size);
        //items = a;
        int ind = 0;
        for (int i = 0; i < size; i += 1) {
            ind = arrayInd(i);
            a[capacity / 4 + i] = items[ind];
        }
        items = a;
        nextFirst = capacity / 4 - 1;
        nextLast = nextFirst + size + 1;

    }

    private void reducesize(int factor) {
        T[] a = (T[]) new Object[items.length / factor];
        int ind = 0;
        for (int i = 0; i < size; i++) {
            ind = arrayInd(i);
            a[items.length / 4 + i] = items[ind];
        }
        items = a;

        nextFirst = a.length / factor - 1;
        nextLast = nextFirst + 1 + size;
    }
    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int wizPos;

        private ArrayDequeIterator() {
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
}
