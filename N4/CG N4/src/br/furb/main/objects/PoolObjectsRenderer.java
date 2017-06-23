/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.main.objects;

import br.furb.main.objects.*;
import br.furb.main.utils.Color;
import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;

public class PoolObjectsRenderer {
    
    private GL gl;
    private GLUT glut;
    
    private PoolBall[] poolBalls;
    private PoolTable poolTable;
    private PoolCueStick poolCueStick;
    
    private PoolPositions poolPositions;
    
    private boolean hasLight;
    
    public PoolObjectsRenderer(GL gl, GLUT glut, boolean hasLight) {
        this.setGl(gl);
        this.setGlut(glut);
        this.setLight(hasLight);
        
        this.poolPositions = new PoolPositions(gl, glut);
        this.createObjects();
    }

    public void createObjects() {
        this.setPoolTable(new PoolTable(gl, Color.cBlue, poolPositions.createPoolTableTopFaces(), this.HasLight()));
//        this.setPoolBalls(new PoolBall[]{});
//        this.setPoolCueStick(new PoolCueStick(gl, Color.cBlue, 0, centerPoint, 0, hasLight));
    }
    
    public void drawObjects() {
        this.poolTable.drawObject();
    }

    public GL getGl() {
        return gl;
    }

    public void setGl(GL gl) {
        this.gl = gl;
    }

    public GLUT getGlut() {
        return glut;
    }

    public void setGlut(GLUT glut) {
        this.glut = glut;
    }

    public boolean HasLight() {
        return hasLight;
    }

    public void setLight(boolean hasLight) {
        this.hasLight = hasLight;
    }
    
    public PoolBall[] getPoolBalls() {
        return poolBalls;
    }

    public void setPoolBalls(PoolBall[] poolBalls) {
        this.poolBalls = poolBalls;
    }

    public PoolTable getPoolTable() {
        return poolTable;
    }

    public void setPoolTable(PoolTable poolTable) {
        this.poolTable = poolTable;
    }

    public PoolCueStick getPoolCueStick() {
        return poolCueStick;
    }

    public void setPoolCueStick(PoolCueStick poolCueStick) {
        this.poolCueStick = poolCueStick;
    }
}
