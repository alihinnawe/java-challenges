import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Button12Listener implements ActionListener 
{
	JTextField textField;
	Vector <String> vector;
	JList <String> jlist;
	
	public Button12Listener (JTextField tf,
		Vector <String> v,
		JList <String> jl) 
	{
		textField = tf;
		vector = v;
		jlist = jl;

	}
	
    public void actionPerformed (ActionEvent e) {
        String cmd = e.getActionCommand ();
        if (cmd.equals ("Button1") || cmd.equals ("Button2")) 
        {
            String text = textField.getText();
			vector.add(text);
            jlist.setListData(vector);
            textField.setText("");
        } else {
            System.out.println(((JButton) e.getSource()).getText() + " clicked");
        }
    }
}
