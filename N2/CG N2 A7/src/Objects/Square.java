
package Objects;

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

public class Square extends GraphicObject{    
    private Ponto4D center;
    private float lenght;
    
    public static final Color MAIN_COLOR = new Color(1.0f, 0.0f, 1.0f);
    public static final Color OUT_OF_BOUNDS_COLOR = new Color(1.0f, 1.0f, 0.0f);
    public static final Color THRESHOLD_COLOR = new Color(0.0f, 1.0f, 1.0f);
    
    public Square(GL gl, float lineWidth, Ponto4D center, float lenght) {
        super(gl, lineWidth);
        this.setCenter(center);
        this.setLenght(lenght);
        this.setColor(MAIN_COLOR);
        this.createSquarePoints(45.0f);
    }

    public Ponto4D getCenter() {
        return center;
    }

    public void setCenter(Ponto4D center) {
        this.center = center;
    }

    public float getLenght() {
        return lenght;
    }

    public void setLenght(float lenght) {
        this.lenght = lenght;
    }
    
    public Ponto4D getHypPoint(float angle) {
        return new Ponto4D(
                    this.getCenter().obterX() + (this.getLenght() * (float)Math.cos(Math.PI * angle / 180.0)),
                    this.getCenter().obterY() + (this.getLenght() * (float)Math.sin(Math.PI * angle / 180.0))
                    , 0.0f, 1.0f);
    }
    
    public void createSquarePoints (float angle) {
        if (angle < 360.0f) {
            this.addObjectPoint(this.getHypPoint(angle));
            this.createSquarePoints(angle + 90.0f);
        }
    }

    @Override
    public void drawObject() {        
        this.getGl().glColor3f(this.getColor().getR(), this.getColor().getG(), this.getColor().getB());
        this.getGl().glLineWidth(this.getWidth());        
        this.drawObjectPoints(GL.GL_LINE_LOOP);
    }
    
}
