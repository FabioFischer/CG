package UI;

import Objects.Circle;
import Objects.Square;
import Utils.Camera;
import Utils.Color;
import Utils.Ponto4D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 02 - Atividade 07
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class Main implements GLEventListener, KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

    private GL gl;
    private GLAutoDrawable glDrawable;
    private Camera camera;
    
    private Ponto4D initialMousePosition;
    private Circle mainCircle, innerCircle;

    public void init(GLAutoDrawable drawable) {
        System.out.println(" --- init ---");
        glDrawable = drawable;
        gl = drawable.getGL();

        this.camera = new Camera(gl, glDrawable, -400.0f, 400.0f, -400.0f, 400.0f);
        this.initialMousePosition = new Ponto4D(-1.0f, -1.0f, 0.0f, 1.0f);
        
        Color bColor = new Color(0.0f, 0.0f, 0.0f);
        
        mainCircle = new Circle(gl, bColor, 2, 150, new Ponto4D(200.0f, 200.0f, 0.0f, 0.0f), true, false);
        innerCircle = new Circle(gl, bColor, 2, 50, new Ponto4D(200.0f, 200.0f, 0.0f, 0.0f), false, true);
        
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
        this.mainCircle.drawObject();
        this.innerCircle.drawObject();
        
        gl.glFlush();
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_C:
                // PAN para cima
                this.camera.panUp(15.0f);
                break;
            case KeyEvent.VK_E:
                // PAN para esquerda
                this.camera.panLeft(15.0f);
                break;
            case KeyEvent.VK_D:
                // PAN para direita
                this.camera.panRight(15.0f);
                break;
            case KeyEvent.VK_B:
                // PAN para baixo
                this.camera.panDown(15.0f);
                break;
            case KeyEvent.VK_I:
                // Zoon In
                this.camera.zoonIn(15.0f);
                break;
            case KeyEvent.VK_O:
                // Zoon Out
                this.camera.zoonOut(15.0f);
                break;
        }
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glViewport(0, 0, width, height);
    }

    public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
    }

    public void keyReleased(KeyEvent arg0) {
    }

    public void keyTyped(KeyEvent arg0) {
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

    private void updateInitialMousePosition(float x, float y) {
        this.initialMousePosition.atribuirX(x);
        this.initialMousePosition.atribuirY(y);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.updateInitialMousePosition(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        // Valores -1 e 1
        switch (e.getWheelRotation()) {
            case -1:
                // Zoon In
                this.camera.zoonIn(15.0f);
                break;
            case 1:
                // Zoon Out
                this.camera.zoonOut(15.0f);
                break;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Ponto4D newCenterPoint = new Ponto4D(
                this.innerCircle.getCenterPoint().obterX() - (this.initialMousePosition.obterX() - e.getX()),
                this.innerCircle.getCenterPoint().obterY() + (this.initialMousePosition.obterY() - e.getY()), 0.0f, 0.0f);
        
        if(this.mainCircle.getbBox().pointIsInside(newCenterPoint)) {
            this.innerCircle.setCenterPoint(newCenterPoint);
            this.mainCircle.getInnerSquare().setColor(Square.MAIN_COLOR);
        } else {
            if(this.mainCircle.scanLine(newCenterPoint)) {
                this.innerCircle.setCenterPoint(newCenterPoint);
                this.mainCircle.getInnerSquare().setColor(Square.OUT_OF_BOUNDS_COLOR);
            } else {
                this.mainCircle.getInnerSquare().setColor(Square.THRESHOLD_COLOR);
            }     
        }
        this.glDrawable.display();
        this.updateInitialMousePosition(e.getX(), e.getY()); 
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
