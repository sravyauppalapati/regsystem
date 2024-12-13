import java.util.*;

public class AvailableCourses {
    private final String name;
    private final CourseCatalog catalog;

    public AvailableCourses(String name, CourseCatalog catalog) {
        this.name = name;
        this.catalog = catalog;
    }

    public void showCoursesStudent(int semester) {
        List<Course> availableCourses = catalog.getCoursesForSemester(semester);
        if (availableCourses.isEmpty()) {
            System.out.println("sorry , no available courses this sem");
            return;
        }

        System.out.println("available courses for " + name + ":");
        for (Course course : availableCourses) {
            course.displayCourse();
        }
    }
}