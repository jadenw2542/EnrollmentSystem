/**
 * Jaden Wong
 * SBU ID: 113469617
 * jaden.wong@stonybrook.edu
 * CSE 214.R02 Data Structures - Fall 2021
 */
import java.io.*;
import java.util.Comparator;

public class CourseNameComparator implements Comparator<Course>, Serializable {
    public CourseNameComparator(){
    }

    /**
     * compare two course names with the following priority: department and then number
     * @param left first course to compare
     * @param right second course to compare
     * @return  -1 if the left course name is “less” than the right course name, 0 if they are equal
     * , and 1 if the left course name is “greater” than the right course.
     */
    public int compare (Course left, Course right){
        String department1 = left.getDepartment();
        String department2 = right.getDepartment();
        int number1 = left.getNumber();
        int number2 = right.getNumber();

        if(department1.compareTo(department2) > 0){
            return 1;
        }
        if(department1.compareTo(department2) < 0){
            return -1;
        }
        else{
            if(number1 > number2){
                return 1;
            }
            if(number1 < number2){
                return -1;
            }
            else{
                return 0;
            }
        }
    }
}
