class Laeufer {
	String name;
	String nat; 
	int zeit;
	
	Laeufer (String name, String nat, int zeit)
	{
			this.name = name;
			this.nat = nat;
			this.zeit = zeit;
	}
	
	@Override public String toString ()
	{
		return "Laeufer: Name: " + name + " Nat: " + nat + " Zeit: " + zeit; 
	}
	
	/*
	@Override public boolean equals (Object other) 
	{
		if (other instanceof Laeufer)
		{
			//             casting, Typumwandlung
			Laeufer vgl = (Laeufer) other; 
			return name.equals (vgl.name) && nat.equals (vgl.nat) && (zeit == vgl.zeit); 
		}
		return false; 
	} 
	*/
	@Override public boolean equals (Object other) 
	{
		if (other instanceof Laeufer vgl)
		{
			return name.equals (vgl.name) && nat.equals (vgl.nat) && (zeit == vgl.zeit); 
		}
		return false; 
	}
	
	@Override public int hashCode ()
	{
		return 19 + ((name.hashCode () * 17) + nat.hashCode ()) * 17 + zeit; 
	}
}

public class LaeuferTest {
	
	public static void main (String[] args) 
	{
		Laeufer l1 = new Laeufer ("Tigris", "Eth", 132);
		Laeufer l2 = new Laeufer ("Sheila", "Ken", 137);
		Laeufer l3 = new Laeufer ("Magdalena", "Tan", 139);
		
		Laeufer[] feld = {l1, l2, l3};
		
		for (Laeufer l : feld)
		{
			System.out.println (l.toString ());
		}
		
		Laeufer l4 = new Laeufer ("Sheila", "USA", 147);
		Laeufer l5 = new Laeufer ("Magdalena", "Tan", 139);
		Laeufer l6 = l1; 
		
		System.out.println ("Equals/== - Vergleich: ");
		
		for (Laeufer l : feld)
		{
			if (l.equals (l4))
				System.out.println (l + " equals " + l4);
			// l3.equals (l5); 
			if (l.equals (l5))
				System.out.println (l + " equals " + l5);
			// true
			if (l.equals (l6))
				System.out.println (l + " equals " + l6);
			if (l == l4)
				System.out.println (l + " == " + l4);
			if (l == l5)
				System.out.println (l + " == " + l5);
			// true
			if (l == l6)
				System.out.println (l + " == " + l6);
		}	
	}
}
