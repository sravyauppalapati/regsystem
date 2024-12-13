import java.util.*;

public class RegisterCourses implements ManageCourses
{
    private static final int cLiMIT = 20;
    private static final int cCapacity = 50;
    private static Map<String, List<Course>> studentregisters = new HashMap<>();
    private static Map<String, Integer> courseEnrollment = new HashMap<>();

    public RegisterCourses()
    {
        //hardcored courses with their enrolled number of students
        courseEnrollment.put("CyberSecurity", 0);
        courseEnrollment.put("Computer Networks", 50);
        courseEnrollment.put("Operating System", 50);
        courseEnrollment.put("Advanced Programming", 25);
        courseEnrollment.put("Calculus", 20);
        courseEnrollment.put("Cell Biology & Biochemistry", 15);
        courseEnrollment.put("Genetics and Molecular Biology", 10);
        courseEnrollment.put("Personal Finance", 5);
        courseEnrollment.put("Algorithms in Bioinformatics", 35);
        courseEnrollment.put("Algorithms in Computational Biology", 40);
        courseEnrollment.put("Technical Communication + Environmental Studies", 45);
        courseEnrollment.put("Engineering Economics", 30);
    }

    @Override
    public Course registerForCourse(Student student, CourseCatalog catalog) throws fullCourseException //it throws coursefullexcept
    {
        Scanner s = new Scanner(System.in);

        System.out.println("Available courses for Semester " + student.getSemester() + ":");
        List<Course> availableCourses = catalog.getCoursesForSemester(student.getSemester());

        for (int i = 0; i < availableCourses.size(); i++) {
            Course course = availableCourses.get(i);
            int enrolled = courseEnrollment.getOrDefault(course.getName(), 0);
            System.out.println((i + 1) + ". " + course.getName() + ", Credits: " + course.getCredits() + ", Prerequisite: " + course.getPrerequisite() + ", Enrolled: " + enrolled + "/" + cCapacity);
        }

        System.out.print("Enter the number of the course you want to register for: ");
        int courseChoice = s.nextInt();
        s.nextLine();

        if (courseChoice > 0 && courseChoice <= availableCourses.size()) {
            Course selectedCourse = availableCourses.get(courseChoice - 1);

            int cEnrollment = courseEnrollment.getOrDefault(selectedCourse.getName(), 0);
            if (cEnrollment >= cCapacity) {
                throw new fullCourseException("the course you have " + selectedCourse.getName() + " is already full (50/50 students).");
            }

            if (checkPrerequisite(student, selectedCourse))
            {
                int totalRegCredits = getTotalRegCredits(student);
                if (totalRegCredits + selectedCourse.getCredits() <= cLiMIT) {
                    System.out.println("you have you have sucessfully registered for  " + selectedCourse.getName());
                    addCourse(student.getName(), selectedCourse);
                    courseEnrollment.put(selectedCourse.getName(), cEnrollment + 1);
                    viewRegisteredCredits(student);
                    return selectedCourse;
                } else {
                    System.out.println("You have exceeded the credit limit of " + cLiMIT + " credits.");
                }
            } else {
                System.out.println("sorry, you do not meet the prerequisite for this course.");
            }
        } else {
            System.out.println("invalid course");
        }
        return null;
    }


    @Override
    public void viewRegisteredCredits(Student student) {
        int totalRegCredits = getTotalRegCredits(student);
        System.out.println("Total registered credits: " + totalRegCredits + "/" + cLiMIT);
    }

    @Override
    public List<Course> getregistersForStudent(String studentName)
    {
        return studentregisters.getOrDefault(studentName, new ArrayList<>());
    }

    private void addCourse(String studentName, Course course)
    {
        studentregisters.computeIfAbsent(studentName, k -> new ArrayList<>()).add(course);
    }

    private int getTotalRegCredits(Student student)
    {
        return studentregisters.getOrDefault(student.getName(), new ArrayList<>()).stream().mapToInt(Course::getCredits).sum();
    }

    private boolean checkPrerequisite(Student student, Course course) {
        String prerequisite = course.getPrerequisite();

        if (prerequisite.equals("None"))
        {
            return true;
        }

        System.out.println(prerequisite);
        return true;
    }
}
