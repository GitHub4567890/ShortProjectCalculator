import javax.swing.*;
import java.util.ArrayList;

public class History extends JFrame {
    private JList historyList;
    private JPanel panel1;
    private static ArrayList<String> list;

    public History(ArrayList<String> list) {
        History.list = list;
        createUIComponents();
    }

    private void createUIComponents() {
        setContentPane(panel1);
        setTitle("Calculator History");
        setSize(470, 330);
        setLocation(470, 230);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
