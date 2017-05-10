
package br.furb.main.frame;

import br.furb.main.controller.GraphicObject;
import br.furb.main.controller.GraphicWorld;
import br.furb.main.controller.Edge;
import br.furb.main.utils.Camera;
import br.furb.main.utils.Color;
import br.furb.main.utils.Point;
import br.furb.main.utils.SRU;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.swing.JOptionPane;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 03
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public class Renderer implements GLEventListener, KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

    private GL gl;
    private GLAutoDrawable glDrawable;
    private GraphicWorld world;
    private Camera camera;
    private SRU sru;
    
    private Point newPoint, selectedPoint;
    private GraphicObject newObj, selectedObj;
    private Edge newEdge;

    private static final int STAND_BY_MODE = 1;
    private static final int NEW_OBJECT_MODE = 2;
    private static final int SEL_OBJECT_MODE = 3;
    private static final int NEW_DEPENDENT_MODE = 4;
    private static final int UPD_OBJECT_MODE = 5;
    private static final int UPD_POINT_MODE = 6;

    private int appMode = this.STAND_BY_MODE;
    
    private Point mousePosition = new Point(-1.0, -1.0, 0.0, 1.0);

    @Override
    public void init(GLAutoDrawable glad) {
        this.setGlDrawable(glad);
        this.setGl(glad.getGL());

        this.setWorld(new GraphicWorld());
        
        this.setCamera(new Camera(this.getGl(), this.getGlDrawable(),
                -this.getGlDrawable().getHeight(), this.getGlDrawable().getHeight(),
                -this.getGlDrawable().getWidth(), this.getGlDrawable().getWidth()));
        
        this.setSru(new SRU(gl, glDrawable));

        this.getGlDrawable().setGL(new DebugGL(this.getGl()));
        this.getGl().glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        
        this.showAppInstructions();
    }

    @Override
    public void display(GLAutoDrawable glad) {
        this.getGl().glClear(GL.GL_COLOR_BUFFER_BIT);

        this.getGl().glMatrixMode(GL.GL_MODELVIEW);
        this.getGl().glLoadIdentity();
        this.getCamera().display();

        this.getSru().drawSRU();
        this.getWorld().drawObjects();
        
        if (this.getNewObj() != null) {
            this.getNewObj().drawObject();
        }
                        
        if (this.getSelectedPoint() != null) {
            if (this.getNewObj() != null) {
                this.getNewObj().drawPoint(this.getSelectedPoint());
            } else if (this.getSelectedObj() != null) {
                this.getSelectedObj().drawPoint(this.getSelectedPoint());
            }
        }
        
        if (this.getNewEdge() != null) {
            this.getNewEdge().drawEdge();
        }
        
        this.getGl().glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        this.getGl().glMatrixMode(GL.GL_PROJECTION);
        this.getGl().glLoadIdentity();
        this.getGl().glViewport(0, 0, i2, i3);
    }

    @Override
    public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.updateGraphicWorld();
        
        switch (e.getKeyCode()) {
            case KeyEvent.VK_1:
                this.setAppMode(Renderer.STAND_BY_MODE);
                break;
            case KeyEvent.VK_2:
                this.setAppMode(Renderer.NEW_OBJECT_MODE);
                this.clearGraphicWorld();
                break;
            case KeyEvent.VK_3:
                this.setAppMode(Renderer.SEL_OBJECT_MODE);
                break;
            case KeyEvent.VK_4:
                if (this.getAppMode() == UPD_OBJECT_MODE) {
                    this.setAppMode(Renderer.NEW_DEPENDENT_MODE);
                }
                break;
            case KeyEvent.VK_U:
                switch (this.getAppMode()) {
                    case UPD_OBJECT_MODE:
                        this.getSelectedObj().setDefaultColor(Color.getRandomColor());
                        this.getSelectedObj().setCurrentColor(this.getSelectedObj().getDefaultColor());
                        break;
                }
                break;
            case KeyEvent.VK_E:
                switch (this.getAppMode()) {
                    case UPD_OBJECT_MODE:
                        this.getSelectedObj().translate(-5, 0, 0);
                        break;
                    case UPD_POINT_MODE:
                        this.getSelectedPoint().translate(-5, 0, 0);
                        break;
                }
                break;
            case KeyEvent.VK_D:
                switch (this.getAppMode()) {
                    case UPD_OBJECT_MODE:
                        this.getSelectedObj().translate(5, 0, 0);
                        break;
                    case UPD_POINT_MODE:
                        this.getSelectedPoint().translate(5, 0, 0);
                        break;
                }
                break;
            case KeyEvent.VK_C:
                switch (this.getAppMode()) {
                    case UPD_OBJECT_MODE:
                        this.getSelectedObj().translate(0, 5, 0);
                        break;
                    case UPD_POINT_MODE:
                        this.getSelectedPoint().translate(0, 5, 0);
                        break;
                }
                break;
            case KeyEvent.VK_B:
                switch (this.getAppMode()) {
                    case UPD_OBJECT_MODE:
                        this.getSelectedObj().translate(0, -5, 0);
                        break;
                    case UPD_POINT_MODE:
                        this.getSelectedPoint().translate(0, -5, 0);
                        break;
                }
                break;
            case KeyEvent.VK_EQUALS:
                switch (this.getAppMode()) {
                    case UPD_OBJECT_MODE:
                        this.getSelectedObj().scale(1.1);
                        break;
                }
                break;
            case KeyEvent.VK_MINUS:
                switch (this.getAppMode()) {
                    case UPD_OBJECT_MODE:
                        this.getSelectedObj().scale(0.9);
                        break;
                }
                break;
            case KeyEvent.VK_R:
                switch (this.getAppMode()) {
                    case UPD_OBJECT_MODE:
                        this.getSelectedObj().rotate(10);
                        break;
                }
                break;
            case KeyEvent.VK_T:
                switch (this.getAppMode()) {
                    case UPD_OBJECT_MODE:
                        this.getSelectedObj().rotate(-10);
                        break;
                }
                break;
            case KeyEvent.VK_DELETE:
                switch (this.getAppMode()) {
                    case UPD_OBJECT_MODE:
                        if (this.createWarningDialog("Tem certeza que deseja excluir o objeto selecionado?", new String[]{"Não", "Sim"}) != 0) {
                            this.setAppMode(SEL_OBJECT_MODE);
                            this.getWorld().deleteObject(this.getSelectedObj());                    
                            this.updateGraphicWorld();
                        }
                        break;
                    case UPD_POINT_MODE:
                        if (this.createWarningDialog("Tem certeza que deseja excluir o ponto selecionado?", new String[]{"Não", "Sim"}) != 0) {
                            this.setAppMode(SEL_OBJECT_MODE);
                            this.getSelectedObj().deletePoint(this.getSelectedPoint());             
                            this.updateGraphicWorld();
                        }
                        break;
                }
        }
        
        this.updateGraphicWorld();
        this.glDrawable.display(); 
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.getAppMode() != STAND_BY_MODE) { 
            switch (this.getAppMode()) {
                case NEW_OBJECT_MODE:
                case NEW_DEPENDENT_MODE:
                    this.updateMousePosition(e.getX(), e.getY());
                    
                    this.setNewObj((this.getNewObj() == null) 
                            ? new GraphicObject(this.getGl(), GraphicObject.NEW_OBJ_MODE_COLOR, 3)
                            : this.getNewObj());

                    if (this.getSelectedPoint() != null) {
                        this.getNewObj().addPoint(this.getSelectedPoint());
                        this.setNewPoint(this.getSelectedPoint());
                        
                    } else {                        
                        if(this.getCamera().getBondBox().isInside(this.getMousePosition())) {
                            Point newP = new Point(this.getMousePosition().getX(), this.getMousePosition().getY(), 0, 1);
                            
                            this.getNewObj().addPoint(newP);
                            this.setNewPoint(newP);
                        }
                    }
                    break;
                case SEL_OBJECT_MODE:
                    if (this.getSelectedObj() != null) {
                        this.setAppMode(Renderer.UPD_OBJECT_MODE);
                    }
                    break;
                case UPD_OBJECT_MODE:
                    if (this.getSelectedPoint() != null) {
                        this.setAppMode(Renderer.UPD_POINT_MODE);
                    }
                    break;
            }
            
            this.getGlDrawable().display();            
        }
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
        if (this.getAppMode() != STAND_BY_MODE) {
            this.updateMousePosition(e.getX(), e.getY());
            
            switch (this.getAppMode()) {
                case NEW_OBJECT_MODE:
                case NEW_DEPENDENT_MODE:
                    if (this.getNewObj() != null) {
                        if (this.getNewObj().getObjectPoints().size() > 1) {
                            this.setSelectedPoint(this.getNewObj().findNearPoint(this.getMousePosition(), 10));
                        }
                        
                        if (this.getNewPoint() != null) {
                            if (this.getNewEdge() != null) { 
                                this.getNewEdge().setP1(this.getNewPoint());
                                this.getNewEdge().setP2(this.getMousePosition());
                            } else {
                                this.setNewEdge(new Edge(this.getGl(), this.getNewObj().getCurrentColor(), this.getNewObj().getWidth(), this.getNewPoint(), this.getMousePosition()));
                            }
                        }
                    }
                    break;
                case SEL_OBJECT_MODE:              
                    this.setSelectedObj(this.getWorld().getObjectByPosition(this.getMousePosition()));

                    if(this.getSelectedObj() != null) {
                        this.getSelectedObj().setCurrentColor(GraphicObject.SEL_OBJ_MODE_COLOR);
                    } else {
                        this.getWorld().updateObjectsColor(GraphicObject.STAND_BY_MODE_COLOR);
                    }

                    break;
                case UPD_OBJECT_MODE:
                    this.setSelectedPoint(this.getSelectedObj().findNearPoint(this.getMousePosition(), 10));
                    break;
            }
            
            this.getGlDrawable().display();
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        switch (e.getWheelRotation()) {
            case -1:
                this.camera.zoonIn(15.0f);
                break;
            case 1:
                this.camera.zoonOut(15.0f);
                break;
        }
    }
    
    public void updateMousePosition(double x, double y) {
        this.getMousePosition().setX((x - (this.getGlDrawable().getHeight() / 2)) * 2);
        this.getMousePosition().setY(-(y - (this.getGlDrawable().getWidth() / 2)) * 2);
    }
    
    public void updateGraphicWorld() {
        switch (this.getAppMode()) {
            case NEW_OBJECT_MODE:
                if (this.getWorld() != null) {
                    this.getWorld().addObject(this.getNewObj());
                }
                break;
            case UPD_OBJECT_MODE:
                this.setSelectedPoint(null);
                this.setNewObj(null);
                this.setNewEdge(null);
                this.setNewPoint(null);
                break;
            case UPD_POINT_MODE:
                this.setNewObj(null);
                this.setNewEdge(null);
                this.setNewPoint(null);
                break;            
            case NEW_DEPENDENT_MODE:
                if (this.getSelectedObj() != null) {
                    this.getSelectedObj().addDependent(this.getNewObj());
                }
                break;                
            default:
                this.clearGraphicWorld();
                break;
        }
    }
    
    public void clearGraphicWorld() {
        this.getWorld().updateObjectsColorToDefault();
        this.setNewObj(null);
        this.setSelectedObj(null);
        this.setSelectedPoint(null);
        this.setNewEdge(null);
        this.setNewPoint(null);
    }
    
    public int createWarningDialog(String message, String[] options) {
        return JOptionPane.showOptionDialog(null,message, "Atenção!", 0, JOptionPane.WARNING_MESSAGE, null, options, null);
    }
    
    public void showAppInstructions() {
        System.out.println(
                  "\n###############################################################################################################"  
                + "\n\n       CG-N3 - Editor Vetorial" 
                + "\n\n###############################################################################################################"
                + "\n###############################################################################################################"
                + "\n\n  Modos de Interação: "
                + "\n      Visualização:         Tecla '1'"
                + "\n      Adicionar Objeto:     Tecla '2'"
                + "\n      Selecionar Objeto:    Tecla '3'"
                + "\n\n###############################################################################################################"
                + "\n\n  Modo Adicionar Objeto: "
                + "\n      Clique na tela para que o ponto da posição do mouse faça parte do novo objeto."
                + "\n      Para finalizar o objeto, basta selecionar outro modo de interação"
                + "\n\n###############################################################################################################"
                + "\n\n  Modo Selecionar Objeto: "
                + "\n     Selecione o objeto desejado posicionando o mouse sobre o mesmo."
                + "\n     Assim que a cor do objeto passar a ser VERDE, basta clicar com o botão esquerdo do mouse para editar objeto."
                + "\n\n   Opções:  "
                + "\n        - Deletar Objeto: tecla 'Delete'"
                + "\n        - Translação: tecla 'C' (cima), tecla 'B' (baixo), tecla 'E' (esquerda), tecla 'D' (direita) "
                + "\n        - Escala: tecla '-' (Diminuir), tecla '=' (aumentar)"
                + "\n        - Rotação: tecla 'R' (anti-horário), 'T' (horário)"
                + "\n        - Alterar Cor: tecla 'U'"
                + "\n        - Editar vértice: posicione o mouse sobre o vértice desejado e clique com o botão esquerdo do mouse."
                + "\n              Utiliza as mesma teclas para translação e deleção"
                + "\n\n###############################################################################################################"
        );
    }
    
    public GL getGl() {
        return gl;
    }

    public void setGl(GL gl) {
        this.gl = gl;
    }

    public GLAutoDrawable getGlDrawable() {
        return glDrawable;
    }

    public void setGlDrawable(GLAutoDrawable glDrawable) {
        this.glDrawable = glDrawable;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public GraphicWorld getWorld() {
        return world;
    }

    public void setWorld(GraphicWorld world) {
        this.world = world;
    }

    public Point getMousePosition() {
        return mousePosition;
    }

    public void setMousePosition(Point mousePosition) {
        this.mousePosition = mousePosition;
    }

    public int getAppMode() {
        return appMode;
    }

    public void setAppMode(int appMode) {
        this.appMode = appMode;
    }

    public Point getSelectedPoint() {
        return selectedPoint;
    }

    public void setSelectedPoint(Point selectedPoint) {
        this.selectedPoint = selectedPoint;
    }

    public GraphicObject getNewObj() {
        return newObj;
    }

    public void setNewObj(GraphicObject newObj) {
        this.newObj = newObj;
    }

    public GraphicObject getSelectedObj() {
        return selectedObj;
    }

    public void setSelectedObj(GraphicObject selectedObj) {
        this.selectedObj = selectedObj;
    }

    public SRU getSru() {
        return sru;
    }

    public void setSru(SRU sru) {
        this.sru = sru;
    }

    public Point getNewPoint() {
        return newPoint;
    }

    public void setNewPoint(Point newPoint) {
        this.newPoint = newPoint;
    }

    public Edge getNewEdge() {
        return newEdge;
    }

    public void setNewEdge(Edge newEdge) {
        this.newEdge = newEdge;
    }
}
