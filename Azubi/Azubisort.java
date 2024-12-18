import java.util.*;

public record Azubi (String name, String vorname, int gebjahr, int id) implements Comparable <Azubi> {
    static int counter; 
    public static String vergleich = "gebjahr";
    
    Azubi (String name, String vorname, int gebjahr) {
        this (name, vorname, gebjahr, counter++); 
    }
    
    @Override public int compareTo (Azubi a) {
		if (vergleich.equals ("gebjahr"))
			return gebjahr - a.gebjahr; 
		else if (vergleich.equals ("id"))
			return id - a.id;
		else return name.compareTo (a.name);
    }
}

Azubi azu1 = new Azubi ("Schulz", "Ahmed", 2001);
Azubi azu3 = new Azubi ("Herrmann", "Sheila", 2000);
Azubi azu2 = new Azubi ("Maier", "Paul", 1998);
Azubi azu4 = new Azubi ("Müller", "Paula", 1999);

List <Azubi> azubis = new ArrayList <> ();

azubis.add (azu1);
azubis.add (azu2);
azubis.add (azu3);
azubis.add (azu4);

for (Azubi a : azubis) println (a);

Collections.sort (azubis);

for (Azubi a : azubis) println (a);

