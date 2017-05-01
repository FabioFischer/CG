
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 02 - Atividade 02
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public class Main implements GLEventListener, KeyListener, MouseWheelListener {

    private GL gl;
    private GLU glu;
    private GLAutoDrawable glDrawable;
    private CircleVertex circleVertex;
    private Camera camera;
    
    private float defaultStepvalue = 15.0f;
    
    public void init(GLAutoDrawable drawable) {
        System.out.println(" --- init ---");
        glDrawable = drawable;
        gl = drawable.getGL();
        
        camera = new Camera(gl, glDrawable, -400.0f, 400.0f, -400.0f, 400.0f);
        circleVertex = new CircleVertex(gl, 100.0f, 38, 0, 0);
        
        glDrawable.setGL(new DebugGL(gl));
        System.out.println("Espaco de desenho com tamanho: " + drawable.getWidth() + " x " + drawable.getHeight());
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    //exibicaoPrincipal
    public void display(GLAutoDrawable arg0) {
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
        camera.display();
        
        SRU();
        
        circleVertex.drawCircleVertex();

        gl.glFlush();
    }
    
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_C:
                // PAN para cima
                this.camera.panUp(defaultStepvalue);
                break;
            case KeyEvent.VK_E:
                // PAN para esquerda
                this.camera.panLeft(defaultStepvalue);
                break;
            case KeyEvent.VK_D:
                // PAN para direita
                this.camera.panRight(defaultStepvalue);
                break;
            case KeyEvent.VK_B:
                // PAN para baixo
                this.camera.panDown(defaultStepvalue);
                break;
            case KeyEvent.VK_I:
                // Zoon In
                this.camera.zoonIn(defaultStepvalue);
                break;
            case KeyEvent.VK_O:
                // Zoon Out
                this.camera.zoonOut(defaultStepvalue);
                break;
        }
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        System.out.println(" --- reshape ---");
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glViewport(0, 0, width, height);
    }

    public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
        //System.out.println(" --- displayChanged ---");
    }

    public void keyReleased(KeyEvent arg0) {
        //System.out.println(" --- keyReleased ---");
    }

    public void keyTyped(KeyEvent arg0) {
        //System.out.println(" --- keyTyped ---");
    }

    public void SRU() {
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
    
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        // Valores -1 e 1
        switch (e.getWheelRotation()){
            case -1:
                // Zoon In
                this.camera.zoonIn(defaultStepvalue);
                break;
            case 1:
                // Zoon Out
                this.camera.zoonOut(defaultStepvalue);
                break;
        }
    }

}
