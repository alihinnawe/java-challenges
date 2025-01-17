import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class JListDemo extends JFrame implements Runnable
{
	public JListDemo (String title) {
		super (title);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	}

	private JTextField [] jtf;
	private Vector <String> vs;
	JList <String> jl1, jl2;
	
	/** Panel mit 2 Spalten für Listen.
	*/
	public JPanel createListenPanel ()
	{
		JPanel jp = new JPanel ();

		String [] sarr = {"Jimmy Hendrix", "Deep Purple", "Janis Joplin", "Rolling Stones", "Allman Brothers", "Dire Straits", "Aretha Franklin", "Tina Turner", "Udo Lindenberg"}; 
		vs = new Vector <> ();
			vs.add ("Marzipan");
			vs.add ("Schokolade");
			vs.add ("Vanilleeis");
			vs.add ("Spießbraten");
			vs.add ("Räucheraal");

		jl1 = new JList <> (sarr);
		jl2 = new JList <> (vs);
		
		jtf = new JTextField [4];

		jp.add (genJListPanel ("The Beatles",  "Rock",   0, 1, jl1));
		jp.add (genJListPanel ("Mozartkugeln", "Genuss", 2, 3, jl2));
		
		return jp;
	}

	/**	[neuerEintrag   ] <---- (jtf[iNeu])
		
		+-- label ------+-+
        | jlist.get(0)  |^|
        | jlist.get(1)  | |
        | jlist.get(2)  | |
        | .             | |
        | .             | |
        | .             | | <--- scroll
		+---------------+-+
		|              >| |
		+---------------+-+

		[Doors, Stones   ]  <--- (jtf[iVerkettet])
	*/
	private JPanel genJListPanel (String neuerEintrag, String label, int iNeu, int iVerkettet, JList <String> jlist)
	{
		jtf[iNeu] = new JTextField (neuerEintrag, 20);
		jtf[iNeu].addKeyListener (new AddingKeyAdapter ());
		jtf[iVerkettet] = new JTextField (25);

		JPanel spaltenPanel = new JPanel ();
		spaltenPanel.setLayout (new BoxLayout (spaltenPanel, BoxLayout.PAGE_AXIS));
		
		JScrollPane scroll = new JScrollPane (jlist);
		scroll.setBorder (BorderFactory.createTitledBorder (label));

		spaltenPanel.add (jtf[iNeu]);
		spaltenPanel.add (scroll);
		spaltenPanel.add (jtf[iVerkettet]);
		
		SwingTool.resize (jtf[iNeu], 22);
		SwingTool.resize (jlist, 22);
		SwingTool.resize (jtf[iVerkettet], 22);

		return spaltenPanel;
	}

	/**
		+: Neues Element von oberem JTextField der Liste zufügen. Aus JTF löschen.
		ok: Gewählte Elemente der JList ins untere JTextField übertragen.
		esc: Programm beenden.
	*/
	class JListButtonListener implements ActionListener
	{
		public void actionPerformed (ActionEvent ae)
		{
			String action = ae.getActionCommand ();
			if (action.equals ("+"))
			{
				// System.out.println ("+ Plus detected!");
				/** nicht möglich - zugrundeliegende Struktur ist ein Array,
					es kann nichts zugefügt werden.
				if (jtf[0].getText ().length > 0)
					sarr.add (jtf[0].getText ()); */
				// if (! (jtf[2].getText ().isEmpty ()))
				if (jtf[2].getText ().length () > 0)
				{
					vs.add (jtf[2].getText ());
					jl2.setListData (vs);
				}
				// jl1 (links) ist mit Array verbunden
				// und kann nicht aktualisiert werden
				// jtf[0].setText (""); 
				jtf[2].setText (""); 
			}
			else if (action.equals ("ok"))
			{
				// System.out.println ("OK detected!");
				putSelections2TF (jl1, jtf[1]);
				putSelections2TF (jl2, jtf[3]);
			}
			else if (action.equals ("esc"))
				System.exit (0);
				// System.out.println ("ESC detected!");
		}
	}

	/** großes Potential, eine Funktion zu extrahieren mit ButtonListener
	*/
	class AddingKeyAdapter extends KeyAdapter 
	{
		@Override public void keyTyped (KeyEvent ke)
		// @Override public void keyReleased (KeyEvent ke)
		{
			int kc = ke.getKeyCode ();
			if (kc == KeyEvent.VK_ENTER)
			{
				// System.out.println ("+ Plus detected!");
				/** nicht möglich - zugrundeliegende Struktur ist ein Array,
					es kann nichts zugefügt werden.
				if (jtf[0].getText ().length > 0)
					vs.add (jtf[0].getText ()); */
				if (jtf[2].getText ().length () > 0)
				{
					vs.add (jtf[2].getText ());
					jl2.setListData (vs);
				}
				// jl1 (links) ist mit Array verbunden
				// und kann nicht aktualisiert werden
				// jtf[0].setText (""); 
				jtf[2].setText (""); 
			}
		}
	}

	public void putSelections2TF (JList<String> jl, JTextField jtf)
	{
		java.util.List <String> ls = jl.getSelectedValuesList ();
		boolean minOne = false;
		String verkettet = ""; 
		for (String s: ls)
		{
			verkettet += minOne ? (", " + s) : s;
			minOne = true; 
		}
		if (minOne)
		{
			jtf.setText (verkettet);
		}
	}
	
	public void run ()
	{
		JPanel p = new JPanel ();
		p.setLayout (new BorderLayout ());

		JPanel jlists = createListenPanel ();
		
		JButton plus = new JButton ("+");
		SwingTool.resize (plus, 36);
		// plus.setPreferredSize (new Dimension (60, 40));
		// plus.setMaximumSize (new Dimension (60, 40));
		// p.add (plus, BorderLayout.NORTH);
		// Fügt man den Plusbutton direkt dem BorderLayout.NORTH zu, ohne
		// eigenes Panel, dann erstreckt er sich über die ganze Panelbreite.
		JPanel plusPanel = new JPanel ();
		plusPanel.add (plus);
		
		p.add (plusPanel, BorderLayout.NORTH);
		JListButtonListener jlbl = new JListButtonListener ();
		plus.addActionListener (jlbl);
		
		p.add (jlists, BorderLayout.CENTER);

		JButton  ok = new JButton ("ok");
		JButton esc = new JButton ("esc");
		SwingTool.resize ( ok, 24);
		SwingTool.resize (esc, 24);
		
		 ok.addActionListener (jlbl);
		esc.addActionListener (jlbl);
		
		JPanel jpSouth = new JPanel ();
		jpSouth.add (ok); 
		jpSouth.add (esc); 
		p.add (jpSouth, BorderLayout.SOUTH);
		add (p);
		pack ();
		// SwingTool.center (this);
		setLocationRelativeTo (null);
		setVisible (true);
	}
	
	public static void main (String[] args)
	{
		SwingUtilities.invokeLater (new JListDemo ("JListDemo v. 0.1 alpha"));
	}
}
