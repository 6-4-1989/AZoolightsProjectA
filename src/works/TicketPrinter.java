package works;

import javax.swing.*;
import java.awt.*;
import java.lang.StringBuilder;

public class TicketPrinter extends JFrame
{
    static JLabel titleLabel, costLabel, ageLabel, canAccessAlcohol,
            canAccessTrain, ID;
    static JPanel panelz = new JPanel();
    static JFrame theBiggestFrameTheWorldsEverSeen = new JFrame();
    static StringBuilder string = new StringBuilder();

    public TicketPrinter()
    {

    }
    private void setStuff()
    {
        panelz.setLayout(new GridLayout(0, 2));
        setTitle("Ticket Printer");

        //Name
        titleLabel = new JLabel("   "+Main.nameArray.get(Main.continueOption-1),
                SwingConstants.LEFT);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
        panelz.add(titleLabel);

        //Age
        ageLabel = new JLabel("     -"+Main.timeDifference+" years old",
                SwingConstants.LEFT);
        ageLabel.setFont(new Font("Serif", Font.ITALIC, 18));
        panelz.add(ageLabel);

        //Total Costs incurred
        costLabel = new JLabel("        "+(works.CalculatingAlgorithms.costsIncurred) + "$",
                SwingConstants.LEFT);
        costLabel.setVerticalAlignment(SwingConstants.TOP);
        costLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        panelz.add(costLabel);

        //Randomly Generated ID
        ID = new JLabel("       ID"+works.CalculatingAlgorithms.yourID,
                SwingConstants.LEFT);
        ID.setFont(new Font("Serif", Font.PLAIN, 18));
        panelz.add(ID);

        //Train access (or driving if they're driving)
        canAccessTrain = new JLabel("       -"+ works.CalculatingAlgorithms.ridingTheTrain,
                SwingConstants.LEFT);
        canAccessTrain.setFont(new Font("Serif", Font.ITALIC, 18));
        panelz.add(canAccessTrain);

        //Alcohol
        String textFiller = (Main.timeDifference >= 21) ? "Can Alcohol" : "No Alcohol";
        string.append(textFiller);
        canAccessAlcohol = new JLabel("     " + string.toString(), SwingConstants.LEFT);
        canAccessAlcohol.setFont(new Font("Serif", Font.ITALIC, 18));
        panelz.add(canAccessAlcohol);

        setContentPane(panelz);
        theBiggestFrameTheWorldsEverSeen.setMinimumSize(new Dimension(8000, 6000));
        getContentPane().setBackground(Color.PINK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    public static void main(String [] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicketPrinter().setStuff();
            }
        });
    }
}


