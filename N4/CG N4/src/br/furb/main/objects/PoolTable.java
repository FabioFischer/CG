/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.main.objects;

import br.furb.main.controller.GraphicObject;
import br.furb.main.utils.Color;
import javax.media.opengl.GL;

public class PoolTable extends GraphicObject{
    
    public PoolTable(GL gl, Color color, float width) {
        super(gl, color, width);
    }
    
}
