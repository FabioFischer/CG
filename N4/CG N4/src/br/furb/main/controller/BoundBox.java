package br.furb.main.controller;

import br.furb.main.utils.Point;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 03
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public class BoundBox {
    private double xMax, xMin, yMax, yMin, zMax, zMin;
    private Point centerPoint = null;
    
    public BoundBox(GraphicFace face) {
        this.updateBondBox(face);
    }
    
    public BoundBox(double xMax, double xMin, double yMax, double yMin, double zMax, double zMin) {
        this.updateBondBox(xMax, xMin, yMax, yMin, zMax, zMin);
        this.updateCenterPoint();
    }

    public void updateBondBox(GraphicFace face) {
        boolean firstTime = true;
        
        for (Point point : face.getObjectPoints()) {
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
        this.centerPoint = new Point(((xMax+xMin)/2), ((yMax+yMin)/2), ((zMax+zMin)/2), 1);
    }
    
    public boolean isInside(Point p) {
        return (p.getX() >= this.getxMin() && p.getX() <= this.getxMax() &&
                p.getY() >= this.getyMin() && p.getY() <= this.getyMax() &&
                p.getZ() >= this.getzMin() && p.getZ() <= this.getzMax());
    }    
}
