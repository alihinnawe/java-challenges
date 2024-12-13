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
    
    public void addList (Intlist list) {
		if (list == null) 
			return;
		else
		if (next==null)
			next=list ;
		else 
			next.addList(list);
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

	public Intlist without (int index) 
	{
		if (index == 0) 
			return next;
		else {
			Intlist erg = new Intlist (value); 
			Intlist rest = next.without (index -1); 
			erg.addList (rest);
			return erg; 
		}	
	}

	public boolean pairwiseTrue (Bedingung bedingung) 
	{
		if (next == null) 
			return true;
		else {
			int a = value; 
			int b = next.value; 
			return bedingung.check (a, b) && next.pairwiseTrue (bedingung);
		}			
	}
/*
	public boolean inRange (int delta) 
	{
		if (next == null) 
			return true;
		else {
			int a = value; 
			int b = next.value; 
			boolean result =  (Math.abs (a - b) <= delta); 
			// System.out.print (result ? "+" : "-");	
			return result && next.inRange (delta); 
		}	
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

	public boolean allSameDir (char dir) 
	{
		if (next == null) 
			return true;
		else {
			int a = value; 
			int b = next.value; 
			if (dir == '>') 
				return (a > b && next.allSameDir (dir)); 
			else 
				return (a < b && next.allSameDir (dir)); 
		}	
	}
*/
	public static void main (String[] args) throws ArrayIndexOutOfBoundsException, IOException
	{
		// File file = new File ("./aoc02a.txt");
		File file = new File ("./aoc/aoc02.txt");

		int zeile = 1;
		int matches = 0; 
		
		Scanner scanner = new Scanner (file);
		while (scanner.hasNext ()) //  && zeile < 10)
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
			// char mark = ' '; 
			for (int i = 0; i < il.size (); ++i)
			{
				Intlist il2 = il.without (i); 
				// if ((il2.allUp () || il2.allDown ()) && il2.inRange (3))
				// if ((il2.allSameDir ('>') || il2.allSameDir ('<')) && il2.inRange (3))
				Bedingung b1 = new Up (); 
				Bedingung b2 = new Down (); 
				Bedingung b3 = new InRange (3); 
				if ((il2.pairwiseTrue (b1) || il2.pairwiseTrue (b2)) && il2.pairwiseTrue (b3))
				{
					// mark = '+'; 
					++matches;
					break; 
				}
			}
			System.out.println ("Zeile: " + zeile++ + "\t" + line);
		}
		System.out.println ("matches: " + matches );
	}
}
