import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
public class GUIAli extends JFrame implements  Runnable {
    private static  String name = null;
    public void run()
    {
        File f = new File( "./src/" + name + ".java");
        try (Scanner sc = new Scanner(f);) {

            System.out.print(sc);


        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found: " + e.getMessage());
        }

        Map<String, String> map = new HashMap<>();
        map.put("\\$NAME", name);
        map.put("\\$name", name.toLowerCase());
    }


    public static void main(String[] args) {
        name = args[0];
        System.out.print(name);
        SwingUtilities.invokeLater(new GUIAli());

    }




}
