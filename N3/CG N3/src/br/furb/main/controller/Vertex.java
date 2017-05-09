package br.furb.main.controller;

import br.furb.main.utils.Color;
import br.furb.main.utils.Point;
import static java.lang.Math.abs;
import javax.media.opengl.GL;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 03
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public class Vertex {

    private final int primitive = GL.GL_LINES;
    private GL gl;

    private Color color;
    private Point p1, p2;

    private double lineWidth;

    public Vertex(GL gl, Color color, double lineWidth, Point p1, Point p2) {
        this.setGl(gl);
        this.setColor(color);
        this.setLineWidth(lineWidth);
        this.setP1(p1);
        this.setP2(p2);
    }

    public void drawVertex() {
        this.getGl().glColor3d(this.getColor().getRed(), this.getColor().getGreen(), this.getColor().getBlue());
        this.getGl().glLineWidth((float) this.getLineWidth());

        this.getGl().glBegin(primitive);
        this.getGl().glVertex3d(this.getP1().getX(), this.getP1().getY(), this.getP1().getZ());
        this.getGl().glVertex3d(this.getP2().getX(), this.getP2().getY(), this.getP2().getZ());
        this.getGl().glEnd();
    }

    public static boolean isPointOnVertexLine(Point currentP, Point p1, Point p2) {
        double dxOtherPoint = p2.getX() - p1.getX();
        double dyOtherPoint = p2.getY() - p1.getY();
        double distanceCross = (currentP.getX() - p1.getX()) * dxOtherPoint - (currentP.getY() - p1.getY()) * dyOtherPoint;

        if (distanceCross != 0) {
            return false;
        }

        if (abs(dxOtherPoint) >= abs(dyOtherPoint)) {
            return dxOtherPoint > 0
                    ? p1.getX() <= currentP.getX() && currentP.getX() <= p2.getX()
                    : p2.getX() <= currentP.getX() && currentP.getX() <= p1.getX();
        } else {
            return dyOtherPoint > 0
                    ? p1.getY() <= currentP.getY() && currentP.getY() <= p2.getY()
                    : p2.getY() <= currentP.getY() && currentP.getY() <= p1.getY();
        }
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
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

    public double getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(double lineWidth) {
        this.lineWidth = lineWidth;
    }
}
