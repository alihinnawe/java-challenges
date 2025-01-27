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
    private static int newArgsBtnInt, newArgsChkInt;
    JPanel panel1 = new JPanel();
    JPanel mainPanel;
    //JComboBox combobox1;
    //JCheckBox checkBox1;
    //JTextField textFiled1;
    //JTextField textFiled2;
	//JButton button1;
	//JButton button2;

    $MyTemplate(String s) {
        super(s);
    }

    public void run() {
//        button1 = new JButton("Submit");
//        button2 = new JButton("Cancel");
        List<JButton> buttons = new ArrayList<>();
		List<JTextField> textFields = new ArrayList<>();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        for (int i = 1 ; i <= newArgsBtnInt;i++)
        {   if (i == 1)
			{
				JButton button = new JButton("submit");
				buttons.add(button);
			}
			else if (i == 2)
			{
				JButton button = new JButton("cancel");
				buttons.add(button);
			}
			else 
			{
                // I fixed the bug it was: for (int j = i; j <= buttons.size(); j++)
                // i removed the inner for loop
                JButton button = new JButton("button" + i);
                buttons.add(button);
			}
        }
		for (int i = 1 ; i <= newArgsChkInt;i++)
        {
            JTextField textField = new JTextField("textField" + i);
			textField.setColumns(20);
            textFields.add(textField);
        }
		
		//textFiled1 = new JTextField();
		//textFiled2 = new JTextField();
		//textFiled1.setColumns(20);
		//textFiled2.setColumns(20);
		//panel1.add(button1);
		//panel1.add(button2);


        //panel1.add(textFiled1);
        //panel1.add(textFiled2);
        panel1.setSize(100,100);
        

		
		for (JTextField textField : textFields) {
            System.out.print("textField is: " + textField.getText() );
            panel1.add(textField);
        }
        
		for (JButton button : buttons) {
            System.out.print("button is: " + button.getText() );
            panel1.add(button);
            button.addActionListener(new NewActionListener(buttons,textFields));
        }
        
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
                    if (newArgs[0].equals("btn") )
					{
                        newArgsBtnInt = Integer.parseInt(newArgs[1]);
					}
					if (newArgs[0].equals("chk"))
					{
						newArgsChkInt = Integer.parseInt(newArgs[1]);
					}
					
            }
        }
        SwingUtilities.invokeLater(new $MyTemplate("Welcome to my App"));
    }
}
