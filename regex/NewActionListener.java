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
    public void actionPerformed(ActionEvent ae) {
        String cmd =  ae.getActionCommand();

        if (cmd.equals("open"))
        {   // C:\\Users\\hinna\\IdeaProjects\\java-challenges
			JFileChooser chooser = new JFileChooser("C:\\Users\\hinna\\IdeaProjects\\java-challenges\\src");
			int returnVal = chooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
			}
			File f = new File( "C:\\Users\\hinna\\IdeaProjects\\java-challenges\\src\\test.txt");
			try (Scanner sc = new Scanner(f);){
				//PrintStream ps = new PrintStream("newtext.txt");
				textAreas.get(0).setLineWrap(true);
				textAreas.get(0).setWrapStyleWord(true);
				while (sc.hasNext())
				{   System.out.println("test");
					String nextLine = sc.nextLine();					
					System.out.println("nextLine " + nextLine);
					//TODO import mucltiple lines in textArea!!
					textAreas.get(0).append(nextLine + "\n");
					//ps.println(nextLine);
				}
			} catch (FileNotFoundException e) {
            System.err.println("Error: File not found: " + e.getMessage());
        }
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
            //textFields.get(1).setText(finalResult);
            File f = new File( "C:\\Users\\hinna\\IdeaProjects\\java-challenges\\src\\test.txt");
//            try (Scanner sc = new Scanner(f);){
//                while (sc.hasNext())
//                {
//                    String nextLine = sc.nextLine();
//                    if (txtFValue1.matches(nextLine))
//                    {
//                        String finalResult = txtFValue1.replaceAll(txtFValue2, "$1au$2");
//                    }
//
//                //ps.println(nextLine);
//                }
//            } catch (FileNotFoundException e) {
//                System.err.println("Error: File not found: " + e.getMessage());
//            }
            try (Scanner sc = new Scanner(f); PrintStream ps = new PrintStream(new File("C:\\Users\\hinna\\IdeaProjects\\java-challenges\\src\\testCorrected.txt"))) {
                while (sc.hasNextLine()) {
                    String nextLine = sc.nextLine();

                    // Only modify lines that contain txtFValue1
                    if (nextLine.contains(txtFValue1)) {
                        nextLine = nextLine.replaceAll(txtFValue2, "$1au$2");  // Apply regex replacement
                    }

                    ps.println(nextLine);  // Write updated line to output file
                }
                System.out.println("File processing complete. Updated file saved as: " + new File("C:\\Users\\hinna\\IdeaProjects\\java-challenges\\src\\testCorrected.txt").getAbsolutePath());
            } catch (FileNotFoundException e) {
                System.err.println("Error: File not found: " + e.getMessage());
            }
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
