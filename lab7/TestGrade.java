import java.util.*;

public class TestGrade {

  public static void main(String[] args){

    //System.out.println(Who.APPLE.url());
    //System.out.println("List of grades: "+array);
    ArrayList<Double> grades = new ArrayList<Double>();
    grades.add(3.7);
    grades.add(3.3);
    grades.add(4.0);
    grades.add(2.3);

    System.out.println("List of grades: "+grades);

    double averageGPA = computeGPA( grades );
    
    System.out.println("Average GPA: "+averageGPA);

  }

}
