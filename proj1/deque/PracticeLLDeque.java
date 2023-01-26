package deque;

public class PracticeLLDeque<T> {
    private class Node {
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

    public PracticeLLDeque() {
        sentinel = new Node(null, null, null);

    }
}
