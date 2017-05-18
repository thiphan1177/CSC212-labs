/** Class to demonstrate use of exceptions */
public class DemoExceptions {
  /** Runs the demo */
  public static void main(String[] args) {
    // System.out.println("Entering main.");
    // method1();
    // System.out.println("Exiting main.");

    System.out.println("Entering main.");
    try {
      method1();
    } catch (Exception e) {
      System.out.println("Caught Exception in main: " + e);
    }
    System.out.println("Exiting main.");

  }

  /** First method called */
  // public static void method1() {
  //   System.out.println("Entering method1.");
  //   method2();
  //   System.out.println("Exiting method1.");
  // }


/*So we have only caught generic exceptions. We could be more precise and catch just an ArithmeticException. Change the type of the exception in method1 to ArithmeticException. Does anything change about the execution? -->NO

If we add a new exception handler in method2 for generic Exception, which one would run? (Try it if you are not sure.)*/


  // /** First method called */
  // public static void method1() {
  //   System.out.println("Entering method1.");
  //   try {
  //     method2();
  //   } catch (ArithmeticException e) {
  //     System.out.println("Caught Exception in method1: "+e);
  //   }
  //   System.out.println("Exiting method1.");
  // }

  /**  a handler can be triggered to take some action, but rethrow the exception to an outer level. Observe what happens with the following method1. You may need to disable any handlers in method2, if you added them):*/
  public static void method1() {
    System.out.println("Entering method1.");
    try {
      method2();
    } catch (Exception e) {
      System.out.println("Caught Exception in method: "+e);
      throw e;
    }
    System.out.println("Exiting method1.");
  }

  // /** First method called */
  // public static void method2() {
  //   System.out.println("Entering method2.");
  //   method3();
  //   System.out.println("Exiting method2.");
  // }

  /** First method called */
  public static void method2() {
    System.out.println("Entering method2.");
    try{
      method3();
    } catch (Exception e){ //changed ArithmeticException back to just Exception
      System.out.println("Caught Exception in method2: "+e);
    }
    System.out.println("Exiting method2.");
  }


  /** First method called */
  public static void method3() throws InterruptedException {
    //Thread.sleep(25);

    System.out.println("Entering method3.");
    //Thread.sleep(25);

    // create an exception
    int x = 7/0;
    //Thread.sleep(25);

    System.out.println("Exiting method3.");
    //Thread.sleep(25);

  }
}
