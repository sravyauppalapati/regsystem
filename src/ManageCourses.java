import java.util.*;


public interface ManageCourses {
    Course registerForCourse(Student student, CourseCatalog catalog) throws fullCourseException;
    void viewRegisteredCredits(Student student);
    List<Course> getregistersForStudent(String studentName);
}