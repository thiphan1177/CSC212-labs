/**
*  Class to work with Box class:  store items in boxes.
*/
public class PackItems {
  /** Run the test */

  /** You should not alter any of the existing lines -- just add exception handlers to make the program do what you want. (It is ok to put some of the existing lines inside a try block so long as you don't change them.) When finished your program should add each item to a box, and print out the full list of items in boxes, without errors and without losing any items.
*/
  public static void main(String[] args) {
    int[] boxcap = {100,100,50,200,250};
    int[] items = {10,25,50,50,30,30,50,40,10,50,10,50,40};
    int i, j;

    // // create boxes
    // Box[] boxes = new Box[boxcap.length];
    // for (i = 0; i <= boxcap.length; i++) {
    //   try{
    //     boxes[i] = new Box(boxcap[i]);
    //     throw new BoxFullException("Array Index Out of Bounds Exception!");
    //     //boxes[i] = new Box(boxcap[i]);
    //
    //   } catch (BoxFullException e){
    //     System.out.println("Caught Exception in method: "+e);
    //
    //   }
    // }


    // create boxes
  	Box[] boxes = new Box[boxcap.length];
  	for (i = 0; i <= boxcap.length; i++) {
      try {
  	    boxes[i] = new Box(boxcap[i]);
      } catch (ArrayIndexOutOfBoundsException e){
        System.out.println("Caught exception in main: "+e);
      }
  	}

    // add items to boxes
    i = 0;  // box index
    j = 0;  // item index
    try{
      while (j < items.length) {
        boxes[i].add(items[j]);
        j++;
      }
    }catch (BoxFullException e){
      System.out.println("Caught exception in WHILE: "+e);
    }


    // print items in boxes
    for (i = 0; i < boxes.length; i++) {
      for (j = 0; j < items.length; j++) {
        try{
        System.out.printf("Box %d item %d: size %d.\n",
        i,j,boxes[i].getItem(j));
      } catch (IndexOutOfBoundsException e){
        System.out.println("Caught exception in PRINT BOX: "+e);


      }
      }
    }
  }
}
