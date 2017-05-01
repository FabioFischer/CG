package Objects;

import javax.media.opengl.GL;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 02 - Atividade 03
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public abstract class GraphicObject {
    private GL gl;
    
    public GraphicObject (GL gl){
        this.gl = gl;
    }
    
    public abstract void drawObject();

    public GL getGl() {
        return gl;
    }

    public void setGl(GL gl) {
        this.gl = gl;
    }
}
