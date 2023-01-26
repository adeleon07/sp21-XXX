package deque;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Comparator;

public class MaxArrayDequeTest {
    @Test
    public void addIsEmptySizeTest() {
        Comparator<String> cmp = new Comparator<>() {
            @Override
            public int compare(String strA, String strB) {
                return strB.compareTo(strA);
            }
        };

        MaxArrayDeque ad1 = new MaxArrayDeque(cmp);

        assertTrue("A newly initialized LLD should be empty", ad1.isEmpty());
        ad1.addFirst("front");

        assertEquals(1, ad1.size());
        assertFalse("ad1 should now contain 1 item", ad1.isEmpty());

        ad1.addLast("middle");
        assertEquals(2, ad1.size());

        ad1.addLast("back");
        assertEquals(3, ad1.size());

        System.out.println("Printing out deque: ");
        ad1.printDeque();
    }

    @Test
    public void max() {
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                }
                return 0;
            }
        };

        MaxArrayDeque ad1 = new MaxArrayDeque(cmp);
        ad1.addFirst(1);
        ad1.addLast(2);
        ad1.addLast(3);

        assertEquals(3, ad1.max());
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        Comparator<Integer> cmp = new Comparator<>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };

        MaxArrayDeque ad1 = new MaxArrayDeque(cmp);
        // should be empty
        assertTrue("ad1 should be empty upon initialization", ad1.isEmpty());

        ad1.addFirst(10);
        // should not be empty
        assertFalse("ad1 should contain 1 item", ad1.isEmpty());

        ad1.removeFirst();
        // should be empty
        assertTrue("ad1 should be empty after removal", ad1.isEmpty());

        for (int i = 0; i < 50; i++) {
            ad1.addLast(i);
        }
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        // System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        Comparator<Integer> cmp = new Comparator<>() {
            //重写排序方法
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };

        MaxArrayDeque ad1 = new MaxArrayDeque(cmp);
        ad1.addFirst(3);

        ad1.removeLast();
        ad1.removeFirst();
        ad1.removeLast();
        ad1.removeFirst();

        int size = ad1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* check if null is return when removing from an empty MaxArrayDeque. */
    public void emptyNullReturnTest() {

        // System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        Comparator<Integer> cmp = new Comparator<>() {
            //重写排序方法
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };

        MaxArrayDeque ad1 = new MaxArrayDeque(cmp);

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, ad1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, ad1.removeLast());


    }
}

