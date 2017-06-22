package br.furb.main.controller;

import br.furb.main.utils.Point;
import java.util.ArrayList;
import javax.media.opengl.GL;

public class GraphicFace {
    
    private GL gl;
    private ArrayList<Point> objectPoints;
    private int faceType;
    
    private BoundBox bondBox;
    
    public final int FRONT_FACE_TYPE = 0;
    public final int BACK_FACE_TYPE = 1;
    public final int TOP_FACE_TYPE = 2;
    public final int BOTTOM_FACE_TYPE = 3;
    public final int LEFT_FACE_TYPE = 4;
    public final int RIGHT_FACE_TYPE = 5;
        
    public GraphicFace(GL gl, int faceType) {
        this.setGl(gl);
        this.setFaceType(faceType);
        this.setObjectPoints(new ArrayList<Point>());
        
        this.setBondBox(new BoundBox(this));
    }
    
    public void addPoint(Point p) {
        if (p != null) {
            this.getObjectPoints().add(p);
            this.getBondBox().updateBondBox(this);
        }
    }

    public void deletePoint(Point p) {
        if (this.getObjectPoints().contains(p)) {
            this.getObjectPoints().remove(p);
            this.getBondBox().updateBondBox(this);
        }
    }
    
    public void drawFace() {
        switch (this.getFaceType()) {
            case FRONT_FACE_TYPE:
		this.getGl().glNormal3f(0,0,1);
                break;
            case BACK_FACE_TYPE:
		this.getGl().glNormal3f(0,0,-1);
                break;
            case TOP_FACE_TYPE:
		this.getGl().glNormal3f(0,1,0);
                break;
            case BOTTOM_FACE_TYPE:
		this.getGl().glNormal3f(0,-1,0);
                break;
            case LEFT_FACE_TYPE:
		this.getGl().glNormal3f(1,0,0);
                break;
            case RIGHT_FACE_TYPE:
		this.getGl().glNormal3f(-1,0,0);
                break;
        }
        
        if (!this.getObjectPoints().isEmpty()) {
            for (Point objectPoint : this.getObjectPoints()) {
                this.getGl().glVertex3d(objectPoint.getX(), objectPoint.getY(), objectPoint.getZ());
            }
        }
    }
    
    private double getXDistanceBetweenPoints(Point p1, Point p2) {
        return ((p1.getX() >= p2.getX()) ? p1.getX() : p2.getX())
                - ((p1.getX() <= p2.getX()) ? p1.getX() : p2.getX());
    }

    private double getYDistanceBetweenPoints(Point p1, Point p2) {
        return ((p1.getY() >= p2.getY()) ? p1.getY() : p2.getY())
                - ((p1.getY() <= p2.getY()) ? p1.getY() : p2.getY());
    }

    private double getZDistanceBetweenPoints(Point p1, Point p2) {
        return ((p1.getZ() >= p2.getZ()) ? p1.getZ() : p2.getZ())
                - ((p1.getZ() <= p2.getZ()) ? p1.getZ() : p2.getZ());
    }

    public Point findNearPoint(Point p, double distance) {
        if (!this.getObjectPoints().isEmpty()) {
            for (Point objectPoint : this.getObjectPoints()) {
                if (this.getXDistanceBetweenPoints(objectPoint, p) <= distance
                        && this.getYDistanceBetweenPoints(objectPoint, p) <= distance
                        && this.getZDistanceBetweenPoints(objectPoint, p) <= distance) {
                    return objectPoint;
                }
            }
        }
        return null;
    }

    private double yMin(Point p1, Point p2) {
        return (p1.getY() < p2.getY() ? p1.getY() : p2.getY());
    }

    private double yMax(Point p1, Point p2) {
        return (p1.getY() > p2.getY() ? p1.getY() : p2.getY());
    }

    private Point getIntersectionPoint(Point p1, Point p2, double y) {
        return new Point(p1.getX() + (p2.getX() - p1.getX()) * ((y - p1.getY()) / (p2.getY() - p1.getY())), y, 0.0f, 0.0f);
    }

    public boolean scanLine(Point point) {
        int intersections = 0;
        Point prevPoint = null;

        for (Point objectPoint : this.getObjectPoints()) {

            if (prevPoint != null) {
                if (prevPoint.getY() != objectPoint.getY()) {
                    Point intersectionPoint = this.getIntersectionPoint(prevPoint, objectPoint, point.getY());

                    if (intersectionPoint.getX() != point.getX()) {
                        if (intersectionPoint.getX() >= point.getX()
                                && intersectionPoint.getX() >= this.yMin(prevPoint, objectPoint)
                                && intersectionPoint.getY() <= this.yMax(prevPoint, objectPoint)) {
                            intersections++;
                        }
                    }
                }
            }
            prevPoint = objectPoint;
        }

        if (intersections % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public BoundBox getBondBox() {
        return bondBox;
    }

    public void setBondBox(BoundBox bondBox) {
        this.bondBox = bondBox;
    }

    public GL getGl() {
        return gl;
    }

    public void setGl(GL gl) {
        this.gl = gl;
    }

    public ArrayList<Point> getObjectPoints() {
        return objectPoints;
    }

    public void setObjectPoints(ArrayList<Point> objectPoints) {
        this.objectPoints = objectPoints;
    }

    public int getFaceType() {
        return faceType;
    }

    public void setFaceType(int faceType) {
        this.faceType = faceType;
    }
    
    public void exibeVertices() {;
        for (Point p : this.getObjectPoints()) {
            System.out.println("P0[" + p.getX() + "," + p.getY() + "," + p.getZ() + "]");
        }
    }
}
