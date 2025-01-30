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
    List<JTextField> textFields = new ArrayList<> ();
    List <JTextArea> textAreas =  new ArrayList<> ();
	String inputPath = "C:\\Users\\hinnawe.ali\\IdeaProjects\\MyProject\\src\\test.txt";
	//C:\\Users\\hinnawe.ali\\IdeaProjects\\MyProject\\src
	//C:\documents\java-challenges\regex\
	//C:\documents\java-challenges\regex\test.txt
	String outputPath = "C:\\Users\\hinnawe.ali\\IdeaProjects\\MyProject\\src\\testNew.txt";
	
    public NewActionListener(JButton buttonNew,List<JTextField> textFieldNew, List <JTextArea> textAreaNew) {
        button = buttonNew;
        textFields = textFieldNew;
        textAreas = textAreaNew;
    }
    
    public void load ()
    {
		File inF = new File(inputPath);

		try (Scanner sc = new Scanner(inF);){

			while (sc.hasNext())
			{   
				String nextLine = sc.nextLine();
				textAreas.get(0).append(nextLine + "\n");
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found: " + e.getMessage());
		}
	}

		
	public void save (String newOutputPath)
	{
		File newF = new File(newOutputPath);

		try (PrintStream ps = new PrintStream(newF)) {
			textAreas.get(0).setText("");
			String[] lines = textAreas.get(1).getText().split("\n");
			for (String line : lines) {
				ps.print(line + "\n");
			}
			load();

		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found:");
		}
	}
	
	public void copyToSecondTArea (String textFieldValue1, String textFieldValue2)
	{
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
				textAreas.get(1).append(nextLineCopy +"\n");
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
            String txtFValue1 = textFields.get(0).getText();
            String txtFValue2 = textFields.get(1).getText();
			//"C:\\documents\\java-challenges\\regex\\test.txt"
			//"C:\\documents\\java-challenges\\regex\\testCorrected.txt"
			//save(inputPath, outputPath,txtFValue1, txtFValue2);
			copyToSecondTArea(txtFValue1,txtFValue2);
			textFields.get(0).setText("(.)(.*)");
			textFields.get(1).setText("$1$2");
        }
        else {
            String btnText = button.getText();
            if (cmd.equals(btnText)) {
                String btnTextNumber = button.getText().replaceAll("[^0-9]", "");
                int btnIndexNumber = Integer.parseInt(btnTextNumber);
                textFields.get(btnIndexNumber -1).setText("button " + (btnIndexNumber) + " is selected");
            }
        }
    }

    public static void main(String[] args) {

    }
}
