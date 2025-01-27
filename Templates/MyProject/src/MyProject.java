import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MyProject extends JFrame implements Runnable
{
    private static String newArgs;
    private static int newArgsBtnInt, newArgstxtFInt, newArgsChkInt;
    JPanel panel1, panel2, mainPanel;
    //JComboBox combobox1;
    //JCheckBox checkBox1;
    //JTextField textFiled1;
    //JTextField textFiled2;
	//JButton button1;
	//JButton button2;

    MyProject(String s) {
        super(s);
    }

    public void run() {
//        button1 = new JButton("Submit");
//        button2 = new JButton("Cancel");
        List<JButton> buttons = new ArrayList<>();
		List<JTextField> textFields = new ArrayList<>();
        List<JCheckBox> checkboxes = new ArrayList<>();
        panel1 = new JPanel();
        panel2 = new JPanel();
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
		for (int i = 1 ; i <= newArgstxtFInt;i++)
        {
            JTextField textField = new JTextField("textField" + i);
			textField.setColumns(20);
            textFields.add(textField);
        }
        for (int i = 1 ; i <= newArgsChkInt;i++)
        {
            JCheckBox checkbox = new JCheckBox("checkbox" + i);
            checkboxes.add(checkbox);
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
        panel2.setSize(300,300);



        for (JTextField textField : textFields) {
            System.out.print("textField is: " + textField.getText() );
            panel1.add(textField);
        }
        
		for (JButton button : buttons) {
            System.out.print("button is: " + button.getText() );
            panel1.add(button);
            button.addActionListener(new NewActionListener(button,textFields));
        }

        for (JCheckBox checkBox : checkboxes) {
           checkboxes.get(0).setSelected(true);
            panel2.add(checkBox);
        }
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(panel1, BorderLayout.SOUTH);
        mainPanel.add(panel2, BorderLayout.NORTH);

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
					else if (newArgs[0].equals("txtF"))
					{
						newArgstxtFInt = Integer.parseInt(newArgs[1]);
					}
                    else if  (newArgs[0].equals("chk"))
                    {
                        newArgsChkInt = Integer.parseInt(newArgs[1]);
                    }
					
            }
        }
        SwingUtilities.invokeLater(new MyProject("Welcome to my App"));
    }
}
