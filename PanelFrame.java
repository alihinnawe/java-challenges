// wrong code because we can't apply setLayout to frame directly but to Panels.
import javax.swing.*;
import java.awt.*;
 
public class PanelFrame extends JFrame implements Runnable{

	public PanelFrame (String s){
			super(s);
		}
		
	public void run ()
	{
		JPanel p2 =  new JPanel();
		setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
		setVisible(true);
	}
	
	public static void main (String[] args) {
		SwingUtilities.invokeLater(new PanelFrame ("My Frame"));
		}
}
