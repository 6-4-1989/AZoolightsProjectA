package works;

import javax.swing.*;
import java.awt.*;

public class TicketPrinter extends JFrame
{
    static JLabel titleLabel, costLabel, ageLabel, canAccessAlcohol,
            canAccessTrain, ID;
    static JFrame theBiggestFrameTheWorldsEverSeen;

    public TicketPrinter()
    {
        setTitle("Ticket Printer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        theBiggestFrameTheWorldsEverSeen.setSize(500, 500);
        theBiggestFrameTheWorldsEverSeen.getContentPane().setBackground(Color.YELLOW);

        //Name
        titleLabel = new JLabel(Main.nameArray[Main.continueOption]);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        theBiggestFrameTheWorldsEverSeen.add(titleLabel);
        ageLabel.setHorizontalAlignment(250);
        ageLabel.setVerticalAlignment(30);

        //Age
        ageLabel = new JLabel("-"+Main.timeDifference+" years old");
        ageLabel.setFont(new Font("Serif", Font.ITALIC, 14));
        theBiggestFrameTheWorldsEverSeen.add(ageLabel);
        ageLabel.setHorizontalAlignment(100);
        ageLabel.setVerticalAlignment(100);

        //Total Costs incurred
        costLabel = new JLabel(String.valueOf(works.CalculatingAlgorithms.costsIncurred));
        costLabel.setFont(new Font("Serif", Font.PLAIN, 12));
        theBiggestFrameTheWorldsEverSeen.add(costLabel);
        costLabel.setHorizontalAlignment(100);
        costLabel.setVerticalAlignment(30);

        //Randomly Generated ID
        ID = new JLabel(String.valueOf(works.CalculatingAlgorithms.yourID));
        ID.setFont(new Font("Serif", Font.PLAIN, 12));
        theBiggestFrameTheWorldsEverSeen.add(ID);
        ID.setHorizontalAlignment(400);
        ID.setVerticalAlignment(30);

        //Train access (or driving if they're driving)
        canAccessTrain = new JLabel("-"+ works.CalculatingAlgorithms.ridingTheTrain);
        canAccessTrain.setFont(new Font("Serif", Font.ITALIC, 14));
        theBiggestFrameTheWorldsEverSeen.add(canAccessTrain);
        canAccessTrain.setHorizontalAlignment(200);
        canAccessTrain.setVerticalAlignment(100);

        //Alcohol
        canAccessAlcohol = new JLabel((Main.timeDifference >= 21) ?
                "Can Alcohol" : "No Alcohol");
        canAccessAlcohol.setFont(new Font("Serif", Font.ITALIC, 14));
        theBiggestFrameTheWorldsEverSeen.add(canAccessAlcohol);
        canAccessAlcohol.setHorizontalAlignment(300);
        canAccessAlcohol.setVerticalAlignment(100);
    }
    public static void main(String [] args)
    {
        new TicketPrinter();
    }
}


