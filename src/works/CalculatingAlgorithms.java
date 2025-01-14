package works;
import java.util.Random;
import java.text.ParseException;

public class CalculatingAlgorithms
{
    static int costsIncurred = 0;
    static String ridingTheTrain = "", yourID = "", textFiller = "";

    public static void main(String [] args) throws ParseException
    {
        if (Main.option.equals("y"))
        {
            ridingTheTrain = (Integer.parseInt(Main.weightArray.get(Main.continueOption-1)) < 300
                    && Integer.parseInt(Main.heightArray.get(Main.continueOption-1)) > 48) ?
                    "Can ride" : "Can't ride";
        }
        else
        {
            ridingTheTrain = "Walking";
        }

        textFiller = (Main.timeDifference >= 21) ? "Can Alcohol" : "No Alcohol";

        //Train ride appears free I'm assuming
        if (Main.driveOrWalk.equals("drive") || Main.driveOrWalk.equals("Drive"))
        {
            if (Main.partyCount > 8)
            {
                costsIncurred += Math.multiplyExact(Main.partyCount - 8, 12);
                costsIncurred += 65;
                costsIncurred = costsIncurred/Main.partyCount;
            }
            else
            {
                costsIncurred += 65/Main.partyCount;//Divide Driving Costs Among Party
            }
            ridingTheTrain = "Driving"; textFiller = "No Alcohol";
        }

        if (Main.attendDay.equals("Saturday") || Main.attendDay.equals("Sunday"))
        {
            costsIncurred += (Main.timeDifference > 18) ? 25 : 0;
            costsIncurred += (Main.timeDifference >= 15 && Main.timeDifference <= 18) ? 18 : 0;
            costsIncurred += (Main.timeDifference > 1 && Main.timeDifference <= 14) ? 12 : 0;
            if (Main.timeDifference <= 1) costsIncurred += 0;
        }
        else
        {
            costsIncurred += (Main.timeDifference > 18) ? 16 : 0;
            costsIncurred += (Main.timeDifference >= 15 && Main.timeDifference <= 18) ? 12 : 0;
            costsIncurred += (Main.timeDifference > 1 && Main.timeDifference < 15) ? 8 : 0;
            if (Main.timeDifference <= 1) costsIncurred += 0;
        }

        Random random = new Random();

        for (int i = 0; i < 5; i++)
        {
            yourID += String.valueOf(random.nextInt(10));
        }

        TicketPrinter myTicket = new TicketPrinter();
        myTicket.main(args);
    }
}
