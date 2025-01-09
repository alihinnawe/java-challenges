import java.util.*;

public class Ringpuffer implements Iterator <String> 
{
		final protected String [] puffer;
		final int len; 
		private int pos = 0; 
		
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
}
