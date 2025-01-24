//package foo;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
	Program: Test5 Fri Jan 24 09:53:30 CET 2025
	@AUTHOR
	@Copyright GPLv.3
	
	@TODO: JMenu, JTable, SplitPane, JTextField, JTextArea, ...
	@TODO: KeyListener, MouseListener
	@TODO: Javadoc-Comments 
*/
public class Test5 extends JFrame implements Runnable, ActionListener
{
	private JComboBox <String> [] jcombobox = new JComboBox [2];
	private JList <String> jlist;
	private JCheckBox [] jcb;
	private JRadioButton [] jrb;
	
	public Test5 ()
	{
		super ("Test5 v.0.1 alpha");
		setLayout (new BorderLayout ());

		/*JComboBox <String> dummy1 = new JComboBox <> ();
		JComboBox <String> dummy2 = new JComboBox <> ();
		jcombobox = {dummy1, dummy2}; 
		*/
		add (genJToolBar (
			new String [] {"ok", "flucht", "help", "missing"},
			new String [] {"enter", "esc", "help", "missing"},
			new String [] {"ok", "exit program", "click for help", "missing for test of switch/default"}
		), BorderLayout.SOUTH);
		JPanel jcmBoxen = new JPanel ();
		jcmBoxen.add (genJComboBoxPanel (0, 4, "vocals", "drums", "sax", "organ/keyboard", "guitar", "bass"));
		jcmBoxen.add (genJComboBoxPanel (1, 2, "Fender", "Gibson", "Hammond", "Zylf"));
		add (jcmBoxen, BorderLayout.NORTH);
		// add (genJComboBoxPanel (0, "Band", 4, "vocals", "drums", "sax", "organ/keyboard", "guitar", "bass"), BorderLayout.NORTH);
		//add (genJComboBoxPanel (1, "JCB-2", 1, "foo", "bar" ), BorderLayout.NORTH);
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
		jp.setToolTipText ("Der dumme Dozent hat seine Pause noch nicht gemacht.");
		return jp;	
	}

	private JPanel genJComboBoxPanel (int i, String head, int selectedIdx, String ... labels)
	{
		JPanel jp = new JPanel ();
		jcombobox[i] = new JComboBox <> (labels);
		jp.add (jcombobox[i]);
		return jp;
	}

	private JPanel genListPanel (String head, int selectedIdx, String ... labels)
	{
		JPanel jp = new JPanel ();
		jp.setBorder (BorderFactory.createTitledBorder (head));
		int idx = 0;
		Vector <String> vector = new Vector <>(labels.length);
		for (String s : labels)
		{
			vector.add (s);
		}
		jlist = new JList <> (vector);
		jlist.setSelectedIndex (selectedIdx);
		JScrollPane jscroll = new JScrollPane (jlist);
		jp.add (jscroll);
		return jp;
	}

	private JPanel genCheckBoxPanel (String head, int selectedIdx, String ... labels)
	{
		JPanel jp = new JPanel ();
		jp.setLayout (new BoxLayout (jp, BoxLayout.PAGE_AXIS));
		jp.setBorder (BorderFactory.createTitledBorder (head));
		int idx = 0;
		jcb = new JCheckBox [labels.length];
		int i = 0; 
		for (String s : labels)
		{
			jcb[i] = new JCheckBox (s);
			jp.add (jcb[i]);
			++i;
		}
		jcb[selectedIdx].setSelected (true);
		return jp;
	}

	private JPanel genRadioButtonPanel (String head, int selectedIdx, String ... labels)
	{
		JPanel jp = new JPanel ();
		jp.setLayout (new BoxLayout (jp, BoxLayout.PAGE_AXIS));
		jp.setBorder (BorderFactory.createTitledBorder (head));
		ButtonGroup bg = new ButtonGroup ();
		int idx = 0;
		jrb = new JRadioButton [labels.length];
		for (String s : labels)
		{
			jrb[idx] = new JRadioButton (s);
			jp.add (jrb[idx]);
			bg.add (jrb[idx]);
			idx++;
		}
		jrb[selectedIdx].setSelected (true);
		return jp;
	}

	private void esc () 	{System.out.println ("au revoir"); dispose ();}
	private void help ()	{System.out.println ("@TODO help");}
	private void ok () 		
	{
		String sCombo, sCombo2, sRb = "", sCb = "", sList;
		
		sCombo = (jcombobox[0].getSelectedItem ()).toString ();
		System.out.println ("Combobox 1: " + sCombo);
		
		sCombo2 = (jcombobox[1].getSelectedItem ()).toString ();
		System.out.println ("Combobox 2: " + sCombo2);
		
		for (JRadioButton rb : jrb)
		{
			if (rb.isSelected ())
				sRb = rb.getText ();
		}
		System.out.println ("Radiobutton: " + sRb);
		for (JCheckBox cb : jcb)
		{
			if (cb.isSelected ())
				sCb += cb.getText () + ", ";
		}
		System.out.println ("Checkbox: " + sCb);
		System.out.println ("@TODO ok - evaluate all the selections");
	}

	public JPanel genMultiPanel ()
	{
		JPanel jp = new JPanel ();
		jp.setBorder (BorderFactory.createEtchedBorder ()); 
		jp.setLayout (new FlowLayout ());
		jp.add (genRadioButtonPanel ("Rock", 1, "Janis Joplin", "Frank Zappa", "Allman Brothers", "Rare Earth", "Doors", "Aretha Franklin", "Nina Hagen"));
		jp.add (genCheckBoxPanel ("Songs", 1, "Bobby Mc. Gee", "Bobby Brown", "Midnight Rider", "Get Ready", "LA Woman", "Rangehen", "Bridge over troubled Water"));
		jp.add (genListPanel ("Media", 3, "Cassette", "LP", "CD", "DVD", "Radio", "Live Concert")); 
		return jp;
	}
	
	@Override 
	public void actionPerformed (ActionEvent ae)
	{
		String cmd = ae.getActionCommand ();
		switch (cmd)
		{
			case "enter":	ok (); 		break; 
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
		// Test5 test5 = new Test5 ();
		SwingUtilities.invokeLater (new Test5 ());
	}

	public static void usage ()
	{
		System.out.println ("Usage:\tjava Test5 params... ");
	}
}
