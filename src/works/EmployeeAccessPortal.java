package works;

import java.text.ParseException;
import java.util.Scanner;

public class EmployeeAccessPortal
{
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Click f to open the ticket-selling software> ");
        String input = scanner.nextLine();

        if (input == "f")
        {
            Main mainer = new Main();
            mainer.main(args);
        }
    }
}
