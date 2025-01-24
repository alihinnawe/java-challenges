import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class $ClassName extends JFrame implements Runnable {
    JPanel panel;
    JComboBox combobox1;
    JCheckBox checkBox1;
    JTextField textFiled1;
    JButton button1;


    $ClassName (String s){
        super (s);
    }
    public void run () {
        System.out.println("Welcome to my App");
    }

    public static void usage ()
    {
        System.out.print("Java $ClassName ClassName");
    }

    public static void main(String[] args) {

        if (args.length == 0)
        {
            usage();
            System.exit(1);
        }
        SwingUtilities.invokeLater(new $ClassName("Welcome to my App"));

    }

}
