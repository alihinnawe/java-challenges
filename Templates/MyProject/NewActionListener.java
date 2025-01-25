import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewActionListener implements ActionListener{
    JButton button;
    JTextField textField1;
    public NewActionListener(JButton buttonNew,JTextField textFieldNew) {
        button = buttonNew;
        textField1 = textFieldNew;
    }
    public void actionPerformed(ActionEvent ae) {
        String cmd =  ae.getActionCommand();

        if (cmd.equals("button1"))
        {
            textField1.setText("Button1 is selected");
        }
        else if (cmd.equals("button2")){
            textField1.setText("Button2 is selected");

        }
    }

    public static void main(String[] args) {

    }
}
