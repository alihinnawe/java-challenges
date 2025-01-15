import java.awt.*;
import javax.swing.*;
import java.util.*;

public class ListDemo extends JFrame implements Runnable 
{
    String[] arr = {"Ali", "Hinnawe", "Lebanon", "Beirut"};
	Vector <String> v =  new Vector <> ();
    public ListDemo(String title) {
        setTitle(title);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void run() {
        //JButton [] jbutton  =  new JButton[2];
        //jbutton[0] = new JButton("Button 1");
       // jbutton[1] = new JButton("Button 1");
        JPanel mainPanel = new JPanel();
		v.add("Name");
		v.add("FName");
		v.add("Country");
		v.add("City");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3  = new JPanel();
        JPanel p4 = new JPanel();
        JList<String> jlist1 = new JList<>(arr);
        JList<String> jlist2 = new JList<>(v);

        p1.add(jlist1);
        p2.add(jlist2);

        //{
           // for (int i = 0; i < jbutton.length; i++) {
             //   p3.add(jbutton[i]);
          //  }
         //   for (int i = 0; i < jbutton.length; i++) {
           //     p4.add(jbutton[i]);
           // }
      //  }

        p3.add(new JButton("Button1"));
        p3.add(new JButton("Button2"));
        p4.add(new JButton("Button3"));
        p4.add(new JButton("Button4"));
        JTextField textField1 = new JTextField("textField1");
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ListDemo("ListDemo"));
    }
}
