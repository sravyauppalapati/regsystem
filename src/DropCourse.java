import java.util.*;
import java.time.LocalDate;

public class DropCourse
{
    private static final LocalDate deadline = LocalDate.of(2024, 9, 18); //deadline was september 18th to drop the course

    public void dropCourse(List<Course> registers) throws dropDeadlineException //throws an exception
    {
        if (LocalDate.now().isAfter(deadline)) {
            throw new dropDeadlineException("sorry , the course drop dealdine has passed.");
        }

        Scanner s = new Scanner(System.in);

        System.out.println("your registered courses:");
        for (int i = 0; i < registers.size(); i++)
        {
            System.out.println((i + 1) + ". " + registers.get(i).getName());
        }

        System.out.print("enter the course you want to drop(num) ");
        int choice = s.nextInt();

        if (choice > 0 && choice <= registers.size()) {
            Course droppedCourse = registers.remove(choice - 1);
            System.out.println("you have successfully dropped: " + droppedCourse.getName());
        } else {
            System.out.println("try again. invalid course selction");
        }
    }
}