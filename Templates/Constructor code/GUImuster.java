// package

import java.util.*;
import java.io.*;

/**
	GUImuster

	@author Stefan Wagner
	@date Do 23. Jan 08:02:13 CET 2025

*/
public class GUImuster
{
	public static void main (String[] args) 
	{
		// Prüfen auf Klassen-/Filename
		String name = null;
		if (args.length != 1)
		{
			usage ();
			System.exit (1);
		}
		name = args[0];
		
		// Vorlage festlegen 
		Scanner sc = null;
		try
		{
			sc = new Scanner (new File ("./vorlage.java"));
		}
		catch (IOException ioe)
		{
			System.err.println ("IO-Exc.: " + ioe.getMessage ());
			System.exit (2);
		}

		// Ersetzungmapping definieren
		Map <String, String> kwMap = new HashMap <> ();
		kwMap.put ("\\$NAME", name);
		kwMap.put ("\\$AUTHOR", "@author S. Wagner, (Berlin, Rio, LA)");
		kwMap.put ("\\$DATE", "" + new Date ());		
		kwMap.put ("\\$name", name.toLowerCase ());
		
		// Ausgabe in $NAME.java, zur Not auf Bildschirm
		PrintStream ps = null; 
		try
		{
			ps = new PrintStream ("./" + name + ".java");	
		}
		catch (IOException ioe)
		{
			System.err.println (ioe.getMessage ());
			ps = System.out;
		}
		// Ersetzung vornehmen - Jede Zeile gegen jeden Eintrag in der Map.
		while (sc.hasNext ())
		{
			String line = sc.nextLine ();
			for (String kw: kwMap.keySet ())
			{
				line = line.replaceAll (kw, kwMap.get (kw));
			}
			ps.println (line);
		}		
	}

	/** Klassische Benutzungsanweisung */
	public static void usage ()
	{
		System.out.println ("Usage:\tjava GUImuster param");
	}
}
