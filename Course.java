/**
 * Jaden Wong
 * SBU ID: 113469617
 * jaden.wong@stonybrook.edu
 * CSE 214.R02 Data Structures - Fall 2021
 */
import java.io.*;
public class Course implements Serializable{
    private String department;
    private int number;
    private String semester;

    /**
     * Creates course object
     * @param department department of course
     * @param number Course #
     * @param semester semester that course is being taken in
     */
    public Course(String department, int number, String semester) {
        this.department = department;
        this.number = number;
        this.semester = semester;

    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getSemester() {
        return semester;
    }
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * returns a string of all the courses private variables
     * @return string
     */
    public String toString(){
        String out = "";
        out = String.format("%-6s%-6d%-6s\n", department, number, semester);
        return out;
    }

    /**
     * returns true if the department and number is the same
     * @param department to be compared
     * @param number to be compared
     * @return true or false
     */
    public Boolean equalsCourse(String department, int number){
        if((this.department.equalsIgnoreCase(department)) && (this.number == number) ){
            return true;
        }
        return false;
    }
}

