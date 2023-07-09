
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TheaterRevenue extends JFrame {

    private JTextField priceAdultText;
    private JTextField numberAdultText;
    private JTextField priceChildText;
    private JTextField numberChildText;
    private JLabel priceAdultLabel;
    private JLabel numberAdultLabel;
    private JLabel priceChildLabel;
    private JLabel numberChildLabel;
    private JButton calcButton;
    private JPanel adultTicketPricePanel;
    private JPanel adultTicketsSoldPanel;
    private JPanel childTicketPricePanel;
    private JPanel childTicketsSoldPanel;
    private JPanel calculatePanel;
    private JPanel mainPanel;

    public TheaterRevenue() {

        setTitle("Theater Revenue");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));
        buildPanel();

        add(adultTicketPricePanel);
        add(adultTicketsSoldPanel);
        add(childTicketPricePanel);
        add(childTicketsSoldPanel);
        add(calculatePanel);
        pack();
        setVisible(true);
    }

    private void buildPanel() {

        priceAdultLabel = new JLabel("Enter the adult ticket price: ");
        numberAdultLabel = new JLabel("Enter the Number of adult tickets sold: ");
        priceChildLabel = new JLabel("Enter the child ticket Price: ");
        numberChildLabel = new JLabel("Enter the Number of child tickets sold: ");
        priceAdultText = new JTextField(10);
        numberAdultText = new JTextField(10);
        priceChildText = new JTextField(10);
        numberChildText = new JTextField(10);
        calcButton = new JButton("Calculate Revenue ");
        calcButton.addActionListener(new ButtonAction());
        adultTicketPricePanel = new JPanel();
        adultTicketsSoldPanel = new JPanel();
        childTicketPricePanel = new JPanel();
        childTicketsSoldPanel = new JPanel();
        calculatePanel = new JPanel();

        adultTicketPricePanel.add(priceAdultLabel);
        adultTicketPricePanel.add(priceAdultText);
        adultTicketsSoldPanel.add(numberAdultLabel);
        adultTicketsSoldPanel.add(numberAdultText);
        childTicketPricePanel.add(priceChildLabel);
        childTicketPricePanel.add(priceChildText);
        childTicketsSoldPanel.add(numberChildLabel);
        childTicketsSoldPanel.add(numberChildText);
        calculatePanel.add(calcButton);

    }

    private class ButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            final double PERCENTAGE = 0.20;
            double price_adult = Double.parseDouble(priceAdultText.getText());
            double price_child = Double.parseDouble(priceChildText.getText());
            int number_adult = Integer.parseInt(numberAdultText.getText());
            int number_child = Integer.parseInt(numberChildText.getText());
            double adult_gross = price_adult * number_adult;
            double child_gross = price_child * number_child;
            double adult_net = adult_gross - (adult_gross * PERCENTAGE);
            double child_net = child_gross - (child_gross * PERCENTAGE);

            JOptionPane.showMessageDialog(null, "Gross Revenue for Adult tickets sold: $" + adult_gross
                    + "\nNet Revenue for Adult tickets sold : $" + adult_net
                    + "\nGross revenue for child tickets sold: $" + child_gross
                    + "\nNet Revenue for Child tickets sold : $" + child_net
                    + "\nTotal gross Revenue : $" + (adult_gross + child_gross)
                    + "\nTotal net Revenue: $" + (adult_net + child_net));

        }
    }

    public static void main(String[] args) {
        new TheaterRevenue();

    }
}
