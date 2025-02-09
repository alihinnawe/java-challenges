import java.util.*;

public class Ringpuffer <T> implements Iterator <T> 
{
		final protected T [] puffer;
		final int len; 
		private int pos = 0; 
		
		public T next ()
		{
			return puffer [(pos++ % len)];
		}
		
		public boolean hasNext ()
		{
			return true;
		}
		
		public Ringpuffer (T [] param)
		{
			puffer = param;
			len = puffer.length;
		}
					
		public static void main (String[] args) 
		{
			Ringpuffer <String> rps = new Ringpuffer <> (new String [] {
				"To", "ma", "ten", "sa", "la", "to",
				"ma", "ten", "sa", "la", "to", "ma", "ten", "sa", "la",
				"to", "ma", "ten", "sa", "lat"});
			Ringpuffer <Integer> rpi = new Ringpuffer <> (new Integer [] {
				1, 3, 4, 7, 9, 6, 3, 2, 0}); 

			Iterable <String> iters = new RingpufferIterable <> (rps);
			Iterable <Integer> iteri = new RingpufferIterable <> (rpi);

			int counter = 0;
			
			for (String s: iters)
			{
				System.out.print ("/" + s);
				if (counter++ > 50)
					break; 
			}
			
			for (Integer i: iteri)
			{
				System.out.print ("_" + i);
				if (counter-- == 0)
					break; 
			}
			System.out.println ();
		}
		/*
		public static void usage ()
		{
			System.out.println ("Usage:\tjava Ringpuffer RING PUFFER Initialiserungsliste ...");
		}
		*/
}

class RingpufferIterable <T> implements Iterable <T> {
	
	private Ringpuffer <T> ringpuffer;
	
	public RingpufferIterable (Ringpuffer <T> rp)
	{
		ringpuffer = rp;
	}
	
	public Iterator <T> iterator () {
		return ringpuffer; 
	}
}
