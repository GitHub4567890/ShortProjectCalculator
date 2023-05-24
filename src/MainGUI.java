import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JTextArea calculatorScreen;
    private JButton buttonSeven;
    private JButton buttonNine;
    private JButton divide;
    private JButton multiply;
    private JButton subtract;
    private JButton add;
    private JButton buttonFour;
    private JButton buttonFive;
    private JButton buttonSix;
    private JButton decimal;
    private JButton equals;
    private JButton buttonZero;
    private JButton buttonThree;
    private JButton buttonTwo;
    private JButton buttonOne;
    private JButton buttonEight;
    private JButton clearAll;
    private static String num1 = "";
    private static String num2 = "";
    private static String operation = "";

    public MainGUI() {
        createUIComponents();
    }

    private void createUIComponents() {
        setContentPane(mainPanel);
        setTitle("Calculator");
        setSize(470, 330);
        setLocation(470, 230);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttonOne.addActionListener(this);
        buttonTwo.addActionListener(this);
        buttonThree.addActionListener(this);
        buttonFour.addActionListener(this);
        buttonFive.addActionListener(this);
        buttonSix.addActionListener(this);
        buttonSeven.addActionListener(this);
        buttonEight.addActionListener(this);
        buttonNine.addActionListener(this);
        buttonZero.addActionListener(this);
        decimal.addActionListener(this);
        divide.addActionListener(this);
        multiply.addActionListener(this);
        subtract.addActionListener(this);
        add.addActionListener(this);
        equals.addActionListener(this);
        clearAll.addActionListener(this);
        calculatorScreen.setText("");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = ((JButton) e.getSource()).getText();
        if (button.equals("1") || button.equals("2") || button.equals("3") || button.equals("4") || button.equals("5") || button.equals("6") || button.equals("7") || button.equals("8") || button.equals("9") || button.equals("0") || button.equals(".")) {
            calculatorScreen.append(button);
        } else if (button.equals("/") || button.equals("x") || button.equals("-") || button.equals("+")) {
            num1 = calculatorScreen.getText();
            operation = button;
            calculatorScreen.setText("");

        } else if (button.equals("=")) {
            num2 = calculatorScreen.getText();
            if (num1.equals("")) {
                if (num2.equals("")) {
                    calculatorScreen.setText("0.0");
                } else {
                    calculatorScreen.setText(num2);
                }
            } else if (num2.equals("")) {
                calculatorScreen.setText(num1);
            } else {
                Calculator a = new Calculator(num1, num2, operation);
                calculatorScreen.setText(Double.toString(a.calculate()));
            }

        } else if (button.equals("AC")) {
            calculatorScreen.setText("");
            num1 = "";
            num2 = "";
            operation = "";
        }
    }

}
