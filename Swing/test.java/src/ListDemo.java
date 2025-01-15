import java.awt.*;
import javax.swing.*;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListDemo extends JFrame implements Runnable, ActionListener {
    String[] arr = {"Ali", "Hinnawe", "Lebanon", "Beirut"};
    Vector<String> v = new Vector<>();

    private JTextField textField1;
    private JList<String> jlist1;

    public ListDemo(String title) {
        setTitle(title);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void run() {
        JPanel mainPanel = new JPanel();
        v.add("Name");
        v.add("FName");
        v.add("Country");
        v.add("City");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

        jlist1 = new JList<>(arr);
        JList<String> jlist2 = new JList<>(v);

        p1.add(jlist1);
        p2.add(jlist2);

        JButton button1 = new JButton("Button1");
        JButton button2 = new JButton("Button2");
        JButton button3 = new JButton("Button3");
        JButton button4 = new JButton("Button4");

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

        p3.add(button1);
        p3.add(button2);
        p4.add(button3);
        p4.add(button4);

        textField1 = new JTextField("textField1");
        textField1.setColumns(20);
        JTextField textField2 = new JTextField("textField2");
        textField2.setColumns(20);
        p3.add(textField1);
        p3.add(textField2);

        JTextField textField3 = new JTextField("textField3");
        textField3.setColumns(20);
        JTextField textField4 = new JTextField("textField4");
        textField4.setColumns(20);
        p4.add(textField3);
        p4.add(textField4);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(p1, BorderLayout.EAST);
        mainPanel.add(p2, BorderLayout.WEST);
        mainPanel.add(p3, BorderLayout.NORTH);
        mainPanel.add(p4, BorderLayout.SOUTH);

        add(mainPanel);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Button1")) {
            String text = textField1.getText();
            if (!text.isEmpty()) {
                String[] newArr = new String[arr.length + 1];
                System.arraycopy(arr, 0, newArr, 0, arr.length);
                newArr[arr.length] = text;
                arr = newArr;
                jlist1.setListData(arr);
                textField1.setText("");
            }
        } else {
            System.out.println(((JButton) e.getSource()).getText() + " clicked!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ListDemo("ListDemo"));
    }
}