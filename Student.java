/**
 * Jaden Wong
 * SBU ID: 113469617
 * jaden.wong@stonybrook.edu
 * CSE 214.R02 Data Structures - Fall 2021
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Student implements Serializable {
    private String webID;
    private List<Course> courses;

    /**
     * Creates Student object
     * @param webId webid of Student object
     */
    public Student(String webId){
        this.webID = webId;
        this.courses = new ArrayList<Course>();

    }
    public String getWebID() {
        return webID;
    }

    public void setWebID(String webID) {
        this.webID = webID;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * returns courses sorted by Course
     * @return string
     */
    public String toStringCourse(){
        String out = "";
        List<Course> sort = courses;
        Collections.sort(sort, new CourseNameComparator());
        for(Course i : sort){
            out += i.toString();
        }
        return out;
    }
    /**
     * returns courses sorted by Semester
     * @return string
     */
    public String toStringSemester(){
        String out = "";
        List<Course> sort = courses;
        Collections.sort(sort, new SemesterComparator());
        for(Course i : sort){
            out += i.toString();
        }
        return out;


    }
}
