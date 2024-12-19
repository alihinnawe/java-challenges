package extern;

import figd.*; 

public class KKpub extends Kpub {

	public static void main (String[] args) 
	{
		KKpub kk = new KKpub ();
		kk.m ();
		// Absicht: Zugriff auf kk.a nicht möglich.
		// ist default in K und nur aus gl. package mögl.; nicht aus 
		// abgeleiteter Klasse im fremden Paket.
		System.out.println (kk.a);
	}
}
