import java.util.*;
import java.io.*;

enum Loglevel {
	DEBUG, INFO, WARN, ERR;
}

public class Collatz {

		private Loglevel logLevel; 
		private boolean [] protocol = new boolean [1000*1000*1000];
		
		// static int counter = 0; 

		void log (String message, Loglevel ll)
		{
			if (logLevel.ordinal () <= ll.ordinal ())
				System.out.print (message);
		}

		public boolean secureCollatz (int i)
		{				
			if (i < 1)
			{
				log ("Aufruf für i > 0, i € {ganze Zahlen}\n", Loglevel.ERR);
				return false;
			}
			return collatz (i);
		}
		
		private boolean collatz (int i)
		{				
			if (protocol[i])
			{
				log ("Bottom reached\n", Loglevel.INFO); 
				return true; 
			}
			else if ((i % 2) == 0) 
			{
				log ("g", Loglevel.DEBUG); 
				return collatz (i/2);
			}
			else 
			{
				log ("u", Loglevel.DEBUG); 
				int newindx = i*3 + 1;
				if (newindx <= protocol.length)
					return collatz (newindx);
				else
					{
						log ("Warnung! Maxlen of Arr exceeded!", Loglevel.WARN);
						return false; 
					}
			}
		}

		void run2 (final int MAX)
		{
			protocol[1] = true; 

			for (int i = 0; i <= MAX; ++i)
			{
				log (i + ": ", Loglevel.INFO); 
				boolean res = secureCollatz (i);
				protocol [i] = res; 
			}
		}

		public static void main (String[] args) throws IOException 
		{
			Scanner sc = new Scanner (new File ("Collatz.ini"));
			Loglevel activeLevel = Loglevel.INFO; 
			
			// label: 
			INISEARCH: 
			while (sc.hasNext ())
			{
				String line = sc.nextLine ();
				System.out.println ("line: > " + line);
				if (line.startsWith ("Loglevel="))
				{
						System.out.println (line);
						String[] elements = line.split ("=");
						String ll = elements[1];
						
						for (Loglevel loglevel : Loglevel.values())
						{
							if (ll.equals (loglevel.toString ()))
							{
								activeLevel = loglevel; 
								break INISEARCH; 
							}							
						}
				}
			}
			sc.close ();	
			System.out.println ("> Start collatz");
			Collatz collatz = new Collatz ();
			collatz.logLevel = activeLevel; 
			collatz.run2 (100*1000); 
		}
		
}
