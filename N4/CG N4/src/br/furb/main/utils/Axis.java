/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.main.utils;

import javax.media.opengl.GL;

/**
 *
 * @author fabio.fischer
 */
public class Axis {

    private GL gl;
    private double lenght;
    
    public Axis(GL gl, double lenght) {
        this.setGl(gl);
        this.setLenght(lenght);
    }
    
    public void drawAxis() {
        gl.glColor3d(Color.cRed.getRed(), Color.cRed.getGreen(), Color.cRed.getBlue());
        gl.glBegin(GL.GL_LINES);
            gl.glVertex3d(0, 0, 0);
            gl.glVertex3d(this.getLenght(), 0, 0);
        gl.glEnd();
        
        gl.glColor3d(Color.cGreen.getRed(), Color.cGreen.getGreen(), Color.cGreen.getBlue());
        gl.glBegin(GL.GL_LINES);
            gl.glVertex3d(0, 0, 0);
            gl.glVertex3d(0, this.getLenght(), 0);
        gl.glEnd();

        gl.glColor3d(Color.cBlue.getRed(), Color.cBlue.getGreen(), Color.cBlue.getBlue());
        gl.glBegin(GL.GL_LINES);
            gl.glVertex3d(0, 0, 0);
            gl.glVertex3d(0, 0, this.getLenght());
        gl.glEnd();
    }

    public GL getGl() {
        return gl;
    }

    public void setGl(GL gl) {
        this.gl = gl;
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }
}
