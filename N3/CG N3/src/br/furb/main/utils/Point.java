package br.furb.main.utils;

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
    
    public static Point invert(Point p) {
        p.setX(p.getX() * -1);
        p.setY(p.getY() * -1);
        p.setZ(p.getZ() * -1);
        return p;
    }
    
    public void translate(Point p) {
        this.translateX(p.getX());
        this.translateY(p.getY());
        this.translateZ(p.getZ());
    }
    
    public void translate(double x, double y, double z) {
        this.translateX(x);
        this.translateY(y);
        this.translateZ(z);
    }
    
    public void translateX(double d) {
        this.setX(this.getX() + d);
    }
    
    public void translateY(double d) {
        this.setY(this.getY() + d);
    }
    
    public void translateZ(double d) {
        this.setZ(this.getZ() + d);
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
    
    public void imprimirPonto() {
        System.out.println("X: " + this.getX() + " /// Y: " + this.getY() + " /// Z: " + this.getZ());
    }
}
