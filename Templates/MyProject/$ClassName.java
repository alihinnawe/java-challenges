import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;

public class $ClassName extends JFrame implements Runnable {
    JPanel panel1;
    JPanel mainPanel;
    //JComboBox combobox1;
    //JCheckBox checkBox1;
    //JTextField textFiled1;
    JButton button1;
    JButton button2;

    $ClassName(String s) {
        super(s);
    }

    public void run() {
        button1 = new JButton("button1");
        button2 = new JButton("button2");
        panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(button1);
        panel1.add(button2);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(panel1, BorderLayout.SOUTH);
        add (mainPanel);
        setSize(400, 300);
        setVisible(true);
        System.out.println("Welcome to my App");
    }

    public static void usage() {
        System.out.print("Java $ClassName ClassName");
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            usage();
            System.exit(1);
        } else if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                String Newargs = args[i];
                System.out.println(Newargs);
            }
        }
        SwingUtilities.invokeLater(new $ClassName("Welcome to my App"));
    }
}
