package figd;

// import figd.*;

public class KTest
{
	public static void main (String[] args) 
	{
		Kpri kpri;
		kpri = new Kpri ();
		kpri.m ();
		// Absicht: Zugriff auf kpri.a nicht möglich.
		// System.out.println (kpri.a);

		K k = new K ();
		k.m ();
		System.out.println (k.a);

		Kpro kpro = new Kpro ();
		kpro.m ();
		System.out.println (kpro.a);

		Kpub kpub = new Kpub ();
		kpub.m ();
		System.out.println (kpub.a);
	}
}
