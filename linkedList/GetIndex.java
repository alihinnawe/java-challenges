import java.util.Random; 

public class GetIndex {

    private int value;
    private GetIndex next = null;  
    
    public GetIndex (int i) {value = i;}
    
    public int getVal () {return value;}
    public GetIndex getNext() {return next;}
    
    public void add (int i) {
        if (next == null) 
            next = new GetIndex (i);
        else 
            next.add (i);
    }
	

	public void addList (GetIndex list) {
		if (list == null) 
			return;
		else
		if (next==null)
			next=list ;
		else 
			next.addList(list);
    }

	public int getIndexItem (int index) {
			int num = 0;
			
			while ( int i < index) {
				System.out.println(next.value + " " + num);
	
			}
			return 1; 
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
		GetIndex ilrek = new GetIndex (3); 
		ilrek.add(5);
		ilrek.add(6);
		ilrek.add(7);
		ilrek.add(8);
		ilrek.add(9);
		ilrek.add(10);
		System.out.println(ilrek.size());
		ilrek.getIndexItem (7);	
	}
}
