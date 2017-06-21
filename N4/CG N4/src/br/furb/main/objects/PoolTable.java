/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.main.objects;

import br.furb.main.controller.GraphicPolygon;
import br.furb.main.utils.Color;
import br.furb.main.utils.Point;
import java.util.ArrayList;
import javax.media.opengl.GL;

public class PoolTable extends GraphicPolygon{
    
    private ArrayList<Point> points;
    
    public PoolTable(GL gl, Color color, float width, ArrayList<Point> points) {
        super(gl, color, width);
        
    }
    
    public ArrayList<Point> getPoints() {
        return this.points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
}
