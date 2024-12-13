import java.util.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        ComplaintsSystem complaintsSystem = new ComplaintsSystem();
        CourseCatalog courseCatalog = new CourseCatalog();
        Administrator admin = new Administrator(courseCatalog, complaintsSystem);
        TA ta = new TA(complaintsSystem);

        while (run) {
            System.out.println("WELCOME to University Course Registration System");
            System.out.println("1. Enter the Application");
            System.out.println("2. Exit the Application");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("1. Login");
                System.out.println("2. Sign Up");
                System.out.print("Enter your choice: ");
                int loginOrSignup = sc.nextInt();
                sc.nextLine();
                if (loginOrSignup == 1) {
                    System.out.println("Login as:");
                    System.out.println("1. Student");
                    System.out.println("2. Professor");
                    System.out.println("3. Administrator");
                    System.out.println("4. Teaching Assistant");
                    System.out.print("Enter your choice: ");
                    int role = sc.nextInt();
                    sc.nextLine();

                    try {
                        switch (role) {
                            case 1:
                                Student student = new Student(complaintsSystem);
                                student.StudentLogin();
                                break;
                            case 2:
                                Professor professor = new Professor("", "", true);
                                professor.ProfessorLogin();
                                break;
                            case 3:
                                admin.AdministratorLogin();
                                break;
                            case 4:
                                ta.TALogin();
                                break;
                            default:
                                System.out.println("Invalid option. Please choose again.");
                                continue;
                        }
                    } catch (invalidLoginException e) {
                        System.out.println("Login failed: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An unexpected error occurred: " + e.getMessage());
                    }
                } else if (loginOrSignup == 2) {

                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } else if (choice == 2) {
                System.out.println("Exiting the Application...");
                run = false;
            } else {
                System.out.println("Invalid Option. Please choose again.");
            }
        }

        sc.close();
    }
}