package br.furb.main.controller;

import br.furb.main.utils.Color;
import br.furb.main.utils.Point;
import java.util.ArrayList;
import javax.media.opengl.GL;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 03
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public abstract class GraphicPolygon {

    private final int primitive = GL.GL_LINE_STRIP;

    private GL gl;
    private Color color;
    private double width;

    private ArrayList<Point> objectPoints;
    private ArrayList<GraphicPolygon> dependentObjects;

    private BoundBox bondBox;
    private ObjectTransformation objTransformation;

    public GraphicPolygon(GL gl, Color color, float width) {
        this.setGl(gl);
        this.setColor(color);
        this.setWidth(width);
        this.setObjectPoints(new ArrayList<>());
        this.setDependentObjects(new ArrayList<>());

        this.setBondBox(new BoundBox(this));
        this.setObjTransformation(new ObjectTransformation());
    }

    public void drawObject() {
    }

    public void drawPoint(Point p) {
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

    public void addDependent(GraphicPolygon obj) {
        if (obj != null) {
            this.getDependentObjects().add(obj);
        }
    }

    public void deleteDependent(GraphicPolygon obj) {
        if (obj != null && this.getDependentObjects().contains(obj)) {
            this.getDependentObjects().remove(obj);
        }
    }

    public void translate(double dx, double dy, double dz) {
        this.getObjTransformation().translate3D(dx, dy, dz);
        this.getObjTransformation().getMainMatrix().exibeMatriz();
        this.translateDependents(dx, dy, dz, this.getDependentObjects());
    }
    
    public void translateDependents(double dx, double dy, double dz, ArrayList<GraphicPolygon> dependents) {
        for (GraphicPolygon obj : dependents) {
            obj.getObjTransformation().translate3D(dx, dy, dz);
            this.translateDependents(dx, dy, dz, obj.getDependentObjects());
        }
    }

    public void scale(double scale) {
        this.getObjTransformation().scaleStaticPoint(scale, Point.invert(this.getBondBox().getCenterPoint()));
        this.scaleDependents(scale, this.getDependentObjects());
    }
    
    public void scaleDependents(double scale, ArrayList<GraphicPolygon> dependents) {
        for (GraphicPolygon obj : dependents) {
            obj.getObjTransformation().scaleStaticPoint(scale, Point.invert(obj.getBondBox().getCenterPoint()));
            this.scaleDependents(scale, obj.getDependentObjects());
        }
    }

    public void rotate(double angle) {
        this.getObjTransformation().rotateStaticPoint(angle, Point.invert(this.getBondBox().getCenterPoint()));
        this.rotateDependents(angle, this.getDependentObjects());
    }
    
    public void rotateDependents(double angle, ArrayList<GraphicPolygon> dependents) {
        for (GraphicPolygon obj : dependents) {
            obj.getObjTransformation().rotateStaticPoint(angle, Point.invert(obj.getBondBox().getCenterPoint()));
            this.rotateDependents(angle, obj.getDependentObjects());
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

    public int getPrimitive() {
        return primitive;
    }

    public GL getGl() {
        return gl;
    }

    public void setGl(GL gl) {
        this.gl = gl;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;        
    }

    public ArrayList<Point> getObjectPoints() {
        return objectPoints;
    }

    public void setObjectPoints(ArrayList<Point> objectPoints) {
        this.objectPoints = objectPoints;
    }

    public ArrayList<GraphicPolygon> getDependentObjects() {
        return dependentObjects;
    }

    public void setDependentObjects(ArrayList<GraphicPolygon> dependentObjects) {
        this.dependentObjects = dependentObjects;
    }

    public BoundBox getBondBox() {
        return bondBox;
    }

    public void setBondBox(BoundBox bondBox) {
        this.bondBox = bondBox;
    }

    public ObjectTransformation getObjTransformation() {
        return objTransformation;
    }

    public void setObjTransformation(ObjectTransformation objTransformation) {
        this.objTransformation = objTransformation;
    }
    
    public void exibeVertices() {;
        for (Point p : this.getObjectPoints()) {
            System.out.println("P0[" + p.getX() + "," + p.getY() + "," + p.getZ() + "]");
        }
    }
}
