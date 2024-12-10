class Fabionci {
	private int fabNumber = 0;
	
	 public static void main(String[] args) {
		Fabionci fab1 = new Fabionci ();
		int result = fab1.fab(7);
        System.out.println("result is: " + result);
	}
	public Fabionci () {
		this.fabNumber = fabNumber;
		}
		
		public int fab ( int fabNumber) {
			if (fabNumber <= 1) return fabNumber;
			
			else {
				return fab(fabNumber-1) + fab(fabNumber-2);
			}
		}
}


