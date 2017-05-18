/** My exception class */
public class BoxFullException extends Exception{

  /** Constructs a new exception with null as its detail message. */
  public BoxFullException(){
    //
  }

  /** Constructs a new exception with the specified detail message. */
  public BoxFullException(String message){
    super(message);
  }

  /** Constructs a new exception with the specified detail message and cause. */
  public BoxFullException(String message, Throwable cause){
    super(message, cause);
  }

  /** Constructs new runtime exception with specified cause and detailed message of (cause==null ? null : cause.toString()) (which usually contains the class and detail message of cause). This constructor is useful for runtime exceptions that are little more than wrappers for other throwables.*/

  /** cause - the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.) */
  public BoxFullException(Throwable cause){

  }




}
