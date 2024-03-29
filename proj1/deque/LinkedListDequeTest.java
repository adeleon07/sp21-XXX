package deque;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * and prints the results
     */

    public void addIsEmptySizeTest() {
        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());

        lld1.addFirst("Front");
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("Middle");
        assertEquals(2, lld1.size());

        lld1.addLast("Last");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque:" );
        lld1.printDeque();
    }

    @Test
    /* Adds an item, then removes an item, and ensures that dll is empty afterwards */
    public void addRemoveTest() {
        LinkedListDeque<Integer> intlld = new LinkedListDeque<>();
        assertTrue("A newly initialized LLDeque should be empty", intlld.isEmpty());

        intlld.addFirst(1);
        assertFalse("intlld should now contain one item, the int 1", intlld.isEmpty());

        intlld.removeFirst();
        assertTrue("intlld should now be empty", intlld.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {
        LinkedListDeque<Integer> llde = new LinkedListDeque<>();

        assertTrue("lld1 should be empty upon initialization", llde.isEmpty());
        assertEquals("Should return a null object for .removeFirst()", null, llde.removeFirst());
        assertEquals("Should return a null object for .removeLast()", null, llde.removeLast());
    }

    @Test
    /* Check if you can create LinkedListDeque with different parameterized types */
    public void multipleParamTest() {
        LinkedListDeque<String> llds = new LinkedListDeque<>();
        llds.addFirst("String");
        assertFalse("llds should now contain one string item, 'String'", llds.isEmpty());

        LinkedListDeque<Integer> lldi = new LinkedListDeque<>();
        lldi.addFirst(1);
        assertFalse("lldi should now contain one int item, '1'", llds.isEmpty());

    }

    @Test
    /* check if null is returned when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {
        LinkedListDeque<Integer> lldr = new LinkedListDeque<>();

        assertEquals("Should return null when removeFirst() is called on an empty LinkedListDeque", null, lldr.removeFirst());
        assertEquals("Should return null when removeLast() is called on an empty LinkedListDeque", null, lldr.removeLast());
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        for (int i = 0; i < 100000; i ++) {
            lld.addLast(i);
        }

        for (double j = 0; j < 50000; j++) {
            assertEquals("Should have the same value,  loops through first half of the LinkedListDeque", j, (double) lld.removeFirst(), 0.0);
        }

        for (double k = 99999; k > 50000; k--) {
            assertEquals("Should have the same value,  loops through last half of the LinkedListDeque", k, (double) lld.removeLast(), 0.0);
        }
    }

    @Test
    public void iterativeLLDequeGet() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addLast(0);
        lld.removeLast();
        lld.addLast(2);

        assertEquals(2.0 , (double) lld.get(0), 0);
    }

    @Test
    public void recursiveLLDequeGet() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addFirst(0);
        assertEquals(0.0 , (double) lld.getRecursive(0), 0);
        lld.addFirst(2);
        assertEquals(0.0 , (double) lld.getRecursive(1), 0);
    }

    @Test
    public void lldEqualsad() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addLast(2);
        lld.addLast(2);

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addLast(2);
        ad.addLast(2);

        System.out.println(lld.get(1));
        System.out.println(ad.get(1));

        assertTrue(lld.equals(ad));
    }

    @Test
    public void deepEquals() {
        LinkedListDeque<Deque> a = new LinkedListDeque<>();
        ArrayDeque<Deque> b = new ArrayDeque<>();
        LinkedListDeque<Integer> c = new LinkedListDeque<>();
        LinkedListDeque<Integer> d = new LinkedListDeque<>();

        c.addLast(1);
        d.addFirst(1);

        a.addFirst(c);
        b.addFirst(d);

        System.out.println("a: " + a.get(0));
        System.out.println("b: " + b.get(0));

        assertTrue(a.equals(b));
        assertTrue(a.equals(a));
    }
}
