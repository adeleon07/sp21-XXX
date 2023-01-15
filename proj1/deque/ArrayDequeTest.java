package deque;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;
public class ArrayDequeTest {

    @Test
    public void simpleAddAndRemove() {
        ArrayDeque<Integer> TestADeque = new ArrayDeque<>();
        for (int i=0; i < 7; i++) {
            TestADeque.addLast(i);

        }

        assertEquals((int)TestADeque.get(2), 2);
        assertEquals((int)TestADeque.removeFirst(), 0);


    }
}
