import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainGUI extends JFrame implements ActionListener, KeyListener {
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
    private JButton history;
    private JButton clear;
    private static String num1 = "";
    private static String num2 = "";
    private static String operation = "";
    private static ArrayList<String> historyList;
    private boolean shiftClicked;
    private boolean equalPressed;

    public MainGUI() {
        createUIComponents();
    }

    private void createUIComponents() {
        setContentPane(mainPanel);
        setTitle("Calculator");
        setSize(490, 350);
        setLocation(470, 230);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttonOne.addActionListener(this);
        buttonOne.addKeyListener(this);

        buttonTwo.addActionListener(this);
        buttonTwo.addKeyListener(this);

        buttonThree.addActionListener(this);
        buttonThree.addKeyListener(this);

        buttonFour.addActionListener(this);
        buttonFour.addKeyListener(this);

        buttonFive.addActionListener(this);
        buttonFive.addKeyListener(this);

        buttonSix.addActionListener(this);
        buttonSix.addKeyListener(this);

        buttonSeven.addActionListener(this);
        buttonSeven.addKeyListener(this);

        buttonEight.addActionListener(this);
        buttonEight.addKeyListener(this);

        buttonNine.addActionListener(this);
        buttonNine.addKeyListener(this);

        buttonZero.addActionListener(this);
        buttonZero.addKeyListener(this);

        decimal.addActionListener(this);
        decimal.addKeyListener(this);

        divide.addActionListener(this);
        divide.addKeyListener(this);

        multiply.addActionListener(this);
        multiply.addKeyListener(this);

        subtract.addActionListener(this);
        subtract.addKeyListener(this);

        add.addActionListener(this);
        add.addKeyListener(this);

        equals.addActionListener(this);
        equals.addKeyListener(this);

        clearAll.addActionListener(this);
        clearAll.addKeyListener(this);

        history.addActionListener(this);
        history.addKeyListener(this);

        clear.addActionListener(this);
        clear.addKeyListener(this);

        calculatorScreen.setText("");
        calculatorScreen.addKeyListener(this);

        historyList = new ArrayList<String>();

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = ((JButton) e.getSource()).getText();
        if (button.equals("1") || button.equals("2") || button.equals("3") || button.equals("4") || button.equals("5") || button.equals("6") || button.equals("7") || button.equals("8") || button.equals("9") || button.equals("0") || button.equals(".")) {
            if (equalPressed) {
                calculatorScreen.setText("");
                equalPressed = false;
            }
            calculatorScreen.append(button);
        } else if (button.equals("/") || button.equals("x") || button.equals("-") || button.equals("+")) {
            if (equalPressed) {
                equalPressed = false;
            }
            num1 = calculatorScreen.getText();
            operation = button;
            calculatorScreen.setText("");

        } else if (button.equals("=")) {
            equalPressed = true;
            num2 = calculatorScreen.getText();
            if (operation.equals("")) {
                operation = "NO OPERATION";
            }
            if (num1.equals("")) {
                if (num2.equals("")) {
                    calculatorScreen.setText("0.0");
                    historyList.add("0.0" + operation + "0.0=0.0");
                } else {
                    calculatorScreen.setText(num2);
                    historyList.add("0.0" + operation + num2 + "=" + calculatorScreen.getText());
                }
            } else if (num2.equals("")) {
                calculatorScreen.setText(num1);
                historyList.add(num1 + operation + "0.0" + "=" + calculatorScreen.getText());
            } else {
                Calculator a = new Calculator(num1, num2, operation);
                calculatorScreen.setText(Double.toString(a.calculate()));
                historyList.add(num1 + operation + num2 + "=" + calculatorScreen.getText());
            }

        } else if (button.equals("AC")) {
            calculatorScreen.setText("");
            num1 = "";
            num2 = "";
            operation = "";

        } else if (button.equals("Clear")) {
            calculatorScreen.setText("");

        } else if (button.equals("History")) {
            num1 = "";
            num2 = "";
            operation = "";
            History a = new History(historyList, this, calculatorScreen, history);
            a.setVisible(true);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SHIFT) {
            shiftClicked = true;
        } else if (keyCode == KeyEvent.VK_SLASH) {
            ActionEvent a = new ActionEvent(divide, 1, "1");
            actionPerformed(a);
            shiftClicked = false;
        } else if (shiftClicked && keyCode == KeyEvent.VK_8) {
            ActionEvent a = new ActionEvent(multiply, 1, "1");
            actionPerformed(a);
            shiftClicked = false;
        } else if (keyCode == KeyEvent.VK_MINUS) {
            ActionEvent a = new ActionEvent(subtract, 1, "1");
            actionPerformed(a);
            shiftClicked = false;
        } else if (shiftClicked && keyCode == KeyEvent.VK_EQUALS) {
            ActionEvent a = new ActionEvent(add, 1, "1");
            actionPerformed(a);
            shiftClicked = false;
        } else if (keyCode == KeyEvent.VK_ENTER) {
            ActionEvent a = new ActionEvent(equals, 1, "1");
            actionPerformed(a);
            shiftClicked = false;
        } else if (keyCode == KeyEvent.VK_0) {
            ActionEvent a = new ActionEvent(buttonZero, 1, "1");
            actionPerformed(a);
            shiftClicked = false;
        } else if (keyCode == KeyEvent.VK_1) {
            ActionEvent a = new ActionEvent(buttonOne, 1, "1");
            actionPerformed(a);
            shiftClicked = false;
        } else if (keyCode == KeyEvent.VK_2) {
            ActionEvent a = new ActionEvent(buttonTwo, 1, "1");
            actionPerformed(a);
            shiftClicked = false;
        } else if (keyCode == KeyEvent.VK_3) {
            ActionEvent a = new ActionEvent(buttonThree, 1, "1");
            actionPerformed(a);
            shiftClicked = false;
        } else if (keyCode == KeyEvent.VK_4) {
            ActionEvent a = new ActionEvent(buttonFour, 1, "1");
            actionPerformed(a);
            shiftClicked = false;
        } else if (keyCode == KeyEvent.VK_5) {
            ActionEvent a = new ActionEvent(buttonFive, 1, "1");
            actionPerformed(a);
            shiftClicked = false;
        } else if (keyCode == KeyEvent.VK_6) {
            ActionEvent a = new ActionEvent(buttonSix, 1, "1");
            actionPerformed(a);
            shiftClicked = false;
        } else if (keyCode == KeyEvent.VK_7) {
            ActionEvent a = new ActionEvent(buttonSeven, 1, "1");
            actionPerformed(a);
            shiftClicked = false;
        } else if (keyCode == KeyEvent.VK_8) {
            ActionEvent a = new ActionEvent(buttonEight, 1, "1");
            actionPerformed(a);
            shiftClicked = false;
        } else if (keyCode == KeyEvent.VK_9) {
            ActionEvent a = new ActionEvent(buttonNine, 1, "1");
            actionPerformed(a);
            shiftClicked = false;
        } else if (keyCode == KeyEvent.VK_PERIOD) {
            ActionEvent a = new ActionEvent(decimal, 1, "1");
            actionPerformed(a);
            shiftClicked = false;
        } else if (keyCode == KeyEvent.VK_BACK_SPACE) {
            calculatorScreen.setText(calculatorScreen.getText().substring(0, calculatorScreen.getText().length() - 1));
            shiftClicked = false;
        } else if (keyCode == KeyEvent.VK_C) {
            ActionEvent a = new ActionEvent(clear, 1, "1");
            actionPerformed(a);
            shiftClicked = false;
        } else if (keyCode == KeyEvent.VK_A) {
            ActionEvent a = new ActionEvent(clearAll, 1, "1");
            actionPerformed(a);
            shiftClicked = false;
        }  else if (keyCode == KeyEvent.VK_H) {
            ActionEvent a = new ActionEvent(history, 1, "1");
            actionPerformed(a);
            shiftClicked = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
    }

}
