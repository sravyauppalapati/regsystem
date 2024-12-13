import java.util.*;

public class AcadProgress {
    private StudentCompletedCourses completedCourses;

    public AcadProgress(StudentCompletedCourses completedCourses) {
        this.completedCourses = completedCourses;
    }

    public void showAcademicProgress(String studentName) {
        List<String> courses = completedCourses.getCompletedCourses(studentName);
        if (courses.isEmpty()) {
            System.out.println("No completed courses found for " + studentName);
            return;
        }

        int semester = 1;
        int coursesPerSemester = 5;
        int index = 0;

        System.out.println("Academic Progress for " + studentName + ":");

        while (index < courses.size()) {
            System.out.println("\nSemester " + semester + ":");

            // displays courses for the semester
            for (int i = 0; i < coursesPerSemester && index < courses.size(); i++)
            {
                System.out.println("- " + courses.get(index));
                index++;
            }

            if (index + 1 < courses.size()) {
                System.out.println("SGPA: " + courses.get(index));
                System.out.println("CGPA: " + courses.get(index + 1));
                index += 2;
            }

            semester++;
        }
    }
}