package Utils;


import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 02 - Atividade 06
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public class Camera {

    private GL gl;
    private GLAutoDrawable glDrawable;
    private GLU glu;

    private float ortho2D_minX, ortho2D_maxX, ortho2D_minY, ortho2D_maxY;

    public Camera(GL gl, GLAutoDrawable glDrawable, float ortho2D_minX, float ortho2D_maxX, float ortho2D_minY, float ortho2D_maxY) {
        this.gl = gl;
        this.glDrawable = glDrawable;
        this.glu = new GLU();

        this.ortho2D_minX = ortho2D_minX;
        this.ortho2D_maxX = ortho2D_maxX;
        this.ortho2D_minY = ortho2D_minY;
        this.ortho2D_maxY = ortho2D_maxY;
    }

    public void display() {
        glu.gluOrtho2D(ortho2D_minX, ortho2D_maxX, ortho2D_minY, ortho2D_maxY);
    }

    private void panX(float value) {
        this.ortho2D_minX += value;
        this.ortho2D_maxX += value;
        glDrawable.display();
    }

    private void panY(float value) {
        this.ortho2D_minY += value;
        this.ortho2D_maxY += value;
        glDrawable.display();
    }

    public void panUp(float value) {
        if (ortho2D_maxY >= (glDrawable.getHeight() / 2)) {
            this.panY(-value);
        }
    }

    public void panDown(float value) {
        if (ortho2D_minY <= -(glDrawable.getHeight() / 2)) {
            this.panY(value);
        }
    }

    public void panLeft(float value) {
        if (ortho2D_minX <= -(glDrawable.getWidth() / 2)) {
            this.panX(value);
        }
    }

    public void panRight(float value) {
        if (ortho2D_maxX >= (glDrawable.getWidth() / 2)) {
            this.panX(-value);
        }
    }

    public void zoonIn(float value) {
        if (this.ortho2D_minX <= -(glDrawable.getWidth() / 2)
                && this.ortho2D_maxX >= (glDrawable.getWidth() / 2)
                && this.ortho2D_minY <= -(glDrawable.getHeight() / 2)
                && this.ortho2D_maxY >= (glDrawable.getHeight() / 2)) {
            this.ortho2D_minX = this.ortho2D_minX + value;
            this.ortho2D_maxX = this.ortho2D_maxX - value;
            this.ortho2D_minY = this.ortho2D_minY + value;
            this.ortho2D_maxY = this.ortho2D_maxY - value;
            glDrawable.display();
        }
    }

    public void zoonOut(float value) {
        if (this.ortho2D_minX + value >= -(glDrawable.getWidth() * 2)) {
            this.ortho2D_minX = this.ortho2D_minX - value;
            this.ortho2D_maxX = this.ortho2D_maxX + value;
            this.ortho2D_minY = this.ortho2D_minY - value;
            this.ortho2D_maxY = this.ortho2D_maxY + value;
            glDrawable.display();
        }
    }
}
