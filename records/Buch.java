import java.util.List;

public record Buch (int id, String titel, List<Person> autoren, int erscheinungsjahr) {

	// Factorymethode 
	public Buch updateBuchtitel (String neuTitel)
	{
		return new Buch (id, neuTitel, autoren, erscheinungsjahr);
	}
	
	public Buch (Buch old, String neuTitel)
	{
		this (old.id (), neuTitel, old.autoren(), old.erscheinungsjahr ());
	}
}

