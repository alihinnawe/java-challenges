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

class VonBisIterable implements Iterable <Integer> 
{
	public Iterator <Integer> iterator () {
		return iter;
	}

	Iterator <Integer> iter;

	public VonBisIterable (int start, int stop)
	{
		iter = new VonBisIterator (start, stop);
	}
}

class VonBisIteratorDemo 
{
	
	public static void main (String[] args) 
	{
		VonBisIterator vbi = new VonBisIterator (10, 40);
		while (vbi.hasNext ())
		{
			System.out.print ("> " + vbi.next ());
		}
	}
}
