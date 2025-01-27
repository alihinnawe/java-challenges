import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NewActionListener implements ActionListener{
    JButton button;
	List<JTextField> textFields = new ArrayList<> ();

    public NewActionListener(JButton buttonNew,List<JTextField> textFieldNew) {
        button = buttonNew;
        textFields = textFieldNew;
    }
    public void actionPerformed(ActionEvent ae) {
        String cmd =  ae.getActionCommand();

        if (cmd.equals("submit"))
        {
            textFields.get(0).setText("submit button is selected");
        }
        else if (cmd.equals("cancel")){
            textFields.get(1).setText("cancel button is selected");

        }
		else
		{
			for (int i = 2; i <= textFields.size(); i++)
			{
				textFields.get(i).setText(" button" + (i + 1) + " is selected");
			}
		}
	
			
    }

    public static void main(String[] args) {

    }
}
