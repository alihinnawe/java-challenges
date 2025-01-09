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

/** Iterable für for-each-Loop-Syntax nötig */
class VonBisIterable implements Iterable <Integer> 
{
	// private VonBisIterator iter;
	private Iterator <Integer> iter;

	public Iterator <Integer> iterator () {
		return iter;
	}

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
		// for (int i : vbi)
		for (int i = vbi.next (); vbi.hasNext (); i = vbi.next ())
		{
			System.out.print (" " + i);
		}
		/*
		while (vbi.hasNext ())
		{
			System.out.print ("> " + vbi.next ());
		}
		*/
		/*
		VonBisIterable vbi = new VonBisIterable (22, 33);
		for (int i : vbi)
		{
			System.out.print ("> " + i);
		}
		*/
	}
}
