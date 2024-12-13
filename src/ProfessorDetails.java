import java.util.*;

public class ProfessorDetails {
    private List<ProfCourse> managedCourses;
    private List<String> enrolledStudents;

    public ProfessorDetails(List<ProfCourse> managedCourses, List<String> enrolledStudents)
    {
        this.managedCourses = managedCourses;
        this.enrolledStudents = enrolledStudents;
    }

    public List<ProfCourse> getManagedCourses() {
        return managedCourses;
    }

    public List<String> getEnrolledStudents() {
        return enrolledStudents;
    }
}