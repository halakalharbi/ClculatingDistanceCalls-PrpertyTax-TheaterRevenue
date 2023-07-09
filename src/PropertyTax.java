
import java.awt.event.*;
import javax.swing.*;

public class PropertyTax extends JFrame {

    private JButton butCalc;
    private JTextField inputFiled;
    private JLabel message;
    private JPanel panel;
    private final int WINDOW_WIDTH = 340;
    private final int WINDOW_HEIGHT = 110;

    public PropertyTax() {

        setTitle("Property Taxes");

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildPanel();

        add(panel);

        setVisible(true);
    }

    private void buildPanel() {

        message = new JLabel("Enter the Actual Property Value:");
        inputFiled = new JTextField(20);
        butCalc = new JButton("Calculate Property Tax");
        butCalc.addActionListener(new ButtonAction());
        panel = new JPanel();

        panel.add(message);
        panel.add(inputFiled);
        panel.add(butCalc);
    }

    private class ButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String input;
            double assessment_value, tax;
            input = inputFiled.getText();

            assessment_value = Integer.parseInt(input) * .6;
            tax = assessment_value * .64 / 100;

            JOptionPane.showMessageDialog(null, "Property Tax : $" + tax);

        }
    }

    public static void main(String[] args) {
        new PropertyTax();

    }
}
