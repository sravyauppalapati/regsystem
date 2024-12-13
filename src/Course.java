public class Course {
    private String name;
    private String code;
    private String professor;
    private int credits;
    private String prerequisite;
    private String timings;


    public Course(String name, String code, String professor, int credits, String prerequisite, String timings) {
        this.name = name;
        this.code = code;
        this.professor = professor;
        this.credits = credits;
        this.prerequisite = prerequisite;
        this.timings = timings;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void displayCourse() {
        System.out.println(name + ", " + code + ", " + professor + ", Credits: " + credits + ", Prerequisite: " + prerequisite + ", Timings: " + timings);
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
    public String getProfessor() {
        return professor;
    }
    @Override
    public String toString() {
        return name + ", " + code + ", Professor: " + (professor != null ? professor : "Not assigned") +  ", Credits: " + credits + ", Prerequisites: " + prerequisite + ", Timings: " + timings;
    }

}
