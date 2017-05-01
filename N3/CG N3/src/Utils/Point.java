package Utils;

public final class Point {

    private double x, y, z, w;

    public Point() {
        this(0, 0, 0, 1);
    }

    public Point(double x, double y, double z, double w) {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
        this.setW(w);
    }
    
    public Point invert(Point p) {
        p.setX(p.getX() * -1);
        p.setY(p.getY() * -1);
        p.setZ(p.getZ() * -1);
        return p;
    }
    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

}
