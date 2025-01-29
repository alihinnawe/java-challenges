//package foo;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
	Program: JTabbedPaneDemo Wed Jan 29 12:31:27 CET 2025
	@author S. Wagner, (Berlin, Rio, LA)
	@Copyright GPLv.3
	
	@TODO: JMenu, JTable, SplitPane, JTextField, JTextArea, ...
	@TODO: KeyListener, MouseListener
	@TODO: Javadoc-Comments 
*/
public class JTabbedPaneDemo extends JFrame implements Runnable, ActionListener
{
	class ValuePanel extends JPanel 
	{	
		private JLabel jlabel; 
		private JTextField value;
		
		public ValuePanel (String label, String defaultVal)
		{
			jlabel = new JLabel (label);
			value = new JTextField (15);
			if (defaultVal != null)
				value.setText (defaultVal);
			setLayout (new BoxLayout (this, BoxLayout.LINE_AXIS));
			add (jlabel);
			add (value);	
		}
		
		public String getText ()
		{
			return value.getText ();
		}
	}

	private JPanel genMultiValuePanel (String ... labels)
	{
		ArrayList <ValuePanel> vpl = new ArrayList <> ();
		JPanel jp = new JPanel ();
		jp.setLayout (new BoxLayout (jp, BoxLayout.PAGE_AXIS));
		
		for (String s: labels)
		{
			ValuePanel vp = new ValuePanel (s, "");
			jp.add (vp);
			vpl.add (vp);
		}
		return jp;
	}

	
	public JTabbedPaneDemo ()
	{
		super ("JTabbedPaneDemo v.0.1 alpha");
		setLayout (new BorderLayout ());

		add (genJToolBar (
			new String [] {"ok", "esc", "help", "missing"},
			new String [] {"ok", "esc", "help", "missing"},
			new String [] {"ok", "exit program", "click for help", "missing for test of switch/default"}
		), BorderLayout.SOUTH);
		
		add (genMultiPanel (), BorderLayout.CENTER);
	}

	private JPanel genJToolBar (String [] buttons, String []actions, String [] ttts)
	{
		JPanel jp = new JPanel (); 
		JToolBar jtb = new JToolBar ();
		for (int i = 0; i < buttons.length; ++i)
		{
			JButton jb = new JButton (buttons[i]);
			jb.setActionCommand (actions[i]);
			jb.setToolTipText (ttts[i]);
			jb.addActionListener (this);
			jtb.add (jb);
		}
		jp.add (jtb);
		return jp;	
	}

	private void esc () 	{System.out.println ("au revoir"); dispose ();}
	private void help ()	{System.out.println ("@TODO help");}
	private void ok () 		
	{
		System.out.println ("@TODO ok - evaluate all the selections");
	}

	public JTabbedPane genMultiPanel ()
	{
		JTabbedPane jtp = new JTabbedPane  ();
		JPanel jp1 = genMultiValuePanel ("Wurst", "Käse", "Creme");
		JPanel jp2 = genMultiValuePanel ("Brot", "Brötchen");
		JPanel jp3 = genMultiValuePanel ("Kaffee", "Tee", "Bier", "Wein", "Saft");
		// jp.setBorder (BorderFactory.createEtchedBorder ()); 
		// jp.setLayout (new FlowLayout ());
		jtp.add (jp1, "Brotbelag"); 
		jtp.add (jp2, "Brotbasis"); 
		jtp.add (jp3, "Getränk"); 		
		return jtp;
	}
	
	@Override 
	public void actionPerformed (ActionEvent ae)
	{
		String cmd = ae.getActionCommand ();
		switch (cmd)
		{
			case "ok":		ok (); 		break; 
			case "esc": 	esc (); 	break; 
			case "help":	help ();	break;
			default: JOptionPane.showConfirmDialog (this, "Unhandled ActionCommand", cmd, JOptionPane.DEFAULT_OPTION, 0); break;
		}
	}

	public static void resize (Component c, float size)
	{		
		Font font = c.getFont ();
		font = font.deriveFont (size);
		c.setFont (font);
	}

	private void fontsResize (Container jc, int size)
	{
		// System.out.println (" + " + jc);
		Component [] childs = jc.getComponents ();
		for (Component child : childs)
		{
			resize (child, size);
			if (child instanceof Container c)
				fontsResize (c, size); 
		}
	}

	@Override 
	public void run ()
	{		
		pack ();
		setLocationRelativeTo (null); 
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		fontsResize (this, 20);
		pack ();
		setVisible (true);
	}
	
	public static void main (String[] args) 
	{
		// JTabbedPaneDemo jtabbedpanedemo = new JTabbedPaneDemo ();
		SwingUtilities.invokeLater (new JTabbedPaneDemo ());
	}

	public static void usage ()
	{
		System.out.println ("Usage:\tjava JTabbedPaneDemo params... ");
	}
}
