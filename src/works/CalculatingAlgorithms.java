package works;
import java.util.Random;
import java.text.ParseException;

public class CalculatingAlgorithms
{
    static int costsIncurred, yourID;
    static String ridingTheTrain;

    public static void main(String [] args) throws ParseException
    {
        if (Main.attendDay == "Saturday" || Main.attendDay == "Sunday")
        {
            costsIncurred += (Main.timeDifference > 18) ? 25 : 0;
            costsIncurred += (Main.timeDifference > 15 && Main.timeDifference <= 18) ? 18 : 0;
            costsIncurred += (Main.timeDifference > 1 && Main.timeDifference <= 14) ? 12 : 0;
            if (Main.timeDifference <= 1) costsIncurred += 0;
        }
        else
        {
            costsIncurred += (Main.timeDifference > 18) ? 16 : 0;
            costsIncurred += (Main.timeDifference > 15 && Main.timeDifference <= 18) ? 12 : 0;
            costsIncurred += (Main.timeDifference > 1 && Main.timeDifference <= 14) ? 8 : 0;
            if (Main.timeDifference <= 1) costsIncurred += 0;
        }
        //Train ride appears free I'm assuming
        if (Main.driveOrWalk.equals("drive") || Main.driveOrWalk.equals("Drive"))
        {
            costsIncurred += 65 ;
            if (Main.partyCount > 8)
            {
                costsIncurred += Math.multiplyExact(Main.partyCount - 8, 12);
            }
            ridingTheTrain = "Driving";
        }

        if (Main.option == "y" || Main.option == "Y")
        {
            ridingTheTrain = (Integer.parseInt(Main.weightArray[Main.continueOption]) < 300
                    && Integer.parseInt(Main.heightArray[Main.continueOption]) > 48) ?
                    "Can ride" : "Can't ride";
        }
        else
        {
            ridingTheTrain = "Walking";
        }

        Random random = new Random();

        for (int i = 0; i < 5; i++)
        {
            yourID += random.nextInt(10);
        }
    }
}
