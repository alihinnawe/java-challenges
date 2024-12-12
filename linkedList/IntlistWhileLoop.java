import java.util.Random; 

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
		Intlist ildo = new Intlist (3); 
		Intlist ilrek = new Intlist (3); 
		int max = 100000; 
		Random rnd = new Random (1);
		
		for (int i = 0; i < max;  ++i)
		{
			ildo.kkadd (rnd.nextInt (100));
			if (i % 10_000 == 0)
				System.out.print (".");
		}
		System.out.println ();
		
		// System.out.println (ildo);
		rnd = new Random (1);

		for (int i = 0; i < max;  ++i)
		{
			ilrek.add (rnd.nextInt (100));
			if (i % 10_000 == 0)
				System.out.print (".");
		}
		System.out.println ();
		
		// System.out.println (ilrek);
	}
}
