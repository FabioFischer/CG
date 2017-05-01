package Objects;

import Utils.BBox;
import Utils.Color;
import Utils.Ponto4D;
import javax.media.opengl.GL;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 02 - Atividade 07
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */
public class Circle extends GraphicObject {

    private Ponto4D centerPoint;
    private float radius;
    private int linesUsed;
    private boolean showInnerSquare, showInnerPoint;

    private Square innerSquare;

    public Circle(GL gl, Color color, float lineWidth, float radius, Ponto4D origin, boolean showInnerSquare, boolean showInnerPoint) {
        super(gl, color, lineWidth);
        this.setRadius(radius);
        this.setLinesUsed((int) radius * 2);
        this.setCenterPoint(origin);
        this.setInnerPoint(showInnerPoint);
        this.setInnerSquare(showInnerSquare);

        this.createCirclePoints();
        this.setInnerSquare(new Square(this.getGl(), this.getWidth(), this.getCenterPoint(), this.getRadius()));
        this.setbBox(new BBox(this.getInnerSquare().getObjectPoints()));
    }

    public Circle(GL gl, Color color, float lineWidth, float radius, Ponto4D origin, boolean showInnerSquare, boolean showInnerPoint, BBox bBox) {
        super(gl, color, lineWidth);
        this.setRadius(radius);
        this.setLinesUsed((int) radius * 2);
        this.setCenterPoint(origin);
        this.setInnerPoint(showInnerPoint);
        this.setInnerSquare(showInnerSquare);

        this.createCirclePoints();
        this.setInnerSquare(new Square(this.getGl(), this.getWidth(), this.getCenterPoint(), this.getRadius()));
        this.setbBox(bBox);
    }

    public Ponto4D getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Ponto4D centerPoint) {
        this.centerPoint = centerPoint;
        this.createCirclePoints();
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public int getLinesUsed() {
        return linesUsed;
    }

    public void setLinesUsed(int linesUsed) {
        this.linesUsed = linesUsed;
    }

    public boolean showInnerSquare() {
        return showInnerSquare;
    }

    public void setInnerSquare(boolean showInnerSquare) {
        this.showInnerSquare = showInnerSquare;
    }

    public boolean showInnerPoint() {
        return showInnerPoint;
    }

    public void setInnerPoint(boolean showInnerPoint) {
        this.showInnerPoint = showInnerPoint;
    }

    public Square getInnerSquare() {
        return innerSquare;
    }

    private void setInnerSquare(Square innerSquare) {
        this.innerSquare = innerSquare;
    }

    private void createCirclePoints() {
        this.getObjectPoints().clear();
        for (int i = 0; i <= this.linesUsed; i++) {
            this.addObjectPoint(new Ponto4D(
                    (float) (this.centerPoint.obterX() + (this.radius * Math.cos((2 * Math.PI) * i / this.linesUsed))),
                    (float) (this.centerPoint.obterY() + (this.radius * Math.sin((2 * Math.PI) * i / this.linesUsed))), 0.0f, 1.0f));
        }
    }

    private void drawCircle() {
        this.getGl().glColor3f(this.getColor().getR(), this.getColor().getG(), this.getColor().getB());
        this.getGl().glLineWidth(this.getWidth());
        this.drawObjectPoints(GL.GL_LINE_LOOP);
    }

    private void drawInnerPoint() {
        if (this.showInnerPoint()) {
            this.getGl().glColor3f(this.getColor().getR(), this.getColor().getG(), this.getColor().getB());
            this.getGl().glPointSize(this.getWidth() * 3.5f);

            this.getGl().glBegin(GL.GL_POINTS);
                this.getGl().glVertex2f(this.getCenterPoint().obterX(), this.getCenterPoint().obterY());
            this.getGl().glEnd();
        }
    }

    private void drawInnerSquare() {
        if (this.showInnerSquare()) {
            this.getInnerSquare().drawObject();
        }
    }

    @Override
    public void drawObject() {
        this.drawInnerPoint();
        this.drawInnerSquare();
        this.drawCircle();
    }
}
