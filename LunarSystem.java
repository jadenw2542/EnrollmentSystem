/**
 * Jaden Wong
 * SBU ID: 113469617
 * jaden.wong@stonybrook.edu
 * CSE 214.R02 Data Structures - Fall 2021
 */
import java.io.*;
import java.util.*;
public class LunarSystem {
    private static HashMap<String, Student> database;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        database = new HashMap<String, Student>();
        Boolean quit = true;
        try {
            FileInputStream fileIn = new FileInputStream("database.obj");
            ObjectInputStream inStream = new ObjectInputStream(fileIn);
            database = (HashMap<String,Student>)inStream.readObject();
            inStream.close();
            System.out.println("Previous data loaded");
        }catch (FileNotFoundException e){
            System.out.println("Previous file not found");
        }catch (Exception f){
            System.out.print("");
        }

        while(quit) {
            printMenu1();
            System.out.println("Please select an option");
            String option1 = in.nextLine().toUpperCase(Locale.ROOT);
            switch (option1) {
                case ("L"):
                    System.out.println("Please enter webid:");
                    String webid = in.nextLine();

                    if (webid.equalsIgnoreCase("REGISTRAR")) {
                        Boolean loggedIn = true;
                        System.out.println("Welcome " + webid);
                        while (loggedIn) {
                            printMenu2();
                            System.out.println("Please select an option");
                            String option2 = in.nextLine().toUpperCase(Locale.ROOT);
                            switch (option2) {
                                case ("R"):
                                    System.out.println("Please enter a webid for the new student: ");
                                    String webidStudentRegister = in.nextLine();
                                    Boolean webidExist = false;

                                    Iterator entries = database.entrySet().iterator();
                                    while (entries.hasNext()) {
                                        Map.Entry entry = (Map.Entry) entries.next();
                                        String key = (String) entry.getKey();
                                        Student value = (Student) entry.getValue();

                                        if (key.equalsIgnoreCase(webidStudentRegister)) {
                                            System.out.println(webidStudentRegister + " is already registered.");
                                            webidExist = true;
                                            break;
                                        }
                                    }
                                    if (!(webidExist)) {
                                        database.put(webidStudentRegister, new Student(webidStudentRegister));
                                    }
                                    break;
                                case ("D"):
                                    System.out.println("Please enter a webid for the student to be deregistered: ");
                                    String webidStudentDeregister = in.nextLine();
                                    String student = "";
                                    Iterator entries4 = database.entrySet().iterator();
                                    while (entries4.hasNext()) {
                                        Map.Entry entry = (Map.Entry) entries4.next();
                                        String key = (String) entry.getKey();
                                        Student value = (Student) entry.getValue();
                                        if(key.equalsIgnoreCase(webidStudentDeregister)){
                                            student = key;
                                        }
                                    }
                                    Boolean dereg = false;
                                    Iterator entries1 = database.entrySet().iterator();
                                    while (entries1.hasNext()) {
                                        Map.Entry entry = (Map.Entry) entries1.next();
                                        String key = (String) entry.getKey();
                                        Student value = (Student) entry.getValue();

                                        if (key.equalsIgnoreCase(student)) {
                                            database.remove(student);
                                            System.out.println(student + " deregistered");
                                            dereg = true;
                                            break;
                                        }
                                    }
                                    if (!(dereg)) {
                                        System.out.println(webidStudentDeregister + " does not exist");
                                    }
                                    break;
                                case ("E"):
                                    String out = "";
                                    System.out.println("Please enter course:");
                                    String courseNameDelIn = in.nextLine(); // "CSE 214"
                                    String courseNameDel = courseNameDelIn.substring(0, courseNameDelIn.indexOf(" "));
                                    int courseNumDel = Integer.parseInt(courseNameDelIn.substring(courseNameDelIn.indexOf(" ") + 1));
                                    Iterator entries2 = database.entrySet().iterator();
                                    while (entries2.hasNext()) {
                                        Map.Entry entry = (Map.Entry) entries2.next();
                                        String key = (String) entry.getKey();
                                        Student value = (Student) entry.getValue();

                                        for (int i = 0; i < database.get(key).getCourses().size(); i++) {
                                            if (database.get(key).getCourses().get(i).equalsCourse(courseNameDel, courseNumDel)) {
                                                out += String.format("%-11s%-11s\n", database.get(key).getWebID(), database.get(key).getCourses().get(i).getSemester());
                                            }
                                        }
                                    }
                                    System.out.print("Student    Semester\n" + "-------------------\n");
                                    System.out.println(out);
                                    break;
                                case ("L"):
                                    System.out.println(webid + " logged out.");
                                    loggedIn = false;
                                    break;

                                default:
                                    System.out.println("Invalid choice");
                                    break;
                            }
                        }
                    }

                    else {

                        String student = "";
                        Iterator entries4 = database.entrySet().iterator();
                        while (entries4.hasNext()) {
                            Map.Entry entry = (Map.Entry) entries4.next();
                            String key = (String) entry.getKey();
                            Student value = (Student) entry.getValue();
                            if(key.equalsIgnoreCase(webid)){
                                student = key;
                            }
                        }
                        if (student.equalsIgnoreCase("")) {
                            System.out.println(webid + " does not exist");
                            break;
                        }

                        Boolean loggedIn = true;
                        System.out.println("Welcome " + student);
                        while (loggedIn) {
                                printMenu3();
                                System.out.println("Please select an option:");
                                String option3 = in.nextLine().toUpperCase(Locale.ROOT);
                                switch (option3) {
                                    case ("A"):
                                        System.out.println("Please enter course name:");
                                        String courseNameIn = in.nextLine(); // "CSE 214"
                                        System.out.println("Please select a semester:");
                                        String semester = in.nextLine();
                                        String courseName = courseNameIn.substring(0, courseNameIn.indexOf(" "));
                                        int courseNum = Integer.parseInt(courseNameIn.substring(courseNameIn.indexOf(" ") + 1));
                                        database.get(student).getCourses().add(new Course(courseName, courseNum, semester));
                                        System.out.println(courseNameIn + " added in " + semester);
                                        break;
                                    case ("D"):
                                        System.out.println("Please enter course name:");
                                        String courseNameDelIn = in.nextLine(); // "CSE 214"
                                        String courseNameDel = courseNameDelIn.substring(0, courseNameDelIn.indexOf(" "));
                                        int courseNumDel = Integer.parseInt(courseNameDelIn.substring(courseNameDelIn.indexOf(" ") + 1));
                                        boolean removed = false;
                                        String semesterRemoved = "";
                                        for(int i = 0; i < database.get(student).getCourses().size(); i++){
                                            if(database.get(student).getCourses().get(i).equalsCourse(courseNameDel, courseNumDel)){
                                                semesterRemoved = database.get(student).getCourses().get(i).getSemester();
                                                database.get(student).getCourses().remove(i);
                                                removed = true;
                                            }
                                        }
                                        if(removed) {
                                            System.out.println(courseNameDelIn + " dropped from " + semesterRemoved);
                                        }else{
                                            System.out.println("Class not found");
                                        }
                                        break;
                                    case ("C"):
                                        System.out.print("Dept. Course Semester\n-------------------------------\n");
                                        System.out.print(database.get(student).toStringCourse());
                                        break;
                                    case ("S"):
                                        System.out.print("Dept. Course Semester\n-------------------------------\n");
                                        System.out.print(database.get(student).toStringSemester());
                                        break;
                                    case("L"):
                                        System.out.println(student + " logged out.");
                                        loggedIn = false;
                                        break;
                                    default:
                                        System.out.println("Invalid choice");
                                        break;
                                }
                            }
                    }
                    break;

                case ("X"): //X)Save state and quit
                    quit = false;
                    ObjectOutputStream outStream;
                    FileOutputStream file;
                    try {
                        file = new FileOutputStream("database.obj");
                        outStream = new ObjectOutputStream(file);
                        outStream.writeObject(database);
                        outStream.close();
                    }catch (FileNotFoundException e){
                        System.out.println("File not found");
                    }catch (Exception e){
                        System.out.println("erorr");
                    }
                    break;
                case ("Q"): //Q)Quit without saving state.
                    quit = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        }

       /**
        Iterator entries = database.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            String key = (String) entry.getKey();
            Student value = (Student) entry.getValue();
            System.out.println(key + " " + value)
        **/
    }

    public static void printMenu1() {
        System.out.println("Menu:\n" +
                "    L)Login(REGISTRAR for admin)\n" +
                "    X)Save state and quit\n" +
                "    Q)Quit without saving state."
        );
    }

    public static void printMenu2() {
        System.out.println("Options:\n" +
                "     R) Register a student\n" +
                "     D) De-register a student\n" +
                "     E) View course enrollment\n" +
                "     L) Logout");
    }

    public static void printMenu3() {
        System.out.println("Options:\n" +
                "    A)Add a class\n" +
                "    D)Drop a class\n" +
                "    C)View your classes sorted by course name/department\n" +
                "    S)View your courses sorted by semester\n" +
                "    L) Logout");
    }
}
