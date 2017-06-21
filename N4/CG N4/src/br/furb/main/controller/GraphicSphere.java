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

    public GraphicSphere(GL gl, GLUT glut, Color color, Point centerPoint, double size) {
        this.setGl(gl);
        this.setGlut(glut);
        this.setColor(color);
        this.setCenterPoint(centerPoint);
        this.setSize(size);
    }

    public void drawSphere() {
        gl.glColor3d(this.getColor().getRed(), this.getColor().getGreen(), this.getColor().getBlue());

        gl.glPushMatrix();
            gl.glTranslated(1.0, 1.2, -6);
            glut.glutSolidSphere(1, 50, 50);
        gl.glPopMatrix();

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
