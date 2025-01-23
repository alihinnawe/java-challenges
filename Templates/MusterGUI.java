import java.util.*;
import java.io.*;

public class MusterGUI
{	
	// Namen lesen für File- und Classname
	public static void main (String[] args) 
	{
		if (args.length == 0)
		{
			usage ();
			System.exit (1);
		}
		String name = args[0];
		System.out.println ("Erzeuge Klasse " + name + " in Datei " + name + ".java");
		
		
		Map <String, String> map = new HashMap <> ();

		map.put ("\\$NAME", name);
		map.put ("\\$name", name.toLowerCase ());
		map.put ("\\$DATE", "" + new Date ());

		// einlesen der guimuster.java-Datei
		Scanner sc = null; 
		try
		{
			sc = new Scanner (new File ("./guimuster.java")); 	
		}
		catch (IOException ioe)
		{
			System.err.println (ioe.getMessage ());
			System.exit (2); 
		}
		
		while (sc.hasNext ())
		{
			String line = sc.nextLine ();
			for (String key: map.keySet())
			   line = line.replaceAll (key, map.get (key)); 
			System.out.println (line);
		}
	}
	
	public static void usage () 
	{
		System.out.println ("Usage:\tjava MusterGUI NAME");
	}
}
