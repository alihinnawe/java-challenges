import java.awt.*;
import javax.swing.*;
import java.util.*;

public class ListDemo extends JFrame implements Runnable {

	String [] arr;
	Vector <String> v;
	
	public ListDemo(String title)
	{   setTitle (title);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void run ()
	{
		JPanel p = new JPanel ();
		p.setLayout (new BorderLayout ());
		setVisible(true);
		pack();
	}
	public static void main (String[] args) 
	{
		SwingUtilities.invokeLater (
			new ListDemo ("ListDemo")
		);
	}
}
