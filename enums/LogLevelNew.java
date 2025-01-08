import java.util.*;
import java.io.*;

enum Loglevel {
	DEBUG{
		@Override
		void log (String message, Loglevel ll)
		{
			if (DEBUG.ordinal () <= ll.ordinal ())
				System.out.print (message);
		}			
	}, 
	INFO{
		@Override
		void log (String message, Loglevel ll)
		{
			if (INFO.ordinal () <= ll.ordinal ())
				System.out.print (message);
		}					
	}, 
	WARN {
		@Override
		void log (String message, Loglevel ll)
		{
			if (WARN.ordinal () <= ll.ordinal ())
				System.out.print (message);
		}
	}, 
	ERR {
		@Override
		void log (String message, Loglevel ll)
		{
			if (ERR.ordinal () <= ll.ordinal ())
				System.out.print (message);
		}
	};
	
	abstract void log (String message, Loglevel ll);
}

public class CollatzSW {

		private Loglevel logLevel; 
		private boolean [] protocol = new boolean [1000*1000*1000];
		
		// static int counter = 0; 

		void oldlog (String message, Loglevel ll)
		{
			if (logLevel.ordinal () <= ll.ordinal ())
				System.out.print (message);
		}

		public boolean secureCollatz (int i)
		{				
			if (i < 1)
			{
				Loglevel.ERR.log ("Aufruf für i > 0, i € {ganze Zahlen}\n", logLevel);
				return false;
			}
			return collatz (i);
		}
		
		private boolean collatz (int i)
		{				
			if (protocol[i])
			{
				Loglevel.INFO.log ("Bottom reached\n", logLevel); 
				return true; 
			}
			else if ((i % 2) == 0) 
			{
				Loglevel.DEBUG.log ("g", logLevel); 
				return collatz (i/2);
			}
			else 
			{
				Loglevel.DEBUG.log ("u", logLevel); 
				int newindx = i*3 + 1;
				if (newindx <= protocol.length)
					return collatz (newindx);
				else
					{
						Loglevel.WARN.log ("Warnung! Maxlen of Arr exceeded! " + newindx, logLevel);
						return false; 
					}
			}
		}

		void run2 (final int MAX)
		{
			protocol[1] = true; 

			for (int i = 1; i <= MAX; ++i)
			{
				Loglevel.INFO.log (i + ": ", logLevel); 
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
			CollatzSW collatz = new CollatzSW ();
			collatz.logLevel = activeLevel; 
			collatz.run2 (100*1000); 
		}
		
}
