public class ProfCourse {
    private String name;
    private String syllabus;
    private String classTimings;
    private int credits;
    private String prerequisites;
    private int enrollmentLimit;
    private String officeHours;

    public ProfCourse(String name, String syllabus, String classTimings, int credits, String prerequisites, int enrollmentLimit, String officeHours) {
        this.name = name;
        this.syllabus = syllabus;
        this.classTimings = classTimings;
        this.credits = credits;
        this.prerequisites = prerequisites;
        this.enrollmentLimit = enrollmentLimit;
        this.officeHours = officeHours;
    }

    public String getName() {
        return name;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public String getClassTimings() {
        return classTimings;
    }

    public void setClassTimings(String classTimings) {
        this.classTimings = classTimings;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public int getEnrollmentLimit() {
        return enrollmentLimit;
    }

    public void setEnrollmentLimit(int enrollmentLimit) {
        this.enrollmentLimit = enrollmentLimit;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    @Override
    public String toString() {
        return "Course: " + name +"\nSyllabus: " + syllabus +"\nClass Timings: " + classTimings +"\nCredits: " + credits +"\nPrerequisites: " + prerequisites + "\nEnrollment Limit: " + enrollmentLimit +"\nOffice Hours: " + officeHours;
    }
}
