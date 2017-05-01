package Objects;

import Utils.Color;
import Utils.Ponto4D;
import java.util.ArrayList;
import javax.media.opengl.GL;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 02 - Atividade 06
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public class Spline extends GraphicObject {

    private Ponto4D[] controlPoints;
    private int linesQty;

    public Spline(GL gl, Color color, float width, ArrayList<Ponto4D> controlPoints, int linesQty) {
        super(gl, color, width);
        this.setLinesQty(linesQty);
        this.updateControlPoints(controlPoints);
    }

    public void updateControlPoints(ArrayList<Ponto4D> controlPoints) {
        if (this.getControlPoints() == null) {
            this.setControlPoints(new Ponto4D[controlPoints.size()]);
        }
        int index = 0;

        for (Ponto4D controlPoint : controlPoints) {
            this.getControlPoints()[index] = controlPoint;
            index++;
        }
    }

    public Ponto4D[] getControlPoints() {
        return this.controlPoints;
    }

    public void setControlPoints(Ponto4D[] controlPoints) {
        this.controlPoints = controlPoints;
    }

    public int getLinesQty() {
        return linesQty;
    }

    public void setLinesQty(int linesQty) {
        this.linesQty = linesQty;
    }

    private void drawSplineCasteljau() {
        // TODO
    }

    private void drawSplineBenzier() {
        // TODO
    }

    private Ponto4D parametricEquation(Ponto4D p1, Ponto4D p2, float t) {
        return new Ponto4D(
                (p1.obterX() + (p2.obterX() - p1.obterX()) * t), 
                (p1.obterY() + (p2.obterY() - p1.obterY()) * t), 0.0f, 1.0f);
    }

    private Ponto4D parametricPoint(PointGroup pSet, float t) {
        Ponto4D pr1 = this.parametricEquation(pSet.getP1(), pSet.getP2(), t);
        Ponto4D pr2 = this.parametricEquation(pr1, pSet.getP3(), t);
        return this.parametricEquation(pr1, pr2, t);
    }

    private void drawSplineParametricEquation() {
        ArrayList<PointGroup> pgs = new ArrayList<>();

        for (int i = 0; (i + 3) <= controlPoints.length; i++) {
            pgs.add(new PointGroup(
                    this.controlPoints[i], 
                    this.controlPoints[i + 1], 
                    this.controlPoints[i + 2]));
        }

        Ponto4D previousPnt = this.controlPoints[0];

        for (float t = 0; t <= 1; t = t + (1 / (float) this.getLinesQty())) {
            PointGroup previousGroup = null;

            for (PointGroup pg : pgs) {
                if (previousGroup != null) {
                    Ponto4D paramPoint = this.parametricEquation(
                            parametricPoint(previousGroup, t),
                            parametricPoint(pg, t), t);
                    
                    this.getGl().glVertex2f(previousPnt.obterX(), previousPnt.obterY());
                    this.getGl().glVertex2f(paramPoint.obterX(), paramPoint.obterY());

                    previousPnt = paramPoint;
                }

                previousGroup = pg;
            }
        }
    }

    @Override
    public void drawObject() {
        if (this.controlPoints.length > 0) {
            this.getGl().glLineWidth(this.getWidth());
            this.getGl().glColor3f(this.getColor().getR(), this.getColor().getG(), this.getColor().getB());
            this.getGl().glBegin(GL.GL_LINES);
//            this.drawSplineCasteljau();
                this.drawSplineParametricEquation();
//            this.drawSplineBenzier();
            this.getGl().glEnd();
        }
    }

    private class PointGroup {

        private Ponto4D p1, p2, p3;

        public PointGroup(Ponto4D p1, Ponto4D p2, Ponto4D p3) {
            this.setP1(p1);
            this.setP2(p2);
            this.setP3(p3);
        }

        public Ponto4D getP1() {
            return p1;
        }

        public void setP1(Ponto4D p1) {
            this.p1 = p1;
        }

        public Ponto4D getP2() {
            return p2;
        }

        public void setP2(Ponto4D p2) {
            this.p2 = p2;
        }

        public Ponto4D getP3() {
            return p3;
        }

        public void setP3(Ponto4D p3) {
            this.p3 = p3;
        }
    }
}
