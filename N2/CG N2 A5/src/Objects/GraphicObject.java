package Objects;

import Utils.Color;
import Utils.Ponto4D;
import javax.media.opengl.GL;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 02 - Atividade 05
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public class GraphicObject {
    private GL gl;
    private Ponto4D p1, p2, p3, p4;    
    private int objTypeSwitch = 0;
    
    private int[] objTypes = new int[]{GL.GL_POINTS, GL.GL_LINES, GL.GL_LINE_LOOP, GL.GL_LINE_STRIP, 
                        GL.GL_TRIANGLES, GL.GL_TRIANGLE_FAN, GL.GL_TRIANGLE_STRIP, GL.GL_QUADS, 
                        GL.GL_QUAD_STRIP, GL.GL_POLYGON};
        
    public GraphicObject (GL gl, Ponto4D p1, Ponto4D p2, Ponto4D p3, Ponto4D p4){
        this.gl = gl;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }
    
    public void changeObjectType() { 
        this.objTypeSwitch = (this.objTypeSwitch + 1) % objTypes.length;
    }
    
    public void drawObject() {
        // Cor e tamanho da linha
        this.gl.glLineWidth(5.0f);
        this.gl.glPointSize(5.0f);

        this.gl.glBegin(this.objTypes[this.objTypeSwitch]);
            this.createVertex(new Color(1.0f, 0.0f, 0.0f), this.p1.obterX(), this.p1.obterY());
            this.createVertex(new Color(0.0f, 1.0f, 0.0f), this.p2.obterX(), this.p2.obterY());
            this.createVertex(new Color(0.0f, 0.0f, 1.0f), this.p3.obterX(), this.p3.obterY());
            this.createVertex(new Color(1.0f, 0.0f, 1.0f), this.p4.obterX(), this.p4.obterY());
        this.gl.glEnd();
    }
    
    private void createVertex(Color color, float x, float y) {
        this.gl.glColor3f(color.getR(), color.getG(), color.getB());
        this.gl.glVertex2f(x, y);
    }
}
