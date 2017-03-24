import java.util.*;
import java.io.*;

/**
 *  Shows use of StreamTokenizer.
 *  @author Nick Howe
 *  @version 26 September 2013
 */
public class Postfix {
    /** Pattern that matches on words */
    public static final String WORD = "[a-zA-Z]*\\b";

    /** Pattern that matches on arithmetic symbols */
    public static final String SYMBOL = "[^\\w]";

    /** Run short test */
    public static void main(String[] args) {
        Stack<String> aStack = new Stack<String>();

      	if (args.length==0) {
      	    System.err.println("Usage:  java Calculate <expr>");
      	} else {
      	    Scanner input = new Scanner(new StringReader(args[0]));
      	    // Below is a complicated regular expression that will split the
      	    // input string at various boundaries.
      	    input.useDelimiter
      		("(\\s+"                             // whitespace
      		 +"|(?<=[a-zA-Z])(?=[^a-zA-Z])"      // word->non-word
      		 +"|(?<=[^a-zA-Z])(?=[a-zA-Z])"      // non-word->word
      		 +"|(?<=[^0-9\\056])(?=[0-9\\056])"  // non-number->number
      		 +"|(?<=[0-9\\056])(?=[^0-9\\056])"  // number->non-number
      		 +"|(?<=[^\\w])(?=[^\\w]))");        // symbol->symbol

      	    while (input.hasNext()) {
            		if (input.hasNextDouble()) {
                    double n = input.nextDouble();
                    aStack.push(n);
            		    //System.out.println("Number:  "+input.nextDouble());
            		} else if (input.hasNext(WORD)) {
            		    System.out.println("Word:  "+input.next(WORD));
            		} else if (input.hasNext(SYMBOL)) {

                  String token = input.next(SYMBOL);

                  if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^")){
                    String number1 = aStack.pop();
                    String number2 = aStack.pop();
                    aStack.push(number1 token number2);

            		    //System.out.println("Symbol:  "+input.next(SYMBOL));
            		} else {
            		    System.out.println("Unknown:  "+input.next());
            		}
      	    }
      	}
          }
}
