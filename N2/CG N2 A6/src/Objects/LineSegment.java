package Objects;

import Utils.Color;
import Utils.Ponto4D;
import javax.media.opengl.GL;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 02 - Atividade 06
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public class LineSegment extends GraphicObject {

    private Ponto4D p1, p2;

    public LineSegment(GL gl, Color color, float width, Ponto4D p1, Ponto4D p2) {
        super(gl, color, width);
        this.setP1(p1);
        this.setP2(p2);
    }

    public Ponto4D getP1() {
        return p1;
    }

    public void setP1(Ponto4D p1) {
        this.p1 = p1;
    }

    public Ponto4D getP2() {
        return p2;
    }

    public void setP2(Ponto4D p2) {
        this.p2 = p2;
    }

    public boolean containsPonto(Ponto4D p) {
        return this.getP1() == p;
    }

    @Override
    public void drawObject() {
        this.getGl().glColor3f(this.getColor().getR(), this.getColor().getG(), this.getColor().getB());
        this.getGl().glLineWidth(this.getWidth());
        this.getGl().glBegin(GL.GL_LINES);
            this.getGl().glVertex2f(this.getP1().obterX(), this.getP1().obterY());
            this.getGl().glVertex2f(this.getP2().obterX(), this.getP2().obterY());
        this.getGl().glEnd();

        this.drawControlPoint(this.getP1());
        this.drawControlPoint(this.getP2());
    }

    private void drawControlPoint(Ponto4D p) {
        if (p.isHighlighted()) {
            this.getGl().glColor3f(1.0f, 0.0f, 0.0f);
            this.getGl().glPointSize(this.getWidth() * 3);
        } else {
            this.getGl().glColor3f(this.getColor().getR(), this.getColor().getG(), this.getColor().getB());
            this.getGl().glPointSize(this.getWidth());
        }

        this.getGl().glBegin(GL.GL_POINTS);
            this.getGl().glVertex2f(p.obterX(), p.obterY());
        this.getGl().glEnd();
    }
}
