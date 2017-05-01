
package Controller;

import Utils.Point;

public class BondBox {
    private double xMax, xMin, yMax, yMin, zMax, zMin;
    private Point centerPoint = null;
    
    public BondBox(GraphicObject obj) {
        this.updateBondBox(obj);
    }
    
    public BondBox(double xMax, double xMin, double yMax, double yMin, double zMax, double zMin) {
        this.updateBondBox(xMax, xMin, yMax, yMin, zMax, zMin);
    }

    public void updateBondBox(GraphicObject obj) {
        boolean firstTime = true;
        
        for (Point point : obj.getObjectPoints()) {
            if (!firstTime) {
                this.setxMin(point.getX() < this.getxMin() ? point.getX() : this.getxMin());
                this.setxMax(point.getX() > this.getxMax() ? point.getX() : this.getxMax());
                this.setyMin(point.getY() < this.getyMin() ? point.getY() : this.getyMin());
                this.setyMax(point.getY() > this.getyMax() ? point.getY() : this.getyMax());
                this.setzMin(point.getZ() < this.getzMin() ? point.getY() : this.getyMin());
                this.setzMax(point.getZ() > this.getzMax() ? point.getY() : this.getyMax());
            } else {
                this.setxMin(point.getX());
                this.setxMax(point.getX());
                this.setyMin(point.getY());
                this.setyMax(point.getY());
                this.setzMin(point.getZ());
                this.setzMax(point.getZ());
                firstTime = false;
            }
        }
        
        this.updateCenterPoint();
    }
    
    public void updateBondBox(double xMax, double xMin, double yMax, double yMin, double zMax, double zMin) {
        this.setxMax(xMax);
        this.setxMin(xMin);
        this.setyMax(yMax);
        this.setyMin(yMin);
        this.setzMax(zMax);
        this.setzMin(zMin);
        this.updateCenterPoint();
    }
    
    public double getxMax() {
        return xMax;
    }

    public void setxMax(double xMax) {
        this.xMax = xMax;
    }

    public double getxMin() {
        return xMin;
    }

    public void setxMin(double xMin) {
        this.xMin = xMin;
    }

    public double getyMax() {
        return yMax;
    }

    public void setyMax(double yMax) {
        this.yMax = yMax;
    }

    public double getyMin() {
        return yMin;
    }

    public void setyMin(double yMin) {
        this.yMin = yMin;
    }

    public double getzMax() {
        return zMax;
    }

    public void setzMax(double zMax) {
        this.zMax = zMax;
    }

    public double getzMin() {
        return zMin;
    }

    public void setzMin(double zMin) {
        this.zMin = zMin;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }
    
    public void updateCenterPoint() {
        this.centerPoint = new Point((xMax+xMin/2), (yMax+yMin/2), (zMax+zMin/2), 1);
    }
    
    public boolean isInside(Point p) {
//        System.out.println("pX: " + p.getX() + " --- pY: " + p.getY() 
//                + "\nxMin: " + this.getxMin() + " --- xMax: " + this.getxMax() 
//                + "\nyMin: " + this.getyMin() + " --- yMax: " + this.getyMax() 
//                + "\nzMin: " + this.getyMin() + " --- zMax: " + this.getyMax());
//        
        return (p.getX() >= this.getxMin() && p.getX() <= this.getxMax() &&
                p.getY() >= this.getyMin() && p.getY() <= this.getyMax() &&
                p.getZ() >= this.getzMin() && p.getZ() <= this.getzMax());
    }    
}
