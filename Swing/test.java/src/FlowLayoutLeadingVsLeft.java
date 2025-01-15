import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class FlowLayoutLeadingVsLeft {
    public static void main(String[] args) {
        // Create a JFrame to hold the panels
        JFrame frame = new JFrame("FlowLayout Leading vs Left Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLayout(new GridLayout(2, 2)); // 2 rows, 2 columns

        // Panels for English (LTR)
        JPanel englishLeadingPanel = createPanel("English - Leading", FlowLayout.LEADING, Locale.ENGLISH);
        JPanel englishLeftPanel = createPanel("English - Left", FlowLayout.LEFT, Locale.ENGLISH);

        // Panels for Arabic (RTL)
        JPanel arabicLeadingPanel = createPanel("Arabic - Leading", FlowLayout.LEADING, new Locale("ar"));
        JPanel arabicLeftPanel = createPanel("Arabic - Left", FlowLayout.LEFT, new Locale("ar"));

        // Add panels to the frame
        frame.add(englishLeadingPanel);
        frame.add(englishLeftPanel);
        frame.add(arabicLeadingPanel);
        frame.add(arabicLeftPanel);

        // Display the frame
        frame.setVisible(true);
    }

    private static JPanel createPanel(String title, int alignment, Locale locale) {
        // Create a panel with a FlowLayout
        JPanel panel = new JPanel(new FlowLayout(alignment, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder(title));

        // Apply locale's component orientation (LTR or RTL)
        panel.applyComponentOrientation(ComponentOrientation.getOrientation(locale));

        // Add buttons for demonstration
        for (int i = 1; i <= 3; i++) {
            panel.add(new JButton("Button " + i));
        }

        return panel;
    }
}
