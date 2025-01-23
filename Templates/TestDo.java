// package 

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
	TestDo
	Thu Jan 23 13:34:27 CET 2025
*/
public class TestDo extends JFrame implements ActionListener, Runnable
{
	// static 
	// final String progname = "TestDo v.0.1 (alpha)";
	
	public TestDo ()
	{
 		super ("TestDo v.0.1 (alpha)"); 
 		// setTitle (progname);
	}


	public void actionPerformed (ActionEvent ae)
	{
		System.out.println ("TODO");
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
		SwingUtilities.invokeLater (new TestDo ());
	}	
}
