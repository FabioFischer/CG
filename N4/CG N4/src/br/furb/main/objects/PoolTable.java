/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.main.objects;

import br.furb.main.controller.GraphicFace;
import br.furb.main.controller.GraphicPolygon;
import br.furb.main.utils.Color;
import java.util.ArrayList;
import javax.media.opengl.GL;

public class PoolTable extends GraphicPolygon{
    
    private ArrayList<GraphicFace> faces;
    
    private ArrayList<PoolTableLeg> poolTableLegs;
    private ArrayList<PoolTableMarginSegment> poolTableMarginSegments;
    
    public PoolTable(GL gl, Color color, ArrayList<GraphicFace> faces, boolean hasLight) {
        super(gl, color, hasLight, faces);
        
        this.setPoolTableLegs(new ArrayList<>());
        this.setPoolTableMarginSegments(new ArrayList<>());
    }
    
    public void drawTableObjects() {
        this.drawObject();
        
        for (PoolTableLeg tableLeg : this.getPoolTableLegs()) {
            tableLeg.drawObject();
        }
        for (PoolTableMarginSegment tableMarginSegment : this.getPoolTableMarginSegments()) {
            tableMarginSegment.drawObject();
        }
    }
    
    public void addPoolTableLeg(PoolTableLeg tableLeg) {
        if (!this.getPoolTableLegs().contains(tableLeg)) {
            this.getPoolTableLegs().add(tableLeg);
        }
    }
    
    public void addPoolTableMarginSegment(PoolTableMarginSegment tableLeg) {
        if (!this.getPoolTableMarginSegments().contains(tableLeg)) {
            this.getPoolTableMarginSegments().add(tableLeg);
        }
    }
    
    public ArrayList<GraphicFace> getFaces() {
        return this.faces;
    }

    public void setFaces(ArrayList<GraphicFace> faces) {
        this.faces = faces;
    }

    public ArrayList<PoolTableLeg> getPoolTableLegs() {
        return poolTableLegs;
    }

    public void setPoolTableLegs(ArrayList<PoolTableLeg> poolTableLegs) {
        this.poolTableLegs = poolTableLegs;
    }

    public ArrayList<PoolTableMarginSegment> getPoolTableMarginSegments() {
        return poolTableMarginSegments;
    }

    public void setPoolTableMarginSegments(ArrayList<PoolTableMarginSegment> poolTableMarginSegments) {
        this.poolTableMarginSegments = poolTableMarginSegments;
    }
}
