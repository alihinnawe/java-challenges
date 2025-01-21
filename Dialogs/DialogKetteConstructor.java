// package

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*; 
import java.io.*;
import javax.swing.filechooser.*;

/**
	KeywordsDone

	@author Stefan Wagner
	@date Do 16. Jan 14:40:39 CET 2025

*/
public class DialogKette extends JFrame implements ActionListener, Runnable
// public class DialogKette implements ActionListener, Runnable
{
	private static final String progname = "DialogKette 0.1 alpha";

	public DialogKette ()
	{
		super (progname);
		// test 1
		// JOptionPane.showConfirmDialog (this, "Multiplikation", "Addition oder Multiplikation", JOptionPane.YES_NO_OPTION);
		// test 2:
		
		/*
		Object[] auswahl = {"Multiplikation", "Addition"};
		Object selected = JOptionPane.showInputDialog (null,
             "Choose one", "Addition oder Multiplikation",
             JOptionPane.INFORMATION_MESSAGE, null,
             auswahl, auswahl[1]);
        */
        
        Object[] options = {"Multiplikation", "Addition"};
		int selected = JOptionPane.showOptionDialog (null, 
			"Addition oder Multiplikation", "Auswahl",
             // JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
             // JOptionPane.CLOSED_OPTION, JOptionPane.QUESTION_MESSAGE,
             JOptionPane.CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
             null, options, options[0]);
        if (selected == -1)
			System.err.println ("Zu blöd einen Button zu klicken!");
		else 
			System.out.println ("selected: " + options[selected]);
        
        
        String label = (selected == 0) ? "Faktoren" : "Summanden";
		/*	
        String res = JOptionPane.showInputDialog (
			null, 
			"Geben Sied die " + label + " ein",
			"Gleichung", 
			JOptionPane.QUESTION_MESSAGE
		);
        System.out.println ("> " + res);
        */
        JDialog werteDialog = new JDialog (this, "Geben Sie bitte 2 " + label + " ein.");
        werteDialog.add (labeledTextField ("1: "));
        werteDialog.add (labeledTextField ("2: "));
        werteDialog.setVisible (true);
        dispose ();
	}

	JPanel labeledTextField (String label)
	{
		JPanel jp = new JPanel ();
		jp.add (new JLabel (label));
		jp.add (new JTextField (4));
		return jp;
	}

	/**
	class SwitchListener implements ActionListener
	{
		public void actionPerformed (ActionEvent ae)
		{
			unchanged = false;
		}
	}

		System.exit (1) if FileNotFound
	*/

	@Override 
	public void actionPerformed (ActionEvent ae)
	{
	}
/*
	public static void resize (Component c, float size)
	{
		Font font = c.getFont ();
		font = font.deriveFont (size);
		c.setFont (font);
	}

	private void fontsResize (Container cont, int size)
	{
		// System.out.print ("+");
		Component [] childs = cont.getComponents ();
		for (Component child : childs)
		{
			resize (child, size);
			if (child instanceof Container c)
				fontsResize (c, size); 
		}
	}
*/
	private void beenden (boolean save)
	{	
		System.exit (0);
	}
	
	public void run ()
	{
		//  setSize (400, 400);
		pack ();
		setLocationRelativeTo (null);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setVisible (true);
	}

	public static void main (final String args[])
	{
		if (args.length > 0)
		{
			usage ();
			System.exit (1);
		}
		SwingUtilities.invokeLater (new DialogKette ());
	}

	public static void usage ()
	{
		System.out.println ("Usage:\tjava DialogKette ");
	}
}
