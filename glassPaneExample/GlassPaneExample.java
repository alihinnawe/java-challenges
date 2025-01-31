import javax.swing.*;
import java.awt.*;

public class GlassPaneExample extends JFrame {
    
    public GlassPaneExample() {
        setTitle("GlassPane Gradient Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        
        // Create a simple button to show that underlying components still work
        JButton button = new JButton("Click Me");
        button.setBounds(150, 100, 100, 40);
        add(button);
        
        // Create a custom GlassPane with a gradient
        JComponent glassPane = new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                
                // Enable anti-aliasing for smoother gradients
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Define gradient colors (Top to Bottom)
                Color color1 = new Color(0, 0, 255, 50);  // Semi-transparent blue
                Color color2 = new Color(0, 255, 255, 50); // Semi-transparent cyan
                
                // Create a vertical gradient
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                
                // Apply gradient to the glass pane
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        
        // Set the custom GlassPane
        setGlassPane(glassPane);
        glassPane.setVisible(true); // Make the GlassPane visible
        
        // Allow mouse events to pass through the GlassPane
        glassPane.setOpaque(false);  // This makes the GlassPane transparent and non-intercepting

        setVisible(true);
    }

    public static void main(String[] args) {
        new GlassPaneExample();
    }
}
