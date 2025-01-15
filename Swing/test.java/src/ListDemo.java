import java.awt.*;
import javax.swing.*;

public class ListDemo extends JFrame implements Runnable {

    String[] arr = {"Ali", "Hinnawe", "Lebanon", "Beirut"};
	Vector <String> v =  new Vector <> ();
	v.add("Name");
	v.add("FName");
	v.add("Country");
	v.add("City");

    public ListDemo(String title) {
        setTitle(title);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void run() {
        JPanel mainPanel = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        JList<String> jlist1 = new JList<>(arr);
        JList<String> jlist2 = new JList<>(v);

        p1.add(jlist1);
        p2.add(jlist2);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(p1, BorderLayout.EAST);
        mainPanel.add(p2, BorderLayout.WEST);

        add(mainPanel);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ListDemo("ListDemo").run());
    }
}
