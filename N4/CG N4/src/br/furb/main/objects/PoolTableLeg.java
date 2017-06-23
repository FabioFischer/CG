package br.furb.main.objects;

import br.furb.main.controller.GraphicPolygon;
import br.furb.main.utils.Color;
import javax.media.opengl.GL;

public class PoolTableLeg extends GraphicPolygon {
    
    public PoolTableLeg(GL gl, Color color, boolean hasLight) {
        super(gl, color, hasLight);
    }
    
}
