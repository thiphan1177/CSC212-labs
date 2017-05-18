import java.util.*;
/**
*  Represents a box with limited capacity
*/
public class Box {
  /** Capacity of this box -- cannot change once allocated */
  private final int capacity;

  /** How much is already filled */
  private int used;

  /** Current list of items stored */
  private ArrayList<Integer> items;

  /** Constructor makes an empty box */
  public Box(int cap) {
    capacity = cap;
    used = 0;
    items = new ArrayList<Integer>();
  }

  /** Accessor for capacity */
  public int getCapacity() {
    return capacity;
  }

  /** Accessor for Used */
  public int getUsed() {
    return used;
  }

  /** Accessor for remainder */
  public int getRemainder() {
    return capacity-used;
  }

  /** Accessor for items */
  public Integer getItem(int i) {
    return items.get(i);
  }

  // /** Stores an item in the box */
  // public void add(Integer item) {
  //   used += item; //used = used + item
  //   items.add(item);
  // }

  // /** Stores an item in the box */
  // public void add(Integer item) {
  //
  //   System.out.println("Entering add() method.");
  //   try {
  //     used += item;
  //     items.add(item);
  //   } catch (BoxFullException e) {
  //     System.out.println("Caught BoxFullException in method: "+e);
  //     throw e;
  //   }
  //   System.out.println("Exiting add() method.");
  //
  // }

  public void add(Integer item) throws BoxFullException{
    used += item;
    items.add(item);
    if (used > capacity){
      throw new BoxFullException();
    }

  }



  /** Removes an item from the box by index */
  public void remove(int i) {
    used -= items.remove(i);
  }
}
