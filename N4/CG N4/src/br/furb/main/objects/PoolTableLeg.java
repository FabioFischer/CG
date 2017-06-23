package br.furb.main.objects;

import br.furb.main.controller.GraphicFace;
import br.furb.main.controller.GraphicPolygon;
import br.furb.main.utils.Color;
import java.util.ArrayList;
import javax.media.opengl.GL;

public class PoolTableLeg extends GraphicPolygon {
    
    public PoolTableLeg(GL gl, Color color, boolean hasLight, ArrayList<GraphicFace> faces) {
        super(gl, color, hasLight, faces);
    }
    
}
