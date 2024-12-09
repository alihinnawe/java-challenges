package extern;

import figd.*; 

public class KKpri extends Kpri {

	public static void main (String[] args) 
	{
		KKpri kk = new KKpri ();
		kk.m ();
		// Absicht: Zugriff auf kpri.a nicht möglich.
		// System.out.println (super.a);
	}
}
