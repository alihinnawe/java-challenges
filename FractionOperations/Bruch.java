class Bruch {
	private int nominomator;
	private int dominonator;
	
	
	public Bruch (int nominator, int dominator) {
		this.nominomator = nominomator;
		this.dominonator = dominonator; 
	} 
	
	public Bruch (int nominator) {
		this.nominomator = nominomator;
		this.dominonator = 1; 
	} 
	
	public Bruch multiplication (Bruch bruch) {
		int nominatorMultiplication = this.nominomator * bruch.nominomator;
		int dominatorMultiplication = this.dominonator * bruch.dominonator;
		return new Bruch (nominatorMultiplication, dominatorMultiplication);
		} 
		
	public void print () {
		System.out.println(this.nominomator,this.dominonator);
		}
}

public class Main {
	
	public static void main (String [] args){
		Bruch bruch1 = new Bruch(24,3);
		Bruch bruch2 = new Bruch(25,9);
		Bruch result = bruch1.multiplication(bruch2);
		result.print()
		
	}
}