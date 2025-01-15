import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListDemo extends JFrame implements Runnable, ActionListener {
    String[] arr = {"Ali", "Hinnawe", "Lebanon", "Beirut"}; // Keep arr as a String array
    Vector<String> v = new Vector<>();

    // Declare components as instance variables to access them in actionPerformed
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

        // Create JLists
        jlist1 = new JList<>(arr); // Initialize jlist1 with the String array
        JList<String> jlist2 = new JList<>(v);

        // Add JLists to panels
        p1.add(jlist1);
        p2.add(jlist2);

        // Initialize buttons
        JButton button1 = new JButton("Button1");
        JButton button2 = new JButton("Button2");
        JButton button3 = new JButton("Button3");
        JButton button4 = new JButton("Button4");

        // Add ActionListener to buttons
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

        // Add buttons to panels
        p3.add(button1);
        p3.add(button2);
        p4.add(button3);
        p4.add(button4);

        // Initialize text fields
        textField1 = new JTextField("textField1"); // Initialize textField1
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

        // Set layout for mainPanel
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(p1, BorderLayout.EAST);
        mainPanel.add(p2, BorderLayout.WEST);
        mainPanel.add(p3, BorderLayout.NORTH);
        mainPanel.add(p4, BorderLayout.SOUTH);

        // Add mainPanel to the frame
        add(mainPanel);

        // Pack and make the frame visible
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        if (e.getActionCommand().equals("Button1")) { // Check if Button1 was clicked
            String text = textField1.getText(); // Get text from textField1
            if (!text.isEmpty()) { // Check if the text is not empty
                // Create a new array with one additional slot
                String[] newArr = new String[arr.length + 1];

                // Copy the old array into the new array
                System.arraycopy(arr, 0, newArr, 0, arr.length);

                // Add the new text to the end of the new array
                newArr[arr.length] = text;

                // Update the reference to the new array
                arr = newArr;

                // Update the JList with the new array
                jlist1.setListData(arr);

                // Clear the text field after adding
                textField1.setText("");
            }
        } else {
            System.out.println(((JButton) e.getSource()).getText() + " clicked!");
        }
    }

    public static void main(String[] args) {
        // Run the application on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new ListDemo("ListDemo"));
    }
}