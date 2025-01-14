/*
Names: Kevin, Aelinia, Tristan
Date: 1/12/2025
Description: Get info and print ticket for ZooLights
 */
package works;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;
/*Don't know what "drive through tickets
are 1 ticket number" means
*/
public class Main
{
    static String names="", bDay="", height="", weight="",
            attendDay="", attendDate="", option="", driveOrWalk="";
    static int filler, continueOption, partyCount;
    static ArrayList<String> nameArray = new ArrayList<String>();
    static ArrayList<String> weightArray = new ArrayList<String>();
    static ArrayList<String> heightArray = new ArrayList<String>();
    static ArrayList<String> bDayArray = new ArrayList<String>();
    static long timeDifference;

    public static void Quesionnare() throws ParseException
    {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleFormat = new SimpleDateFormat("MM/dd/yyyy" );
        DateFormat simplerFormat = new SimpleDateFormat("EEEE");

        System.out.print("Party Count?> ");
        partyCount = scanner.nextInt();
        scanner.nextLine(); //refresh

        System.out.print("Date of attendance MM/dd/yyyy?> ");
        attendDate = scanner.nextLine();
        Date date = simpleFormat.parse(attendDate);
        attendDay = simplerFormat.format(date);

        System.out.print("Drive thru or walk thru drive/walk?> ");
        driveOrWalk = scanner.nextLine();

        for (int i = 0; i < partyCount; i++)
        {
            System.out.printf("What is the name of person %d?> ", i);
            names = scanner.nextLine(); nameArray.add(names);
        }

        if (driveOrWalk.equals("walk") || driveOrWalk.equals("Walk"))
        {
            System.out.printf("Want to do the to do the train y/n?> ");
            option = scanner.nextLine();

            if (option.equals("y"))
            {
                for (String i : nameArray)
                {
                    System.out.printf("What's %s's weight in pounds?> ", i);
                    weight = scanner.nextLine(); weightArray.add(weight);
                    System.out.printf("What's %s's height in inches?> ", i);
                    height = scanner.nextLine(); heightArray.add(height);
                }
            }
        }

        for (String i : nameArray)
        {
            System.out.printf("What's the birthday of %s?> ", i);
            bDay = scanner.nextLine(); bDayArray.add(bDay);
        }
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

        CalculatingAlgorithms calculate = new CalculatingAlgorithms();
        TicketPrinter myTicket = new TicketPrinter();
        continueOption = 1;

        for (int i = 0; i < partyCount; i++)
        {
            calculate.costsIncurred = 0;
            calculate.ridingTheTrain = ""; calculate.yourID = "";
            calculate.textFiller = ""; //reset stored values

            Date date1 = simpledFormat.parse(attendDate);
            Date date2 = simpledFormat.parse(bDayArray.get(continueOption-1));
            BigInteger indeed = new BigInteger(String.valueOf
                    (date1.getTime() - date2.getTime()));
            BigInteger millisecondsPerDay = new BigInteger("86400000");

            timeDifference = Long.parseLong(String.valueOf
                    (indeed.divide(millisecondsPerDay)));
            timeDifference = timeDifference / 365;

            calculate.main(args);

            System.out.print("Close the window and click enter to print the next ticket> ");
            String filler1 = scanner.nextLine();
            continueOption++;
            //clear board
            myTicket.clearPane();
        }
    }
}
