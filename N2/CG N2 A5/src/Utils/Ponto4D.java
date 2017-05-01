package Utils;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 02 - Atividade 05
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public final class Ponto4D {

    private float x; /// valor X.
    private float y; /// valor Y.
    private float z; /// valor Z.
    private float w; /// valor W.

    /// Cria o ponto (0,0,0,1).
    public Ponto4D() {
        this(0, 0, 0, 1);
    }

    /// Cria o ponto (0,0,0,1).
    public Ponto4D(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Ponto4D inverterSinal(Ponto4D pto) {
        pto.atribuirX(pto.obterX() * -1);
        pto.atribuirY(pto.obterY() * -1);
        pto.atribuirZ(pto.obterZ() * -1);
        return pto;
    }

    /// Obter valor X do ponto.
    public float obterX() {
        return x;
    }

    /// Obter valor Y do ponto.
    public float obterY() {
        return y;
    }

    /// Obter valor Z do ponto.
    public float obterZ() {
        return z;
    }

    /// Obter valor W do ponto.
    public float obterW() {
        return w;
    }

    /// Atribuir valor X do ponto.
    public void atribuirX(float x) {
        this.x = x;
    }

    /// Atribuir valor Y do ponto.
    public void atribuirY(float y) {
        this.y = y;
    }

    /// Atribuir valor Z do ponto.
    public void atribuirZ(float z) {
        this.z = z;
    }

    /// Atribuir valor W do ponto.
//	public void AtribuirW(double w) {
//		this.w = w;
//	}
}
