import java.util.*;

public class Administrator extends Administer
{
    private static final String AdminPassword = "123123";
    Scanner s = new Scanner(System.in);
    private CourseCatalog courseCatalog = new CourseCatalog();
    private StudentCompletedCourses studentCompletedCourses = new StudentCompletedCourses();
    private Map<String, Professor> professors = new HashMap<>();
    private ComplaintsSystem complaintsSystem;
    public Administrator() {
        this.courseCatalog = new CourseCatalog();
        initializeProfessors();
    }

    public Administrator(CourseCatalog courseCatalog) {
        this.courseCatalog = courseCatalog;
        initializeProfessors();
    }
    public Administrator(CourseCatalog courseCatalog, ComplaintsSystem complaintsSystem) {
        this.courseCatalog = courseCatalog;
        this.complaintsSystem = complaintsSystem;
    }

    private void initializeProfessors() {
        professors.put("Dr. Ananada", new Professor("Dr. Ananda", "CyberSecurity", true));
        professors.put("Dr. Venkata", new Professor("Dr. Venkata", "Calculus", false));
        professors.put("Dr. Neelam", new Professor("Dr. Neelam", "Economics", true));
        professors.put("Dr. Shubham", new Professor("Dr. Shubham", "Biology", true));
        professors.put("Dr. Krishna", new Professor("Dr. Krishna", "OOPS", false));
    }




    @Override
    public void AdministratorLogin() {
        System.out.println("Enter Administrator Password: ");
        String pass = s.nextLine();
        if (pass.equals(AdminPassword)) {
            System.out.println("Administrator logged in Successfully");
            showAdminMenu();
        } else {
            System.out.println("Invalid Password. Please Retry.");
        }
    }

    public void showAdminMenu() {
        boolean running = true;
        while (running) {
            System.out.println("Administrator Menu:");
            System.out.println("1. Manage Course Catalog");
            System.out.println("2. Manage Student Records");
            System.out.println("3. Assign Professors to Courses");
            System.out.println("4. Handle Complaints");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    manageCourseCatalog();
                    break;
                case 2:
                    manageStudentRecords();
                    break;
                case 3:
                    assignProfessorsToCourses();
                    break;
                case 4:
                    handleComplaints();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public void manageCourseCatalog() {
        boolean running = true;
        while (running) {
            System.out.println("Manage Course Catalog:");
            System.out.println("1. View Courses");
            System.out.println("2. Add Course");
            System.out.println("3. Delete Course");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    viewCourses();
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    deleteCourse();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void viewCourses()
    {
        System.out.println("Enter the semester to view courses (1-5): ");
        int semester = s.nextInt();
        s.nextLine();
        List<Course> courses = courseCatalog.getCoursesForSemester(semester);

        if (courses.isEmpty()) {
            System.out.println("No courses available for this semester.");
        } else {
            System.out.println("Available Courses in Semester " + semester + ":");
            for (Course course : courses) {
                System.out.println(course.getName());
            }
        }
    }

    public void addCourse() {
        System.out.println("Enter the semester for the new course (e.g., 1 for Sem 1, 2 for Sem 2, etc.): ");
        int semester = s.nextInt();
        s.nextLine();

        System.out.println("Enter the name of the course: ");
        String name = s.nextLine();

        System.out.println("Enter the course code: ");
        String code = s.nextLine();

        System.out.println("Enter the professor's name: ");
        String professor = s.nextLine();

        System.out.println("Enter the number of credits: ");
        int credits = s.nextInt();
        s.nextLine();

        System.out.println("Enter the prerequisites (comma-separated, or 'None' if no prerequisites): ");
        String prerequisites = s.nextLine();

        System.out.println("Enter the timings (e.g., Mon-Wed 9:30AM - 11AM): ");
        String timings = s.nextLine();

        Course newCourse = new Course(name, code, professor, credits, prerequisites, timings);
        List<Course> coursesForSemester = courseCatalog.getCoursesForSemester(semester);
        coursesForSemester.add(newCourse);
        System.out.println("Course added successfully.");
    }

    public void deleteCourse() {
        System.out.println("Enter the semester to delete a course from (e.g., 1 for Sem 1, 2 for Sem 2, etc.): ");
        int semester = s.nextInt();
        s.nextLine();

        List<Course> coursesForSemester = courseCatalog.getCoursesForSemester(semester);
        if (coursesForSemester.isEmpty()) {
            System.out.println("No courses available for this semester.");
            return;
        }

        System.out.println("available courses in sem" + semester + ":");
        for (int i = 0; i < coursesForSemester.size(); i++) {
            System.out.println((i + 1) + ". " + coursesForSemester.get(i).getName());
        }

        System.out.println("enter the number of the course to delete: ");
        int courseNumber = s.nextInt();
        s.nextLine();

        if (courseNumber < 1 || courseNumber > coursesForSemester.size()) {
            System.out.println("invalid course number");
        } else {
            coursesForSemester.remove(courseNumber - 1);
            System.out.println("course has been deleted.");
        }
    }



    public void manageStudentRecords() {
        boolean running = true;
        while (running) {
            System.out.println("Manage Student Records:");
            System.out.println("1. View and Update Student Records");
            System.out.println("2. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    updateStudentRecords();
                    break;
                case 2:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public void updateStudentRecords() {
        System.out.println("Enter the student name (PRAJNA, NIDHI, ROHIT):");
        String studentName = s.nextLine().toUpperCase();

        if (!Arrays.asList("PRAJNA", "NIDHI", "ROHIT").contains(studentName)) {
            System.out.println("Invalid student name.");
            return;
        }

        System.out.println("Enter the semester number (1, 2, 3, ...):");
        int semester = s.nextInt();
        s.nextLine();

        List<String> courses = studentCompletedCourses.getCompletedCourses(studentName);
        if (courses.isEmpty()) {
            System.out.println("No completed courses found for " + studentName);
            return;
        }

        int startIdx = (semester - 1) * 10;
        int endIdx = semester * 10;

        if (startIdx >= courses.size()) {
            System.out.println("No courses found for Semester " + semester);
            return;
        }

        System.out.println("Courses for Semester " + semester + ":");
        Map<String, Integer> cGrades = new LinkedHashMap<>();
        for (int i = startIdx; i < endIdx && i < courses.size(); i += 2) {
            String courseName = courses.get(i);
            int grade = Integer.parseInt(courses.get(i + 1));
            cGrades.put(courseName, grade);
            System.out.println(courseName + ": Grade " + grade);
        }

        System.out.println("enter the course name to update:");
        String courseToUpdate = s.nextLine();

        if (!cGrades.containsKey(courseToUpdate)) {
            System.out.println("Course not found.");
            return;
        }

        System.out.println("Enter the new grade for " + courseToUpdate + ":");
        int newGrade = s.nextInt();
        s.nextLine();
        List<String> updatedCourses = new ArrayList<>(courses);
        for (int i = startIdx; i < endIdx && i < updatedCourses.size(); i += 2) {
            if (updatedCourses.get(i).equals(courseToUpdate)) {
                updatedCourses.set(i + 1, String.valueOf(newGrade));
                break;
            }
        }

        //saving the update records
        studentCompletedCourses.updateCompletedCourses(studentName, updatedCourses);
        System.out.println("Grade updated successfully.");
    }


    public void assignProfessorsToCourses() {
        System.out.println("Assign Professors to Courses:");
        System.out.println("Available Professors:");
        for (Professor prof : professors.values()) {
            System.out.println(prof.getName() + " - Expertise: " + prof.getExpertise() +
                    ", Available: " + (prof.isAvailable() ? "Yes" : "No"));
        }

        System.out.println("\nEnter the name of the professor you want to assign:");
        String profName = s.nextLine();

        Professor selectedProf = professors.get(profName);
        if (selectedProf == null) {
            System.out.println("Professor not found.");
            return;
        }

        if (!selectedProf.isAvailable()) {
            System.out.println("Professor " + profName + " is busy and cannot be assigned.");
            return;
        }

        System.out.println("Enter the semester of the course you want to assign (1-5):");
        int semester = s.nextInt();
        s.nextLine();

        List<Course> courses = courseCatalog.getCoursesForSemester(semester);
        if (courses.isEmpty()) {
            System.out.println("No courses available for semester " + semester);
            return;
        }

        System.out.println("Available courses for semester " + semester + ":");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getName());
        }

        System.out.println("Enter the number of the course you want to assign:");
        int courseNumber = s.nextInt();
        s.nextLine();

        if (courseNumber < 1 || courseNumber > courses.size())
        {
            System.out.println("Invalid course number.");
            return;
        }

        Course selectedCourse = courses.get(courseNumber - 1);
        selectedCourse.setProfessor(selectedProf.getName());
        selectedProf.setAvailable(false);

        System.out.println("Professor " + profName + " has been assigned to " + selectedCourse.getName());
    }
    public void viewAllComplaints() {
        List<Complaint> allComplaints = complaintsSystem.getAllComplaints();
        for (int i = 0; i < allComplaints.size(); i++) {
            Complaint complaint = allComplaints.get(i);
            System.out.println("Complaint " + (i + 1) + ":");
            System.out.println("Student: " + complaint.getStudentName());
            System.out.println("Description: " + complaint.getDescription());
            System.out.println("Status: " + complaint.getStatus());
            System.out.println();
        }
    }
    public void resolveComplaint(int complaintIndex) {
        complaintsSystem.updateComplaintStatus(complaintIndex, "Resolved");
    }

    public void AdminPage() {
        while (true) {
            System.out.println("1. View All Complaints");
            System.out.println("2. Resolve a Complaint");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    viewAllComplaints();
                    break;
                case 2:
                    System.out.print("Enter the index of the complaint to resolve: ");
                    int index = s.nextInt() - 1;
                    resolveComplaint(index);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }



    }

    public void handleComplaints() {
        System.out.println("Handling Complaints...");
        List<Complaint> allComplaints = complaintsSystem.getAllComplaints();
        for (int i = 0; i < allComplaints.size(); i++) {
            Complaint complaint = allComplaints.get(i);
            System.out.println("Complaint " + (i + 1) + ": " + complaint.getDescription() +" | Status: " + complaint.getStatus() +" | Student: " + complaint.getStudentName());
        }

        System.out.print("Enter the index of the complaint to resolve: ");
        int index = s.nextInt() - 1;
        if (index >= 0 && index < allComplaints.size()) {
            resolveComplaint(index);
        } else {
            System.out.println("Invalid complaint index.");
        }
    }






}