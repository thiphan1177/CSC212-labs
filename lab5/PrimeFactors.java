import java.util.Stack;

/**
 *  This file contains a demo of the use of the stack.
 *
 * Ask the user for a number, and then find its prime factorization.
 *
 *  @author Thao Phan
 *  @version CSC 212, 2 March 2017
 */
public class PrimeFactors {
  /**
   *  getFactor() returns some factor of the argument a.
   *  If the number is prime, it will return 1.
   *
   *  @param a:  number to get a factor for.
   *  @return  the largest integral factor of a
   */
  public static int getFactor(int a) {
  	int i = (int)Math.sqrt(a);

  	while (a%i != 0) {
  		i--;
  	}
  	return i;
  }  // end of getFactor()

/** Runs StackPrimeFactor on a number */
public static void main(String[] args){
  int n;
  Stack<Integer> s = new Stack<Integer>();

  // make sure the user has provided a number on the command line.
  if (args.length == 0){
    System.err.println("You must provide a number on the command line.");
    System.err.println("Ex: java StackPrimeFactor 100");
    System.exit(-1);
  } //endif
  n = Integer.valueOf(args[0]);
  s.push(n);
  System.out.println("Looking for the prime factors summing to "+n+".");
  while (!s.empty()){
    System.out.println("Stack contains: "+s);
    n = s.pop();
    if (getFactor(n) != 1){
      int numberFactor = getFactor(n);
      s.push(numberFactor);
      s.push(n/numberFactor);
    } else{
      System.out.println("Found "+n);
    }//end ifelse

  } //endwhile
}

}
