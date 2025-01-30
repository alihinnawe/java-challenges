import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class NewActionListener implements ActionListener{
    JButton button;
    List<JTextField> textFields = new ArrayList<> ();
    List <JTextArea> textAreas =  new ArrayList<> ();

    public NewActionListener(JButton buttonNew,List<JTextField> textFieldNew, List <JTextArea> textAreaNew) {
        button = buttonNew;
        textFields = textFieldNew;
        textAreas = textAreaNew;
    }
    
    
    public void load ( String inputPath)
    {
		File f = new File(inputPath);
		try (Scanner sc = new Scanner(f);){
			textAreas.get(0).setLineWrap(true);
			textAreas.get(0).setWrapStyleWord(true);
			while (sc.hasNext())
			{   System.out.println("test");
				String nextLine = sc.nextLine();
				System.out.println("nextLine " + nextLine);
				textAreas.get(0).append(nextLine + "\n");
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found: " + e.getMessage());
		}
		
		}
	public void save (String inputPath, String outputPath, String textFvalue1, String textFvalue2) 
	{
		File f = new File(inputPath);
		File newF = new File(outputPath);
		try (Scanner sc = new Scanner(f); PrintStream ps = new PrintStream(newF)) {
			while (sc.hasNextLine()) {
				String nextLine = sc.nextLine();
				//"$1au$2" (.)as(.*)
				System.out.print(nextLine);
				nextLine = nextLine.replaceAll(textFvalue1,textFvalue2);
				ps.println(nextLine);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found:");
		}

		try (Scanner sc = new Scanner(newF);){
			textAreas.get(0).setLineWrap(true);
			textAreas.get(0).setWrapStyleWord(true);
			textAreas.get(0).setText("");
			while (sc.hasNext())
			{
				String nextLine = sc.nextLine();
				textAreas.get(0).append(nextLine + "\n");

			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found: " + e.getMessage());
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
            load("C:\\documents\\java-challenges\\regex\\test.txt");
        }
        else if (cmd.equals("save")){
            System.out.print("button save true");
            textFields.get(1).setText("save button is selected");
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
			String inputP = "C:\\documents\\java-challenges\\regex\\test.txt";
			String outputP = "C:\\documents\\java-challenges\\regex\\testCorrected.txt";
			save(inputP, outputP,txtFValue1, txtFValue2);
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
