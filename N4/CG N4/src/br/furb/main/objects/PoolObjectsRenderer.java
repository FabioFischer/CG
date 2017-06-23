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
    
    private boolean light;
    
    public PoolObjectsRenderer(GL gl, GLUT glut, boolean light) {
        this.setGl(gl);
        this.setGlut(glut);
        this.setLight(light);
        
        this.poolPositions = new PoolPositions(gl, glut);
        this.createObjects();
    }

    public void createObjects() {
        this.createPoolTable();
//        this.setPoolBalls(new PoolBall[]{});
//        this.setPoolCueStick(new PoolCueStick(gl, Color.cBlue, 0, centerPoint, 0, hasLight));
    }
    
    public void createPoolTable() {
        this.setPoolTable(new PoolTable(this.getGl(), Color.cGreen, poolPositions.createPoolTableTopFaces(), this.HasLight()));
        
        PoolTableLeg leg1 = new PoolTableLeg(this.getGl(), Color.cBrown, this.HasLight(), poolPositions.createPoolTableLeg1());
        PoolTableLeg leg2 = new PoolTableLeg(this.getGl(), Color.cBrown, this.HasLight(), poolPositions.createPoolTableLeg2());
        PoolTableLeg leg3 = new PoolTableLeg(this.getGl(), Color.cBrown, this.HasLight(), poolPositions.createPoolTableLeg3());
        PoolTableLeg leg4 = new PoolTableLeg(this.getGl(), Color.cBrown, this.HasLight(), poolPositions.createPoolTableLeg4());
        
        leg3.exibeVertices();
        
        this.getPoolTable().addPoolTableLeg(leg1);
        this.getPoolTable().addPoolTableLeg(leg2);
        this.getPoolTable().addPoolTableLeg(leg3);
        this.getPoolTable().addPoolTableLeg(leg4);
    }
    
    public void drawObjects() {
        this.poolTable.drawTableObjects();
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
        return light;
    }

    public void setLight(boolean hasLight) {
        this.light = hasLight;
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
