
package Utils;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 02 - Atividade 05
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public class Color {

    float r, g, b;

    public Color(float r, float g, float b) {
        this.setR(r);
        this.setG(g);
        this.setB(b);
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        if (r < 0 || r > 1) {
            throw new IllegalArgumentException("R inválido");
        }
        this.r = r;
    }

    public float getG() {
        return g;
    }

    public void setG(float g) {
        if (r < 0 || r > 1) {
            throw new IllegalArgumentException("G inválido");
        }
        this.g = g;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        if (r < 0 || r > 1) {
            throw new IllegalArgumentException("B inválido");
        }
        this.b = b;
    }
}
