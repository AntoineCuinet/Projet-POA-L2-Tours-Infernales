public class Tower {
    private Floor floor;
    private Ceil ceil;

    public Tower(Floor floor, Ceil ceil) {
        this.floor = floor;
        this.ceil = ceil;
    }

    public Floor getFloor() {
        return this.floor;
    }

    public Ceil getCeil() {
        return this.ceil;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public void setCeil(Ceil ceil) {
        this.ceil = ceil;
    }
}
