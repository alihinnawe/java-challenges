import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TicTacToe extends JFrame implements Runnable
{
	
	
	public TicTacToe(String title)
	{
		super(title);
		
		
	}
	
	
	public void run()
	{
		
		JPanel jpanel = new JPanel();
		
		jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));
		add(jpanel);
		ButtonListener bl = new ButtonListener();
		for(int i=1;i<=3;i++)
		{
			JPanel bpanel = new JPanel();
			for(int j=1;j<=3;j++)
			{			
				JButton button = new JButton(" ");
				//button.setText("X");
				bpanel.add(button);
				button.addActionListener(bl);
				button.setToolTipText(" " + i + " " + j);
			}
			jpanel.add(bpanel);
		}
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public class ButtonListener implements ActionListener
	{
		public void  actionPerformed(ActionEvent e)
		{
			Object o = e.getSource();
			JButton b = (JButton)o;
			String s = e.getActionCommand();
			if(s.equals(" "))
				b.setText("X");	
			else if(s.equals("X"))
				b.setText("0");		
			else
				b.setText(" ");		
			//System.out.println(e);
		}
	}
	
	
	public static void main (String[] args){
		
		SwingUtilities.invokeLater(new TicTacToe("TicTacToe"));
	}
	
}
