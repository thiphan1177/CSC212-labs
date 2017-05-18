/**
*  Tests our hash table implementation.
*
*  @author Nick Howe
*  @version CSC 112, April 12 2006
*/
public class TestTable {
  /** Runs the test */
  public static void main(String[] args) {
    Table ht = new Table(7);  // very small table

    ht.insert(702,"first");
    ht.insert(426,"second");
    ht.insert(343,"third");
    ht.insert(149,"fouth");
    ht.insert(258,"fifth");
    System.out.println("Mistaken:");
    ht.print();
    ht.insert(149,"fourth");
    System.out.println("Corrected:");
    ht.print();

    System.out.println("\nData stored under key 149:  "+ht.lookup(149));
    System.out.println("Data stored under key 343:  "+ht.lookup(343));
    System.out.println("Data stored under key 258:  "+ht.lookup(258));
    ht.remove(343);
    System.out.println("\nModified:");
    ht.print();
    System.out.println("\nData stored under key 149:  "+ht.lookup(149));
    System.out.println("Data stored under key 343:  "+ht.lookup(343));
    System.out.println("Data stored under key 258:  "+ht.lookup(258));


    /* correct table output:
    149 : fourth
    343 : third
    258 : fifth

    149 : fourth
    343 : null
    258 : fifth
    **/
  }

  //************************************************************
}
