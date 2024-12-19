import java.io.*;
import java.util.*;

public class Intlist {

    private int value;
    private Intlist next = null;  
    
    public Intlist (int i) {value = i;}
    
    public int getVal () {return value;}
    public Intlist getNext() {return next;}
    
    public void add (int i) {
        if (next == null) 
            next = new Intlist (i);
        else 
            next.add (i);
    }
    
	@Override public String toString () {
		if (next == null)
			return "Intlist: " + value + " ||"; 
		else
			return "Intlist: " + value + ", " + next.toString (); 
	}
	
	public int size () {
		if (next == null)
			return 1;
		else 
			return 1 + next.size (); 
	}
	
	public boolean allUp () 
	{
		if (next == null) 
			return true;
		else {
			int a = value; 
			int b = next.value; 
			return (a < b && next.allUp ()); 
		}	
	}

	public boolean allDown () 
	{
		if (next == null) 
			return true;
		else {
			int a = value; 
			int b = next.value; 
			return (a > b && next.allDown ()); 
		}	
	}

	public boolean inRange (int delta) 
	{
		if (next == null) 
			return true;
		else {
			int a = value; 
			int b = next.value; 
			boolean result =  (Math.abs (a - b) <= delta); 
			System.out.print (result ? "+" : "-");	
			return result && next.inRange (delta); 
		}	
	}

	public static void main (String[] args) throws ArrayIndexOutOfBoundsException, IOException
	{
		// File file = new File ("./aoc02a.txt");
		File file = new File ("./aoc/aoc02.txt");

		int zeile = 0;
		int matches = 0; 
		
		Scanner scanner = new Scanner (file);
		while (scanner.hasNext ()) // && zeile < 80)
		{
			String line = scanner.nextLine ();
			Scanner wertescanner = new Scanner (line); 
			int startwert = wertescanner.nextInt ();
			Intlist il = new Intlist (startwert); 
			while (wertescanner.hasNext ())
			{
				int wert = wertescanner.nextInt ();
				il.add (wert); 
			}
			char mark = ' '; 
			if ((il.allUp () || il.allDown ()) && il.inRange (3))
			{
				mark = '+'; 
				++matches;
			}
			System.out.println ("Zeile: " + zeile++ + "\t" + mark + " " + line);
		}
		System.out.println ("matches: " + matches );
	}
}
