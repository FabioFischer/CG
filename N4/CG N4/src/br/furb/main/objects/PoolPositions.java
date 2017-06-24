package br.furb.main.objects;

import br.furb.main.controller.GraphicFace;
import br.furb.main.utils.Color;
import br.furb.main.utils.Point;
import com.sun.opengl.util.GLUT;
import java.util.ArrayList;
import javax.media.opengl.GL;

public class PoolPositions {
    
    private GL gl;
    private GLUT glut;
    
    private final double DEFAULT_POOL_BALL_SIZE = 0.27;
    private final double WHITE_POOL_BALL_SIZE = 0.29;
    
    public PoolPositions(GL gl, GLUT glut) {
        this.setGl(gl);
        this.setGlut(glut);
    }
    
    public ArrayList<GraphicFace> createPoolTableTopFaces() {
        ArrayList<GraphicFace> faces = new ArrayList<>();
        
        GraphicFace face1,face2, face3, face4, face5, face6;
        
        face1 = new GraphicFace(gl, GraphicFace.FRONT_FACE_TYPE);
        face1.addPoint(new Point(0, 5, 0, 1));
        face1.addPoint(new Point(0, 4, 0, 1));
        face1.addPoint(new Point(8, 4, 0, 1));
        face1.addPoint(new Point(8, 5, 0, 1));
        
        face2 = new GraphicFace(gl, GraphicFace.BACK_FACE_TYPE);
        face2.addPoint(new Point(0, 5, 14, 1));
        face2.addPoint(new Point(0, 4, 14, 1));
        face2.addPoint(new Point(8, 4, 14, 1));
        face2.addPoint(new Point(8, 5, 14, 1));
        
        face3 = new GraphicFace(gl, GraphicFace.TOP_FACE_TYPE);
        face3.addPoint(new Point(0, 5, 0, 1));
        face3.addPoint(new Point(0, 5, 14, 1));
        face3.addPoint(new Point(8, 5, 14, 1));
        face3.addPoint(new Point(8, 5, 0, 1));
        
        face4 = new GraphicFace(gl, GraphicFace.BOTTOM_FACE_TYPE);
        face4.addPoint(new Point(0, 4, 0, 1));
        face4.addPoint(new Point(8, 4, 0, 1));
        face4.addPoint(new Point(8, 4, 14, 1));
        face4.addPoint(new Point(0, 4, 14, 1));
        
        face5 = new GraphicFace(gl, GraphicFace.LEFT_FACE_TYPE);
        face5.addPoint(new Point(0, 4, 0, 1));
        face5.addPoint(new Point(0, 5, 0, 1));
        face5.addPoint(new Point(0, 5, 14, 1));
        face5.addPoint(new Point(0, 4, 14, 1));
        
        face6 = new GraphicFace(gl, GraphicFace.RIGHT_FACE_TYPE);
        face6.addPoint(new Point(8, 4, 0, 1));
        face6.addPoint(new Point(8, 5, 0, 1));
        face6.addPoint(new Point(8, 5, 14, 1));
        face6.addPoint(new Point(8, 4, 14, 1));
                
        faces.add(face1);
        faces.add(face2);
        faces.add(face3);
        faces.add(face4);
        faces.add(face5);
        faces.add(face6);
        
        return faces;
    } 
    
    public ArrayList<GraphicFace> createPoolTableLeg1() {
        ArrayList<GraphicFace> faces = new ArrayList<>();
        
        GraphicFace face1,face2, face3, face4, face5, face6;
        
        face1 = new GraphicFace(gl, GraphicFace.FRONT_FACE_TYPE);
        face1.addPoint(new Point(0, 0, 0, 1));
        face1.addPoint(new Point(1, 0, 0, 1));
        face1.addPoint(new Point(1, 4, 0, 1));
        face1.addPoint(new Point(0, 4, 0, 1));
        
        face2 = new GraphicFace(gl, GraphicFace.BACK_FACE_TYPE);
        face2.addPoint(new Point(0, 0, 1, 1));
        face2.addPoint(new Point(1, 0, 1, 1));
        face2.addPoint(new Point(1, 4, 1, 1));
        face2.addPoint(new Point(0, 4, 1, 1));
        
        face3 = new GraphicFace(gl, GraphicFace.TOP_FACE_TYPE);
        face3.addPoint(new Point(0, 4, 0, 1));
        face3.addPoint(new Point(0, 4, 1, 1));
        face3.addPoint(new Point(1, 4, 1, 1));
        face3.addPoint(new Point(1, 4, 0, 1));
        
        face4 = new GraphicFace(gl, GraphicFace.BOTTOM_FACE_TYPE);
        face4.addPoint(new Point(0, 0, 0, 1));
        face4.addPoint(new Point(0, 0, 1, 1));
        face4.addPoint(new Point(1, 0, 1, 1));
        face4.addPoint(new Point(1, 0, 0, 1));
        
        face5 = new GraphicFace(gl, GraphicFace.LEFT_FACE_TYPE);
        face5.addPoint(new Point(0, 0, 0, 1));
        face5.addPoint(new Point(0, 4, 0, 1));
        face5.addPoint(new Point(0, 4, 1, 1));
        face5.addPoint(new Point(0, 0, 1, 1));
        
        face6 = new GraphicFace(gl, GraphicFace.RIGHT_FACE_TYPE);
        face6.addPoint(new Point(1, 0, 0, 1));
        face6.addPoint(new Point(1, 4, 0, 1));
        face6.addPoint(new Point(1, 4, 1, 1));
        face6.addPoint(new Point(1, 0, 1, 1));
        
        faces.add(face1);
        faces.add(face2);
        faces.add(face3);
        faces.add(face4);
        faces.add(face5);
        faces.add(face6);
        
        return faces;
    }

    public ArrayList<GraphicFace> createPoolTableLeg2() {
        ArrayList<GraphicFace> faces = new ArrayList<>();
        
        GraphicFace face1,face2, face3, face4, face5, face6;
        
        face1 = new GraphicFace(gl, GraphicFace.FRONT_FACE_TYPE);
        face1.addPoint(new Point(7, 0, 0, 1));
        face1.addPoint(new Point(8, 0, 0, 1));
        face1.addPoint(new Point(8, 4, 0, 1));
        face1.addPoint(new Point(7, 4, 0, 1));
        
        face2 = new GraphicFace(gl, GraphicFace.BACK_FACE_TYPE);
        face2.addPoint(new Point(7, 0, 1, 1));
        face2.addPoint(new Point(8, 0, 1, 1));
        face2.addPoint(new Point(8, 4, 1, 1));
        face2.addPoint(new Point(7, 4, 1, 1));
        
        face3 = new GraphicFace(gl, GraphicFace.TOP_FACE_TYPE);
        face3.addPoint(new Point(7, 4, 0, 1));
        face3.addPoint(new Point(7, 4, 1, 1));
        face3.addPoint(new Point(8, 4, 1, 1));
        face3.addPoint(new Point(8, 4, 0, 1));
        
        face4 = new GraphicFace(gl, GraphicFace.BOTTOM_FACE_TYPE);
        face4.addPoint(new Point(7, 0, 0, 1));
        face4.addPoint(new Point(7, 0, 1, 1));
        face4.addPoint(new Point(8, 0, 1, 1));
        face4.addPoint(new Point(8, 0, 0, 1));
        
        face5 = new GraphicFace(gl, GraphicFace.LEFT_FACE_TYPE);
        face5.addPoint(new Point(7, 0, 0, 1));
        face5.addPoint(new Point(7, 4, 0, 1));
        face5.addPoint(new Point(7, 4, 1, 1));
        face5.addPoint(new Point(7, 0, 1, 1));
        
        face6 = new GraphicFace(gl, GraphicFace.RIGHT_FACE_TYPE);
        face6.addPoint(new Point(8, 0, 0, 1));
        face6.addPoint(new Point(8, 4, 0, 1));
        face6.addPoint(new Point(8, 4, 1, 1));
        face6.addPoint(new Point(8, 0, 1, 1));
        
        faces.add(face1);
        faces.add(face2);
        faces.add(face3);
        faces.add(face4);
        faces.add(face5);
        faces.add(face6);
        
        return faces;
    }
    
    public ArrayList<GraphicFace> createPoolTableLeg3() {
        ArrayList<GraphicFace> faces = new ArrayList<>();
        
        GraphicFace face1,face2, face3, face4, face5, face6;
        
        face1 = new GraphicFace(gl, GraphicFace.FRONT_FACE_TYPE);
        face1.addPoint(new Point(0, 0, 13, 1));
        face1.addPoint(new Point(1, 0, 13, 1));
        face1.addPoint(new Point(1, 4, 13, 1));
        face1.addPoint(new Point(0, 4, 13, 1));
        
        face2 = new GraphicFace(gl, GraphicFace.BACK_FACE_TYPE);
        face2.addPoint(new Point(0, 0, 14, 1));
        face2.addPoint(new Point(1, 0, 14, 1));
        face2.addPoint(new Point(1, 4, 14, 1));
        face2.addPoint(new Point(0, 4, 14, 1));
        
        face3 = new GraphicFace(gl, GraphicFace.TOP_FACE_TYPE);
        face3.addPoint(new Point(0, 4, 13, 1));
        face3.addPoint(new Point(0, 4, 14, 1));
        face3.addPoint(new Point(1, 4, 14, 1));
        face3.addPoint(new Point(1, 4, 13, 1));
        
        face4 = new GraphicFace(gl, GraphicFace.BOTTOM_FACE_TYPE);
        face4.addPoint(new Point(0, 0, 13, 1));
        face4.addPoint(new Point(0, 0, 14, 1));
        face4.addPoint(new Point(1, 0, 14, 1));
        face4.addPoint(new Point(1, 0, 13, 1));
        
        face5 = new GraphicFace(gl, GraphicFace.RIGHT_FACE_TYPE);
        face5.addPoint(new Point(1, 0, 13, 1));
        face5.addPoint(new Point(1, 4, 13, 1));
        face5.addPoint(new Point(1, 4, 14, 1));
        face5.addPoint(new Point(1, 0, 14, 1));
                
        face6 = new GraphicFace(gl, GraphicFace.LEFT_FACE_TYPE);
        face6.addPoint(new Point(0, 0, 13, 1));
        face6.addPoint(new Point(0, 4, 13, 1));
        face6.addPoint(new Point(0, 4, 14, 1));
        face6.addPoint(new Point(0, 0, 14, 1));
        
        faces.add(face1);
        faces.add(face2);
        faces.add(face3);
        faces.add(face4);
        faces.add(face5);
        faces.add(face6);
        
        return faces;
    }
        
    public ArrayList<GraphicFace> createPoolTableLeg4() {
        ArrayList<GraphicFace> faces = new ArrayList<>();
        
        GraphicFace face1,face2, face3, face4, face5, face6;
        
        face1 = new GraphicFace(gl, GraphicFace.FRONT_FACE_TYPE);
        face1.addPoint(new Point(7, 0, 13, 1));
        face1.addPoint(new Point(8, 0, 13, 1));
        face1.addPoint(new Point(8, 4, 13, 1));
        face1.addPoint(new Point(7, 4, 13, 1));
        
        face2 = new GraphicFace(gl, GraphicFace.BACK_FACE_TYPE);
        face2.addPoint(new Point(7, 0, 14, 1));
        face2.addPoint(new Point(8, 0, 14, 1));
        face2.addPoint(new Point(8, 4, 14, 1));
        face2.addPoint(new Point(7, 4, 14, 1));
        
        face3 = new GraphicFace(gl, GraphicFace.TOP_FACE_TYPE);
        face3.addPoint(new Point(7, 4, 13, 1));
        face3.addPoint(new Point(7, 4, 14, 1));
        face3.addPoint(new Point(8, 4, 14, 1));
        face3.addPoint(new Point(8, 4, 13, 1));
        
        face4 = new GraphicFace(gl, GraphicFace.BOTTOM_FACE_TYPE);
        face4.addPoint(new Point(7, 0, 13, 1));
        face4.addPoint(new Point(7, 0, 14, 1));
        face4.addPoint(new Point(8, 0, 14, 1));
        face4.addPoint(new Point(8, 0, 13, 1));
        
        face5 = new GraphicFace(gl, GraphicFace.LEFT_FACE_TYPE);
        face5.addPoint(new Point(7, 0, 13, 1));
        face5.addPoint(new Point(7, 4, 13, 1));
        face5.addPoint(new Point(7, 4, 14, 1));
        face5.addPoint(new Point(7, 0, 14, 1));
        
        face6 = new GraphicFace(gl, GraphicFace.RIGHT_FACE_TYPE);
        face6.addPoint(new Point(8, 0, 13, 1));
        face6.addPoint(new Point(8, 4, 13, 1));
        face6.addPoint(new Point(8, 4, 14, 1));
        face6.addPoint(new Point(8, 0, 14, 1));
        
        faces.add(face1);
        faces.add(face2);
        faces.add(face3);
        faces.add(face4);
        faces.add(face5);
        faces.add(face6);
        
        return faces;
    }
    
    public ArrayList<GraphicFace> createPoolTableMarginSeg1() {
        ArrayList<GraphicFace> faces = new ArrayList<>();
        
        GraphicFace face1,face2, face3, face4, face5, face6;
        
        face1 = new GraphicFace(gl, GraphicFace.FRONT_FACE_TYPE);
        face1.addPoint(new Point(-0.5, 4, -0.5, 1));
        face1.addPoint(new Point(8.5, 4, -0.5, 1));
        face1.addPoint(new Point(8.5, 5.5, -0.5, 1));
        face1.addPoint(new Point(-0.5, 5.5, -0.5, 1));
        
        face2 = new GraphicFace(gl, GraphicFace.BACK_FACE_TYPE);
        face2.addPoint(new Point(-0.5, 4, 0, 1));
        face2.addPoint(new Point(8.5, 4, 0, 1));
        face2.addPoint(new Point(8.5, 5.5, 0, 1));
        face2.addPoint(new Point(-0.5, 5.5, 0, 1));
        
        face3 = new GraphicFace(gl, GraphicFace.TOP_FACE_TYPE);
        face3.addPoint(new Point(-0.5, 5.5, -0.5, 1));
        face3.addPoint(new Point(-0.5, 5.5, 0, 1));
        face3.addPoint(new Point(8.5, 5.5, 0, 1));
        face3.addPoint(new Point(8.5, 5.5, -0.5, 1));
        
        face4 = new GraphicFace(gl, GraphicFace.BOTTOM_FACE_TYPE);
        face4.addPoint(new Point(-0.5, 4, 0, 1));
        face4.addPoint(new Point(-0.5, 4, -0.5, 1));
        face4.addPoint(new Point(8.5, 4, 0, 1));
        face4.addPoint(new Point(8.5, 4, -0.5, 1));
        
        face5 = new GraphicFace(gl, GraphicFace.LEFT_FACE_TYPE);
        face5.addPoint(new Point(-0.5, 4, -0.5, 1));
        face5.addPoint(new Point(-0.5, 5.5, -0.5, 1));
        face5.addPoint(new Point(-0.5, 5.5, 0, 1));
        face5.addPoint(new Point(-0.5, 4, 0, 1));
        
        face6 = new GraphicFace(gl, GraphicFace.RIGHT_FACE_TYPE);
        face6.addPoint(new Point(8.5, 4, -0.5, 1));
        face6.addPoint(new Point(8.5, 5.5, -0.5, 1));
        face6.addPoint(new Point(8.5, 5.5, 0, 1));
        face6.addPoint(new Point(8.5, 4, 0, 1));
        
        faces.add(face1);
        faces.add(face2);
        faces.add(face3);
        faces.add(face4);
        faces.add(face5);
        faces.add(face6);
        
        return faces;
    }
    
    public ArrayList<GraphicFace> createPoolTableMarginSeg2() {
        ArrayList<GraphicFace> faces = new ArrayList<>();
        
        GraphicFace face1,face2, face3, face4, face5, face6;
        
        face1 = new GraphicFace(gl, GraphicFace.FRONT_FACE_TYPE);
        face1.addPoint(new Point(-0.5, 4, 14.5, 1));
        face1.addPoint(new Point(8.5, 4, 14.5, 1));
        face1.addPoint(new Point(8.5, 5.5, 14.5, 1));
        face1.addPoint(new Point(-0.5, 5.5, 14.5, 1));
        
        face2 = new GraphicFace(gl, GraphicFace.BACK_FACE_TYPE);
        face2.addPoint(new Point(-0.5, 4, 14, 1));
        face2.addPoint(new Point(8.5, 4, 14, 1));
        face2.addPoint(new Point(8.5, 5.5, 14, 1));
        face2.addPoint(new Point(-0.5, 5.5, 14, 1));
                        
        face3 = new GraphicFace(gl, GraphicFace.TOP_FACE_TYPE);
        face3.addPoint(new Point(-0.5, 5.5, 14, 1));
        face3.addPoint(new Point(-0.5, 5.5, 14.5, 1));
        face3.addPoint(new Point(8.5, 5.5, 14.5, 1));
        face3.addPoint(new Point(8.5, 5.5, 14, 1));
        
        face4 = new GraphicFace(gl, GraphicFace.BOTTOM_FACE_TYPE);
        face4.addPoint(new Point(-0.5, 4, 14, 1));
        face4.addPoint(new Point(-0.5, 4, 14.5, 1));
        face4.addPoint(new Point(8.5, 4, 14.5, 1));
        face4.addPoint(new Point(8.5, 4, 14, 1));
                        
        face5 = new GraphicFace(gl, GraphicFace.LEFT_FACE_TYPE);
        face5.addPoint(new Point(-0.5, 4, 14, 1));
        face5.addPoint(new Point(-0.5, 5.5, 14, 1));
        face5.addPoint(new Point(-0.5, 5.5, 14.5, 1));
        face5.addPoint(new Point(-0.5, 4, 14.5, 1));
        
        face6 = new GraphicFace(gl, GraphicFace.RIGHT_FACE_TYPE);
        face6.addPoint(new Point(8.5, 4, 14, 1));
        face6.addPoint(new Point(8.5, 5.5, 14, 1));
        face6.addPoint(new Point(8.5, 5.5, 14.5, 1));
        face6.addPoint(new Point(8.5, 4, 14.5, 1));
//       
        faces.add(face1);
        faces.add(face2);
        faces.add(face3);
        faces.add(face4);
        faces.add(face5);
        faces.add(face6);
        
        return faces;
    }
    
    public ArrayList<GraphicFace> createPoolTableMarginSeg3() {
        ArrayList<GraphicFace> faces = new ArrayList<>();
        
        GraphicFace face1,face2, face3, face4, face5, face6;
       
        face1 = new GraphicFace(gl, GraphicFace.FRONT_FACE_TYPE);
        face1.addPoint(new Point(-0.5, 4, 0, 1));
        face1.addPoint(new Point(0, 4, 0, 1));
        face1.addPoint(new Point(0, 5.5, 0, 1));
        face1.addPoint(new Point(-0.5, 5.5, 0, 1));
        
        face2 = new GraphicFace(gl, GraphicFace.BACK_FACE_TYPE);
        face2.addPoint(new Point(-0.5, 4, 14, 1));
        face2.addPoint(new Point(0, 4, 14, 1));
        face2.addPoint(new Point(0, 5.5, 14, 1));
        face2.addPoint(new Point(-0.5, 5.5, 14, 1));
                        
        face3 = new GraphicFace(gl, GraphicFace.TOP_FACE_TYPE);
        face3.addPoint(new Point(-0.5, 5.5, 0, 1));
        face3.addPoint(new Point(-0.5, 5.5, 14, 1));
        face3.addPoint(new Point(0, 5.5, 14, 1));
        face3.addPoint(new Point(0, 5.5, 0, 1));
        
        face4 = new GraphicFace(gl, GraphicFace.BOTTOM_FACE_TYPE);
        face4.addPoint(new Point(-0.5, 4, 0, 1));
        face4.addPoint(new Point(-0.5, 4, 14, 1));
        face4.addPoint(new Point(0, 4, 14, 1));
        face4.addPoint(new Point(0, 4, 0, 1));
                        
        face5 = new GraphicFace(gl, GraphicFace.LEFT_FACE_TYPE);
        face5.addPoint(new Point(-0.5, 4, 0, 1));
        face5.addPoint(new Point(-0.5, 5.5, 0, 1));
        face5.addPoint(new Point(-0.5, 5.5, 14, 1));
        face5.addPoint(new Point(-0.5, 4, 14, 1));
        
        face6 = new GraphicFace(gl, GraphicFace.RIGHT_FACE_TYPE);
        face6.addPoint(new Point(0, 4, 0, 1));
        face6.addPoint(new Point(0, 5.5, 0, 1));
        face6.addPoint(new Point(0, 5.5, 14, 1));
        face6.addPoint(new Point(0, 4, 14, 1));
        
        faces.add(face1);
        faces.add(face2);
        faces.add(face3);
        faces.add(face4);
        faces.add(face5);
        faces.add(face6);
        
        return faces;
    }
    
    public ArrayList<GraphicFace> createPoolTableMarginSeg4() {
        ArrayList<GraphicFace> faces = new ArrayList<>();
//        
        GraphicFace face1,face2, face3, face4, face5, face6;
       
        face1 = new GraphicFace(gl, GraphicFace.FRONT_FACE_TYPE);
        face1.addPoint(new Point(8.5, 4, 0, 1));
        face1.addPoint(new Point(8, 4, 0, 1));
        face1.addPoint(new Point(8, 5.5, 0, 1));
        face1.addPoint(new Point(8.5, 5.5, 0, 1));
        
        face2 = new GraphicFace(gl, GraphicFace.BACK_FACE_TYPE);
        face2.addPoint(new Point(8.5, 4, 14, 1));
        face2.addPoint(new Point(8, 4, 14, 1));
        face2.addPoint(new Point(8, 5.5, 14, 1));
        face2.addPoint(new Point(8.5, 5.5, 14, 1));
                        
        face3 = new GraphicFace(gl, GraphicFace.TOP_FACE_TYPE);
        face3.addPoint(new Point(8, 5.5, 0, 1));
        face3.addPoint(new Point(8, 5.5, 14, 1));
        face3.addPoint(new Point(8.5, 5.5, 14, 1));
        face3.addPoint(new Point(8.5, 5.5, 0, 1));
        
        face4 = new GraphicFace(gl, GraphicFace.BOTTOM_FACE_TYPE);
        face4.addPoint(new Point(8, 4, 0, 1));
        face4.addPoint(new Point(8, 4, 14, 1));
        face4.addPoint(new Point(8.5, 4, 14, 1));
        face4.addPoint(new Point(8.5, 4, 0, 1));
                        
        face5 = new GraphicFace(gl, GraphicFace.LEFT_FACE_TYPE);
        face5.addPoint(new Point(8, 4, 0, 1));
        face5.addPoint(new Point(8, 5.5, 0, 1));
        face5.addPoint(new Point(8, 5.5, 14, 1));
        face5.addPoint(new Point(8, 4, 14, 1));
        
        face6 = new GraphicFace(gl, GraphicFace.RIGHT_FACE_TYPE);
        face6.addPoint(new Point(8.5, 4, 0, 1));
        face6.addPoint(new Point(8.5, 5.5, 0, 1));
        face6.addPoint(new Point(8.5, 5.5, 14, 1));
        face6.addPoint(new Point(8.5, 4, 14, 1));
        
        faces.add(face1);
        faces.add(face2);
        faces.add(face3);
        faces.add(face4);
        faces.add(face5);
        faces.add(face6);
       
        faces.add(face1);
        faces.add(face2);
        faces.add(face3);
        faces.add(face4);
        faces.add(face5);
        faces.add(face6);
        
        return faces;
    }
    
    public ArrayList<PoolBall> createPoolBalls() {
        ArrayList<PoolBall> poolBalls = new ArrayList<>();
        
        PoolBall pBall0 = new PoolBall(this.getGl(), this.getGlut(), Color.cWhite, new Point(4, (5 + WHITE_POOL_BALL_SIZE), 3.5, 1), WHITE_POOL_BALL_SIZE);
        PoolBall pBall1 = new PoolBall(this.getGl(), this.getGlut(), Color.cYellow, new Point(4, (5 + DEFAULT_POOL_BALL_SIZE), 10, 1), DEFAULT_POOL_BALL_SIZE);
        PoolBall pBall2 = new PoolBall(this.getGl(), this.getGlut(), Color.cBlue, new Point(4.3, (5 + DEFAULT_POOL_BALL_SIZE), 10.5, 1), DEFAULT_POOL_BALL_SIZE);
        PoolBall pBall3 = new PoolBall(this.getGl(), this.getGlut(), Color.cRed, new Point(3.7, (5 + DEFAULT_POOL_BALL_SIZE), 10.5, 1), DEFAULT_POOL_BALL_SIZE);
        PoolBall pBall4 = new PoolBall(this.getGl(), this.getGlut(), Color.cDarkBlue, new Point(3.4, (5 + DEFAULT_POOL_BALL_SIZE), 11, 1), DEFAULT_POOL_BALL_SIZE);
        PoolBall pBall5 = new PoolBall(this.getGl(), this.getGlut(), Color.cOrange, new Point(4, (5 + DEFAULT_POOL_BALL_SIZE), 11, 1), DEFAULT_POOL_BALL_SIZE);
        PoolBall pBall6 = new PoolBall(this.getGl(), this.getGlut(), Color.cDarkGreen, new Point(4.6, (5 + DEFAULT_POOL_BALL_SIZE), 11, 1), DEFAULT_POOL_BALL_SIZE);
        PoolBall pBall7 = new PoolBall(this.getGl(), this.getGlut(), Color.cDarkRed, new Point(4.9, (5 + DEFAULT_POOL_BALL_SIZE), 11.5, 1), DEFAULT_POOL_BALL_SIZE);
        PoolBall pBall8 = new PoolBall(this.getGl(), this.getGlut(), Color.cBlack, new Point(4.3, (5 + DEFAULT_POOL_BALL_SIZE), 11.5, 1), DEFAULT_POOL_BALL_SIZE);
        PoolBall pBall9 = new PoolBall(this.getGl(), this.getGlut(), Color.cYellow, new Point(3.7, (5 + DEFAULT_POOL_BALL_SIZE), 11.5, 1), DEFAULT_POOL_BALL_SIZE);
        PoolBall pBall10 = new PoolBall(this.getGl(), this.getGlut(), Color.cBlue, new Point(3.1, (5 + DEFAULT_POOL_BALL_SIZE), 11.5, 1), DEFAULT_POOL_BALL_SIZE);
        PoolBall pBall11 = new PoolBall(this.getGl(), this.getGlut(), Color.cRed, new Point(2.8, (5 + DEFAULT_POOL_BALL_SIZE), 12, 1), DEFAULT_POOL_BALL_SIZE);
        PoolBall pBall12 = new PoolBall(this.getGl(), this.getGlut(), Color.cDarkBlue, new Point(3.4, (5 + DEFAULT_POOL_BALL_SIZE), 12, 1), DEFAULT_POOL_BALL_SIZE);
        PoolBall pBall13 = new PoolBall(this.getGl(), this.getGlut(), Color.cOrange, new Point(4, (5 + DEFAULT_POOL_BALL_SIZE), 12, 1), DEFAULT_POOL_BALL_SIZE);
        PoolBall pBall14 = new PoolBall(this.getGl(), this.getGlut(), Color.cDarkerGreen, new Point(4.6, (5 + DEFAULT_POOL_BALL_SIZE), 12, 1), DEFAULT_POOL_BALL_SIZE);
        PoolBall pBall15 = new PoolBall(this.getGl(), this.getGlut(), Color.cDarkRed, new Point(5.2, (5 + DEFAULT_POOL_BALL_SIZE), 12, 1), DEFAULT_POOL_BALL_SIZE);
        
        poolBalls.add(pBall0);
        poolBalls.add(pBall1);
        poolBalls.add(pBall2);
        poolBalls.add(pBall3);
        poolBalls.add(pBall4);
        poolBalls.add(pBall5);
        poolBalls.add(pBall6);
        poolBalls.add(pBall7);
        poolBalls.add(pBall8);
        poolBalls.add(pBall9);
        poolBalls.add(pBall10);
        poolBalls.add(pBall11);
        poolBalls.add(pBall12);
        poolBalls.add(pBall13);
        poolBalls.add(pBall14);
        poolBalls.add(pBall15);

        return poolBalls;
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
}
