import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;
public class GUIAli extends JFrame implements  Runnable {
    private static  String name = null;
    public void run()
    {
        Map<String, String> map = new HashMap<>();
        map.put("\\$MyTemplate", name);

        File f = new File( "./$MyTemplate.java");
        try (Scanner sc = new Scanner(f);) {
            PrintStream ps = new PrintStream("MyProject.java");
            while (sc.hasNext())
            {
                String nextLine = sc.nextLine();
                System.out.println("nextLine" + nextLine);
                for ( String key : map.keySet()) {
                    nextLine = nextLine.replaceAll(key, map.get(key));
                }
                ps.println(nextLine);
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found: " + e.getMessage());
        }
    }



    public static void main(String[] args) {
        name = args[0];
        SwingUtilities.invokeLater(new GUIAli());

    }




}
