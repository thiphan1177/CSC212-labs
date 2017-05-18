import java.io.*;
import java.util.*;

/**
*  Tests our hash table implementation.
*
*  @author Nick Howe
*  @version CSC 112, April 12 2006
*/
public class TableStats {
  /** Computes statistics */
  public static void main(String[] args) throws IOException {
    if (args.length < 1) {
      System.err.println("Must specify table size in command line.");
    } else {
      int tsize = Integer.valueOf(args[0]);
      Table ht = new Table(tsize);
      int key;
      String data;

      // stats:
      int ndata = 0;
      int disp = 0;
      int maxDisp = 0;
      double totalDisp = 0;
      double nSearch = 0;

      // fill table
      BufferedReader stdin =
      new BufferedReader(new InputStreamReader(System.in));
      String line = stdin.readLine();
      while (line != null) {
        StringTokenizer st = new StringTokenizer(line);
        key = Integer.valueOf(st.nextToken());
        data = st.nextToken();

        // insert key in table, noting displacement
        disp = ht.insert(key,data);
        if (disp < 0) {
          throw new RuntimeException("Negative displacement");
        }
        ndata++;
        totalDisp += disp;
        if (disp > maxDisp) {
          maxDisp = disp;
        }
        line = stdin.readLine();
      }

      // test full table
      int maxCluster = 0;
      for (int i = 0; i < tsize; i++) {
        disp = ht.insert(i,"");
        nSearch += disp;
        if (disp > maxCluster) {
          maxCluster = disp;
        }
        ht.remove(i);
      }

      System.out.println("Done.  Final report:");
      System.out.println("Created a table with "+tsize+" slots.");
      System.out.println("Inserted "+ndata+" elements.");
      System.out.println("Total number of displacements:  "+totalDisp);
      System.out.println("Mean displacement:  "+(totalDisp/ndata));
      System.out.println("Maximum displacement:  "+maxDisp);
      System.out.println("Mean search on lookup:  "+(nSearch/tsize));
      System.out.println("Largest cluster:  "+maxCluster);

      /* in terminal: thaophan$ java TableStats 101 < states.txt */
      /* Done.  Final report:
      Created a table with 151 slots.
      Inserted 50 elements.
      Total number of displacements:  7557.0
      Mean displacement:  151.14
      Maximum displacement:  153
      Mean search on lookup:  151.19205298013244
      Largest cluster:  154*/
    }
  }
}
