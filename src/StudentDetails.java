public class StudentDetails
{
    private int semester;
    private String branch;

    public StudentDetails(int semester, String branch) {
        this.semester = semester;
        this.branch = branch;
    }

    public int getSemester() {
        return semester;
    }

    public String getBranch() {
        return branch;
    }
}
