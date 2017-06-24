
package br.furb.main.utils;

import javax.media.opengl.glu.GLU;

public class Camera {
    
    private GLU glu;
    
    private float xEye, yEye, zEye;
    private float xCenter, yCenter, zCenter;

    public Camera(GLU glu, float xEye, float yEye, float zEye, float xCenter, float yCenter, float zCenter) {
        this.setGlu(glu);
        this.setCameraEye(xEye, zEye, zEye);
        this.setCameraCenter(xCenter, zCenter, zCenter);
    }

    public Camera(GLU glu) {
        this.setGlu(glu);
    }
    
    public void display() {
        this.getGlu().gluLookAt(xEye, yEye, zEye, xCenter, yCenter, zCenter, 0, 1, 0);        
    }

    public GLU getGlu() {
        return glu;
    }

    public void setGlu(GLU glu) {
        this.glu = glu;
    }
    
    public void setCameraEye(float x, float y, float z) {
        this.xEye = x;
        this.yEye = y;
        this.zEye = z;
    }
    
    public void setCameraCenter(float x, float y, float z) {
        this.xCenter = x;
        this.yCenter = y;
        this.zCenter = z;
    }
}
