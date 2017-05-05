package br.furb.main.utils;

import javax.media.opengl.GL;
import javax.media.opengl.GLDrawable;

public class SRU {

    private GL gl;
    private GLDrawable glDrawable;
    private double height, width, depth;

    private static final Color HEIGHT_COLOR = new Color(1, 0, 0);
    private static final Color WIDTH_COLOR = new Color(0, 1, 0);
    private static final Color DEPTH_COLOR = new Color(0, 0, 1);
    
    public SRU(GL gl, GLDrawable glDrawable, double height, double width, double depth) {
        this.setGl(gl);
        this.setGlDrawable(glDrawable);
        this.setHeight(height);
        this.setWidth(width);
        this.setDepth(depth);
    }
    
    public SRU(GL gl, GLDrawable glDrawable) {
        this.setGl(gl);
        this.setGlDrawable(glDrawable);
        this.setHeight(this.getGlDrawable().getHeight() / 2);
        this.setWidth(this.getGlDrawable().getWidth() / 2);
        this.setDepth(this.getGlDrawable().getHeight() / 2);
    }

    public GL getGl() {
        return gl;
    }

    public void setGl(GL gl) {
        this.gl = gl;
    }
    
    public GLDrawable getGlDrawable() {
        return glDrawable;
    }

    public void setGlDrawable(GLDrawable glDrawable) {
        this.glDrawable = glDrawable;
    }
    
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
    
    public Point getHeightPoint() {
        return new Point(this.getHeight(), 0, 0, 1);
    }
    
    public Point getWidthPoint() {
        return new Point(0, this.getWidth(), 0, 1);
    }
    
    public Point getDepthPoint() {
        return new Point(0, 0, this.getDepth(), 1);
    }
        
    private void drawLine(Color c, Point p1, Point p2) {
        this.getGl().glColor3d(c.getRed(), c.getGreen(), c.getBlue());
        this.getGl().glBegin(GL.GL_LINES);
            this.getGl().glVertex3d(p1.getX(), p1.getY(), p1.getZ());
            this.getGl().glVertex3d(p2.getX(), p2.getY(), p2.getZ());
        this.getGl().glEnd();
    }
    
    public void drawSRU() {
        this.getGl().glLineWidth(1.0f);

        this.drawLine(HEIGHT_COLOR, this.getHeightPoint(), Point.invert(this.getHeightPoint()));
        this.drawLine(WIDTH_COLOR, this.getWidthPoint(), Point.invert(this.getWidthPoint()));
        this.drawLine(DEPTH_COLOR, this.getDepthPoint(), Point.invert(this.getDepthPoint()));
    }
}
