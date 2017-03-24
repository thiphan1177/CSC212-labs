import java.util.Stack;

/**
 *  A class to test use of the Stack class.
 *
 *  @author Nicholas R. Howe
 *  @version CSC 112, 27 February 2006
 */
public class TestStack {
    /** Runs the test */
    public static void main(String[] args) {
      	Stack<Integer> s;
      	s = new Stack<Integer>();
        s.push(4);
      	s.push(3);
      	s.push(2);
        //s.push(4);
        s.push(1);
        s.push(27);
        s.push(36);
        s.push(21);
        s.push(32);
        //s.push(4);
      	while (!s.empty()) {
      	    System.out.println("Popping s:  "+s.pop());
      	}
      	System.out.println("Empty!");

        // popping an empty stack to see what will happen
        try {
            s.pop();
        } catch (Exception e) {
            System.out.println("Exception caught:  "+e.getClass());
        }

      	Stack<String> s2;
      	s2 = new Stack<String>();
        s2.push("burger!");
        s2.push("a");
        s2.push("and");
      	s2.push("cracker");
      	s2.push("a");
      	s2.push("wants");
      	s2.push("Polly");
      	while (!s2.empty()) {
      	    System.out.println("Popping s:  "+s2.pop());
      	}
      	System.out.println("Empty!");
    }
}
