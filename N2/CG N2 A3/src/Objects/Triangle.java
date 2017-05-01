package Objects;

import Utils.Ponto4D;
import javax.media.opengl.GL;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 02 - Atividade 03
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public class Triangle extends GraphicObject{    
    Ponto4D p1, p2, p3;
    
    public Triangle(GL gl, Ponto4D p1, Ponto4D p2, Ponto4D p3) {
        super(gl);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    
    @Override
    public void drawObject() {
        // Cor e tamanho da linha
        this.getGl().glColor3f(0.0f, 1.0f, 1.0f);
        this.getGl().glLineWidth(2.0f);

        this.getGl().glBegin(GL.GL_LINE_LOOP);
            this.getGl().glVertex2f(this.p1.obterX(), this.p1.obterY());
            this.getGl().glVertex2f(this.p2.obterX(), this.p2.obterY());
            this.getGl().glVertex2f(this.p3.obterX(), this.p3.obterY());
        this.getGl().glEnd();
    }
}
