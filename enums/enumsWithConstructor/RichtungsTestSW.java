import java.util.*;

enum Richtung { 
	   UP ( 0,  1), 
	 DOWN ( 0, -1), 
	 LEFT (-1,  0), 
	RIGHT (+1,  0);
	
	int dx, dy; 
	private Richtung (int hor, int ver) { dx = hor; dy = ver;}

    public Position step (Position start) {
		return new Position (start.x + dx, start.y + dy);
    }
}

class Position {
	int x;
	int y;
	public Position (int x, int y)
	{
		this.x = x;
		this.y = y; 
	}
	
	public String toString () { return "(" + x + ":" + y + ")"; }
}

public class RichtungsTestSW
{
	public static void main(String[] args) {
		Position start = new Position (0,0);
		// Position p1 = start.Richtung.UP (start);
		Position p1 = Richtung.UP.step (start);	// 0, 1
		Position p2 = Richtung.LEFT.step (p1);  // -1, 1
		Position p3 = Richtung.DOWN.step (p2);  // -1, 0
		
		Random rnd = new Random (8);
		Position p = new Position (500, 500);
		Richtung[] richtungen = Richtung.values ();
		
		for (int i = 0; i < 1000; ++i)
		{
			int j = rnd.nextInt (4);
			p = richtungen[j].step (p);
			System.out.println (p);
		}
	}
}
