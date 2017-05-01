package UI;

import Objects.LineSegment;
import Objects.Spline;
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
import java.util.ArrayList;

import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 02 - Atividade 06
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public class Main implements GLEventListener, KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

    private GL gl;
    private GLAutoDrawable glDrawable;
    private Camera camera;

    private ArrayList<Ponto4D> controlPoints;
    private ArrayList<LineSegment> lines;

    private Ponto4D initialMousePosition, highightedPoint;
    private Spline spline;
    
    public void init(GLAutoDrawable drawable) {
        System.out.println(" --- init ---");
        glDrawable = drawable;
        gl = drawable.getGL();

        this.camera = new Camera(gl, glDrawable, -400.0f, 400.0f, -400.0f, 400.0f);
        this.initialMousePosition = new Ponto4D(-1.0f, -1.0f, 0.0f, 1.0f);
        
        this.controlPoints = new ArrayList<>();
        this.lines = new ArrayList<>();
        
        this.controlPoints.add(new Ponto4D(-100.0f, -100.0f, 0.0f, 1.0f));
        this.controlPoints.add(new Ponto4D(-100.0f, 100.0f, 0.0f, 1.0f));
        this.controlPoints.add(new Ponto4D(100.0f, 100.0f, 0.0f, 1.0f));
        this.controlPoints.add(new Ponto4D(100.0f, -100.0f, 0.0f, 1.0f));
        this.controlPoints.add(new Ponto4D(150.0f, -150.0f, 0.0f, 1.0f));
        
        this.populateLineSegments(new Color(0.0f, 1.0f, 1.0f), 2.0f);
        this.spline = new Spline(gl, new Color(1.0f, 1.0f, 0.0f), 3, controlPoints, 60);
                
        glDrawable.setGL(new DebugGL(gl));
        System.out.println("Espaco de desenho com tamanho: " + drawable.getWidth() + " x " + drawable.getHeight());
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public void populateLineSegments(Color lineColor, float lineWidth) {
        Ponto4D p = null;
        for (Ponto4D controlPoint : controlPoints) {
            if (p != null) {
                this.lines.add(new LineSegment(this.gl, lineColor, lineWidth, p, controlPoint));
            }
            p = controlPoint;
        }
    }
    
    public void drawLineSegments() {
        for (LineSegment line : lines) {
            line.drawObject();
        }
    }
    
    public void changeControlPoint (int pointIndx){    
        int indx = 1;
        for (Ponto4D controlPoint : controlPoints) {
            if(indx == pointIndx) {
                if (this.getHighlightedPoint() != null) {
                    this.getHighlightedPoint().setHighlighted(false);
                }                
                controlPoint.setHighlighted(true);
                this.setHighlightedPoint(controlPoint);
            }
            indx++;
        }
    }
    
    public void moveControlPoint (float x, float y) {
        if(this.getHighlightedPoint() != null) {
            this.getHighlightedPoint().panX(x);
            this.getHighlightedPoint().panY(y);
        }
        this.spline.updateControlPoints(controlPoints);
    }
    
    public void setHighlightedPoint(Ponto4D p) {
        this.highightedPoint = p;
    }
    
    public Ponto4D getHighlightedPoint() {
        return this.highightedPoint;
    }

    public int getSplineLinesFactor() {
        System.out.println(this.spline.getLinesQty());
        return this.spline.getLinesQty();
    }

    public void setSplineLinesFactor(int splineLinesFactor) {
        this.spline.setLinesQty(splineLinesFactor > 0 ? splineLinesFactor : this.spline.getLinesQty());
    }
    
    //exibicaoPrincipal
    public void display(GLAutoDrawable arg0) {
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
        camera.display();

        this.SRU();
        this.drawLineSegments();
        this.spline.drawObject();
        
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
            case KeyEvent.VK_1:
                // Alterar ponto de Controle
                this.changeControlPoint(1);
                this.glDrawable.display();
                break;
            case KeyEvent.VK_2:
                // Alterar ponto de Controle
                this.changeControlPoint(2);
                this.glDrawable.display();
                break;
            case KeyEvent.VK_3:
                // Alterar ponto de Controle
                this.changeControlPoint(3);
                this.glDrawable.display();
                break;
            case KeyEvent.VK_4:
                // Alterar ponto de Controle
                this.changeControlPoint(4);
                this.glDrawable.display();
                break;
            case KeyEvent.VK_EQUALS:
                // Aumentar quantidade de linhas na spline
                this.setSplineLinesFactor(this.getSplineLinesFactor() + 1);
                this.glDrawable.display();
                break;
            case KeyEvent.VK_MINUS:
                // Aumentar quantidade de linhas na spline
                this.setSplineLinesFactor(this.getSplineLinesFactor() - 1);
                this.glDrawable.display();
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
        this.moveControlPoint(this.initialMousePosition.obterX() - e.getX()
                            , this.initialMousePosition.obterY() - e.getY());
        this.glDrawable.display();
        this.updateInitialMousePosition(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
