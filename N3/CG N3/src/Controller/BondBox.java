
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
        this.updateCenterPoint();
    }

    public void updateBondBox(GraphicObject obj) {
        boolean firstTime = true;
        
        for (Point point : obj.getObjectPoints()) {
            if (!firstTime) {
                this.updateBondBox(
                        this.getHigherValue(point.getX(), this.getxMax()), 
                        this.getLowerValue(point.getX(), this.getxMin()), 
                        this.getHigherValue(point.getY(), this.getyMax()), 
                        this.getLowerValue(point.getY(), this.getyMin()),
                        this.getHigherValue(point.getZ(), this.getzMax()), 
                        this.getLowerValue(point.getZ(), this.getzMin()));
            } else {
                this.updateBondBox(point.getX(), point.getX(), point.getY(), point.getY(), point.getZ(), point.getZ());
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
    }
    
    public double getHigherValue(double d1, double d2) {
        return d1 > d2 ? d1 : d2;
    }
    
    public double getLowerValue(double d1, double d2) {
        return d1 < d2 ? d1 : d2;
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
