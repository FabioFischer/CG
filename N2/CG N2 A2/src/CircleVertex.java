
import javax.media.opengl.GL;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 02 - Atividade 02
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public class CircleVertex {
    private GL gl;
    private float radius, angleStepValue;
    private int points;
    
    private float x, y;
    
    public CircleVertex(GL gl, float radius, int points, float x, float y) {
        this.gl = gl;
        this.radius = radius;
        this.points = points > 1 ? points : 1;
        this.x = x;
        this.y = y;
        
        // Quantidade de pontos igualmente espacados
        this.angleStepValue = (float)((2*Math.PI) / this.points);
    }
    
    // Cria um circulo utilizando multiplos pontos
    public void drawCircleVertex(){
        // Cor e tamanho do ponto
        this.gl.glColor3f(0.0f, 0.0f, 0.0f);
        this.gl.glPointSize(3.0f);
                
        this.gl.glBegin(GL.GL_POINTS);
            // Angulo inicial será o espaçamento entre pontos do circulo
            this.drawCircleVertex(this.angleStepValue); 
        this.gl.glEnd();
    }

    private void drawCircleVertex(float angle) {
        // PI = 180 graus; 2PI = 360 graus
        if (angle < 2 * Math.PI) {
            this.gl.glVertex2d(this.radius * Math.cos(angle), this.radius * Math.sin(angle));
            this.drawCircleVertex((angle + this.angleStepValue));
        }
    }
    
}
