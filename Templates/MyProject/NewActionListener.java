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
        else {
            String btnText = button.getText();
            if (cmd.equals(btnText)) {
                String btnTextNumber = button.getText().replaceAll("[^0-9]", "");
                int btnIndexNumber = Integer.parseInt(btnTextNumber);
                textFields.get(btnIndexNumber -1).setText("button " + (btnIndexNumber) + " is selected");
            }
        }
    }

    public static void main(String[] args) {

    }
}
