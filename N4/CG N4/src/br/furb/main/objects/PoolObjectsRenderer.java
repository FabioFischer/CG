/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.main.objects;

import br.furb.main.objects.*;

public class PoolObjectsRenderer {
    
    private PoolBall[] poolBalls;
    private PoolTable poolTable;
    private PoolTableLeg[] poolTableLegs;
    private PoolTableMarginSegment[] poolTableMarginSegments;
    
    private boolean hasLight;
    
    public PoolObjectsRenderer() {
    }

    public void createObjects() {
//        this.setPoolTable(new PoolTable(gl, Color.cBlue, 0, null));
//        this.setPoolBalls(new PoolBall[]{});
//        this.setPoolTableLegs(new PoolTableLeg[]{});
//        this.setPoolTableMarginSegments(new PoolTableMarginSegment[]{});
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

    public PoolTableMarginSegment[] getPoolTableMarginSegments() {
        return poolTableMarginSegments;
    }

    public void setPoolTableMarginSegments(PoolTableMarginSegment[] poolTableMarginSegments) {
        this.poolTableMarginSegments = poolTableMarginSegments;
    }

    public PoolTableLeg[] getPoolTableLegs() {
        return poolTableLegs;
    }

    public void setPoolTableLegs(PoolTableLeg[] poolTableLegs) {
        this.poolTableLegs = poolTableLegs;
    }
}
