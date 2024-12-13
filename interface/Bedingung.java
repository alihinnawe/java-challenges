interface Bedingung {
	public boolean check (int a, int b); 
}

class Up implements Bedingung {
	public boolean check (int a, int b) {
		return (a < b); 
	}
}

class Down implements Bedingung {
	public boolean check (int a, int b) {
		return (a > b); 
	}
}

class InRange implements Bedingung {
	private int delta;
	InRange (int delta) { this.delta  = delta;}
	public boolean check (int a, int b) {
		return (Math.abs (a - b) > delta); 
	}		
}
