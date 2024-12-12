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

	/*    
    public void doadd (int i) {
		Intlist tmp = next; 
        while (tmp != null)
        {
			tmp = tmp.next; 
		}
		tmp = new Intlist (i); 
		System.out.println (this);
    }

    public void vdoadd (int i) {
        while (next != null)
        {
			next.add (i); 
		}
		if (next == null
    }
	*/
	
    public void kkadd (int i) {
		Intlist kkadd = this; 
        while (kkadd.next != null)
        {
			kkadd = kkadd.next;
		}
		kkadd.next = new Intlist (i); 
    }
   
	public void addList (Intlist list) {
		if (list == null) 
			return;
		else
		if (next==null)
			next=list ;
		else 
			next.addList(list);
    }
    
	public boolean contains(int value) {
        if (this.value == value){ 
            return true;
        }else if(next != null){
			return next.contains(value); 
		}else
		    return  false;
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
		System.out.println (" " + il.contains (3));
		System.out.println (" " + il.contains (4));
		il.add (4); 
		System.out.print ("" + il.size ());
		//System.out.println (" " + il.getLength ());
		il.add (5); 
		System.out.print ("" + il.size ());
		//System.out.println (" " + il.getLength ());
	}
}
