package br.furb.main.frame;

import br.furb.main.utils.Axis;
import com.sun.opengl.util.GLUT;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 03
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */
public class Renderer implements GLEventListener, KeyListener {

    private GL gl;
    private GLU glu;
    private GLUT glut;
    private GLAutoDrawable glDrawable;
    
    private Axis axis;
    
    public void init(GLAutoDrawable drawable) {
        this.setGlDrawable(drawable);
        this.setGl(drawable.getGL());
        this.setGlu(new GLU());
        this.setGlut(new GLUT());
        
        this.axis = new Axis(this.getGl(), 10);
        
        this.getGlDrawable().setGL(new DebugGL(gl));

        this.getGl().glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        float posLight[] = {5.0f, 5.0f, 10.0f, 0.0f};
        
        this.getGl().glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, posLight, 0);
        this.getGl().glEnable(GL.GL_LIGHT0);

        this.getGl().glEnable(GL.GL_CULL_FACE);
        this.getGl().glEnable(GL.GL_DEPTH_TEST);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        this.getGl().glMatrixMode(GL.GL_PROJECTION);
        this.getGl().glLoadIdentity();
        this.getGl().glViewport(0, 0, width, height);
        this.getGlu().gluPerspective(60, width / height, 0.1, 100);				// projecao Perpectiva 1 pto fuga 3D    
//		Debug();
    }

    public void display(GLAutoDrawable drawable) {
        this.getGl().glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

        this.getGl().glMatrixMode(GL.GL_MODELVIEW);
        this.getGl().glLoadIdentity();
        this.getGlu().gluLookAt(5, 5, 5, 0, 0, 0, 0, 1, 0);

        this.axis.drawAxis();
        
        this.getGl().glFlush();
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_R:
                // Reiniciar jogo
                break;
        }
        this.getGlDrawable().display();
    }

    public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
    }

    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }

    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }

    public void Debug() {
    }

    public GL getGl() {
        return gl;
    }

    public void setGl(GL gl) {
        this.gl = gl;
    }

    public GLU getGlu() {
        return glu;
    }

    public void setGlu(GLU glu) {
        this.glu = glu;
    }

    public GLUT getGlut() {
        return glut;
    }

    public void setGlut(GLUT glut) {
        this.glut = glut;
    }

    public GLAutoDrawable getGlDrawable() {
        return glDrawable;
    }

    public void setGlDrawable(GLAutoDrawable glDrawable) {
        this.glDrawable = glDrawable;
    }
}
