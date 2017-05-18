import java.util.*;

/**
*  Class HeapTest, lab9
*
*  @author Thao Phan
*  @version CSC 212, 6 April 2017
*/

public class HeapTest{

  public static void main(String [] args){

    Heap<Integer> h = new Heap<Integer>();

    h.insert(1);
    h.insert(4);
    h.insert(7);
    h.insert(51);
    h.insert(99);
    h.insert(25);
    h.insert(14);
    h.insert(54);
    h.insert(63);
    h.insert(72);
    h.insert(115);
    h.insert(405);
    h.insert(505);
    h.insert(89);
    h.print();

    System.out.println("\nPopping off items from the heap: ");

    h.popTop(); //pops 14
    h.print();
    h.popTop(); //pops 25
    h.print();
    h.popTop(); //pops 4
    h.print();
    h.popTop(); // pops 63
    h.print();

    Heap<Integer> heap2 = new Heap<Integer>();

    int arr[] = {-2,3,9,-7,1,2,6,-3};
    //  int arr[] = {45,54,87,3,4,53,77,10};

    /**  You will loop over the array three times in all: once to fill the heap, once to empty it, and once to print. */

    for (int i = 0; i < arr.length; i++){
      heap2.insert(arr[i]);
    }
    System.out.println("\nPrinting out the heap after filling it with a for-loop: ");

    heap2.print();
    System.out.println();


    /** Pop the numbers off the heap again, storing them all in the array backwards as you do so. */
    int array[] = new int[8];
    for (int i = 0; i < array.length; i++){
      int number = heap2.popTop();
      array[i] = number;
      System.out.println("Printing out array in the for-loop: "+Arrays.toString(array));
    }

    /** Finally, print out the array, which should now be sorted. */
    System.out.println("Printing out the array after the loop: "+Arrays.toString(array));

  }

}
