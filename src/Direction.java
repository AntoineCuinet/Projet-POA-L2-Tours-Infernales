public class Direction {
    private int x;
    private int y;
    private int z;

    public Direction(int x, int y, int z) {
        if (isValidDirection(x) && isValidDirection(y) && isValidDirection(z)) {
            this.x = x;
            this.y = y;
            this.z = z;
        } else {
            throw new IllegalArgumentException("Invalid direction values. Each element must be -1, 0, or 1.");
        }
    }

    private boolean isValidDirection(int value) {
        return value >= -1 && value <= 1;
    }

    // Getters and setters for x, y, and z

    public Position calculateFuturePosition(Position currentPosition) {
        int futureX = currentPosition.getX() + x;
        int futureY = currentPosition.getY() + y;
        int futureZ = currentPosition.getZ() + z;
        return new Position(futureX, futureY, futureZ);
    }
}
