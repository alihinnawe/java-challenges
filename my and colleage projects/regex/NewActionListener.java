import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
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
	/*
	
	* replace the lines 37 and 133 with your own path.
	* TODO: TODO: add comments for methods.

	*/
	
	JButton button;
	List<JTextField> textFields1 = new ArrayList<>();
	List<JTextField> textFields2 = new ArrayList<>();
	List<JTextArea> textAreas1 = new ArrayList<>();
	List<JTextArea> textAreas2 = new ArrayList<>();
	private CardLayout cardLayout;
	private JPanel cardPanel;
	String inputPath = "C:\\documents\\java-challenges\\regex\\test.txt";

	public NewActionListener(JButton buttonNew, List<JTextField> textFieldsNew1, List<JTextField> textFieldsNew2, List<JTextArea> textAreaNew1, List<JTextArea> textAreaNew2, CardLayout cardLayoutNew, JPanel cardPanelNew) {
		button = buttonNew;
		textFields1 = textFieldsNew1;
		textFields2 = textFieldsNew2;
		textAreas1 = textAreaNew1;
		textAreas2 = textAreaNew2;
		cardLayout = cardLayoutNew;
		cardPanel = cardPanelNew;
	}

	public void load() {
		File inF = new File(inputPath);
		try (Scanner sc = new Scanner(inF)) {
			while (sc.hasNext()) {
				String nextLine = sc.nextLine();
				textAreas1.get(0).append(nextLine + "\n");
				textAreas2.get(0).append(nextLine + "\n");
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found: " + e.getMessage());
		}
	}

	public void save(String newOutputPath) {
		File newF = new File(newOutputPath);
		if (!textAreas1.get(1).getText().isEmpty()) {
			try (PrintStream ps = new PrintStream(newF)) {
				textAreas1.get(0).setText("");
				String[] lines = textAreas1.get(1).getText().split("\n");
				for (String line : lines) {
					ps.print(line + "\n");
				}
				
				load();
				
				int option = JOptionPane.showConfirmDialog(null, "Do you want to stay replacing or move to the Filter panel?", "Choose Action", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.NO_OPTION) {
					textFields2.get(0).setText("(.)(.*)");
					textAreas2.get(1).setText("");
					textAreas2.get(0).setText("");
					load();
					cardLayout.show(cardPanel, "Filter Panel");
				}
			} catch (FileNotFoundException e) {
				System.err.println("Error: File not found:");
			}
		}
	}

	public void copyToSecondTFilterArea(String textFieldValue1) {
		textAreas2.get(1).setText("");
		File f = new File(inputPath);
		try (Scanner sc = new Scanner(f)) {
			while (sc.hasNextLine()) {
				String nextLine = sc.nextLine();
				Pattern compiledPattern = Pattern.compile(textFieldValue1);
				Matcher matcher = compiledPattern.matcher(nextLine);
				if (matcher.matches() && !textAreas2.get(0).getText().isEmpty()) {
					textAreas2.get(1).append(nextLine + "\n");
				}
			}
			int option = JOptionPane.showConfirmDialog(null, "Do you want to stay filtering or move to the Replacement panel?", "Choose Action", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (option == JOptionPane.NO_OPTION) {
				textFields1.get(0).setText(textFields2.get(0).getText());
				textAreas1.get(0).setText("");
				textAreas1.get(1).setText("");
				
				load();
				
				cardLayout.show(cardPanel, "Replacement Panel");
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found:");
		}
	}

	public void copyToSecondTArea(String textFieldValue1, String textFieldValue2) {
		textAreas1.get(1).setText("");
		File f = new File(inputPath);
		try (Scanner sc = new Scanner(f)) {
			while (sc.hasNextLine()) {
				String nextLine = sc.nextLine();
				String nextLineCopy = nextLine.replaceAll(textFieldValue1, textFieldValue2);
				textAreas1.get(1).append(nextLineCopy + "\n");
				textAreas2.get(1).append(nextLineCopy + "\n");
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found:");
		}
	}

	public void actionPerformed(ActionEvent ae) {
		String cmd = ae.getActionCommand();
		if (cmd.equals("open")) {
			JFileChooser chooser = new JFileChooser("C:\\documents\\java-challenges\\regex");
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
			}
			load();
			button.setEnabled(false);
		} else if (cmd.equals("save")) {
			save(inputPath);
		} else if (cmd.equals("exit")) {
			System.exit(1);
		} else if (cmd.equals("run")) {
			copyToSecondTArea(textFields1.get(0).getText(), textFields1.get(1).getText());
		} else if (cmd.equals("filter")) {
			copyToSecondTFilterArea(textFields2.get(0).getText());
		}
	}

	public static void main(String[] args) {}
}
