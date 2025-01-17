import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListDemo extends JFrame implements Runnable, ActionListener {
    Vector<String> v1 = new Vector<>();
    Vector<String> v2 = new Vector<>();


    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    private JList<String> jlist1;
    private JList<String> jlist2;


    public ListDemo(String title) {
        setTitle(title);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void run() {
        JPanel mainPanel = new JPanel();
        v1.add("Name");
        v1.add("FName");
        v1.add("Country");
        v1.add("City");

        v2.add("Ali");
        v2.add("Hinnawe");
        v2.add("Lebanon");
        v2.add("Beirut");
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

        jlist1 = new JList<>(v1);
        jlist2 = new JList<>(v2);

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

        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();


        textField1.setColumns(20);
        textField2.setColumns(20);
        textField3.setColumns(20);
        textField4.setColumns(20);

        p3.add(textField1);
        p3.add(textField2);
        p4.add(textField3);
        p4.add(textField4);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(p1, BorderLayout.WEST);
        mainPanel.add(p2, BorderLayout.EAST);
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
                v1.add(text);
                jlist1.setListData(v1);
                textField1.setText("");
            }
        }
        else if (e.getActionCommand().equals("Button2")) {
            String text = textField2.getText();
            if (!text.isEmpty()) {
                v2.add(text);
                jlist2.setListData(v2);
                textField2.setText("");
            }
        }
        else if (e.getActionCommand().equals("Button3")){

            List<String> textJlist1 = jlist1.getSelectedValuesList();
            if (textJlist1.isEmpty())
            {
                textField3.setText("[]");

            }
            else {
                textField3.setText(textJlist1.toString());
            }
            if (textJlist1.isEmpty())
                {
                    textField2.setText("[]");
                }
            else
            {
                List<String> textJlist2 = jlist2.getSelectedValuesList();
                textField2.setText(textJlist2.toString());
            }
        }
        else if (e.getActionCommand().equals("Button4")){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ListDemo("ListDemo"));
    }
}