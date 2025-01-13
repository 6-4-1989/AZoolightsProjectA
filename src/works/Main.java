package works;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.math.BigInteger;

public class Main
{
    static String names, bDay, height, weight,
            attendDay, attendDate, option, driveOrWalk;
    static int filler, continueOption, partyCount;
    static String [] nameArray, weightArray, heightArray, bDayArray;
    static long timeDifference;

    public static void Quesionnare() throws ParseException
    {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat simplerFormat = new SimpleDateFormat("EEEE");

        System.out.print("Party Count?> ");
        partyCount = scanner.nextInt();
        scanner.nextLine(); //refresh

        System.out.print("Date of attendance mm/dd/yyyy?> ");
        attendDate = scanner.nextLine();
        Date date = simpleFormat.parse(attendDate);
        attendDay = simplerFormat.format(date);

        System.out.print("Drive thru or walk thru drive/walk?> ");
        driveOrWalk = scanner.nextLine();

        for (int i = 0; i < partyCount; i++)
        {
            System.out.printf("What is the name of person %d?> ", i);
            names += scanner.nextLine(); names += " ";
        }
        nameArray = names.split(" ");

        if (driveOrWalk.equals("walk") || driveOrWalk.equals("Walk"))
        {
            System.out.printf("Want to do the to do the train y/n?> ");
            option = scanner.nextLine();

            if (option == "y" || option == "Y")
            {
                for (String i : nameArray)
                {
                    System.out.print("What's your weight in pounds?> ");
                    weight += scanner.nextLine();
                    weight += " ";
                    System.out.print("What's your height in inches?> ");
                    height += scanner.nextLine();
                    height += " ";
                }
                weightArray = weight.split(" ");
                heightArray = weight.split(" ");
            }
        }
        filler = 0;

        for (String i : nameArray)
        {
            System.out.printf("What's the birthday of %s?>", nameArray[filler]);
            bDay += scanner.nextLine(); bDay += " ";
            filler++;
        }
        bDayArray = bDay.split(" ");

        System.out.println("Tell the receptionist discount code MEMBER" +
                " to get 20% off! Member-exclusive deal.");
    }

    public static void main(String [] args) throws ParseException
    {
        EmployeeAccessPortal accessPortal = new EmployeeAccessPortal();
        accessPortal.main(args);

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpledFormat = new SimpleDateFormat("dd/MM/yyyy");
        Quesionnare();

        String optionToContinue = "n";
        filler = 0;
        CalculatingAlgorithms calculate = new CalculatingAlgorithms();
        TicketPrinter myTicket = new TicketPrinter();

        do
        {
            System.out.printf("Whose ticket do you want to view? Person 0-%d> ", nameArray.length-1);
            continueOption = scanner.nextInt();
            Date date1 = simpledFormat.parse(attendDate);
            Date date2 = simpledFormat.parse(bDayArray[continueOption]);
            BigInteger indeed = new BigInteger(String.valueOf
                    (date1.getTime() - date2.getTime()));
            BigInteger millisecondsPerDay = new BigInteger("86400000");

            timeDifference = Long.parseLong(String.valueOf
                    (indeed.divide(millisecondsPerDay)));
            timeDifference = timeDifference / 365;

            calculate.main(args);
            myTicket.main(args);

            if (partyCount > 1)
            {
                System.out.print("Do you want to continue y/n?> ");
                optionToContinue = scanner.nextLine();
            }
        }
        while (optionToContinue == "y");
    }
}
