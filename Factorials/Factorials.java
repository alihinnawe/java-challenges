public class Factorials {

		private int factorialNum; 
		
		public static int saveFactorial (int num) 
		{
			if (num == 1) return 1;
			return num * saveFactorial(num - 1);
			}
		public Factorials ()
		{
		}
		public static void main (String [] arg) {
			Factorials fact = new Factorials ();
			int result = fact.getFactorial(12);
			System.out.println("factorial result is: " + result);
			}

		public int getFactorial (int num) {
			if (num <0) throw new ArithmeticException ("facotrial of negative numbers is not allowed");
			if (num <= 1) return 1;
			
			return num * saveFactorial (num -1);
			}

}	


		
