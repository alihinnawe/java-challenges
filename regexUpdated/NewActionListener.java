import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Handles user actions and manages text input and output areas.
 *
 * @param button The button that triggers actions.
 * @param textFieldsNew1 List of JTextField elements for first set of text inputs.
 * @param textFieldsNew2 List of JTextField elements for second set of text inputs.
 * @param textAreaNew1 List of JTextArea elements for first set of text areas.
 * @param textAreaNew2 List of JTextArea elements for second set of text areas.
 * @param cardLayoutNew The CardLayout used to switch between panels.
 * @param cardPanelNew The JPanel that holds different card layout views.
 */
public class NewActionListener implements ActionListener {
    JButton button;
    List<JTextField> textFields1 = new ArrayList <> ();
    List<JTextField> textFields2 = new ArrayList <> ();
    List<JTextArea> textAreas1 = new ArrayList <> ();
    List<JTextArea> textAreas2 = new ArrayList <> ();
    private CardLayout cardLayout;
    private JPanel cardPanel;
	// C:\\Users\\hinnawe.ali\\Desktop\\aufg1-ah
    String inputPath = "C:\\documents\\java-challenges\\regex\\test.txt";

    public NewActionListener(JButton buttonNew, List<JTextField> textFieldsNew1, List<JTextField> textFieldsNew2, List<JTextArea> textAreaNew1, List<JTextArea> textAreaNew2, CardLayout cardLayoutNew, JPanel cardPanelNew) {
        this.button = buttonNew;
        this.textFields1 = textFieldsNew1;
        this.textFields2 = textFieldsNew2;
        this.textAreas1 = textAreaNew1;
        this.textAreas2 = textAreaNew2;
        this.cardLayout = cardLayoutNew;
        this.cardPanel = cardPanelNew;
    }

    public void load() {
        File inF = new File(this.inputPath);

        try (Scanner sc = new Scanner(inF)) {
            while(sc.hasNext()) {
                String nextLine = sc.nextLine();
                ((JTextArea)this.textAreas1.get(0)).append(nextLine + "\n");
                ((JTextArea)this.textAreas2.get(0)).append(nextLine + "\n");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found: " + e.getMessage());
        }

    }

    public void save(String newOutputPath) {
        File newF = new File(newOutputPath);
        if (!((JTextArea)this.textAreas1.get(1)).getText().isEmpty()) {
            try (PrintStream ps = new PrintStream(newF)) {
                ((JTextArea)this.textAreas1.get(0)).setText("");
                String[] lines = ((JTextArea)this.textAreas1.get(1)).getText().split("\n");

                for(String line : lines) {
                    ps.print(line + "\n");
                }

                this.load();
                int option = JOptionPane.showConfirmDialog((Component)null, "Do you want to stay replacing or move to the Filter panel?", "Choose Action", 0, 3);
                if (option == 1) {
                    ((JTextField)this.textFields2.get(0)).setText("(.)(.*)");
                    ((JTextArea)this.textAreas2.get(1)).setText("");
                    ((JTextArea)this.textAreas2.get(0)).setText("");
                    this.load();
                    this.cardLayout.show(this.cardPanel, "Filter Panel");
                }
            } catch (FileNotFoundException var11) {
                System.err.println("Error: File not found:");
            }
        }

    }

    public void copyToSecondTFilterArea(String textFieldValue1) {
        ((JTextArea)this.textAreas2.get(1)).setText("");
        File f = new File(this.inputPath);

        try (Scanner sc = new Scanner(f)) {
            while(sc.hasNextLine()) {
                String nextLine = sc.nextLine();
                Pattern compiledPattern = Pattern.compile(textFieldValue1);
                Matcher matcher = compiledPattern.matcher(nextLine);
                if (matcher.matches() && !((JTextArea)this.textAreas2.get(0)).getText().isEmpty()) {
                    ((JTextArea)this.textAreas2.get(1)).append(nextLine + "\n");
                }
            }

            int option = JOptionPane.showConfirmDialog((Component)null, "Do you want to stay filtering or move to the Replacement panel?", "Choose Action", 0, 3);
            if (option == 1) {
                ((JTextField)this.textFields1.get(0)).setText(((JTextField)this.textFields2.get(0)).getText());
                ((JTextArea)this.textAreas1.get(0)).setText("");
                ((JTextArea)this.textAreas1.get(1)).setText("");
                this.load();
                this.cardLayout.show(this.cardPanel, "Replacement Panel");
            }
        } catch (FileNotFoundException var9) {
            System.err.println("Error: File not found:");
        }

    }

    public void copyToSecondTArea(String textFieldValue1, String textFieldValue2) {
        ((JTextArea)this.textAreas1.get(1)).setText("");
        File f = new File(this.inputPath);

        try (Scanner sc = new Scanner(f)) {
            while(sc.hasNextLine()) {
                String nextLine = sc.nextLine();
                String nextLineCopy = nextLine.replaceAll(textFieldValue1, textFieldValue2);
                ((JTextArea)this.textAreas1.get(1)).append(nextLineCopy + "\n");
                ((JTextArea)this.textAreas2.get(1)).append(nextLineCopy + "\n");
            }
        } catch (FileNotFoundException var9) {
            System.err.println("Error: File not found:");
        }

    }

    public void actionPerformed(ActionEvent ae) {
        String cmd = ae.getActionCommand();
        if (cmd.equals("open")) {
            JFileChooser chooser = new JFileChooser("C:\\documents\\java-challenges\\regex");
            int returnVal = chooser.showOpenDialog((Component)null);
            if (returnVal == 0) {
                System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
            }

            this.load();
            this.button.setEnabled(false);
        } else if (cmd.equals("save")) {
            this.save(this.inputPath);
        } else if (cmd.equals("exit")) {
            System.exit(1);
        } else if (cmd.equals("run")) {
            this.copyToSecondTArea(((JTextField)this.textFields1.get(0)).getText(), ((JTextField)this.textFields1.get(1)).getText());
        } else if (cmd.equals("filter")) {
            this.copyToSecondTFilterArea(((JTextField)this.textFields2.get(0)).getText());
        }

    }

    public static void main(String[] args) {
    }
}
