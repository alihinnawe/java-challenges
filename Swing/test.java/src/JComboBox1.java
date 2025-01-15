import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class JComboBoxDemo implements Runnable 
{
	private JFrame jframe;
	private JComboBox <String> jcmbKurs;
	private int oldindex = 0;
	private String auswahl = "";
	
	public JComboBoxDemo (String title)
	{
		jframe = new JFrame (title);
		jframe.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	}

	class SwingTool {
		public static void resize (JComponent what, int size) {};
	}
	
	private JPanel createListenPanel (String [] werte)
	{
		JPanel jpDetails = new JPanel ();
		JRadioButton [] jrb = new JRadioButton [werte.length];
		jpDetails.setLayout (new BoxLayout (jpDetails, BoxLayout.PAGE_AXIS));
		ButtonGroup bg = new ButtonGroup ();
		
		for (int i = 0; i< werte.length; ++i)
		{
			jrb[i] = new JRadioButton (werte[i]);
			String s = werte [i];
			char key = s.charAt (0);
			jrb[i].setMnemonic (key);
			jrb[i].setActionCommand (werte[i]);
			jrb[i].addActionListener (new ActionListener () {
				public void actionPerformed (ActionEvent ae) {
					auswahl = ae.getActionCommand ();
					System.out.println ("gew#hlt: " + auswahl);
					jpDetails.updateUI ();
				}
			});
			
			bg.add (jrb[i]);
			jpDetails.add (jrb[i]);			
		}
		return jpDetails;
	}
	
	public void run ()
	{
		JPanel p = new JPanel ();
		p.setLayout (new BorderLayout ());
		JPanel [] details = new JPanel [3];
		String [] kurse = {"IT", "Buchhaltung", "Grafik"};
		
		// IT
		String [] it = {"Programmieren","DB","Netzwrk","Hardware"};
		// Buchhaltg
		String [] bh = {"Einkauf", "Verkauf","Marketing","Lohnbuchhaltg","Schwarzgeld"};
		// Grafik
		String [] gr = {"2d", "3d","Animation"};
	
		details [0] = createListenPanel (it);
		details [1] = createListenPanel (bh);	
		details [2] = createListenPanel (gr);
		
		jcmbKurs = new JComboBox <> (kurse); 
		SwingTool.resize (jcmbKurs, 21); // fontsize 21pt
		
		jcmbKurs.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent ae)
			{
				int idx = jcmbKurs.getSelectedIndex ();
				System.out.println ("Index: " + idx);
				p.remove (details [oldindex]);
				oldindex = idx;
				p.add (details[idx], BorderLayout.CENTER);
				p.updateUI (); 
			}
		});
		p.add (jcmbKurs, BorderLayout.NORTH);
		p.add (details[0], BorderLayout.CENTER);
		jframe.add (p);
		// jframe.pack ();
		jframe.setSize (400, 200);
		// SwingTool.center (jframe);
		jframe.setVisible (true);
	}
	
	public static void main (String[] args) 
	{
		SwingUtilities.invokeLater (
			new JComboBoxDemo ("JComboBoxDemo")
		);
	}
	
}

