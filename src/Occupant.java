public abstract class Occupant implements Redirector {
    private Grid grid;
    private Position position;

    public Occupant(Grid grid, Position position) {
        this.position = position;
        setGrid(grid);
    }

    public Occupant(Grid grid) {
        this(grid, new Position(0, 0, 0));
    }

    public Grid getGrid() {
        return this.grid;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.grid.moveOccupant(this, position);
        this.position = position;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
        grid.addOccupant(this);
    }
}
