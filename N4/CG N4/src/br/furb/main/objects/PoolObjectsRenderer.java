/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.main.objects;

import br.furb.main.objects.*;
import br.furb.main.utils.Color;
import com.sun.opengl.util.GLUT;
import java.util.ArrayList;
import javax.media.opengl.GL;

public class PoolObjectsRenderer {
    
    private GL gl;
    private GLUT glut;
    
    private PoolTable poolTable;
    private PoolCueStick poolCueStick;
    private ArrayList<PoolBall> poolBalls;
    
    private PoolObjectsPositions poolObjectsPositions;
    
    private boolean light;
    
    public PoolObjectsRenderer(GL gl, GLUT glut, boolean light) {
        this.setGl(gl);
        this.setGlut(glut);
        this.setLight(light);
        
        this.poolObjectsPositions = new PoolObjectsPositions(gl, glut);
        this.createObjects();
    }

    public void createObjects() {
        this.createPoolTable();
        this.setPoolBalls(this.poolObjectsPositions.createPoolBalls());
//        this.setPoolCueStick(new PoolCueStick(gl, Color.cBlue, 0, centerPoint, 0, hasLight));
    }
    
    public void createPoolTable() {
        this.setPoolTable(new PoolTable(this.getGl(), Color.cDarkGreen, poolObjectsPositions.createPoolTableTopFaces(), this.hasLight()));
        
        PoolTableLeg leg1 = new PoolTableLeg(this.getGl(), Color.cBrown, this.hasLight(), poolObjectsPositions.createPoolTableLeg1());
        PoolTableLeg leg2 = new PoolTableLeg(this.getGl(), Color.cBrown, this.hasLight(), poolObjectsPositions.createPoolTableLeg2());
        PoolTableLeg leg3 = new PoolTableLeg(this.getGl(), Color.cBrown, this.hasLight(), poolObjectsPositions.createPoolTableLeg3());
        PoolTableLeg leg4 = new PoolTableLeg(this.getGl(), Color.cBrown, this.hasLight(), poolObjectsPositions.createPoolTableLeg4());
        
        PoolTableMarginSegment margin1 = new PoolTableMarginSegment(this.getGl(), Color.cDarkBrown, this.hasLight(), poolObjectsPositions.createPoolTableMarginSeg1());
        PoolTableMarginSegment margin2 = new PoolTableMarginSegment(this.getGl(), Color.cDarkBrown, this.hasLight(), poolObjectsPositions.createPoolTableMarginSeg2());
        PoolTableMarginSegment margin3 = new PoolTableMarginSegment(this.getGl(), Color.cDarkBrown, this.hasLight(), poolObjectsPositions.createPoolTableMarginSeg3());
        PoolTableMarginSegment margin4 = new PoolTableMarginSegment(this.getGl(), Color.cDarkBrown, this.hasLight(), poolObjectsPositions.createPoolTableMarginSeg4());
        
        this.getPoolTable().addPoolTableLeg(leg1);
        this.getPoolTable().addPoolTableLeg(leg2);
        this.getPoolTable().addPoolTableLeg(leg3);
        this.getPoolTable().addPoolTableLeg(leg4);
        
        this.getPoolTable().addPoolTableMarginSegment(margin1);
        this.getPoolTable().addPoolTableMarginSegment(margin2);
        this.getPoolTable().addPoolTableMarginSegment(margin3);
        this.getPoolTable().addPoolTableMarginSegment(margin4);
    }
    
    public void drawObjects() {
        this.poolTable.drawTableObjects();
        
        for (PoolBall poolBall : this.getPoolBalls()) {
            poolBall.drawSphere();
        }
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

    public boolean hasLight() {
        return light;
    }

    public void setLight(boolean hasLight) {
        this.light = hasLight;
    }
    
    public ArrayList<PoolBall> getPoolBalls() {
        return poolBalls;
    }

    public void setPoolBalls(ArrayList<PoolBall> poolBalls) {
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
