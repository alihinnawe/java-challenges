public class ahFriIntlist {
 
    private int value;
    private ahFriIntlist next = null;  
    
    public ahFriIntlist (int i) {value = i;}
    
    public int getVal () {return value;}
    public ahFriIntlist getNext() {return next;}
    
    public void add (int i) {
        if (next == null) 
            next = new ahFriIntlist (i);
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
	 
	public int itemIndex (int index) {
			ahFriIntlist temp = this; 
			if (index >= size () || index < 0)
				throw new IndexOutOfBoundsException ("ahFriIntlist out of bounds for max: " + size () + " with index: " + index);
			for (int i = 0; i < index; ++i) {
				temp = temp.next;
			}
			return temp.getVal();
	}
    
	public int getLastItem () {
		ahFriIntlist temp = this;
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp.getVal();
	}
 
 	public Intlist without (int index) 
	{
		if (index == 0) 
			return next;
		else {
			Intlist erg = new Intlist (value); 
			Intlist rest = next.without (index -1); 
			erg.addList (rest);
			return erg; 
		}	
	}
	
	public static void main (String[] args) 
	{
		ahFriIntlist il = new ahFriIntlist (3); 
		il.add (4); 
		il.add (5); 
		il.add (6); 
		il.add (7); 
		il.add (8); 
		int indexValue = il.itemIndex (10);
		System.out.println ("size: " + il.size ());
		System.out.println ("index value is 3? " + indexValue);
		int lastItem = il.getLastItem();
		System.out.println ("last item value 8?" + lastItem);
	}
}
