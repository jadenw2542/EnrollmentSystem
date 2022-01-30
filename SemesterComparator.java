/**
 * Jaden Wong
 * SBU ID: 113469617
 * jaden.wong@stonybrook.edu
 * CSE 214.R02 Data Structures - Fall 2021
 */
import java.io.*;
import java.util.Comparator;

public class SemesterComparator implements Comparator<Course>, Serializable{
    /**
     * compare two courses based on the semester they were offered
     * @param left left course to compare
     * @param right right course to compare
     * @return -1 if the left course’s semester is less than the right, 0 if the semesters are equal, and 1 if the left’s semester is greater than the right.
     */
    public int compare(Course left, Course right){
        String semester1 = left.getSemester(); 
        String semester2 = right.getSemester();

        String season1 = semester1.substring(0,1);
        String season2 = semester2.substring(0,1);

        int year1 = Integer.parseInt(semester1.substring(1));
        int year2 = Integer.parseInt(semester2.substring(1));

        if(year1 > year2){
                return 1;
        }
        if(year1 < year2){
                return -1;
        }
        else {
            if (season1.compareTo(season2) > 0) {
                return 1;
            }
            if (season1.compareTo(season2) < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
