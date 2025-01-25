import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

 public class $MyTemplate extends JFrame implements Runnable
{
    private static String newArgs;
    private static int newArgsInt;
    JPanel panel1 = new JPanel();
    JPanel mainPanel;
    //JComboBox combobox1;
    //JCheckBox checkBox1;
    JTextField textFiled1;
    JTextField textFiled2;
//    JButton button1;
//    JButton button2;

    $MyTemplate(String s) {
        super(s);
    }

    public void run() {
//        button1 = new JButton("Submit");
//        button2 = new JButton("Cancel");
        List<JButton> buttons = new ArrayList<JButton>();

        for (int i = 1 ; i <= newArgsInt;i++)
        {
            JButton button = new JButton("button" + i);
            buttons.add(button);
        }
        textFiled1 = new JTextField();
        textFiled2 = new JTextField();
        for (JButton button : buttons) {
            System.out.print("button is: " + button.getText() );
            panel1.add(button);

            //button.addActionListener(new NewActionListener(button,textFiled1));
        }

        textFiled1.setColumns(20);
        textFiled2.setColumns(20);
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
//        panel1.add(button1);
//        panel1.add(button2);


        panel1.add(textFiled1);
        panel1.add(textFiled2);

        panel1.setSize(100,100);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(panel1, BorderLayout.SOUTH);
        add (mainPanel);
        setSize(400, 300);
        pack();
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
                    String [] newArgs = args[i].split("-");
                    if (newArgs[0].equals("btn") ){
                        newArgsInt = Integer.parseInt(newArgs[1]);
                }
            }
        }
        SwingUtilities.invokeLater(new $MyTemplate("Welcome to my App"));
    }
}
