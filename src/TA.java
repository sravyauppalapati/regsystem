import java.util.*;

public class TA extends Student //the name of the ta is RAJ
//HARCORED TA
{
    private static final String taName = "RAJ";
    private List<Course> assisitedC;
    private Map<String, Map<String, Integer>> cGrades;

    public TA(ComplaintsSystem complaintsSystem)
    {
        super(complaintsSystem);
        this.assisitedC = new ArrayList<>();
        this.cGrades = new HashMap<>();
        iassisitedC();
        iCourseGrade();
    }

    private void iassisitedC()
    {
        assisitedC.add(new Course("Operating System", "OS", "Dr. Nilesh Kumar", 4, "DC, CO", "Tuesday & Thursday 3PM-4:30PM"));
        assisitedC.add(new Course("Introduction to Programming", "IP", "Dr Shad Akhthar", 4, "None", "Mon-Tue 8AM-9:30AM"));
    }

    private void iCourseGrade()
    {
        Map<String, Integer> osG = new HashMap<>();
        osG.put("NIDHI", 60);
        cGrades.put("Operating System", osG);

        Map<String, Integer> ipG = new HashMap<>();
        ipG.put("ROHIT", 90);
        cGrades.put("Introduction to Programming", ipG);
    }

    public void TALogin() throws invalidLoginException //thorws exception if invalid name written
    {
        System.out.println("enter your name: ");
        String name = s.nextLine();

        if (name.equalsIgnoreCase(taName))
        {
            System.out.println("logged in as" + taName);
            taP();
        } else {
            throw new invalidLoginException("name is not recognized , try again.");
        }
    }

    @Override
    public String toString() //string object class
    {
        return "TA" + taName + "\nAssisted Courses: " + assisitedC.size() +"\nCourses: " + assisitedC.stream().map(Course::getName).reduce((a, b) -> a + ", " + b).orElse("None");
    }

    @Override
    public boolean equals(Object obj) //using the equal object class
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        TA other = (TA) obj;
        return taName.equals(other.taName) && Objects.equals(assisitedC, other.assisitedC) && Objects.equals(cGrades, other.cGrades);
    }

    @Override
    public int hashCode() //using hash object class
    {
        return Objects.hash(super.hashCode(), taName, assisitedC, cGrades);
    }

    private void taP()
    {
        while (true) {
            System.out.println("\nTA Menu:");
            System.out.println("1. view ta Assisted Courses");
            System.out.println("2. manage student grades");
            System.out.println("3. acess student function");
            System.out.println("4. display the TA info");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();
            s.nextLine();

            switch (choice)
            {
                case 1:
                    assistedC();
                    break;
                case 2:
                    manageSgrade();
                    break;
                case 3:
                    super.StudentPage();
                    break;
                case 4:
                    System.out.println(this);
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void assistedC()
    {
        if (assisitedC.isEmpty()) {
            System.out.println("not assisiting courses currently ");
        } else {
            System.out.println("courses you are assisting:");
            for (Course course : assisitedC)
            {
                System.out.println(course.getName());
            }
        }
    }

    private void manageSgrade()
    {
        while (true) {
            System.out.println("\nManage Student Grades:");
            System.out.println("1. Operating System");
            System.out.println("2. Introduction to Programming");
            System.out.println("3. Return back");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    manage("Operating System", "NIDHI");
                    break;
                case 2:
                    manage("Introduction to Programming", "ROHIT");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void manage(String courseName, String studentName)
    {
        Map<String, Integer> grades = cGrades.get(courseName);
        if (grades == null || !grades.containsKey(studentName)) {
            System.out.println("grade not available for " + studentName + " in " + courseName);
            return;
        }

        int currGrade = grades.get(studentName);
        System.out.println(studentName + "'s current grade in " + courseName + ": " + currGrade);

        System.out.print("do you want to changethis grade? (Y/N): ");
        String response = s.nextLine().trim().toUpperCase();
        if (response.equals("Y")) {
            System.out.print("enter new grade for " + studentName + ": ");
            int newGrade = s.nextInt();
            s.nextLine();
            grades.put(studentName, newGrade);
            System.out.println("grade has been updated");
        }
    }
}