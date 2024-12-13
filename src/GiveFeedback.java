import java.util.*;

class GiveFeedback<T> //generic class for feedback
{
    private static GiveFeedback<?> instance;
    private Map<String, Map<String, T>> feedbackMap;
    private StudentExistingCourses  studentExistingCourses;

    private GiveFeedback() {
        this.feedbackMap = new HashMap<>();
        this.studentExistingCourses = new StudentExistingCourses();
    }

    @SuppressWarnings("unchecked")
    public static synchronized <T> GiveFeedback<T> getInstance()
    {
        if (instance == null) {
            instance = new GiveFeedback<>();
        }
        return (GiveFeedback<T>) instance;
    }

    public void provide(String studentName) {
        Scanner sc = new Scanner(System.in);
        List<Course> currentCourses = studentExistingCourses.getCoursesForStudent(studentName);

        if (currentCourses.isEmpty()) {
            System.out.println("you have not enrolled in any courses");
            return;
        }

        System.out.println("your Current Courses:");
        for (int i = 0; i < currentCourses.size(); i++)
        {
            System.out.println((i + 1) + ". " + currentCourses.get(i).getName());
        }

        System.out.println("select course to give feedback(num) ");
        int courseIndex = sc.nextInt() - 1;
        sc.nextLine();

        if (courseIndex < 0 || courseIndex >= currentCourses.size())
        {
            System.out.println("invalid course");
            return;
        }

        String courseName = currentCourses.get(courseIndex).getName();

        System.out.println("what type of feedback?");
        System.out.println("1. numeric rating (1-5)");
        System.out.println("2. textual feedback");
        int feedbackChoice = sc.nextInt();
        sc.nextLine();

        T feedback;
        if (feedbackChoice == 1) {
            System.out.print("enter your rating from 1-5");
            int rating = sc.nextInt();
            sc.nextLine();

            if (rating < 1 || rating > 5)// if given wrong rating then
            {
                System.out.println("invalid rating should be between 1 and 5.");
                return;
            }

            feedback = (T) Integer.valueOf(rating);
        } else if (feedbackChoice == 2) {
            System.out.print("enter your feedback: ");
            feedback = (T) sc.nextLine();
        } else {
            System.out.println("invalid choice.");
            return;
        }

        feedbackMap.computeIfAbsent(courseName, k -> new HashMap<>()).put(studentName, feedback);
        System.out.println("feedback submitted for " + courseName + ".");
    }

    public void view(String courseName, String professorName, Map<String, ProfessorDetails> PROFESSOR_INFO)
    {
        //this method checks if prof teaches the course
        boolean profTeachC = false;
        ProfessorDetails profDetail = PROFESSOR_INFO.get(professorName);
        if (profDetail != null) {
            for (ProfCourse course : profDetail.getManagedCourses()) {
                if (course.getName().equalsIgnoreCase(courseName))
                {
                    profTeachC = true;
                    break;
                }
            }
        }

        if (!profTeachC)
        {
            System.out.println("you do not teach this course.");
            return;
        }

        System.out.println("feedback for course: " + courseName); //prints the feedback for his course with the student name as welo

        Map<String, T> courseFeedback = feedbackMap.get(courseName);
        if (courseFeedback != null && !courseFeedback.isEmpty())
        {
            for (Map.Entry<String, T> entry : courseFeedback.entrySet())
            {
                System.out.println(entry.getKey() + " feedback: " + entry.getValue());
            }
        } else
        {
            System.out.println("no feedback given yet");
        }
    }
}
