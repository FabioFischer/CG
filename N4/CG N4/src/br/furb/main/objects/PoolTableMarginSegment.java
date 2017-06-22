/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.main.objects;

import br.furb.main.controller.GraphicPolygon;
import br.furb.main.utils.Color;
import javax.media.opengl.GL;

/**
 *
 * @author fabio.fischer
 */
public class PoolTableMarginSegment extends GraphicPolygon {
    
    public PoolTableMarginSegment(GL gl, Color color, float width) {
        super(gl, color, width);
    }
    
}
