import java.awt.event.*;

class StrgButtonListener implements ActionListener 
{
	public void actionPerformed (ActionEvent ae)
	{
		if (ae.getActionCommand ().equals ("ok"))
			System.out.println ("OK: " + ae);
		else if (ae.getActionCommand ().equals ("esc"))
		{
			System.out.println ("ESC: " + ae);
			System.exit (0); 
		}
	}
}
