/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.main.objects;

import br.furb.main.controller.GraphicPolygon;
import br.furb.main.utils.Color;
import br.furb.main.utils.Point;
import javax.media.opengl.GL;

/**
 *
 * @author fabio.fischer
 */
public class PoolCueStick extends GraphicPolygon {
    
    private Point centerPoint;
    private double size;
    
    public PoolCueStick(GL gl, Color color, Point centerPoint, double size, boolean hasLight) {
        super(gl, color, hasLight);
        this.setCenterPoint(centerPoint);
        this.setSize(size);
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
