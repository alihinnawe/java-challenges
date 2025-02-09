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
	
	public static void main (String[] args) 
	{
		Intlist il = new Intlist (3); 
		System.out.print ("" + il.size ());
		System.out.println (" " + il.getLength ());
		il.add (4); 
		System.out.print ("" + il.size ());
		System.out.println (" " + il.getLength ());
		il.add (5); 
		System.out.print ("" + il.size ());
		System.out.println (" " + il.getLength ());

	}
}
