import java.util.*;
import java.util.Scanner;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;


public class Replacer extends JFrame implements Runnable{
	static int argsbtnsNumber, textFieldsNumber, argstextAreaNumber, pnNumber;
	
	JPanel mainPanel, panel;
	List <JButton> buttons =  new ArrayList<>();
	List <JTextField> textFields =  new ArrayList<>(); 
	List <JTextArea> teaxtArea = new ArrayList <>();
	List <JPanel> panels = new ArrayList <>();

	 public void run ()
	 
	{
		 
		 for (int i = 0; i <= argsbtnsNumber; i++)
		 {
			 if ( i == 1)
			 { 
			 JButton button = new JButton("Open");
			 buttons.add(button);
			 }
			 
			 else if (i == 2)
			 { 
			 JButton button = new JButton("save");
			 buttons.add(button);

			 }
			 
			 else 
			 {
				JButton button = new JButton("button" + i);
				buttons.add(button);

			 }
		}
			
		
		for (JButton button : buttons)
		{
			panel.add(button);
			}
			
			
		for (int i = 0; i <= textFieldsNumber; i++)
		{
			 if ( i == 1)
			 { 
				 JTextField textField = new JTextField("search");
				 textFields.add(textField);
			 }
			 
			 else if (i == 2)
			 { 
				 JTextField textField = new JTextField("result");
				 textFields.add(textField);
			 }
			 
			 else 
			 {
				 JTextField textField = new JTextField("textField" + i);
				 textFields.add(textField);
			 }
		}
		
		
		for (int i = 0; i <= argstextAreaNumber; i++)
		{
			if ( i == 1)
			{ 
				JButton button = new JButton("Open");
				buttons.add(button);
			}

			else if (i == 2)
			{ 
			JButton button = new JButton("save");
			buttons.add(button);

			}

			else 
			{
			JButton button = new JButton("button" + i);
			buttons.add(button);

			}
		}
		
		 mainPanel =  new JPanel();
		 mainPanel.setLayout(new BorderLayout());
		 
		 
		for (int i = 0; i <= pnNumber; i++)
		{
			if ( i == 1)
			{ 
			JPanel panel = new JPanel();
			panel.setSize(100,100);
			mainPanel.add(panel, BorderLayout.NORTH);
			panels.add(panel);
			}

			else if (i == 2)
			{ 
			JPanel panel = new JPanel();
			panel.setSize(100,100);
			mainPanel.add(panel, BorderLayout.SOUTH);


			}

			else 
			{
			JPanel panel = new JPanel();
			panel.setSize(100,100);
			panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
			mainPanel.add(panel, BorderLayout.CENTER);
			}
		}
		
		
		 pack();
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setVisible(true);
	 }
		 
		 
		 
	public static void main (String[] args) {
		
		if (args.length == 0)
		{
			System.exit(1);
			}
			
		else
		{
			for (int i = 1 ; i <= args.length; ++i )
			{	
				String [] newArgs = args[i].split("");
				
				switch (newArgs[0]) {
					case "btn": 
					{
						argsbtnsNumber = Integer.parseInt(newArgs[1]);
						break;
					}
					case "textA": 
					{
						argstextAreaNumber = Integer.parseInt(newArgs[1]);
						break;
					}
					case "txtF": 
					{
						textFieldsNumber = Integer.parseInt(newArgs[1]);
						break;
					}
					
					case "pn": 
					{
						pnNumber = Integer.parseInt(newArgs[1]);
						break;
					}
					
					default:
					{
						return;
						
						}
					
					}
				

				}
			}
		SwingUtilities.invokeLater(new Replacer());
		
		}
	}
