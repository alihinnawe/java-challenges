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
	 
	public int get (int index) {
			ahFriIntlist temp = this; 
			for (int i = 0; i < index; ++i) {
				temp = temp.next;
			}
			return temp.getVal();
	}
    
	public int getLast() {
		ahFriIntlist temp = this;
		while (temp.next != null) {
		temp = temp.next;
		}
		return temp.getVal();
	}
 
	public static void main (String[] args) 
	{
		ahFriIntlist il = new ahFriIntlist (3); 
		il.add (4); 
		il.add (5); 
		il.add (6); 
		il.add (7); 
		il.add (8); 
		int indexValue = il.get(0);
		System.out.print ("" + il.size ());
		System.out.print ("index value is:" + indexValue);
		int lastItem = il.getLast();
		System.out.print ("last item value:" + lastItem);
	 
	}
}
