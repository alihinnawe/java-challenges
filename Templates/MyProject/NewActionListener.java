import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewActionListener implements ActionListener{
    JButton button1;
    JTextField textField1;
    public NewActionListener(JButton buttonNew,JTextField textFieldNew) {
        button1 = buttonNew;
        textField1 = textFieldNew;
    }
    public void actionPerformed(ActionEvent ae) {
        String cmd =  ae.getActionCommand();

        if (cmd.equals(this.button1.getText()))
        {
            textField1.setText("Welcome to my first trial");
            System.out.print("event listener is working!");
        }
    }

    public static void main(String[] args) {

    }
}
