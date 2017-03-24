import java.util.*;

/**
 * Sample program to demonstrate variable types
 *
 * @author Thao Phan
 * @version 18 February 2016
 */
class NumberFacts {
  /**
   * Get a number from the user and display facts
   *
   * @param args Command line arguments
   */
  public static void main(String[] args) {
      // ask user for a number
      System.out.print("Please enter an integer: ");
      Scanner input = new Scanner(System.in);
      int n = input.nextInt();

      // double of number
      int ndoubled = n+n;
      System.out.println(n+" doubled is "+ndoubled);

      // square of number
      double nSquared = n*n;
      System.out.println(n+" squared is "+nSquared);

      // square root of a number
      double nSquareRoot = Math.sqrt(n);
      System.out.println(n+" square rooted is "+nSquareRoot);

      // number divided by 7
      double ndiv7a = n/7;
      System.out.println(n+" divided by 7 is "+ndiv7a);

      // number divided by 7.0
      double ndiv7b = n/7.0;
      System.out.println(n+" divided by 7.0 is "+ndiv7b);

      /**
       *  Tests whether an integer is prime
       *
       *  @param n  The number to test
       */

       boolean isPrime = true;
       if (n%2 ==0){
         isPrime = false;
         System.out.println(n+" is Even.");
       } else {
         System.out.println(n+" is Odd.");
       }

       // Create an array with space to hold 10 int values.
       // Then, use a loop to fill in as values the multiples from 0-9
       // of the original number entered by the user.

       //multiples
       int[] intArr = new int[10];
       for (int i = 0; i < 10; i++) {
         intArr[i] = i * n;
         System.out.println("intArr["+i+"] is "+intArr[i]);
       }
       
       // Create an array with space to hold eleven String values. Then fill in the number names from zero to ten as their values. To check that everything worked right, you can write a loop to print out the values one to a line.

       String[] stringArr = new String[11];
       stringArr[0] = "zero";
       stringArr[1] = "one";
       stringArr[2] = "two";
       stringArr[3] = "three";
       stringArr[4] = "four";
       stringArr[5] = "five";
       stringArr[6] = "six";
       stringArr[7] = "seven";
       stringArr[8] = "eight";
       stringArr[9] = "nine";
       stringArr[10] = "ten";

       for (int i = 0; i < 11; i++){
         System.out.println("stringArr["+i+"] is "+stringArr[i]);
       }





  }
}
