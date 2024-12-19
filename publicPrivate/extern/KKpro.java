package extern;

import figd.*; 

public class KKpro extends Kpro {

	public static void main (String[] args) 
	{
		KKpro kk = new KKpro ();
		kk.m ();
		// Absicht: Zugriff auf kpri.a nicht möglich.
		System.out.println (kk.a);
	}
}
