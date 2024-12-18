package direction;

public class Main {
    public static void main(String[] args) {
        Pos start = new Pos(0, 0);

        Pos p1 = Richtung.UP.step(start);  
        System.out.println("New Position after UP: " + p1); 
    }
}
