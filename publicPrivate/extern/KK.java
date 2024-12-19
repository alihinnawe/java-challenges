package extern;

import figd.*; 

public class KK extends K {

	public static void main (String[] args) 
	{
		KK kk = new KK ();
		kk.m ();
		// Absicht: Zugriff auf kk.a nicht möglich.
		// ist default in K und nur aus gl. Klasse u. gl. package mögl.
		// System.out.println (kk.a);
	}
}
