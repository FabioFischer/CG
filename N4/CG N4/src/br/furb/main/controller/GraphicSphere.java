package br.furb.main.controller;

import br.furb.main.utils.Color;
import br.furb.main.utils.Point;
import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;

public class GraphicSphere {

    private GL gl;
    private GLUT glut;
    private Color color;
    private Point centerPoint;
    private double size;
    
    private boolean hasLight;
    
    private final int NUM_OF_SUB_DIVISIONS = 100;

    public GraphicSphere(GL gl, GLUT glut, Color color, Point centerPoint, double size, boolean light) {
        this.setGl(gl);
        this.setGlut(glut);
        this.setColor(color);
        this.setCenterPoint(centerPoint);
        this.setSize(size);
        this.setLight(light);
    }

    public void drawSphere() {
        this.getGl().glColor3d(this.getColor().getRed(), this.getColor().getGreen(), this.getColor().getBlue());
                
        if (this.hasLight()) {
            this.getGl().glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE, this.getColor().getColorArrayF(), 0);
            this.getGl().glEnable(GL.GL_LIGHTING);
        }
        
        this.getGl().glPushMatrix();
            this.getGl().glTranslated(getCenterPoint().getX(), getCenterPoint().getY(), getCenterPoint().getZ());
            this.getGlut().glutSolidSphere(this.getSize(), NUM_OF_SUB_DIVISIONS, NUM_OF_SUB_DIVISIONS);
        this.getGl().glPopMatrix();
        
        if (this.hasLight()) {
            this.getGl().glDisable(GL.GL_LIGHTING);
        }
    }

    public boolean hasLight() {
        return hasLight;
    }

    public void setLight(boolean hasLight) {
        this.hasLight = hasLight;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public GL getGl() {
        return gl;
    }

    public void setGl(GL gl) {
        this.gl = gl;
    }

    public GLUT getGlut() {
        return glut;
    }

    public void setGlut(GLUT glut) {
        this.glut = glut;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
