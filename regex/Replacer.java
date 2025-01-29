import java.util.*;
import java.util.Scanner;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;


public class Replacer extends JFrame implements Runnable{
	static int argsbtnsNumber, textFieldsNumber, argstextAreaNumber, pnNumber;
	
	JPanel mainPanel;
	List <JButton> buttons =  new ArrayList<>();
	List <JTextField> textFields =  new ArrayList<>(); 
	List <JTextArea> textAreas = new ArrayList <>();
	List <JPanel> panels = new ArrayList <>();

	 public void run ()
	 
	{
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		 
		 for (int i = 0; i < argsbtnsNumber; i++)
		 {
			 if ( i == 0)
			 { 
			 JButton button = new JButton("Open");
			 buttons.add(button);
			 }
			 
			 else if (i == 1)
			 { 
			 JButton button = new JButton("save");
			 buttons.add(button);

			 }
			 
			 else if (i == 2)
			 { 
			 JButton button = new JButton("exit");
			 buttons.add(button);

			 }
			 
			 else 
			 {
				JButton button = new JButton("button" + i);
				buttons.add(button);

			 }
		}
			

			
		for (int i = 0; i < textFieldsNumber; i++)
		{
			 if ( i == 0)
			 { 
				 JTextField textField = new JTextField("search");
				 textFields.add(textField);
			 }
			 
			 else if (i == 1)
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
		
		
		for (int i = 0; i < argstextAreaNumber; i++)
		{

			JTextArea textArea = new JTextArea();
			textAreas.add(textArea);

		}
		
	 
		for (int i = 0; i < pnNumber; i++)
		{
			if ( i == 0)
			{ 
				JPanel panel = new JPanel();
				panel.setSize(100,100);
				
				for (JButton button : buttons)
				{
					panel.add(button);
				}
				mainPanel.add(panel, BorderLayout.NORTH);
			}

			else if (i == 1)
			{ 
			JPanel panel = new JPanel();
			panel.setSize(100,100);
			
			for (JTextField textField : textFields)
			{
				panel.add(textField);
			}
			mainPanel.add(panel, BorderLayout.SOUTH);
			}

			else if (i == 2) 
			{
				JPanel panel = new JPanel();
				panel.setSize(300,200);
				panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
				JPanel centerPanel = new JPanel();
				System.out.print(textAreas.size());
				JPanel leftP = new JPanel();
				JPanel rightP = new JPanel();
				
				JTextArea lefttextA = textAreas.get(0);
				lefttextA.setPreferredSize(new Dimension(200,150));
				leftP.add(new JScrollPane(lefttextA));
				
				JTextArea righttextA = textAreas.get(1);
				righttextA.setPreferredSize(new Dimension(200,150));
				rightP.add(new JScrollPane(righttextA));			
				panel.add(leftP);
				panel.add(rightP);	
				centerPanel.add(panel);
				mainPanel.add(centerPanel, BorderLayout.CENTER);

				}
			}
		
		
		add(mainPanel);
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
			for (int i = 0 ; i <= args.length - 1; i++ )
			{	
				
				String [] newArgs = args[i].split("-");
				//System.out.print(newArgs);
				switch (newArgs[0]) {
					case "btn": 
					{
						argsbtnsNumber = Integer.parseInt(newArgs[1]);
						break;
					}

					case "txtF": 
					{
						textFieldsNumber = Integer.parseInt(newArgs[1]);
						break;
					}
					
					case "txtA": 
					{
						argstextAreaNumber = Integer.parseInt(newArgs[1]);
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
