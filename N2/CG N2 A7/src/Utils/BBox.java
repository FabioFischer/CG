package Utils;

import java.util.ArrayList;

public class BBox {

    private float minX, maxX, minY, maxY;

    public BBox() {
    }

    public BBox(ArrayList<Ponto4D> points) {
        boolean firstTime = true;
        for (Ponto4D point : points) {
            if (!firstTime) {
                this.setMinX(point.obterX() < this.getMinX() ? point.obterX() : this.getMinX());
                this.setMaxX(point.obterX() > this.getMaxX() ? point.obterX() : this.getMaxX());
                this.setMinY(point.obterY() < this.getMinY() ? point.obterY() : this.getMinY());
                this.setMaxY(point.obterY() > this.getMaxY() ? point.obterY() : this.getMaxY());
            } else {
                this.setMinX(point.obterX());
                this.setMaxX(point.obterX());
                this.setMinY(point.obterY());
                this.setMaxY(point.obterY());
                firstTime = false;
            }
        }
    }

    public BBox(float minX, float maxX, float minY, float maxY) {
        this.setMinX(minX);
        this.setMaxX(maxX);
        this.setMinY(minY);
        this.setMaxY(maxY);
    }

    public float getMinX() {
        return minX;
    }

    public void setMinX(float minX) {
        this.minX = minX;
    }

    public float getMaxX() {
        return maxX;
    }

    public void setMaxX(float maxX) {
        this.maxX = maxX;
    }

    public float getMinY() {
        return minY;
    }

    public void setMinY(float minY) {
        this.minY = minY;
    }

    public float getMaxY() {
        return maxY;
    }

    public void setMaxY(float maxY) {
        this.maxY = maxY;
    }

    public void printLimits() {
        System.out.println("--------------"
                + "\nMinX: " + this.getMinX()
                + "\nMaxX: " + this.getMaxX()
                + "\nMinY: " + this.getMinY()
                + "\nMaxY: " + this.getMaxY());
    }

    public boolean pointIsInside(Ponto4D ponto) {
        if (ponto.obterX() > this.getMinX() && ponto.obterX() < this.getMaxX()
                && ponto.obterY() > this.getMinY() && ponto.obterY() < this.getMaxY()) {
            return true;
        }
        return false;
    }
}
