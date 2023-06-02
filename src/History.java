import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class History extends JFrame implements ActionListener {
    private JList historyList;
    private JPanel panel1;
    private JButton clear;
    private JButton backMain;
    private static String[] history;
    private JTextArea screen;
    private ArrayList<String> historyArrList;
    private MainGUI mainCalc
    private JButton historyButtonMain;

    public History(ArrayList<String> list, MainGUI mainCalc, JTextArea screen, JButton historyButtonMain) {
        history = new String[list.size()];
        for (int i = 0; i <= list.size() - 1; i++) {
            history[i] = list.get(i);
        }
        this.screen = screen;
        historyArrList = list;
        this.mainCalc = mainCalc;
        this.historyButtonMain = historyButtonMain;
        createUIComponents();
    }

    private void createUIComponents() {
        setContentPane(panel1);
        setTitle("Calculator History");
        setSize(470, 330);
        setLocation(470, 230);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        backMain.addActionListener(this);
        clear.addActionListener(this);
        Container ControlHost = getContentPane();
        ControlHost.setLayout(new FlowLayout());
        historyList = new JList<>(history);
        historyList.setVisibleRowCount(17);
        JScrollPane jcp = new JScrollPane(historyList);
        ControlHost.add(jcp);
        historyList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String selectedEquation = (String) historyList.getSelectedValue();
                screen.setText(selectedEquation.substring(selectedEquation.indexOf("=") + 1));
                setVisible(false);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = ((JButton) e.getSource());
        if (button.equals(clear)) {
            historyList.removeAll();
            historyArrList.clear();
            setVisible(false);
            ActionEvent a = new ActionEvent(historyButtonMain, 1, "1");
            mainCalc.actionPerformed(a);
        } else if (button.equals(backMain)) {
            setVisible(false);
        }
    }
}
