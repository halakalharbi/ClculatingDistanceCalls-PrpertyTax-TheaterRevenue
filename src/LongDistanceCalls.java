
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LongDistanceCalls extends JFrame {

    private JRadioButton dayTimeRadio;
    private JRadioButton eveningRadio;
    private JRadioButton offPeakRadio;
    private ButtonGroup bg;
    private JTextField minutesField;
    private JLabel messageLabel;
    private JButton calcButton;
    private JButton exitButton;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private final int WINDOW_WIDTH = 350;
    private final int WINDOW_HEIGHT = 500;
    private final double DAY_TIME = .07;
    private final double EVENING = .12;
    private final double OFF_PEAK = .05;

    public LongDistanceCalls() {

        setTitle("Tempreture Converter");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        buildPanel();
        add(panel1);
        add(panel2);
        add(panel5);
        setVisible(true);
    }

    private void buildPanel() {
        dayTimeRadio = new JRadioButton("Daytime (6:00 a.m. through 5:59 p.m.)");
        eveningRadio = new JRadioButton("Evening (6:00 p.m. through 11:59 p.m.) ");
        offPeakRadio = new JRadioButton("Off-Peak (12:00 a.m. through 5:59 a.m.)");
        bg = new ButtonGroup();
        bg.add(dayTimeRadio);
        bg.add(eveningRadio);
        bg.add(offPeakRadio);

        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel1.setBorder(BorderFactory.createTitledBorder("Select a Rate Category"));
        panel1.add(dayTimeRadio);
        panel1.add(eveningRadio);
        panel1.add(offPeakRadio);

        messageLabel = new JLabel("Minutes:");
        minutesField = new JTextField(10);
        panel2 = new JPanel();

        panel2.setBorder(BorderFactory.createTitledBorder("Time of Call"));
        panel2.setLayout(new GridLayout(1, 2));
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel3.add(messageLabel);
        panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel4.add(minutesField);
        panel2.add(panel3);
        panel2.add(panel4);

        calcButton = new JButton("Calculate Charges");
        exitButton = new JButton("Exit");
        panel5 = new JPanel();
        calcButton.addActionListener(new CalcButtonListener());
        exitButton.addActionListener(new ExitButtonListener());

        panel5.add(calcButton);
        panel5.add(exitButton);

    }

    private class CalcButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int minutes = Integer.parseInt(minutesField.getText());
            double charge = 0;
            if (dayTimeRadio.isSelected()) {
                charge = minutes * DAY_TIME;
            } else if (eveningRadio.isSelected()) {
                charge = minutes * EVENING;
            } else if (offPeakRadio.isSelected()) {
                charge = minutes * OFF_PEAK;
            }

            JOptionPane.showMessageDialog(null, String.format("Total Charges is: $%.2f", charge));

        }

    }

    private class ExitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new LongDistanceCalls();

    }
}
