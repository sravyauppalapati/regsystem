public class Complaint {
    private String description;
    private String status;
    private String studentName;

    public Complaint(String description, String studentName) {
        this.description = description;
        this.status = "Pending";
        this.studentName = studentName;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStudentName() {
        return studentName;
    }
}
