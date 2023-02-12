

public class SLList {
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return first.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        /* Your Code Here! */
        IntNode p = first;

        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    /** Returns the number of items in the list using recursion. */
    public int size() {
        /* Your Code Here! */
        IntNode p = first;
        int i = 1;
        while (p.next != null) {
            p = p.next;
            i++;
        }

        return i;
    }

    private static int size_priv(IntNode p) {
        if (p.next == null) {
            return 1;
        }else{
            return 1 + size_priv(p.next);
        }

    }

    public int size_rec(){
        return size_priv(first);
    }

    public static void main(String[] args) {
        SLList L = new SLList(0);

        System.out.println(L.size());
        System.out.println(L.size_rec());
    }
}