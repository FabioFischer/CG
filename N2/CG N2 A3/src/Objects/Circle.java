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

public class Circle extends GraphicObject {
    private float radius;
    private int linesUsed;
    private Ponto4D origin;

    public Circle(GL gl, float radius, int linesUsed, Ponto4D origin) {
        super(gl);
        this.radius = radius;
        this.linesUsed = linesUsed > 2 ? linesUsed : 3;
        this.origin = origin;
    }

    // Cria um circulo utilizando multiplas linhas
    @Override
    public void drawObject() {
        // Cor e tamanho da linha
        this.getGl().glColor3f(0.0f, 0.0f, 0.0f);
        this.getGl().glLineWidth(2.0f);

        this.getGl().glBegin(GL.GL_LINE_LOOP);
            for (int i = 0; i <= this.linesUsed; i++) {
                this.getGl().glVertex2f(
                        (float) (this.origin.obterX() + (this.radius * Math.cos((2 * Math.PI) * i / this.linesUsed))),
                        (float) (this.origin.obterY() + (this.radius * Math.sin((2 * Math.PI) * i / this.linesUsed)))
                );
            }
        this.getGl().glEnd();
    }
}
