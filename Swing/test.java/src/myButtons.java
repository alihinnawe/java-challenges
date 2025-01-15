import java.awt.*;
import javax.swing.*;

public class myButtons extends JFrame {
	JButton button1, button2, button3;
	
	public myButtons () {
		JPanel main = new JPanel ();
		
		main.setLayout (new FlowLayout ());
		
		button1 = new JButton("Ok");
		button2 = new JButton("Open");
		button3 = new JButton("Close");
		main.add(button1);
		main.add(button2);
		main.add(button3);
		
		add (main);
		setSize (400, 400);
		setVisible (true);
	}
	
	public static void main (String[] args) 
	{
		myButtons mb = new myButtons ();
		
	}
	
}
