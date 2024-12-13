import java.util.*;


public class CourseCatalog {
    private Map<Integer, List<Course>> courseMap = new HashMap<>();

    public CourseCatalog() { //sem 1 courses
        List<Course> sem1Courses = Arrays.asList(
                new Course("Introduction to Programming", "IP", "Dr Shad Akhthar", 4, "None", "Mon-Tue 8AM-9:30AM"),
                new Course("Digital Circuits", "DC", "Dr. Sajjad", 4, "None", "Wed-Thu 8AM-9:30AM"),
                new Course("Human-Computer Interaction", "HCI" , "Dr Sonal Kapoor" , 4 ,  "None" , "Monday and Wednesday 11AM-12PM "),
                new Course("Linear Algebra", "LA", "Dr Abhishek", 4, "None", "Wednesday and Thursday 11AM-12PM"),
                new Course("Communication Skills", "COM", "Dr Shobith", 4, "None", "Friday 10AM-12PM")

        );

        List<Course> sem2Courses = Arrays.asList( //sem2 courses
                new Course("Data Structure and Algorithm", "DSA", "Dr David", 4, "IP", "Mon-Wed 9:30AM - 11AM"),
                new Course("Computer Organisation", "CO", "Dr Tammam", 4, "DC", "Tue-Thu 9:30AM-10:30AM"),
                new Course("Probability and Statistics", "PNS", "Dr Sanjit Kaul", 4, "None", "Tuesday and Thursday 3PM-4:30PM"),
                new Course("Money and Banking", "MNB", "Dr Syed", 4, "None", "9:30AM-11AM"),
                new Course("Foundations of Biology", "FOB", "Dr Siddharth", 4, "None", "Friday 11AM-12:30PM"),
                new Course("Ecology ", "ECO" , "Dr. Shahid" , 4 , "None" , "Friday 9AM-11AM "),
                new Course("Anthroplogy " , "ATR" , "Dr, Nandan " , 4 , "None " , "Wednesday 1PM-3PM")
        );

        List<Course> sem3Courses = new ArrayList<>(Arrays.asList(//sem 3
                new Course("Operating System", "OS", "Dr. Nilesh Kumar", 4, "DC, CO", "Tuesday & Thursday 3PM-4:30PM"),
                new Course("Advanced Programming", "AP", "Dr. Anil Mehta", 4, "IP", "Monday and Wednesday 3PM-4:30PM"),
                new Course("Calculus", "M-III", "Dr. Ashutosh", 4, "LA", "Tuesday and Thursday 4:30PM - 6PM"),
                new Course("Cell Biology & Biochemistry", "CBB", "Dr Pragnya", 4, "FOB", "Monday and Wednesday 9AM-11AM"),
                new Course("Genetics and Molecular Biology", "GMB", "Dr Gaurav", 4, "FOB", "Friday 11AM-1PM"),
                new Course("Personal Finance " , "PF" , "Dr Ramani " , 4 , "MNB" , "Friday 1PM-3PM")

        ));
        List<Course> sem4Courses = new ArrayList<>(Arrays.asList( //sem 4
                new Course("Algorithm Design (B)", "AD", "Dr Rohit", 4, "DSA", "Tuesday & Thursday 3PM-4:30PM"),
                new Course("Fundamentals of Database Management Systems", "FDMS", "Dr Saurabh", 4, "AP", "Friday 11AM - 1PM"),
                new Course("Basic Electronics", "BE", "Dr Tammam", 4, "CO", "Monday and Wednesday 8:30AM - 10:30AM"),
                new Course("Practical Bioinformatics", "PB", "Dr Ratna", 4, "GMB", "Tuesday and Thursday 9:30AM - 11AM"),
                new Course("Introduction to Quantitative Biology", "IQB", "Dr Saketh", 4, "CBB", "Friday 3PM - 5PM"),
                new Course("Journalism " , "JM" , "Dr Sreenivasu " , 4 , "None " , "Saturday 5PM-6PM")
        ));
        List<Course> sem5Courses = new ArrayList<>(Arrays.asList(//sem 5
                new Course("Computer Networks", "CN", "Dr. Kelly", 4, "AP", "Tuesday 5PM-6:30PM"),
                new Course("Algorithms in Bioinformatics", "AB", "Dr. Nishat Singh", 4, "GMB", "Monday and Wednesday 8:30AM-10AM"),
                new Course("Algorithms in Computational Biology", "ACB", "Dr. VS Sindhu", 4, "CBB", "Thursday 5PM-6:30PM"),
                new Course("Technical Communication + Environmental Studies", "TCES", "Dr. John", 4, "None", "Friday 10:30AM-12PM"),
                new Course("Engineering Economics", "EE", "Dr. Ankit Jain", 4, "None", "Thursday 11AM - 12PM"),
                new Course("CyberSecurity " , "CST" , "Dr. Anirudh " , 4 , "IP" ," Saturday 6PM-7PM" )
        ));


        courseMap.put(1, sem1Courses);
        courseMap.put(2, sem2Courses);
        courseMap.put(3, sem3Courses);
        courseMap.put(4, sem4Courses);
        courseMap.put(5, sem5Courses);

    }

    public List<Course> getCoursesForSemester(int semester)

    {
        return courseMap.getOrDefault(semester, new ArrayList<>());
    }
}
