package br.furb.main.objects;

import br.furb.main.controller.GraphicSphere;
import br.furb.main.utils.Color;
import br.furb.main.utils.Point;
import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;

public class PoolBall extends GraphicSphere{
    
    private int id;
    private double speed;
    private double angle;
    
    public PoolBall(GL gl, GLUT glut, Color color, Point centerPoint, double size, boolean light) {
        super(gl, glut, color, centerPoint, size, light);
    }
}
