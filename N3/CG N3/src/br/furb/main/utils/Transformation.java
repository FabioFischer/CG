package br.furb.main.utils;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 03
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public final class Transformation {

    public static final double DEG_TO_RAD = 0.017453292519943295769236907684886;

    private double[] matrix = {1, 0, 0, 0,
                               0, 1, 0, 0,
                               0, 0, 1, 0,
                               0, 0, 0, 1};
    
    public Transformation() {
    }
    
    public void setIdentity() {
        for (int i = 0; i < this.getMatrix().length; i++) {
            this.getMatrix()[i] = 0;
        }
        this.getMatrix()[0] = this.getMatrix()[5] = this.getMatrix()[10] = this.getMatrix()[15] = 1;    
    }
    
    public void translate(double tx, double ty, double tz) {
        this.setIdentity();
        this.getMatrix()[12] = tx;
        this.getMatrix()[13] = ty;
        this.getMatrix()[14] = tz;
    }
    
    public void scale(double sx, double sy, double sz) {
        this.setIdentity();
        this.getMatrix()[0] = sx;
        this.getMatrix()[5] = sy;
        this.getMatrix()[10] = sz;
    }
    
    public void rotateX(double radians) {
        this.setIdentity();
        this.getMatrix()[5] = Math.cos(radians);
        this.getMatrix()[6] = Math.sin(radians);
        this.getMatrix()[9] = -Math.sin(radians);
        this.getMatrix()[10] = Math.cos(radians);
    }
    
    public void rotateY(double radians) {
        this.setIdentity();
        this.getMatrix()[0] = Math.cos(radians);
        this.getMatrix()[2] = -Math.sin(radians);
        this.getMatrix()[8] = Math.sin(radians);
        this.getMatrix()[10] = Math.cos(radians);
    }
    
    public void rotateZ(double radians) {
        this.setIdentity();
        this.getMatrix()[0] = Math.cos(radians);
        this.getMatrix()[1] = Math.sin(radians);
        this.getMatrix()[4] = -Math.sin(radians);
        this.getMatrix()[5] = Math.cos(radians);
    }
    
    public Point transformPoint(Point p) {
        Point newP = new Point(
                this.getMatrix()[0] * p.getX() + this.getMatrix()[4] * p.getY() + this.getMatrix()[8] * p.getZ() + this.getMatrix()[12] * p.getW(), 
                this.getMatrix()[1] * p.getX() + this.getMatrix()[5] * p.getY() + this.getMatrix()[9] * p.getZ() + this.getMatrix()[13] * p.getW(), 
                this.getMatrix()[2] * p.getX() + this.getMatrix()[6] * p.getY() + this.getMatrix()[10] * p.getZ() + this.getMatrix()[14] * p.getW(), 
                this.getMatrix()[3] * p.getX() + this.getMatrix()[7] * p.getY() + this.getMatrix()[11] * p.getZ() + this.getMatrix()[15] * p.getW());
        return newP;
    }
    
    public Transformation transformMatrix(Transformation t) {
        Transformation newT = new Transformation();
        
        for (int i = 0; i < 16; i++) {
            newT.getMatrix()[i] = 
                      this.getMatrix()[i%4] * t.getMatrix()[i/4*4] 
                    + this.getMatrix()[(i%4)+4] * t.getMatrix()[i/4*4+1] 
                    + this.getMatrix()[(i%4)+8] * t.getMatrix()[i/4*4+2] 
                    + this.getMatrix()[(i%4)+12] * t.getMatrix()[i/4*4+3];
        }
        
        return newT;
    }
    
    public double getElement (int index) {
        return this.getMatrix()[index];
    }
    
    public void setElement(int index, double value) {
        this.getMatrix()[index] = value;
    }

    public double[] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[] matrix) {
        for (int i = 0; i < this.getMatrix().length; i++) {
            this.getMatrix()[i] = matrix[i];
        }
    }
    
    public void exibeMatriz() {
            System.out.println("______________________");
            System.out.println("|" + getElement( 0) + " | "+ getElement( 4) + " | " + getElement( 8) + " | "+ getElement(12));
            System.out.println("|" + getElement( 1) + " | "+ getElement( 5) + " | " + getElement( 9) + " | "+ getElement(13));
            System.out.println("|" + getElement( 2) + " | "+ getElement( 6) + " | " + getElement(10) + " | "+ getElement(14));
            System.out.println("|" + getElement( 3) + " | "+ getElement( 7) + " | " + getElement(11) + " | "+ getElement(15));
    }
}
