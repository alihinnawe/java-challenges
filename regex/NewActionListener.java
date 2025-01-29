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

        if (cmd.equals("open"))
        {
			System.out.print("button open true" );
            textFields.get(0).setText("open button is selected");
        }
        else if (cmd.equals("save")){
			System.out.print("button save true");
            textFields.get(1).setText("save button is selected");

        }
        else if (cmd.equals("exit")){
			System.out.print("exit save true");
            textFields.get(1).setText("exit button is selected");
        }
		else if (cmd.equals("run")){
			System.out.print("exit save true");
            textFields.get(1).setText("run button is selected");
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
