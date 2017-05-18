import java.util.*;

/**
*  Implements a heap data structure, using Vector for storage.
*
*  @author Nicholas R. Howe, Thao Phan
*  @version CSC 212, 6 April 2017
*/
public class Heap<E extends Comparable<E>> {
  /** Elements of the heap are stored in a Vector */
  private Vector<E> storage;

  /** Default constructor creates an empty heap */
  public Heap() {
    storage = new Vector<E>();
  }

  /** @return  heap size */
  public int size() {
    return storage.size();
  }

  /** @return largest element in heap */
  public E peekTop() {
    return storage.get(0);
  }

  /** @return index of parent */
  private static int parent(int pos) {
    return (pos-1)/2;
  }

  /** @return index of left child */
  private static int leftChild(int pos) {
    return 2*pos+1;
  }

  /** @return index of right child */
  private static int rightChild(int pos) {
    return 2*pos+2;
  }

  /** @return T/F does left child exist in tree? */
  private boolean hasLeftChild(int pos) {
    return (leftChild(pos)<size());
  }

  /** @return T/F does right child exist in tree? */
  private boolean hasRightChild(int pos) {
    return (rightChild(pos)<size());
  }

  /**
  *  Swaps an element upwards
  * @param pos  Position of element to swap upwards
  */
  private void swapup(int pos) {
    E tmp = storage.elementAt(parent(pos));
    storage.setElementAt(storage.get(pos),parent(pos));
    storage.setElementAt(tmp,pos);
  }

  /**
  *  Compares two elements in the heap
  *  @return  true if the first is bigger than the second
  */
  private boolean isBigger(int pos1, int pos2) {
    //Comparable c1 = storage.get(pos1);
    //Comparable c2 = storage.get(pos2);
    //return c1.compareTo(c2) > 0;
    return storage.get(pos1).compareTo(storage.get(pos2)) > 0;
  }

  /**
  *  Bubbles an item down toward the larger of its two children, if any.
  *  It starts at the root (position 0), and follows the item as it sinks.
  *  At each point it should perform several comparisons to determine
  *  what swap is necessary.
  *
  *  First, if the current item has a right child, and that right
  *  child is larger than the current item and its left child,
  *  then swap the current item with its right child.
  *
  *  Otherwise, if the current item has a left child, and that left
  *  child is larger than the current item,
  *  then swap the current item with its left child.
  *
  *  Otherwise, don't swap anything.  You are done.
  *
  *  If the current position is swapped with either child, continue
  *  the process with the child position.

  // FILL IN
  // You should use the isBigger, leftChild, and rightChild methods.
  // also hasLeftChild and hasRightChild.

  */
  private void bubbleDown() {
    int pos = 0;
    boolean done = false;
    while (!done) {
      if ( hasRightChild(pos) ){
        if ( isBigger(rightChild(pos), pos) &&
        isBigger(rightChild(pos), leftChild(pos)) ) {

          swapup( rightChild(pos) );
          pos = rightChild(pos);

        }
        else if ( hasLeftChild(pos) ){
          if ( isBigger(leftChild(pos), pos) ) {

            swapup(leftChild(pos));
            pos = leftChild(pos);
          }
        }
      }
      done = true;
    }
  }

  /**
  *  Pops largest element off heap and returns it.
  *
  *  Heap size decreases by one.  The last element in the heap
  *  is swapped to the root and bubbled down.
  *
  *  @return the former root element
  */
  public E popTop() {
    // FILL IN
    int pos = 0;
    E top = peekTop();
    int lastObject = size()-1;
    storage.setElementAt( storage.get( lastObject ), pos);
    //storage.remove(lastObject);
    bubbleDown();
    storage.remove(lastObject);

    return top;
  }

  /**
  *  Bubbles an item up until it reaches equilibrium.
  *
  *  As long as the current item is greater than its parent, swap upwards.
  *
  *  @param pos  The position to work with
  */
  private void bubbleUp(int pos) {

    while ( pos != 0 && isBigger(pos, parent(pos)) ) {
        swapup(pos);
        pos = parent(pos);
      }

}

  /**
  *  Inserts a new item and re-heapifies
  *
  *  Add the item at the end of the heap, and bubble it up.
  *
  *  @param item  The item to insert
  */
  public void insert(E item) {
    // FILL IN

    storage.addElement(item);
    bubbleUp(storage.size()-1);

  }

  /** Prints heap for debugging */
  public void print() {
    int j = 1, k = 0;
    System.out.println("Heap contents:");
    for (E item : storage) {
      System.out.print(item+" ");
      k++;
      if (k >= j) {
        j = j << 1;
        k = 0;
        System.out.println("");
      }
    }
    System.out.println("");
  }
}
