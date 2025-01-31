import javax.swing.*;
import java.awt.*;

public class GradientJFrameExample extends JFrame {
    public GradientJFrameExample() {
        setTitle("Gradient JFrame Example");
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Override the paint method to apply the gradient
    @Override
    public void paint(Graphics g) {
        super.paint(g); // Call the superclass method to avoid UI glitches
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Define gradient colors (Top to Bottom)
        Color color1 = Color.BLUE;
        Color color2 = Color.CYAN;

        // Create a vertical gradient
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2d.setPaint(gp);

        // Fill the entire frame with the gradient
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    public static void main(String[] args) {
        new GradientJFrameExample();
    }
}
