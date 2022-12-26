package randomizedtest;

import org.junit.Test;
import static org.junit.Assert.*;
public class testThreeAddThreeRemove {
    @Test
    public static void main(String[] args) {
        AListNoResizing<Integer> TestAList = new AListNoResizing<>();
        BuggyAList<Integer> TestBuggyList = new BuggyAList<>();

        // Add 3 Integers
        for (int i = 1; i <= 3; i++) {
            TestAList.addLast(i);
            TestBuggyList.addLast(i);
        }
        assertEquals(TestAList.size() ,TestBuggyList.size());
        //Remove 3 integers
        for (int j = 3; j >= 1; j--) {
            assertEquals(TestAList.getLast(), TestBuggyList.getLast());
            System.out.println("TestAList last number:" + TestAList.removeLast());
            System.out.println("TestBuggyList last number:" + TestBuggyList.removeLast());


        }
    }
}
