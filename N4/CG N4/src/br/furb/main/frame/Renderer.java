package br.furb.main.frame;

import br.furb.main.objects.PoolObjectsRenderer;
import br.furb.main.utils.Point;
import br.furb.main.utils.Axis;
import br.furb.main.utils.Camera;
import com.sun.opengl.util.GLUT;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 04
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */
public class Renderer implements GLEventListener, KeyListener, MouseListener, MouseMotionListener {

    private GL gl;
    private GLU glu;
    private GLUT glut;
    private GLAutoDrawable glDrawable;
    
    private Camera camera;
    
    private float cameraAngle = 0;
    
    private Axis axis;
        
    private boolean light = true;
    
    private float POOL_TABLE_SIZE_X = 8;
    private float POOL_TABLE_SIZE_Y = 10;
    private float POOL_TABLE_SIZE_Z = 14;
    
    private PoolObjectsRenderer poolObjects;
    private Point mousePos;
        
    public void init(GLAutoDrawable drawable) {
        this.setGlDrawable(drawable);
        this.setGl(drawable.getGL());
        this.setGlu(new GLU());
        this.setGlut(new GLUT());
        
        this.getGlDrawable().setGL(new DebugGL(gl));
        
        this.setCamera(new Camera(this.getGlu(), 20, 20, 23, POOL_TABLE_SIZE_X/2, POOL_TABLE_SIZE_Y/2, POOL_TABLE_SIZE_Z/2));



//        this.setCamera(new Camera(this.getGlu(), 20, 20, 23, 0, 0, 0));

        this.setAxis(new Axis(this.getGl(), 10));
        this.getGl().glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                
        this.setLight();
        this.setPoolObjects(new PoolObjectsRenderer(this.getGl(), this.getGlut(), this.isLight()));
        this.setMousePos(new Point(-1, -1, 0, 1));
        
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
        
        this.getCamera().display();
        
//        this.axis.drawAxis();        
        this.getPoolObjects().drawObjects();
        
        this.getGl().glFlush();
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                System.exit(1);
            break;
            case KeyEvent.VK_1:
                this.getCamera().setCameraEye(20, 20, 23);
            break;
            case KeyEvent.VK_2:
                this.getCamera().setCameraEye(20, 20, 0);
                break;
            case KeyEvent.VK_3:
                this.getCamera().setCameraEye(0, 20, 20);
                break;
            case KeyEvent.VK_4:
                this.getCamera().setCameraEye(20, 0, 20);
                break;
            case KeyEvent.VK_EQUALS:
                this.getCamera().rotateHorizonEye(cameraAngle);
                cameraAngle = cameraAngle + 1;
                System.out.println(cameraAngle);
                break;
            case KeyEvent.VK_L:
                this.light = !light;
                this.setLight();
                break;
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
    
    public void setLight() {        
        if (this.isLight()) {
            float posLight[] = { 0.0f, 20.0f, 20.0f, 0.0f };
            gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, posLight, 0);
            gl.glEnable(GL.GL_LIGHT0);
        } else {
            gl.glDisable(GL.GL_LIGHT0);
        }
        
        if (this.getPoolObjects() != null) {
            this.getPoolObjects().setLight(this.isLight());
        }
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Axis getAxis() {
        return axis;
    }

    public void setAxis(Axis axis) {
        this.axis = axis;
    }
    
    public PoolObjectsRenderer getPoolObjects() {
        return poolObjects;
    }

    public void setPoolObjects(PoolObjectsRenderer poolObjects) {
        this.poolObjects = poolObjects;
    }

    public Point getMousePos() {
        return mousePos;
    }

    public void setMousePos(Point mousePos) {
        this.mousePos = mousePos;
    }

    public boolean isLight() {
        return light;
    }

    public void setLight(boolean light) {
        this.light = light;
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
    
    public void updateMousePosition(double x, double y) {
        this.getMousePos().setX((x - (this.getGlDrawable().getHeight() / 2)) * 2);
        this.getMousePos().setY(-(y - (this.getGlDrawable().getWidth() / 2)) * 2);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.updateMousePosition(e.getPoint().getX(), e.getPoint().getY());
        System.out.println("P --- X = " + this.getMousePos().getX() + " | Y = " + this.getMousePos().getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
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
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
