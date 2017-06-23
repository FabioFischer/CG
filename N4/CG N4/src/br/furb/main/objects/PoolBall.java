package br.furb.main.objects;

import br.furb.main.controller.GraphicSphere;
import br.furb.main.utils.Color;
import br.furb.main.utils.Point;
import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;

public class PoolBall extends GraphicSphere{
    
    public PoolBall(GL gl, GLUT glut, Color color, Point centerPoint, double size) {
        super(gl, glut, color, centerPoint, size);
    }
}
