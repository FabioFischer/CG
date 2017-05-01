package Graphics;

import Utils.Ponto4D;
import javax.media.opengl.GL;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 02 - Atividade 04
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public class LineSegment extends GraphicObject {

    private float angle, lenght;
    private Ponto4D position;
    private float lineWidth, pointSize;

    public LineSegment(GL gl, float angle, float lenght, Ponto4D position) {
        super(gl);
        this.position = position;
        this.setAngle(angle);
        this.setLenght(lenght);
        this.setLineWidth(2.0f);
        this.setPointSize(5.0f);
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle % 360;
    }

    public float getLenght() {
        return lenght;
    }

    public void setLenght(float lenght) {
        this.lenght = lenght;
    }

    public Ponto4D getPosition() {
        return position;
    }

    public float getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    public float getPointSize() {
        return pointSize;
    }

    public void setPointSize(float pointSize) {
        this.pointSize = pointSize;
    }
    
    public void increaseLineLenght(float value) {
        this.setLenght(this.getLenght() + value);
    }
    
    public void decreaseLineLenght(float value) {
        this.setLenght(this.getLenght() - value);
    }
    
    public void increaseLineAngle(float value) {
        this.setAngle(this.getAngle() + value);
    }
    
    public void decreaseLineAngle(float value) {
        this.setAngle(this.getAngle() - value);
    }
    
    public void panX(float value) {
        this.getPosition().atribuirX(this.getPosition().obterX() + value);
    }
    
    public void panY(float value) {
        this.getPosition().atribuirY(this.getPosition().obterY() - value);
    }
    
    @Override
    public void drawObject() {
        this.getGl().glColor3f(0.0f, 0.0f, 0.0f);
        this.getGl().glLineWidth(this.getLineWidth());
        this.drawObjectGeoStyle(GL.GL_LINES);

        this.getGl().glPointSize(this.getPointSize());
        this.drawObjectGeoStyle(GL.GL_POINTS);
    }

    private void drawObjectGeoStyle(int geoStyle) {
        this.getGl().glBegin(geoStyle);
            this.getGl().glVertex2f(this.position.obterX(), this.position.obterY());
            this.getGl().glVertex2f(
                    this.getPosition().obterX() + (this.getLenght() * (float)Math.cos(Math.PI * this.getAngle() / 180.0)),
                    this.getPosition().obterY() + (this.getLenght() * (float)Math.sin(Math.PI * this.getAngle() / 180.0))
                    );
        this.getGl().glEnd();
    }
}
