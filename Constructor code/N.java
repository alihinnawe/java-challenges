class N {

	String s; //  = null; 

	public N ()
	{
		String k = "kein Zugriff möglich"; 
		String m = null;
		System.out.println ("> " + s.length ());
		System.out.println ("> " + m.length ());
	}

	public void foo ()
	{
		String l = "lausiges Beispiel"; 
		if (s != null)
			System.out.println ("> " + s.length ());
		else
			System.out.println ("> -1");
	}

	public static void main (String[] args) 
	{
		N n = new N ();
		n.foo ();
		n.s = "Test";
		n.foo (); 
		// System.out.println ("" + n.k); 
	}
	
}
