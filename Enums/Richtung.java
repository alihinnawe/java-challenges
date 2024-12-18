package direction;

public enum Richtung {

    UP, DOWN, RIGHT, LEFT;

    public Pos step(Pos indices) {
        int x = indices.xCoord;
        int y = indices.yCoord;

        switch (this) {
            case UP:
                return new Pos(x, y + 1); 
            case DOWN:
                return new Pos(x, y - 1); 
            case RIGHT:
                return new Pos(x + 1, y); 
            case LEFT:
                return new Pos(x - 1, y); 
            default:
                return indices; 
        }
    }
}
