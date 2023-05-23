import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainGUI extends JFrame implements ActionListener, KeyListener {
    private JTextField bill;
    private JTextArea totalResult;
    private JButton tipSubtract;
    private JTextField tip;
    private JButton tipAdd;
    private JTextArea tipResult;
    private JLabel billLabel;
    private JTextField people;
    private JLabel tipLabel;
    private JPanel mainPanel;
    private JButton peopleSubtract;
    private JButton peopleAdd;
    private JLabel tipRLabel;
    private JLabel totalRLabel;
    private JLabel peopleLabel;
    private JLabel billWarning;
    private TipCalculator tipCalc;

    public MainGUI() {
        createUIComponents();
    }

    private void createUIComponents() {
        setContentPane(mainPanel);
        setTitle("Tip Calculator");
        setSize(700, 300);
        setLocation(360, 250);
        bill.setText("0.00");
        tip.setText("0");
        people.setText("0");
        tipCalc = new TipCalculator(Double.parseDouble(bill.getText()), Integer.parseInt(tip.getText()), Integer.parseInt(people.getText()));
        tipResult.setText(Double.toString(tipCalc.calculateTip()));
        totalResult.setText(Double.toString(tipCalc.totalBill()));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        bill.addActionListener(this);
        tipAdd.addActionListener(this);
        tipSubtract.addActionListener(this);
        tip.addActionListener(this);
        peopleAdd.addActionListener(this);
        peopleSubtract.addActionListener(this);
        people.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JTextField) {
            tipCalc.setBill(Double.parseDouble(bill.getText()));
            tipResult.setText(Double.toString(tipCalc.calculateTip()));
            totalResult.setText(Double.toString(tipCalc.totalBill()));
        } else if (source instanceof JButton) {
            String label = ((JButton) source).getText();
            if (label.equals("T-")) {
                if (Integer.parseInt(tip.getText()) != 0) {
                    tip.setText(Integer.toString(Integer.parseInt(tip.getText()) - 1));
                }
            } else if (label.equals("T+")) {
                tip.setText(Integer.toString(Integer.parseInt(tip.getText()) + 1));
            } else if (label.equals("P-")) {
                if (Integer.parseInt(people.getText()) != 0) {
                    people.setText(Integer.toString(Integer.parseInt(people.getText()) - 1));
                }
            } else if (label.equals("P+")) {
                people.setText(Integer.toString(Integer.parseInt(people.getText()) + 1));
            }
            tipCalc.setTipPercentage(Integer.parseInt(tip.getText()));
            tipCalc.setNumberOfPeople(Integer.parseInt(people.getText()));
            tipResult.setText(Double.toString(tipCalc.calculateTip()));
            totalResult.setText(Double.toString(tipCalc.totalBill()));
        }
    }

     @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
