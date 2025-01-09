/**
 * 
 * <img src="doc-files\directions.jpg" alt="Direction Diagram" width="300" height="300">
 */
public enum Direction {
    /**
     * Represents the North direction.
     */
    NORTH,

    /**
     * Represents the South direction.
     */
    SOUTH,

    /**
     * Represents the East direction.
     */
    EAST,

    /**
     * Represents the West direction.
     */
    WEST;

    /**
     * Returns the opposite direction of the current direction.
     * 
     * @return The opposite direction.
     * @see Direction
     */
    public Direction getOpposite() {
        switch (this) {
            case NORTH:
                return SOUTH;
            case SOUTH:
                return NORTH;
            case EAST:
                return WEST;
            case WEST:
                return EAST;
            default:
                throw new IllegalStateException("Invalid direction: " + this);
        }
    }

    /**
     * Returns the direction as a lowercase string.
     * 
     * @return The direction in lowercase.
     * @see #toString() To get the direction in its default string representation.
     */
    public String toLowercase() {
        return this.toString().toLowerCase();
    }
}
