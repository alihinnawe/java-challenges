package direction;

public class Pos {
	public int xCoord;
	public int yCoord;

	public Pos (int xCoord, int yCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	@Override public String toString() {
		return "(" + xCoord + ", " + yCoord + ")";
	}
	
	public static void main (String [] args) {
		
		Pos pos = new Pos (3,4);
		System.out.println(pos.toString());
			
		}

}
