package deque;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;
public class ArrayDequeTest {

    @Test
    public void simpleAddAndGet() {
        ArrayDeque<Integer> TestADeque = new ArrayDeque<>();
        for (int i=0; i < 7; i++) {
            TestADeque.addLast(i);

        }
        assertEquals(0, (int)TestADeque.get(0));
        assertEquals(1, (int)TestADeque.get(1));
        assertEquals(2, (int)TestADeque.get(2));
        assertEquals(3, (int)TestADeque.get(3));
    }

    @Test
    public void simpleAddAndRemoveFirst() {
        ArrayDeque<Integer> TestRDeque = new ArrayDeque<>();
        for (int i=0; i < 7; i++) {
            TestRDeque.addLast(i);
        }
        assertEquals(7, (int)TestRDeque.size());
        assertEquals(0, (int)TestRDeque.removeFirst());
        assertEquals(1, (int)TestRDeque.removeFirst());
        assertEquals(2, (int)TestRDeque.removeFirst());
        assertEquals(3, (int)TestRDeque.removeFirst());
        assertEquals(3, (int)TestRDeque.size());
    }

    @Test
    public void simpleAddAndRemoveLast() {
        ArrayDeque<Integer> TestRLDeque = new ArrayDeque<>();
        for (int i=0; i < 7; i++) {
            TestRLDeque.addLast(i);
        }
        TestRLDeque.printDeque();
        assertEquals(7, (int)TestRLDeque.size());
        assertEquals(6, (int)TestRLDeque.removeLast());
        assertEquals(5, (int)TestRLDeque.removeLast());
        assertEquals(4, (int)TestRLDeque.removeLast());
        assertEquals(3, (int)TestRLDeque.removeLast());
        assertEquals(3, (int)TestRLDeque.size());
    }

    @Test
    public void largeAddandRemove() {
        ArrayDeque<Integer> TestRLDeque = new ArrayDeque<>();
        for (int i = 0; i < 25; i++) {
            TestRLDeque.addLast(i);
        }
        for (int j = 0; j < 25; j++) {
            TestRLDeque.removeLast();
        }
        assertTrue(TestRLDeque.isEmpty());


        for (int i = 0; i < 1000; i++) {
            TestRLDeque.addFirst(i);
        }
        for (int i = 0; i < 1000; i++) {
            TestRLDeque.removeFirst();
        }
        assertTrue(TestRLDeque.isEmpty());

    }

    @Test
    public void resizeNoNull() {
        ArrayDeque<Integer> TestRLDeque = new ArrayDeque<>();
        for (int i = 0; i < 8; i++) {
            TestRLDeque.addFirst(i);
        }
        assertEquals(7.0 , (double)TestRLDeque.removeFirst(), 0);
        assertEquals(0.0 , (double)TestRLDeque.removeLast(), 0);



    }
    @Test
    public void basicget() {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<>();
        ArrayDeque.addLast(0);
        ArrayDeque.get(0);
        ArrayDeque.removeLast();
        ArrayDeque.addFirst(6);
        ArrayDeque.addLast(7);
        ArrayDeque.addFirst(8);
        ArrayDeque.removeLast();
        ArrayDeque.removeLast();
        ArrayDeque.addFirst(11);
        ArrayDeque.addLast(12);
        ArrayDeque.removeFirst();
        ArrayDeque.addLast(14);
        ArrayDeque.addLast(15);
        ArrayDeque.addLast(16);
        ArrayDeque.removeFirst();
        ArrayDeque.addLast(18);
        ArrayDeque.removeLast();

        ArrayDeque<Integer> ArrayDeque1 = new ArrayDeque<>();
        ArrayDeque1.addLast(0);
        ArrayDeque1.addLast(1);
        ArrayDeque1.removeFirst();
        ArrayDeque1.removeFirst();
        ArrayDeque1.addLast(4);
        ArrayDeque1.get(0);
        ArrayDeque1.addLast(6);
        ArrayDeque1.get(0);
        ArrayDeque1.addFirst(8);
        ArrayDeque1.addLast(9);
        ArrayDeque1.removeLast();
        ArrayDeque1.removeFirst();
        ArrayDeque1.removeFirst();
        ArrayDeque1.removeFirst();
        ArrayDeque1.addFirst(14);

        ArrayDeque<Integer> ArrayDeque2 = new ArrayDeque<>();
        ArrayDeque2.addLast(0);
        ArrayDeque2.addLast(1);
        ArrayDeque2.addLast(2);
        assertEquals(2.0, (double)ArrayDeque2.removeLast(), 0.0);
    }
}
