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
public class KeywordsDoneMo extends JFrame implements ActionListener, Runnable
{
	private static final String progname = "KeywordsDoneMo 0.4";

	ResourceBundle b = ResourceBundle.getBundle ("KeywordsDone");

	private int fontsize = 16; 

	// private JList <JCheckBox> jlist;
	private JTextField keywordNeu;
	private JTextField filename;
	private JButton select, ende, esc, save, read, add, fplus, fminus;
	private JFileChooser jfc = new JFileChooser ("./");
	// aufpassen, dass vcb und das Scrollpanel synchron bleiben,
	// also dass zu beiden zugefügt wird, nicht bloß zu einem
	private Vector <JCheckBox> vcb = new Vector <> ();
	private JPanel checkboxPanel;
	
	private boolean unchanged = true; 

	public KeywordsDoneMo (String keywordfile)
	{
		super (progname);
		JPanel mainpanel = new JPanel ();
		mainpanel.setLayout (new BorderLayout ());
		add (mainpanel);

 		// JLabel jl = new JLabel (b.getString ("new keyword: "));
		JLabel jl = new JLabel ("new keyword: ");
		keywordNeu = new JTextField (15);
		filename  = new JTextField (keywordfile);
		select	  = new JButton ("select");
		  read	  = new JButton ("read");
		   add	  = new JButton ("add");
		  save	  = new JButton ("save");
		  ende	  = new JButton ("end");
		   esc    = new JButton ("esc");
		   fplus  = new JButton ("<html><i>f</i><b>+</b>");
		   fminus = new JButton ("<html><i>f</i><b>-</b>");

		   select.setActionCommand ("select");
		    fplus.setActionCommand ("fplus");
		   fminus.setActionCommand ("fminus");
		   
		/*
		select = new JButton (b.getString ("select"));
		  read = new JButton (b.getString ("read"));
		   add = new JButton (b.getString ("add"));
		  save = new JButton (b.getString ("save"));
		  ende = new JButton (b.getString ("end"));
		   esc = new JButton (b.getString ("esc")); */

		JToolBar top = new JToolBar ();
		JToolBar bottom = new JToolBar ();
		
		FileNameExtensionFilter fifi = new FileNameExtensionFilter ("Keyword Filter", "kw", "txt");	
		jfc.setFileFilter (fifi);
		
		java.util.List <JComponent> jul1 = java.util.List.of (select, filename, read);
		java.util.List <JComponent> jul2 = java.util.List.of (fplus, fminus, add, keywordNeu, save, ende, esc);
		jul1.forEach (comp ->
		{
			top.add (comp);
			if (comp instanceof JButton jb)
			{
				jb.addActionListener (this);
			}
			SwingTool.resize (comp, 18);
		});
		jul2.forEach (comp ->
		{
			bottom.add (comp);
			if (comp instanceof JButton jb)
			{
				jb.addActionListener (this);
			}
			SwingTool.resize (comp, 18);
		});
		
		JScrollPane center = readFile ();
		mainpanel.add (center,	BorderLayout.CENTER);
		mainpanel.add (top, 	BorderLayout.NORTH);
		mainpanel.add (bottom,	BorderLayout.SOUTH);
	}

	/** neues KW in Liste der Checkboxen und in den Vector, zum Speichern */
	private void add ()
	{
		JCheckBox neu = new JCheckBox (keywordNeu.getText (), false);
		vcb.add (neu);
		SwingTool.resize (neu, 18);
		checkboxPanel.add (neu);
		unchanged = false; 
	}

	class SwitchListener implements ActionListener
	{
		public void actionPerformed (ActionEvent ae)
		{
			unchanged = false;
		}
	}

	/**
		System.exit (1) if FileNotFound
	*/
	private JScrollPane readFile ()
	{
		File f = new File (filename.getText ());
		Scanner sc = null;
		try
		{
			sc = new Scanner (f);
		}
		catch (FileNotFoundException fnfe)
		{
			fnfe.printStackTrace ();
			System.exit (1);
		}
		checkboxPanel = new JPanel ();
		checkboxPanel.setLayout (new BoxLayout (checkboxPanel, BoxLayout.PAGE_AXIS));

		SwitchListener sl = new SwitchListener ();
		
		vcb.clear ();
		int counter = 0;
		while (sc.hasNext ())
		{
			int bit = sc.nextInt ();
			String schluesselwort = sc.next ();
			// System.out.println ("> " + schluesselwort);
			JCheckBox jcb = new JCheckBox (schluesselwort, (bit == 1));
			jcb.addActionListener (sl);
			SwingTool.resize (jcb, 18);
			checkboxPanel.add (jcb);
			vcb.add (jcb);
			++counter;
		}
		sc.close ();
		System.out.println ("Counter: " + counter);
		JScrollPane scroll = new JScrollPane (checkboxPanel);
		scroll.setPreferredSize (new Dimension (400, 800));
		scroll.setMaximumSize (new Dimension (400, 1200));
		unchanged = true; 
		return scroll;
	}

	@Override 
	public void actionPerformed (ActionEvent ae)
	{
		String cmd = ae.getActionCommand ();
		System.out.println ("cmd"); 
		switch (cmd)
		{
			case "select": select (); 		break;
			case "add"   : add ();  		break;
			/** Howto protocoll, ob irgendwas geändert wurde? */
			case "ende"  : beenden (true);  break;			
			case "esc"   : beenden (false);	break;
			case "read"  : readFile (); 	break;
			case "save"	 : save (); 		break;
			case "fplus"  : fontsResize (this, fontsize +=2); break;
			case "fminus" : fontsResize (this, fontsize -=2); break;
			
			default: System.out.println ("Den Button gibt es nicht: " + cmd); break;
		}
	}

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

	private void beenden (boolean save)
	{	/** TODO Dialog "Änderungen! Wirklich schließen?" */
		if (unchanged || ! save)
			System.exit (0);
	}
	
	private void save () 
	{
		int returnVal = jfc.showSaveDialog (KeywordsDoneMo.this);
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			File file = jfc.getSelectedFile();
			String fname = file.getName ();
			try
			{
				PrintStream ps = new PrintStream (fname);	
				for (JCheckBox jcb : vcb)
				{
					ps.println ((jcb.isSelected () ? 1 : 0) + "\t" + jcb.getText ());
				}
			}
			catch (FileNotFoundException fnfe)
			{
				for (JCheckBox jcb : vcb)
				{
					System.out.println ((jcb.isSelected () ? 1 : 0) + "\t" + jcb.getText ());
				}				
			}
		}
		else
			System.out.println ("aborting: save");
	}
	
	private void select ()
	{	
		int returnVal = jfc.showOpenDialog (KeywordsDoneMo.this); 
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			File file = jfc.getSelectedFile ();
			filename.setText (file.getName ());
			readFile  ();
		}
		else
		{
			System.out.println ("select command cancelled by user.");
		}
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
		String file = "keywords.java.txt";
		if (args.length > 1)
		{
			usage ();
			System.exit (1);
		}
		if (args.length == 1)
		{
			file = args[0];
		}
		SwingUtilities.invokeLater (new KeywordsDoneMo (file));
	}

	public static void usage ()
	{
		System.out.println ("Usage:\tjava KeywordsDoneMo keywords.LANGUAGE.txt");
	}
}
