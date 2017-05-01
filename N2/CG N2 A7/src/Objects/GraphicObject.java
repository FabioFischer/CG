package Objects;

import Utils.BBox;
import Utils.Color;
import Utils.Ponto4D;
import java.util.ArrayList;
import javax.media.opengl.GL;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 02 - Atividade 07
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */
public abstract class GraphicObject {

    private float width;

    private GL gl;
    private Color color;
    private ArrayList<Ponto4D> objectPoints;
    private BBox bBox;

    public GraphicObject(GL gl, Color color, float width) {
        this.setGl(gl);
        this.setColor(color);
        this.setWidth(width);
        this.objectPoints = new ArrayList<>();
    }

    public GraphicObject(GL gl, float width) {
        this.setGl(gl);
        this.setWidth(width);
        this.objectPoints = new ArrayList<>();
    }

    public ArrayList<Ponto4D> getObjectPoints() {
        return objectPoints;
    }

    public void addObjectPoint(Ponto4D point) {
        if (point != null) {
            this.objectPoints.add(point);
        }
    }

    public BBox getbBox() {
        return bBox;
    }

    public void setbBox(BBox bBox) {
        this.bBox = bBox;
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

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void printObjectPoints() {
        for (Ponto4D objectPoint : objectPoints) {
            System.out.println("----------------------"
                    + "\nObjX: " + objectPoint.obterX()
                    + "\nObjY: " + objectPoint.obterY());
        }
    }

    public abstract void drawObject();

    public void drawObjectPoints(int primitive) {
        this.getGl().glBegin(primitive);
            for (Ponto4D objectPoint : objectPoints) {
                this.getGl().glVertex2f(objectPoint.obterX(), objectPoint.obterY());
            }
        this.getGl().glEnd();
    }
    
    private float yMin(Ponto4D p1, Ponto4D p2) {
        return (p1.obterY() < p2.obterY() ? p1.obterY() : p2.obterY());
    }
    
    private float yMax(Ponto4D p1, Ponto4D p2) {
        return (p1.obterY() > p2.obterY() ? p1.obterY() : p2.obterY());
    }
    
    private Ponto4D getIntersectionPoint(Ponto4D p1, Ponto4D p2, float y) {
        return new Ponto4D(p1.obterX() + (p2.obterX() - p1.obterX())*((y - p1.obterY()) / (p2.obterY() - p1.obterY())), y, 0.0f, 0.0f);
    }
    
    public boolean scanLine(Ponto4D point) {
        int intersections = 0;
        Ponto4D prevPoint = null;
        
        for (Ponto4D objectPoint : objectPoints) {
            if (prevPoint != null) {
                
                if (prevPoint.obterY() != objectPoint.obterY()) {
                    Ponto4D intersectionPoint = this.getIntersectionPoint(prevPoint, objectPoint, point.obterY());
                    
                    if (intersectionPoint.obterX() != point.obterX()) {
                        if (intersectionPoint.obterX() > point.obterX() 
                                && intersectionPoint.obterY() > this.yMin(prevPoint, objectPoint)
                                && intersectionPoint.obterY() <= this.yMax(prevPoint, objectPoint)) {
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
}
