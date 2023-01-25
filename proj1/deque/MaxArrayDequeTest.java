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

}
