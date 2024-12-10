public class Factorials {

		private int factorialNum; 
		
		public Factorials ()
		{
		}
		public static void main (String [] arg) {
			Factorials fact = new Factorials ();
			int result = fact.getFactorial(7);
			System.out.println("factorial result is: " + result);
			}

		public int getFactorial (int num) {
			
			if (num <= 1) return 1;
			
			return num * getFactorial (num -1);
			}

}	


		
