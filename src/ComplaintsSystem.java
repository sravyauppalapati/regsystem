import java.util.*;

public class ComplaintsSystem
{
    private List<Complaint> complaints = new ArrayList<>();
    public ComplaintsSystem() {
        //harcored complaints
        complaints.add(new Complaint("Schedule clash with another course", "NIDHI"));
        complaints.add(new Complaint("Course is going too fast", "PRAJNA"));
        complaints.add(new Complaint("Google classroom code was not provided. ", "ROHIT"));
    }

    public void submitComplaint(String description, String studentName) {
        Complaint complaint = new Complaint(description, studentName);
        complaints.add(complaint);
        System.out.println("Complaint submitted successfully.");
    }

    public void viewComplaints(String studentName) {
        boolean found = false;
        for (int i = 0; i < complaints.size(); i++) {
            Complaint complaint = complaints.get(i);
            if (complaint.getStudentName().equals(studentName)) {
                System.out.println("Complaint " + (i + 1) + ":");
                System.out.println("Description: " + complaint.getDescription());
                System.out.println("Status: " + complaint.getStatus());
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No complaints found for " + studentName);
        }
    }

    public void updateComplaintStatus(int complaintIndex, String newStatus)
    {
        if (complaintIndex >= 0 && complaintIndex < complaints.size()) {
            complaints.get(complaintIndex).setStatus(newStatus);
            System.out.println("Complaint status updated successfully.");
        } else {
            System.out.println("Invalid complaint index.");
        }
    }

    public List<Complaint> getAllComplaints()
    {
        return complaints;
    }
}
