import java.util.*;

public class StudentCompletedCourses {
    private Map<String, List<String>> completedCourses;

    public StudentCompletedCourses() {
        completedCourses = new HashMap<>();

        // Nidhi's completed courses (Sem1-Sem2)
        completedCourses.put("NIDHI", Arrays.asList(
                "Introduction to Programming", "8", "Digital Circuits","9", "Human-Computer Interaction" , "10", "Linear Algebra","7", "Communication Skills","8" , // Sem 1
                "Data Structure and Algorithm", "10","Computer Organisation","6", "Probability and Statistics","8", "Money and Banking","9", "Foundations of Biology","7"  // Sem 2
        ));

        // Prajna's completed courses (Sem1-Sem4)
        completedCourses.put("PRAJNA", Arrays.asList(
                "Introduction to Programming","10", "Digital Circuits","7", "Human-Computer Interaction","8", "Linear Algebra", "9","Communication Skills", "7" , // Sem 1
                "Data Structure and Algorithm","8", "Computer Organisation","8", "Probability and Statistics", "9","Money and Banking","9", "Foundations of Biology", "10" ,// Sem 2
                "Operating System","8", "Advanced Programming","9", "Calculus", "8", "Cell Biology & Biochemistry","10" , "Genetics and Molecular Biology" , "8" , // Sem 3
                "Algorithm Design", "9","Fundamentals of Database Management Systems","8", "Basic Electronics","9", "Practical Bioinformatics", "8", "Introduction to Quantitative Biology" , "8"  // Sem 4
        ));

        // Rohit's completed courses (None yet as he is in first sem)
        completedCourses.put("ROHIT", new ArrayList<>());
    }

    public List<String> getCompletedCourses(String studentName) {
        return completedCourses.getOrDefault(studentName, new ArrayList<>());
    }
    public void updateCompletedCourses(String studentName, List<String> updatedCourses) {
        completedCourses.put(studentName, updatedCourses);
    }



}