class X {

	int a = 7;
	static int b = 8; 
	int c;
	
	public X (int x)
	{
		System.out.println ("a = " + a);
		System.out.println ("b = " + b);
		c = x;
		System.out.println ("c = " + c);
	}
}

public class Y extends X {

	int ay = 7;
	static int by = 8; 
	int cy;

	public Y ()
	{
		super (ay); 
	}
}
