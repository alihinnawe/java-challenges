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

public class NewActionListener implements ActionListener {
	JButton button;
	List<JTextField> textFields1 = new ArrayList<> ();
	List<JTextField> textFields2 = new ArrayList<> ();

	List <JTextArea> textAreas1 =  new ArrayList<> ();
	List <JTextArea> textAreas2 =  new ArrayList<> ();
	private CardLayout cardLayout;
	private JPanel cardPanel;
	String inputPath = "C:\\documents\\java-challenges\\regex\\test.txt";
	//C:\\Users\\hinnawe.ali\\IdeaProjects\\MyProject\\src\\test.txt
	//C:\\Users\\hinnawe.ali\\IdeaProjects\\MyProject\\src
	//C:\\documents\\java-challenges\\regex\\test.txt
	//String outputPath = "C:\\Users\\hinnawe.ali\\IdeaProjects\\MyProject\\src\\testNew.txt";

	public NewActionListener(JButton buttonNew,List<JTextField> textFieldsNew1,List<JTextField> textFieldsNew2, List <JTextArea> textAreaNew1,List <JTextArea> textAreaNew2, CardLayout cardLayoutNew, JPanel cardPanelNew) {
		button = buttonNew;
		textFields1 = textFieldsNew1;
		textFields2 = textFieldsNew2;

		textAreas1 = textAreaNew1;
		textAreas2 = textAreaNew2;
		cardLayout = cardLayoutNew;
		cardPanel =  cardPanelNew;
	}

	public void load ()
	{
		File inF = new File(inputPath);

		try (Scanner sc = new Scanner(inF);){

			while (sc.hasNext())
			{
				String nextLine = sc.nextLine();
				textAreas1.get(0).append(nextLine + "\n");
				textAreas2.get(0).append(nextLine + "\n");

			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found: " + e.getMessage());
		}
	}

	public void loadFilter ()
	{
		File inF = new File(inputPath);

		try (Scanner sc = new Scanner(inF);){

			while (sc.hasNext())
			{
				String nextLine = sc.nextLine();
				textAreas2.get(0).append(nextLine + "\n");

			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found: " + e.getMessage());
		}
	}


	public void save (String newOutputPath)
	{
		File newF = new File(newOutputPath);
		if (!textAreas1.get(1).getText().isEmpty()) {
			try (PrintStream ps = new PrintStream(newF)) {
				textAreas1.get(0).setText("");
				String[] lines = textAreas1.get(1).getText().split("\n");
				for (String line : lines) {
					ps.print(line + "\n");
				}
				load();

			} catch (FileNotFoundException e) {
				System.err.println("Error: File not found:");
			}
		}
	}

	public void copyToSecondTFilterArea (String textFieldValue1)
	{   textAreas2.get(1).setText("");
		File f = new File (inputPath);
		try (Scanner sc = new Scanner(f)) {
			//Boolean replaced = false;
			while (sc.hasNextLine()) {
				String nextLine = sc.nextLine();
				//"$1au$2" (.)as(.*)
				Pattern compiledPattern = Pattern.compile(textFieldValue1);
				Matcher matcher = compiledPattern.matcher(nextLine);
				if (matcher.matches())
				{
					textAreas2.get(1).append(nextLine + "\n");
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found:");
		}
	}

	public void copyToSecondTArea (String textFieldValue1, String textFieldValue2)
	{   textAreas1.get(1).setText("");
		File f = new File (inputPath);
		try (Scanner sc = new Scanner(f)) {
			//Boolean replaced = false;
			while (sc.hasNextLine()) {
				String nextLine = sc.nextLine();
				//"$1au$2" (.)as(.*)
				//Pattern compiledPattern = Pattern.compile(textFieldValue1);
				//Matcher matcher = compiledPattern.matcher(nextLine);
				//if (matcher.matches()) {
				String nextLineCopy = nextLine.replaceAll(textFieldValue1,textFieldValue2);
				textAreas1.get(1).append(nextLineCopy +"\n");
				textAreas2.get(1).append(nextLineCopy +"\n");

				//}

			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found:");
		}
	}



	public void actionPerformed(ActionEvent ae) {
		String cmd =  ae.getActionCommand();

		if (cmd.equals("open"))
		{   // C:\\Users\\hinna\\IdeaProjects\\java-challenges
			//C:\\documents\\java-challenges\\regex

			JFileChooser chooser = new JFileChooser("C:\\documents\\java-challenges\\regex");
			int returnVal = chooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
			}

			load();
			button.setEnabled(false);
		}
		else if (cmd.equals("save")){
			save(inputPath);
		}
		else if (cmd.equals("exit")){
			System.out.print("exit save true");
			System.exit(1);
			//textFields.get(1).setText("exit button is selected");
		}
		else if (cmd.equals("run")){
			String txtFValue1 = textFields1.get(0).getText();
			String txtFValue2 = textFields1.get(1).getText();
			//"C:\\documents\\java-challenges\\regex\\test.txt"
			//"C:\\documents\\java-challenges\\regex\\testCorrected.txt"
			//save(inputPath, outputPath,txtFValue1, txtFValue2);
			copyToSecondTArea(txtFValue1,txtFValue2);
			textFields1.get(0).setText("(.)(.*)");
			textFields1.get(1).setText("$1$2");
		}
		else if (cmd.equals("filter")){
			String txtFValue = textFields2.get(0).getText();
			copyToSecondTFilterArea(txtFValue);
		}
		else {
			String btnText = button.getText();
			if (cmd.equals(btnText)) {
				String btnTextNumber = button.getText().replaceAll("[^0-9]", "");
				int btnIndexNumber = Integer.parseInt(btnTextNumber);
				textFields1.get(btnIndexNumber -1).setText("button " + (btnIndexNumber) + " is selected");
			}
		}
	}

	public static void main(String[] args) {

	}
}
