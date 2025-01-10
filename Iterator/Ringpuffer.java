import java.util.*;

public class Ringpuffer implements Iterator <String> 
{
		final protected String [] puffer;
		final int len; 
		private int pos = 0; 
		/**
		* @return puffer [(pos++ % len)]
		* suppose len = 9. We start with index 0, 0 % len = 0, after that index 1 1% len = 1, 
		* then 2 % len = 2 , till we reach 9 % len = 0. and start over the first index again.
		*/
		public String next ()
		{
			return puffer [(pos++ % len)];
		}
		
		public boolean hasNext ()
		{
			return true;
		}
		
		public Ringpuffer (String [] param)
		{
			if (param.length == 0)
			{
				puffer = new String [] {"To", "ma", "ten", "sa", "la", "to",
					"ma", "ten", "sa", "la", "to", "ma", "ten", "sa", "la",
					"to", "ma", "ten", "sa", "lat"};
			}
			else
			{
				puffer = param;
			}
			len  = puffer.length; 
		}
		
		public static void main (String[] args) 
		{
			String [] param = null;
			if (args.length == 1 && args[0].equals ("h"))
			{
				usage ();
				System.exit (0); 
			}
			else 
			{
					System.out.println ("<" + args[0] + ">");
			}
			param = args;
			
			Ringpuffer rp = new Ringpuffer (param);
			// ArrayList <String> al = new ArrayList <> ();
			int counter = 0;
			
			Iterable <String> iter = new RingpufferIterable (rp); 
			/*
			for (String s: iter)
			{
				al.add (s);
				if (counter++ > 50)
					break; 
			}
			*/
			
			// Iterable <String> aliter = (Iterable <String>) al;
			// Iterable <String> aliter = al;
			for (String s: iter)
			{
				System.out.print ("-" + s);
				if (counter++ > 50)
					break; 
			}
			System.out.println ();
		}
		
		public static void usage ()
		{
			System.out.println ("Usage:\tjava Ringpuffer RING PUFFER Initialiserungsliste ...");
		}
}

class RingpufferIterable implements Iterable <String> {
	
	private Ringpuffer ringpuffer;
	
	public RingpufferIterable (Ringpuffer rp)
	{
		ringpuffer = rp;
	}
	
	public Iterator <String> iterator () {
		return ringpuffer; 
	}
}
