package extern;

import figd.*; 

public class Ext {

	public static void main (String[] args) 
	{
		Kpri kpri;
		kpri = new Kpri ();
		kpri.m ();
		// Absicht: Zugriff auf kpri.a nicht möglich.
		// System.out.println (kpri.a);

		K k = new K ();
		k.m ();
		// geht auch nicht aus anderem package
		// System.out.println (k.a);

		Kpro kpro = new Kpro ();
		kpro.m ();
		// geht auch nicht - keine abgeleitete Klasse
		// System.out.println (kpro.a);

		Kpub kpub = new Kpub ();
		kpub.m ();
		System.out.println (kpub.a);
	}
}
