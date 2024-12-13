import java.util.*;


public class HomePage {
    Scanner s = new Scanner(System.in);

    public void SignUp() {
        System.out.println("Enter Email: ");
        s.nextLine();
        System.out.println("Enter Password: ");
        String pass = s.nextLine();
        System.out.println("Confirm Password: ");
        String cpass = s.nextLine();
        if (pass.equals(cpass)) {
            System.out.println("Confirmed, logging in...");
        } else {
            System.out.println("Passwords don't match! Please Retry.");
        }
    }

    public void LogIn() {
        System.out.println("Enter Email: ");
        s.nextLine();
        System.out.println("Enter Password: ");
        s.nextLine();
        System.out.println("Logging in...");
    }
    public void display() {
        System.out.println("Welcome to the University Home Page!");
    }
}
