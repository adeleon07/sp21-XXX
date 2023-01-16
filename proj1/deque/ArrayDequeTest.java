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
}
