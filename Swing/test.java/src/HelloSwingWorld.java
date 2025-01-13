import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class HelloSwingWorld extends JFrame implements Runnable {

	/*
	public HelloSwingWorld ()
	{
		super ("HelloSwingWorld SW v.0.1 (c) alpha 2025");
	}
	*/
	
	private JPanel genPanel (int color, String orientation, String ttt)
	{
		JPanel p = new JPanel ();
		JLabel jl = new JLabel (ttt);
		p.add (jl);
		p.setBorder (BorderFactory.createEtchedBorder ());
		p.setToolTipText (orientation);
		p.setBackground (new Color (color));
		add (p, orientation); 
		return p;
	}
	
	private JPanel [] p = new JPanel [5];
	
	private void initButtons ()
	{
		JButton ok = new JButton ("ok");
		JButton esc = new JButton ("esc");
		ActionListener okbl = new StrgButtonListener ();
		 ok.addActionListener (okbl);
		esc.addActionListener (okbl);
		
		p[3].add (ok);
		p[3].add (esc);		
	}
	
	private JPanel genCenterPanel ()
	{
		JPanel jp = new JPanel ();
		String[] label = {"Vorname", "Name", "PLZ"};
		jp.setLayout (new BoxLayout (jp, BoxLayout.PAGE_AXIS));
		for (int i = 0; i < 3; ++i)
		{
			JPanel sub = new JPanel ();
			sub.setLayout (new BoxLayout (sub, BoxLayout.LINE_AXIS));
			JTextField lbl = new  JTextField (12); 
			lbl.setText (label[i]);
			lbl.setEditable (false);
			sub.add (lbl);
			sub.add (new JTextField (20)); 
			for (int j = 0; j < 15; ++j)
				sub.add (new JLabel ("foobar " + j));			
			sub.setBorder (BorderFactory.createEtchedBorder ());
			jp.add (sub);
		}
		return jp; 
	}
	
	@Override public void run ()
	{
		setTitle ("HelloSwingWorld SW v.0.1 (c) alpha 2025");
		setSize (400, 200); 
		int [] farbe = {0xff0000, 0x00ff00, 0xffff00, 0x0000ff, 0xffffff};
		String [] orientation = {
			BorderLayout.NORTH,
			BorderLayout.WEST,
			BorderLayout.EAST,
			BorderLayout.SOUTH,
			BorderLayout.CENTER	};
		String [] ttt = {"Nord", "West", "Ost", "Süd", "Zentrum"};
		
		for (int i = 0; i < 5; ++i)
		{
			p[i] = genPanel (farbe[i], orientation[i], ttt[i]);		
		}
		p[4] = genCenterPanel ();
		add (p[4], BorderLayout.CENTER);
		initButtons ();
		
		pack (); 
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
		setVisible (true);		
	}

	public static void main (String[] args) 
	{
		SwingUtilities.invokeLater (new HelloSwingWorld ());
	}
}
