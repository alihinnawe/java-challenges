import java.util.*;
import java.io.*;

public enum Richtung {

	NORD ("NORTH"),
	OST  ("EAST"),
	SUED ("SOUTH"),
	WEST ("WEST");
	
	String engl; 

	protected Richtung (String engl)
	{
		this.engl = engl;
	}

	
	public static Richtung genFromString (String sri)
	{
		switch (sri)
		{
			case "NORD": return NORD;
			case "OST": return OST;
			case "SUED": return SUED;
			case "WEST": return WEST;
			default: throw new NoSuchElementException ();
		}
	}
	
	public static void main (String[] args) throws Exception 
	{
		System.out.println ("Test");
		Richtung n = NORD;
		Richtung s = SUED;
		System.out.println ("Nord " + n + "\t" + n.ordinal ());
		System.out.println ("Süd " + s + "\t" + s.ordinal ());
		
		File f = new File ("Richtung.ini");
		Scanner sc = new Scanner (f);
		while (sc.hasNext ())
		{
			String line = sc.nextLine ();
			System.out.println ("line: > " + line);
			if (line.startsWith ("Richtung="))
			{
					String[] elements = line.split ("=");
					String ri = elements[1];
					Richtung r = genFromString (ri);
					System.out.println ("Richtung aus Inifile: " + r + "\t" + r.ordinal ());
					// Konstruktor in Enum nicht möglich
					// Richtung r2 = Richtung.ri;
			}
		}
		sc.close ();		
	}
	
	
}
