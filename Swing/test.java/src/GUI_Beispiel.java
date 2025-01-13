
import java.awt.*;
import javax.swing.*;
public class GUI_Beispiel {
   private JFrame frame;
    public GUI_Beispiel() {
        frame = new JFrame();
        frame.setTitle("My first gui");
        JButton button1 = new JButton("button1");
        JButton button2 = new JButton("button2");
        JButton button3 = new JButton("button3");
        JButton button4 = new JButton("button4");
        JButton button5 = new JButton("button5");

        frame.setLayout(new BorderLayout ());
        frame.add(button1, BorderLayout.NORTH);
        frame.add(button2, BorderLayout.SOUTH);
        frame.add(button3, BorderLayout.EAST);
        frame.add(button4, BorderLayout.WEST);
        frame.add(button5, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GUI_Beispiel();
        });
    }
}
