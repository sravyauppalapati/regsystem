import java.util.*;

public class Schedule extends CourseCatalog
{
    private String studentName;
    private CourseCatalog catalog;

    public Schedule(String studentName, CourseCatalog catalog) {
        this.studentName = studentName;
        this.catalog = catalog;
    }

    public void showWeeklySchedule(int semester) {
        List<Course> coursesForSemester = catalog.getCoursesForSemester(semester);
        if (coursesForSemester.isEmpty()) {
            System.out.println(studentName + " has no courses registered for Semester " + semester + ".");
            return;
        }

        System.out.println("Weekly Schedule for " + studentName + " (Semester " + semester + ") held at Old Academic Building:");
        for (Course course : coursesForSemester) {
            course.displayCourse();
            System.out.println("Location: Old Academic Building");
        }
    }
}