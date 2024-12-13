import java.util.*;


public class Student extends HomePage
{
    private static final Map<String, StudentDetails> STUDENT_INFO = Map.of(
            "NIDHI", new StudentDetails(3, "CSD"),
            "PRAJNA", new StudentDetails(5, "CSB"),
            "ROHIT", new StudentDetails(1, "ECE")
    );

    private String name;
    private int semester;
    private String branch;
    private ComplaintsSystem complaintsSystem;
    private GiveFeedback<Object> feedbackS;
    private static final StudentExistingCourses studentExistingCourses = new StudentExistingCourses();



    public Student(ComplaintsSystem complaintsSystem) {
        super();
        this.complaintsSystem = complaintsSystem;
        this.feedbackS = GiveFeedback.getInstance();
    }

    public void StudentLogin() throws invalidLoginException
    {
        System.out.println("Enter your name: ");
        String name = s.nextLine();

        if (STUDENT_INFO.containsKey(name)) {
            this.name = name;
            StudentDetails details = STUDENT_INFO.get(name);
            this.semester = details.getSemester();
            this.branch = details.getBranch();
            System.out.println("Logged in as " + name + ". Semester: " + semester + ", Branch: " + branch);
            StudentPage();
        } else {
            throw new invalidLoginException("Invalid student name. Please try again.");
        }
    }

    public void StudentPage() {
        RegisterCourses registerCourses = new RegisterCourses();
        CourseCatalog catalog = new CourseCatalog();
        AvailableCourses availableCourses = new AvailableCourses(name, catalog);
        DropCourse dropCourse = new DropCourse();
        Schedule schedule = new Schedule(this.getName(), catalog);
        while (true) {
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for Courses");
            System.out.println("3. Check Schedule ");
            System.out.println("4. Drop Courses");
            System.out.println("5. Submit Complaints");
            System.out.println("6. Give Feedback for Courses");
            System.out.println("7. Logout");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    availableCourses.showCoursesStudent(semester);
                    break;
                case 2:
                    try {
                        Course register = registerCourses.registerForCourse(this, catalog);
                        if (register != null) {
                            System.out.println("you have registered for  " + register.getName());
                        }
                    } catch (fullCourseException e) {
                        System.out.println("error: " + e.getMessage());
                    }
                    break;
                case 3:
                    schedule.showWeeklySchedule(semester);
                    break;
                case 4:
                    try {
                        dropCourse.dropCourse(studentExistingCourses.getCoursesForStudent(this.getName()));
                    } catch (dropDeadlineException e) {
                        System.out.println("error: " + e.getMessage());
                    }
                    break;
                case 5:
                    complaintMenu();
                    break;
                case 6:
                    feedbackS.provide(this.name);
                    break;
                case 7:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Incorrect option. Try again. ");
            }
        }
    }

    public void submitComplaint(String description) {
        complaintsSystem.submitComplaint(description, this.getName());
    }

    public void viewComplaints() {
        complaintsSystem.viewComplaints(this.getName());
    }

    private void complaintMenu() {
        while (true) {
            System.out.println("1. Submit Complaints");
            System.out.println("2. View Complaints");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter your complaint description: ");
                    String description = s.nextLine();
                    submitComplaint(description);
                    break;
                case 2:
                    viewComplaints();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    public List<Course> getregisters() {
        return studentExistingCourses.getCoursesForStudent(this.getName());
    }



}
