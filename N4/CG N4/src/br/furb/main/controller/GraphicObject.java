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

public abstract class GraphicObject {

    private final int primitive = GL.GL_LINE_STRIP;

    public static final Color STAND_BY_MODE_COLOR = new Color(0, 0, 0);
    public static final Color NEW_OBJ_MODE_COLOR = new Color(0, 0, 1);
    public static final Color SEL_OBJ_MODE_COLOR = new Color(0, 1, 0);
    public static final Color DEL_OBJ_MODE_COLOR = new Color(1, 0, 0);

    private GL gl;
    private Color currentColor, defaultColor;
    private double width;

    private ArrayList<Point> objectPoints;
    private ArrayList<GraphicObject> dependentObjects;

    private BoundBox bondBox;
    private ObjectTransformation objTransformation;

    public GraphicObject(GL gl, Color color, float width) {
        this.setGl(gl);
        this.setCurrentColor(color);
        this.setDefaultColor(this.STAND_BY_MODE_COLOR);
        this.setWidth(width);
        this.setObjectPoints(new ArrayList<>());
        this.setDependentObjects(new ArrayList<>());

        this.setBondBox(new BoundBox(this));
        this.setObjTransformation(new ObjectTransformation());
    }

    public void drawObject() {
        this.getGl().glColor3d(this.getCurrentColor().getRed(),
                this.getCurrentColor().getGreen(),
                this.getCurrentColor().getBlue());
        this.getGl().glLineWidth((float) this.getWidth());

        this.getGl().glPushMatrix();
            this.getGl().glMultMatrixd(this.getObjTransformation().getMainMatrix().getMatrix(), 0);
            this.getGl().glBegin(this.getPrimitive());
                for (Point objectPoint : this.getObjectPoints()) {
                    this.getGl().glVertex2d(objectPoint.getX(), objectPoint.getY());
                }
            this.getGl().glEnd();
        this.getGl().glPopMatrix();
        
        if (this.getDependentObjects() != null) {
            for (GraphicObject obj : this.getDependentObjects()) {
                if (obj != null) {
                    obj.drawObject();
                }
            }
        }
    }

    public void drawPoint(Point p) {
        this.getGl().glColor3d(this.getCurrentColor().getRed() + 0.2,
                this.getCurrentColor().getGreen() + 0.2,
                this.getCurrentColor().getBlue() + 0.2);
        this.getGl().glPointSize((float) (this.getWidth() * 4));

        this.getGl().glBegin(GL.GL_POINTS);
            this.getGl().glVertex2d(p.getX(), p.getY());
        this.getGl().glEnd();
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

    public void addDependent(GraphicObject obj) {
        if (obj != null) {
            this.getDependentObjects().add(obj);
        }
    }

    public void deleteDependent(GraphicObject obj) {
        if (obj != null && this.getDependentObjects().contains(obj)) {
            this.getDependentObjects().remove(obj);
        }
    }

    public void translate(double dx, double dy, double dz) {
        this.getObjTransformation().translate3D(dx, dy, dz);
        this.getObjTransformation().getMainMatrix().exibeMatriz();
        this.translateDependents(dx, dy, dz, this.getDependentObjects());
    }
    
    public void translateDependents(double dx, double dy, double dz, ArrayList<GraphicObject> dependents) {
        for (GraphicObject obj : dependents) {
            obj.getObjTransformation().translate3D(dx, dy, dz);
            this.translateDependents(dx, dy, dz, obj.getDependentObjects());
        }
    }

    public void scale(double scale) {
        this.getObjTransformation().scaleStaticPoint(scale, Point.invert(this.getBondBox().getCenterPoint()));
        this.scaleDependents(scale, this.getDependentObjects());
    }
    
    public void scaleDependents(double scale, ArrayList<GraphicObject> dependents) {
        for (GraphicObject obj : dependents) {
            obj.getObjTransformation().scaleStaticPoint(scale, Point.invert(obj.getBondBox().getCenterPoint()));
            this.scaleDependents(scale, obj.getDependentObjects());
        }
    }

    public void rotate(double angle) {
        this.getObjTransformation().rotateStaticPoint(angle, Point.invert(this.getBondBox().getCenterPoint()));
        this.rotateDependents(angle, this.getDependentObjects());
    }
    
    public void rotateDependents(double angle, ArrayList<GraphicObject> dependents) {
        for (GraphicObject obj : dependents) {
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

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;

        if (this.getDependentObjects() != null) {
            for (GraphicObject obj : this.getDependentObjects()) {
                obj.setCurrentColor(currentColor);
            }
        }
    }

    public Color getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(Color defaultColor) {
        this.defaultColor = defaultColor;
        
        if (this.getDependentObjects() != null) {
            for (GraphicObject obj : this.getDependentObjects()) {
                obj.setDefaultColor(defaultColor);
            }
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
        
        if (this.getDependentObjects() != null) {
            for (GraphicObject obj : this.getDependentObjects()) {
                obj.setWidth(width);
            }
        }
    }

    public ArrayList<Point> getObjectPoints() {
        return objectPoints;
    }

    public void setObjectPoints(ArrayList<Point> objectPoints) {
        this.objectPoints = objectPoints;
    }

    public ArrayList<GraphicObject> getDependentObjects() {
        return dependentObjects;
    }

    public void setDependentObjects(ArrayList<GraphicObject> dependentObjects) {
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
