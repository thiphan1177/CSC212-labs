/**
*  Implements a simple hash table.
*
*  @author Nick Howe, Thao Phan
*  @version CSC 212, April 13 2017
*/
public class Table {
  /** Number of items stored */
  private int nStored;

  /** Array of pairs */
  TableRow[] rows;


  /** Constructor creates a table with the specified number of slots */
  public Table(int tableSize) {
    nStored = 0;
    rows = new TableRow[tableSize];
  }

  /**
  *  Returns the default slot where this key is stored
  *
  *  @param key  The key to look for
  *  @return The slot index
  */
  private int hash(int key) {
    return key%rows.length;
  }

  /**
  *  Locates the row where the specified key can be found,
  *  or where it should be inserted if it is not already
  *  in the table
  *
  *  @param key  The key to look for
  *  @return The slot index
  */
  private int locate(int key) {
    int pos = hash(key);

    // Linear probing.
    // Starting from the current position, keep searching
    // (incrementing pos) until either an empty slot is found
    // or the desired key is located.  Then return that position.
    // Don't forget to wrap around at the end of the table.
    while ( (rows[pos] != null) && ( rows[pos].key != key ) ){
      pos++;
      if ( pos == rows.length ){
        pos = 0;
      }
      //pos++;

    }
    return pos;
  }

  /**
  *  Puts the specified data in the table under the specified key.
  *  Returns the distance between the home position and the actual.
  *
  *  @param key  The key to insert under
  *  @param data  The data to store under this key
  *  @return Distance of actual position from home
  */
  public int insert(int key, String data) {
    // Find correct position using locate.
    // If new key, increment number of items in table.
    // Store new key and item in correct position.
    // Return difference between actual and home position,
    // keeping in mind table wrap.
    int pos = locate(key);
    if ( pos > rows.length-1 ){
      nStored += nStored;
      //TableRow table = new TableRow(key, data);
      //rows[pos] = table;
    }
    TableRow table = new TableRow(key, data);
    rows[pos] = table;

    int actualPos = locate(key);
    int numberOfRows = rows.length;
    int home = hash(key);

    //System.out.println("number of rows: "+numberOfRows);
    //System.out.println(actualPos+" "+numberOfRows+" "+home);

    return ( actualPos + numberOfRows - home );
    //return actualPos-home;

  }

  /**
  *  Retrieves the item associated with the given key.
  *  If there is no item stored under that key, then it returns
  *  false.
  *
  *  @param key  The key to look up
  *  @return The data stored, if any
  */
  public String lookup(int key) {
    // FILL IN:
    // Find correct position using locate().
    // If the position is occupied, then return the data found
    // there.  Otherwise, return null.
    int pos = locate(key);
    if (rows[pos] != null){
      return rows[pos].data;
    }
    return null;
  }

  /**
  *  Removes the entry associated with the given key.
  *  If there is no item stored under that key, then does nothing.
  *
  *  @param key  The key to remove
  */
  public void remove(int key) {
    int pos = locate(key);
    if (rows[pos] != null) {
      // look for displaced items that want vacated slot
      for (int pos2 = (pos+1)%rows.length;
      rows[pos2] != null;
      pos2 = (pos2+1)%rows.length) {
        int hkp = hash(rows[pos].key);
        if ((pos2-pos)%rows.length <= (pos2-hkp)%rows.length) {
          rows[pos] = rows[pos2];
          pos = pos2; // this slot is now available
        }
      }
      rows[pos] = null;  // nobody wants this slot
      nStored--;
    }
  }


  /**
  *  Prints the contents of the table
  */
  public void print() {
    System.out.println("Row:\tKey:\tData:");
    for (int i = 0; i < rows.length; i++) {
      if (rows[i] == null) {
        System.out.println(i+"\t***\tEmpty");
      } else {
        System.out.println(i+"\t"+rows[i].key+"\t"+rows[i].data);
      }
    }
  }

  /**
  *  Class designed to hold the data in one row of the table
  */
  private class TableRow {
    /** Key for this row */
    int key;

    /** Data in this row */
    String data;

    /** Constructor to fill in data */
    TableRow(int key, String data) {
      this.key = key;
      this.data = data;
    }
  }
}
