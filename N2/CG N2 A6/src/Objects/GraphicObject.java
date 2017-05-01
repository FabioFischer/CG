package Objects;

import Utils.Color;
import javax.media.opengl.GL;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 02 - Atividade 06
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public abstract class GraphicObject {
    private GL gl;
    private Color color;
    private float width;
    
    public GraphicObject (GL gl, Color color, float width){
        this.setGl(gl);
        this.setColor(color);
        this.setWidth(width);
    }

    public GL getGl() {
        return gl;
    }

    public void setGl(GL gl) {
        this.gl = gl;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }
    
    public abstract void drawObject();
}
