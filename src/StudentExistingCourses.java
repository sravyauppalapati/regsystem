import java.util.*;


public class StudentExistingCourses {
    private Map<String, List<Course>> studentCourses;

    public StudentExistingCourses()
    {
        studentCourses = new HashMap<>();
        initializeStudentCourses();
    }

    private void initializeStudentCourses() {
        // Courses for Prajna (5th semester)
        studentCourses.put("PRAJNA", Arrays.asList(
                new Course("Computer Networks", "CN", "Dr. Kelly", 4, "AP", "Tuesday 5PM-6:30PM"),
                new Course("Algorithms in Bioinformatics", "AB", "Dr. Nishat Singh", 4, "GMB", "Monday and Wednesday 8:30AM-10AM"),
                new Course("Algorithms in Computational Biology", "ACB", "Dr. VS Sindhu", 4, "CBB", "Thursday 5PM-6:30PM"),
                new Course("Technical Communication + Environmental Studies", "TCES", "Dr. John", 4, "None", "Friday 10:30AM-12PM"),
                new Course("Engineering Economics", "EE", "Dr. Ankit Jain", 4, "None", "Thursday 11AM - 12PM")
        ));

        // Courses for Nidhi (3rd semester)
        studentCourses.put("NIDHI", Arrays.asList(
                new Course("Operating System", "OS", "Dr. Nilesh Kumar", 4, "DC, CO", "Tuesday & Thursday 3PM-4:30PM"),
                new Course("Advanced Programming", "AP", "Dr. Anil Mehta", 4, "IP", "Monday and Wednesday 3PM-4:30PM"),
                new Course("Calculus", "M-III", "Dr. Ashutosh", 4, "LA", "Tuesday and Thursday 4:30PM - 6PM"),
                new Course("Cell Biology & Biochemistry", "CBB", "Dr Pragnya", 4, "FOB", "Monday and Wednesday 9AM-11AM"),
                new Course("Genetics and Molecular Biology", "GMB", "Dr Gaurav", 4, "FOB", "Friday 11AM-1PM")
        ));

        // Courses for Rohit (1st semester)
        studentCourses.put("ROHIT", Arrays.asList(
                new Course("Introduction to Programming", "IP", "Dr Shad Akhthar", 4, "None", "Mon-Tue 8AM-9:30AM"),
                new Course("Digital Circuits", "DC", "Dr. Sajjad", 4, "None", "Wed-Thu 8AM-9:30AM"),
                new Course("Human-Computer Interaction", "HCI", "Dr Sonal Kapoor", 4, "None", "Monday and Wednesday 11AM-12PM"),
                new Course("Linear Algebra", "LA", "Dr Abhishek", 4, "None", "Wednesday and Thursday 11AM-12PM"),
                new Course("Communication Skills", "COM", "Dr Shobith", 4, "None", "Friday 10AM-12PM")
        ));
    }

    public List<Course> getCoursesForStudent(String studentName) {
        return studentCourses.getOrDefault(studentName, new ArrayList<>());
    }
}