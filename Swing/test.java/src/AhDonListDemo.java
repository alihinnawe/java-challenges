import java.awt.*;
import javax.swing.*;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AhDonListDemo extends JFrame implements Runnable {

    Vector<String> vector1 = new Vector<>();
    Vector<String> vector2 = new Vector<>();
    private JTextField textField1;
    private JTextField textField2;
    private JList<String> jlist1;
    private JList<String> jlist2;

    public AhDonListDemo(String title) {
        setTitle(title);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        vector1.add("Ali");
        vector1.add("Hinnawe");
        vector1.add("Lebanon");
        vector1.add("Beirut");

        vector2.add("Name");
        vector2.add("FName");
        vector2.add("Country");
        vector2.add("City");
    }

    public void run() {
        JPanel mainPanel = new JPanel();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

        jlist1 = new JList<>(vector1);
        jlist2 = new JList<>(vector2);

        p1.add(new JScrollPane(jlist1));
        p2.add(new JScrollPane(jlist2));

        JButton button1 = new JButton("Button1");
        JButton button2 = new JButton("Button2");
        JButton button3 = new JButton("Button3");
        JButton button4 = new JButton("Button4");

        p3.add(button1);
        p3.add(button2);
        p4.add(button3);
        p4.add(button4);

        textField1 = new JTextField(20);
        textField2 = new JTextField(20);
        p3.add(textField1);
        p3.add(textField2);

        ActionListener al1 = new Button12Listener(textField1, vector1, jlist1);
        ActionListener al2 = new Button12Listener(textField2, vector2, jlist2);

        button1.addActionListener(al1);
        button2.addActionListener(al2);
        button3.addActionListener(al1);
        button4.addActionListener(al2);

        JTextField textField3 = new JTextField(20);
        JTextField textField4 = new JTextField(20);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new AhDonListDemo("ListDemo"));
    }

    // Define the Button12Listener class
    class Button12Listener implements ActionListener {
        private JTextField textField;
        private Vector<String> vector;
        private JList<String> jlist;

        public Button12Listener(JTextField textField, Vector<String> vector, JList<String> jlist) {
            this.textField = textField;
            this.vector = vector;
            this.jlist = jlist;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = textField.getText();
            if (!text.isEmpty()) {
                vector.add(text);
                jlist.setListData(vector); // Update the JList
                textField.setText(""); // Clear the text field
            }
        }
    }
}
