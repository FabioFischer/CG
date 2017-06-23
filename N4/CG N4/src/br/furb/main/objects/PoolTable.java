/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.main.objects;

import br.furb.main.controller.GraphicFace;
import br.furb.main.controller.GraphicPolygon;
import br.furb.main.utils.Color;
import br.furb.main.utils.Point;
import java.util.ArrayList;
import javax.media.opengl.GL;

public class PoolTable extends GraphicPolygon{
    
    private ArrayList<GraphicFace> faces;
    
    private PoolTableLeg[] poolTableLegs;
    private PoolTableMarginSegment[] poolTableMarginSegments;
    
    public PoolTable(GL gl, Color color, ArrayList<GraphicFace> faces, boolean hasLight) {
        super(gl, color, hasLight, faces);
    }
    
    public ArrayList<GraphicFace> getFaces() {
        return this.faces;
    }

    public void setFaces(ArrayList<GraphicFace> faces) {
        this.faces = faces;
    }

    public PoolTableLeg[] getPoolTableLegs() {
        return poolTableLegs;
    }

    public void setPoolTableLegs(PoolTableLeg[] poolTableLegs) {
        this.poolTableLegs = poolTableLegs;
    }

    public PoolTableMarginSegment[] getPoolTableMarginSegments() {
        return poolTableMarginSegments;
    }

    public void setPoolTableMarginSegments(PoolTableMarginSegment[] poolTableMarginSegments) {
        this.poolTableMarginSegments = poolTableMarginSegments;
    }
}
