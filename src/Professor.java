import java.util.*;

public class Professor extends HomePage
{
    private static final Map<String, ProfessorDetails> PROFESSOR_INFO = Map.of(
            "Dr Shobith", new ProfessorDetails(
                    Arrays.asList(
                            new ProfCourse("Operating System", "Basic OS concepts", "Tuesday & Thursday 3PM-4:30PM", 4, "None", 50, "Monday 2PM-3PM"),
                            new ProfCourse("Design Drawing", "Introduction to Design", "Monday and Wednesday 9:30AM - 11AM", 4, "None", 50, "Wednesday 3PM-4PM")
                    ),
                    Arrays.asList("NIDHI", "PRAJNA")
            ),
            "Dr Abhishek", new ProfessorDetails(
                    Arrays.asList(
                            new ProfCourse("Advanced Programming", "Advanced concepts in programming", "Monday and Wednesday 3PM - 4:30PM", 4, "IP", 50, "Monday 5PM-6PM"),
                            new ProfCourse("Computer Networks", "Network protocols and design", "Tuesday 5PM - 6:30PM", 4, "None", 50, "Thursday 3PM-4PM")
                    ),
                    Arrays.asList("ROHIT", "PRAJNA")
            )
    );

    private String name;
    private List<ProfCourse> managedCourses;
    private List<String> enrolledStudents;
    private String expertise;
    private boolean available;
    private GiveFeedback<Object> feedbackS;

    public Professor(String name, String expertise, boolean available) {
        this.name = name;
        this.expertise = expertise;
        this.available = available;
        this.feedbackS = GiveFeedback.getInstance();
    }

    public String getName() { return name; }
    public String getExpertise() { return expertise; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public void ProfessorLogin() throws invalidLoginException //if prof eneters wrong credential
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your name (Dr Shobith/Dr Abhishek): ");
        String name = s.nextLine();

        if (PROFESSOR_INFO.containsKey(name))
        {
            this.name = name;
            ProfessorDetails details = PROFESSOR_INFO.get(name);
            this.managedCourses = details.getManagedCourses();
            this.enrolledStudents = details.getEnrolledStudents();
            System.out.println("Logged in as " + name);
            enterProfessorMode();
        } else {
            throw new invalidLoginException("Professor not recognized. Please try again.");
        }
    }

    public void enterProfessorMode() {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Professor Mode:");
            System.out.println("1. Manage Courses");
            System.out.println("2. View Enrolled Students");
            System.out.println("3. View Feedback ");

            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    manageCourses();
                    break;
                case 2:
                    viewEnrolledStudents();
                    break;
                case 3:
                    view();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private void view() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter course name to view feedback:");
        String courseName = s.nextLine();
        feedbackS.view(courseName, this.name, PROFESSOR_INFO);
    }



    private void manageCourses() {
        Scanner s = new Scanner(System.in);
        System.out.println("Managing Courses for " + name + ":");
        for (ProfCourse course : managedCourses) {
            System.out.println(course);
        }

        System.out.println("Enter 'u' to update an existing course, or any other key to go back.");
        String action = s.nextLine();

        if (action.equals("u")) {
            System.out.println("Enter the name of the course to update:");
            String courseToUpdate = s.nextLine();
            ProfCourse course = findCourseByName(courseToUpdate);

            if (course != null) {
                updateCourseDetails(course);
            } else {
                System.out.println("Course not found.");
            }
        } else {
            System.out.println("Returning to Professor Mode...");
        }
    }

    private ProfCourse findCourseByName(String courseName) {
        for (ProfCourse course : managedCourses) {
            if (course.getName().equalsIgnoreCase(courseName)) {
                return course;
            }
        }
        return null;
    }

    private void updateCourseDetails(ProfCourse course) {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Update Course Details:");
            System.out.println("1. Update Syllabus");
            System.out.println("2. Update Class Timings");
            System.out.println("3. Update Credits");
            System.out.println("4. Update Prerequisites");
            System.out.println("5. Update Enrollment Limit");
            System.out.println("6. Update Office Hours");
            System.out.println("7. Return to Manage Courses");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the new syllabus:");
                    String syllabus = s.nextLine();
                    course.setSyllabus(syllabus);
                    System.out.println("Syllabus updated.");
                    break;
                case 2:
                    System.out.println("Enter the new class timings:");
                    String classTimings = s.nextLine();
                    course.setClassTimings(classTimings);
                    System.out.println("Class timings updated.");
                    break;
                case 3:
                    System.out.println("Enter the new credits:");
                    int credits = s.nextInt();
                    s.nextLine();
                    course.setCredits(credits);
                    System.out.println("Credits updated.");
                    break;
                case 4:
                    System.out.println("Enter the new prerequisites:");
                    String prerequisites = s.nextLine();
                    course.setPrerequisites(prerequisites);
                    System.out.println("Prerequisites updated.");
                    break;
                case 5:
                    System.out.println("Enter the new enrollment limit:");
                    int enrollmentLimit = s.nextInt();
                    s.nextLine();
                    course.setEnrollmentLimit(enrollmentLimit);
                    System.out.println("Enrollment limit updated.");
                    break;
                case 6:
                    System.out.println("Enter the new office hours:");
                    String officeHours = s.nextLine();
                    course.setOfficeHours(officeHours);
                    System.out.println("Office hours updated.");
                    break;
                case 7:
                    System.out.println("Returning to Manage Courses...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private void viewEnrolledStudents() {
        System.out.println("Students enrolled under " + name + ":");
        for (String student : enrolledStudents) {
            System.out.println("- " + student);
        }
    }
}