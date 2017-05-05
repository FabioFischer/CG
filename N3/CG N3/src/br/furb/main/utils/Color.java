package br.furb.main.utils;

public class Color {
    private double red, green, blue;
    
    public Color (double red, double green, double blue) {
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
    }

    public double getRed() {
        return red;
    }

    public void setRed(double red) {
        this.red = red;
    }

    public double getGreen() {
        return green;
    }

    public void setGreen(double green) {
        this.green = green;
    }

    public double getBlue() {
        return blue;
    }

    public void setBlue(double blue) {
        this.blue = blue;
    }    
}
