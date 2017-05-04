
package Controller;

import Utils.Color;
import Utils.Point;
import Utils.Transformation;
import java.util.ArrayList;
import javax.media.opengl.GL;

public class GraphicObject {
    
    private final int primitive = GL.GL_LINE_STRIP;
    
    private GL gl;
    private Color color; 
    private double width;
    private ArrayList<Point> objectPoints;
    
    private BondBox bondBox;
    private ObjectTransformation objTransformation;

    public static final Color STAND_BY_MODE_COLOR = new Color(0, 0, 0);
    public static final Color NEW_OBJ_MODE_COLOR = new Color(0, 0, 1);
    public static final Color SEL_OBJ_MODE_COLOR = new Color(0, 1, 0);
    public static final Color DEL_OBJ_MODE_COLOR = new Color(1, 0, 0);
    
    public GraphicObject(GL gl, Color color, float width) {
        this.setGl(gl);
        this.setColor(color);
        this.setWidth(width);
        this.setObjectPoints(new ArrayList<>());
        
        this.setBondBox(new BondBox(this));
        this.setObjTransformation(new ObjectTransformation());
    }
    
    public void drawObject() {
        this.getGl().glColor3d(this.getColor().getRed(), 
                this.getColor().getGreen(), 
                this.getColor().getBlue());
        this.getGl().glLineWidth((float)this.getWidth());
        
        this.getGl().glPushMatrix();
            this.getGl().glMultMatrixd(this.getObjTransformation().getMainMatrix().getMatrix(), 0);
            this.getGl().glBegin(this.getPrimitive());
                for (Point objectPoint : this.getObjectPoints()) {
                    this.getGl().glVertex2d(objectPoint.getX(), objectPoint.getY());
                }
            this.getGl().glEnd();
        this.getGl().glPopMatrix();
    }
    
    public void drawPoint(Point p) {
        this.getGl().glColor3d(this.getColor().getRed() + 0.2, 
                this.getColor().getGreen() + 0.2, 
                this.getColor().getBlue() + 0.2);
        this.getGl().glPointSize((float)(this.getWidth()*4));
        
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
        return new Point(p1.getX() + (p2.getX() - p1.getX())*((y - p1.getY()) / (p2.getY() - p1.getY())), y, 0.0f, 0.0f);
    }
    
    public boolean scanLine(Point point) {
        int intersections = 0;
        Point prevPoint = null;
        
        for (Point objectPoint : this.getObjectPoints()) {
            if (prevPoint != null) {
                
                if (prevPoint.getY() != objectPoint.getY()) {
                    Point intersectionPoint = this.getIntersectionPoint(prevPoint, objectPoint, point.getY());
                    
                    if (intersectionPoint.getX() != point.getX()) {
                        if (intersectionPoint.getX() > point.getX() 
                                && intersectionPoint.getX() > this.yMin(prevPoint, objectPoint)
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

    public BondBox getBondBox() {
        return bondBox;
    }

    public void setBondBox(BondBox bondBox) {
        this.bondBox = bondBox;
    }

    public ObjectTransformation getObjTransformation() {
        return objTransformation;
    }

    public void setObjTransformation(ObjectTransformation objTransformation) {
        this.objTransformation = objTransformation;
    }
//        
//    public void exibeMatriz() {
//            this.getObjTransformation().getMainMatrix().exibeMatriz();
//    }
//
//    public void exibeVertices() {
//        for (Point p : this.getObjectPoints()) {
//            System.out.println("P0[" + p.getX() + "," + p.getY() + "," + p.getZ() + "]");
//        }
//    }
}
