public class TrueFalse {

	public static void main (String [] args) throws ArrayIndexOutOfBoundsException, IOException
	{
		// File file = new File ("./keywords.java.txt");
		File file = new File ("./keywords.java.txt");

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
	}

	}

}
