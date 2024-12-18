import java.util.*;

class Buchtest {

	@SuppressWarnings("deprecation") 
	public static void main (String[] args) 
	{
		Person p1 = new Person (1, "Tom", "Wulf", new Date (1929, 4, 29)); 
		Person p2 = new Person (2, "Robert", "Sedgewick", new Date (1939, 10, 9)); 
		Person p3 = new Person (3, "Donald", "Knuth", new Date (1937, 4, 2)); 
		Person p4 = new Person (4, "Erich Maria", "Remarque", new Date (1899, 4, 7)); 
		Buch b1 = new Buch (1, "Im Westen nichts Neues", List.of (p4), 1929);
		Buch b2 = new Buch (2, "Algorithmen u. Datenstruckturen in C++", List.of (p2), 1989);
		Buch b3 = new Buch (3, " The Art of Computer Programming, I", List.of(p3), 1984);
		
		// List <Buch> buchlist = List.of (b1, b2, b3);
		List <Buch> buchlist = new ArrayList <> ();
		buchlist.add (b1);
		buchlist.add (b2);
		buchlist.add (b3);
		
		for (Buch b: buchlist)
		{
			System.out.println (b);
		}
		
		System.out.println (b2.titel ());
		Buch b2a = b2.updateBuchtitel ("Algorithmen u. Datenstrukturen in C++");
		System.out.println (b2a);
		
	}

}
