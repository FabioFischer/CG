package UI;

import Objects.GraphicObject;
import Objects.Circle;
import Objects.Triangle;
import Utils.Ponto4D;
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
**   Unidade 02 - Atividade 03
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public class Main implements GLEventListener, KeyListener {

    private GL gl;
    private GLU glu;
    private GLAutoDrawable glDrawable;
    
    private GraphicObject circle1, circle2, circle3, triangle1;
    
    private float CIRCLE_RADIUS = 100.0f;
    
    public void init(GLAutoDrawable drawable) {
        System.out.println(" --- init ---");
        glDrawable = drawable;
        gl = drawable.getGL();
        
        Ponto4D p1 = new Ponto4D(100.0f, 100.0f, 0.0f, 1.0f);
        Ponto4D p2 = new Ponto4D(0.0f, -100.0f, 0.0f, 1.0f);
        Ponto4D p3 = new Ponto4D(-100.0f, 100.0f, 0.0f, 1.0f);
        
        glu = new GLU();
        triangle1 = new Triangle(gl, p1, p2, p3);
        circle1 = new Circle(gl, 100.0f, 360, p1);
        circle3 = new Circle(gl, 100.0f, 360, p2);
        circle2 = new Circle(gl, 100.0f, 360, p3);
        
        glDrawable.setGL(new DebugGL(gl));
        System.out.println("Espaco de desenho com tamanho: " + drawable.getWidth() + " x " + drawable.getHeight());
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    //exibicaoPrincipal
    public void display(GLAutoDrawable arg0) {
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-400.0f, 400.0f, -400.0f, 400.0f);

        SRU();
        
        triangle1.drawObject();
        circle1.drawObject();
        circle2.drawObject();
        circle3.drawObject();

        gl.glFlush();
    }

    public void keyPressed(KeyEvent e) {
        System.out.println(" --- keyPressed ---");
        switch (e.getKeyCode()) {
        }
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        System.out.println(" --- reshape ---");
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glViewport(0, 0, width, height);
    }

    public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
        System.out.println(" --- displayChanged ---");
    }

    public void keyReleased(KeyEvent arg0) {
        System.out.println(" --- keyReleased ---");
    }

    public void keyTyped(KeyEvent arg0) {
        System.out.println(" --- keyTyped ---");
    }

    public void SRU() {
//		gl.glDisable(gl.GL_TEXTURE_2D);
//		gl.glDisableClientState(gl.GL_TEXTURE_COORD_ARRAY);
//		gl.glDisable(gl.GL_LIGHTING); //TODO: [D] FixMe: check if lighting and texture is enabled

        // eixo x
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glLineWidth(1.0f);
        gl.glBegin(GL.GL_LINES);
            gl.glVertex2f(-200.0f, 0.0f);
            gl.glVertex2f(200.0f, 0.0f);
        gl.glEnd();
        // eixo y
        gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glBegin(GL.GL_LINES);
            gl.glVertex2f(0.0f, -200.0f);
            gl.glVertex2f(0.0f, 200.0f);
        gl.glEnd();
    }

}
