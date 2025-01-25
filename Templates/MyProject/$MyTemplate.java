import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;

 public class $MyTemplate extends JFrame implements Runnable
{
    JPanel panel1;
    JPanel mainPanel;
    //JComboBox combobox1;
    //JCheckBox checkBox1;
    JTextField textFiled1;
    JTextField textFiled2;
    JButton button1;
    JButton button2;

    $MyTemplate(String s) {
        super(s);
    }

    public void run() {
        button1 = new JButton("Submit");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String cmd =  ae.getActionCommand();
//                Object cmd1 = ae.getSource();
//                if(cmd1 instanceof JButton) {
//                    System.out.print("it is a button");
//                }
//                System.out.print("action performed is cmd1:  " + cmd1.getClass() );
//                System.out.print("action performed is cmd" + cmd );
                if (cmd.equals(button1.getText()))
                {
                    textFiled1.setText("Welcome to my first traial");
                }
            }
        });
        button2 = new JButton("Cancel");
        textFiled1 = new JTextField();
        textFiled2 = new JTextField();
        textFiled1.setColumns(20);
        textFiled2.setColumns(20);
        panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        panel1.add(button1);
        panel1.add(button2);
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
                String Newargs = args[i];
                //System.out.println(Newargs);
            }
        }
        SwingUtilities.invokeLater(new $MyTemplate("Welcome to my App"));
    }
}
