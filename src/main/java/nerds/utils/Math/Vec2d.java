package nerds.utils.Math;

public class Vec2d {

    private double x, y;

    public Vec2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void subtract(double x, double y) {
        this.x -= x;
        this.y -= y;
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }
}