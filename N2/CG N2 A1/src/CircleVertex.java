
import javax.media.opengl.GL;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 02 - Atividade 01
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public class CircleVertex {

    private GL gl;
    private float radius, angleStepValue;
    private int circlePoints;

    public CircleVertex(GL gl, float radius, int circlePoints) {
        this.gl = gl;
        this.radius = radius;
        this.circlePoints = circlePoints > 1 ? circlePoints : 1;

        // Quantidade de pontos igualmente espacados
        this.angleStepValue = (float) ((2 * Math.PI) / this.circlePoints);
    }

    // Cria um circulo utilizando multiplos pontos
    public void drawCircleVertex() {
        // Cor e tamanho do ponto
        this.gl.glColor3f(0.0f, 0.0f, 1.0f);
        this.gl.glPointSize(3.0f);

        this.gl.glBegin(GL.GL_POINTS);
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
