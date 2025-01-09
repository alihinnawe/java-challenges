import java.util.Iterator;

class VonBisIterator implements Iterator <Integer> 
{
	private int current;
	private final int stop; 
	
	public VonBisIterator (int start, int stop)
	{
		current = start;
		this.stop = stop;
	}
	
	public Integer next ()
	{
		return current++; 
	}
	
	public boolean hasNext ()
	{
		return current <= stop;
	}
}

public class VonBisIteratorDemo {
	
	
	public static void main (String[] args) 
	{
		VonBisIterator vbi = new VonBisIterator (10, 40);
		int counter = 0;
		while (vbi.hasNext () && counter++ < 50)
		{
			System.out.print ("> " + vbi.next ());
		}
	}
	
}
