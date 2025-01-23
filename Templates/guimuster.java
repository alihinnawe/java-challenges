// package 

import java.util.*;

/**
	$NAME
	$DATE
*/
class $NAME extends JFrame implements ActionListener, Runnable 
{
	String progname = "$NAME v.0.1 (alpha)"
	
	public $NAME ()
	{
		super (progname); 
	}

	public void run ()
	{
		pack ();
		setLocationRelativeTo (null);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setVisible (true);
	}

	public static void main (String[] args) 
	{
		SwingUtilities.invokeLater (new $NAME ());
	}	
}
