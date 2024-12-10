public class Bruch {

		private int zaehler; 
		private int nenner; 
		
		public Bruch (int zaehler, int nenner)
		{
			if (nenner == 0) 
				throw new ArithmeticException ("Div/0!") ; 
			this.zaehler = zaehler;
			this.nenner = nenner; 
		}
		
		public Bruch (int zaehler)
		{
				this.zaehler = zaehler;
				this.nenner = 1; 				
		}
		/*
		public Bruch (int zaehler)
		{
				this (zaehler, 1);
		}
		*/ 
		
		/**
			(3/4) * (7/5) = (3*7) / (4*5)
		*/
		public Bruch mul (Bruch bruch) 
		{
				int neuZaehler = zaehler * bruch.zaehler; 
				int neuNenner = nenner * bruch.nenner; 
				return new Bruch (neuZaehler, neuNenner); 
		}

		/**
			(3/4) + (7/5) =  ((3*5) / (4*5)) + ((7*4) / (5*4))
						  =  ((3*5) + (7*4)) / (5*4) 
			(z/n) + (bz/bn)= ((z*bn) + (bz*n)) / (n*bn)  
		public Bruch add (Bruch b) 
		{
				return new Bruch (((zaehler*b.nenner) + (b.zaehler * nenner)), (nnenner * b.nenner)  ); 
		}
		*/
		public Bruch add (Bruch b) 
		{
				int nz = (zaehler * b.nenner) + (b.zaehler * nenner);
				int nn = (nenner * b.nenner); 
				return new Bruch (nz, nn); 
		}

		public Bruch kuerzen () 
		{
				int teiler = ggT (zaehler, nenner); 
				return new Bruch (zaehler/teiler, nenner/teiler);
		}
		
		private int ggT (int a, int b)		
		{
			for (int i = Math.min (a, b); i > 1; --i)
			{
				if (a % i == 0)
					if (b % i == 0)
						return i;
			}
			return 1; 
		}

		// Zwischenstand Alis Modulo-Lösung: 
		private int ggtAli(int a, int b) {
			while (b != 0) {  
				int tmp = a % b;
				a = b;  
				b = tmp;  
			}
			return a;  
		}

		public Double toDouble ()
		{
			return (1.0 * zaehler) / nenner; 
		}
		
		@Override public String toString ()
		{
			return "Bruch: " + zaehler + " / " + nenner; 
		}
		

}	
		
