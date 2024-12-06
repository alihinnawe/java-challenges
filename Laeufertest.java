class Laeufer 
{
	private String name;
	private String nat;
	private int zeit;
	private char sex; // "f" := female, "m" :=male
	private int nummer;
	
	public Laeufer (String name, String nat, int zeit, char sex, int nummer)
	{
		this.name = name;
		this.nat = nat;
		this.zeit = zeit;
		this.sex = sex;
		this.nummer = nummer;
	}
	
	public int getNummer ()
	{
		return nummer;
		}
	
	public void setNummer (int nummer) 
	{
			this.nummer = nummer;
		}
}
class Langstreckenlaeufer extends Laeufer 
{
	int mindestdistanz;
	public Langstreckenlaeufer (String name, String nat, int zeit, char sex)
	{
		super (name, nat, zeit, sex, 0);
		this.mindestdistanz = 10000;
	}
	
	public Langstreckenlaeufer (String name, String nat, int zeit, char sex, int midestdistanz)
	{
		super (name, nat, zeit, sex, 0);
		this.mindestdistanz = mindestdistanz;
	}
	
	public void setMindestdistanz (int d)
	{
		if (d > 0)
			mindestdistanz = d;
		else System.err.println ("not correct");
	}
	
	public int getMindestdistanz ()
	{
		return mindestdistanz;
	}
}

class Lauf 
{
	private String ort;
	private int jahr;
	public Laeufer [] starter;

	public Lauf (String ort, int  jahr, int zeit, Laeufer [] starter)
	{
		this.ort = ort;
		this.jahr = jahr;
		this.starter = starter;
	}
}


public class Laeufertest {
	public static void main (String[] args) {
		Langstreckenlaeufer l1 = new Langstreckenlaeufer("Ali", "Lebanon", 43, 'f', 15000);	
		System.out.println(l1.toString());
	}	}
		
