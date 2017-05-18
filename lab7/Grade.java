import java.util.*;

public enum Grade {
    A_GRADE (4.0, "A"),
    A_MINUS (3.7, "A-"),
    B_PLUS  (3.3, "B+"),
    B_GRADE (3.0, "B"),
    C_PLUS  (2.3, "C+"),
    C_GRADE (2.0, "C"),
    C_MINUS (1.7, "C-"),
    D_PLUS  (1.3, "D+"),
    D_GRADE (1.0, "D"),
    E_GRADE (0, "E");

    private double value;
    private String valueToString;

    /** contructor 1
    * @param value
    * @param valueToString
    */
    Grade(double value, String valueToString) {
        this.value = value;
        this.valueToString = valueToString;
    }

    /** contructor 2
    * @param value
    */
    Grade(double value) {
        this.value = value;
    }

    /** contructor 3
    * @param valueToString
    */
    Grade(String valueToString) {
        this.valueToString = valueToString;
    }

    /** returns value of grade */
    public double getValue() {
       return value;
    }

    /** returns value of grade also */
    public String getValueToString() {
       return valueToString;
    }

      /**
      * method to compute GPA that takes in ArrayList<Double>
      * @param array
      */
      public static double computeGPA( ArrayList<Double> array ) {
        double sum = 0;
        double array_size = array.size();

        for (Double i : array) {
          sum += i;
        }

        double gpa = sum/array_size;
        return gpa;
       }


       /**
       * method to compute GPA that takes in ArrayList<String>
       * @param array
       */
       public static double computeGPAstring( ArrayList<String> array ) {
         double sum = 0;
         double array_size = array.size();

         for (String i : array) {
            String grade = i.toString();

         }

         double gpa = sum/array_size;
         return gpa;
        }

        /** method for returning valueToString */
        public String toString(){

          return this.valueToString;

        }

}
