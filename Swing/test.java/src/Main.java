import javax.swing.*;
import java.awt.*;

public class Main extends JFrame implements Runnable {

    // Method to configure panels
    private void panelConf(JPanel p, int color, String orientation, String ttt) {
        JLabel jl = new JLabel(orientation);
        p.add(jl);
        p.setBorder(BorderFactory.createEtchedBorder()); // Fixed typo
        p.setToolTipText(ttt);
        p.setBackground(new Color(color)); // Fixed color initialization
        add(p, orientation); // Add panel to the specified region
    }

    @Override
    public void run() {
        setTitle("HelloSwingWorld SW v.0.1 (c) alpha 2025");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits on close

        // Create an array of panels
        JPanel[] p = new JPanel[5];
        int[] farbe = {0xff0000, 0x00ff00, 0xffff00, 0x0000ff, 0xffffff}; // Hexadecimal colors
        String[] orientation = {
                BorderLayout.NORTH,
                BorderLayout.WEST,
                BorderLayout.EAST,
                BorderLayout.SOUTH,
                BorderLayout.CENTER
        };
        String[] ttt = {"Nord", "West", "Ost", "Süd", "Zentrum"};

        // Configure and add panels to the frame
        for (int i = 0; i < 5; ++i) {
            p[i] = new JPanel();
            panelConf(p[i], farbe[i], orientation[i], ttt[i]);
        }

        pack(); // Resize the frame to fit the components
        setVisible(true); // Make the frame visible
    }

    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure the GUI runs on the EDT
        SwingUtilities.invokeLater(new Main());
    }
}