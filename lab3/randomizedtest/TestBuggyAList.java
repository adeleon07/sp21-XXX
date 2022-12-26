package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestBuggyAList {
  // YOUR TESTS HERE
  @Test
  public void testThreeAddThreeRemove() {
      AListNoResizing<Integer> TestAList = new AListNoResizing<>();
      BuggyAList<Integer> TestBuggyList = new BuggyAList<>();

      // Add 3 Integers
      for (int i = 1; i <= 3; i++) {
          TestAList.addLast(i);
          TestBuggyList.addLast(i);
      }
      assertEquals(TestAList.size(), TestBuggyList.size());
      //Remove 3 integers
      for (int j = 3; j >= 1; j--) {
          assertEquals(TestAList.getLast(), TestBuggyList.getLast());
          System.out.println("TestAList last number:" + TestAList.removeLast());
          System.out.println("TestBuggyList last number:" + TestBuggyList.removeLast());
      }
  }
  @Test
  public void randomizedTest() {
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> BL = new BuggyAList<>();

      int N = 5000;
      for (int i = 0; i < N; i += 1) {
          int operationNumber = StdRandom.uniform(0, 4);
          if (operationNumber == 0) {
              // addLast
              int randVal = StdRandom.uniform(0, 100);
              L.addLast(randVal);
              BL.addLast(randVal);
              System.out.println("addLast(" + randVal + ")");
          } else if (operationNumber == 1) {
              // size
              int size = L.size();
              int size_BL = BL.size();
              //System.out.println("size: " + size);
              //System.out.println("size of Buggy List: " + size_BL);
          } else if ((L.size() > 0) && (BL.size() > 0)) {
              if (operationNumber == 2) {
                  //System.out.println("List, Last value was: " + L.getLast());
                  //System.out.println("BuggyList, Last value was: " + BL.getLast());
                  assertEquals(L.getLast(), BL.getLast());
              } else if (operationNumber == 3) {
                  //System.out.println("List, Last value removed: " + L.getLast());
                  //System.out.println("Buggy List, Last value removed: " + BL.getLast());
                  assertEquals(L.removeLast(), BL.removeLast());
              }
          }
      }
  }
}
