package br.furb.main.objects;

import br.furb.main.controller.GraphicFace;
import br.furb.main.utils.Point;
import com.sun.opengl.util.GLUT;
import java.util.ArrayList;
import javax.media.opengl.GL;

public class PoolPositions {
    
    private GL gl;
    private GLUT glut;
    
    public GraphicFace POOL_TABLE_LEG_1_FACE_1;
    public GraphicFace POOL_TABLE_LEG_1_FACE_2;
    public GraphicFace POOL_TABLE_LEG_1_FACE_3;
    public GraphicFace POOL_TABLE_LEG_1_FACE_4;
    public GraphicFace POOL_TABLE_LEG_1_FACE_5;
    public GraphicFace POOL_TABLE_LEG_1_FACE_6;
    
    public GraphicFace POOL_TABLE_LEG_2_FACE_1;
    public GraphicFace POOL_TABLE_LEG_2_FACE_2;
    public GraphicFace POOL_TABLE_LEG_2_FACE_3;
    public GraphicFace POOL_TABLE_LEG_2_FACE_4;
    public GraphicFace POOL_TABLE_LEG_2_FACE_5;
    public GraphicFace POOL_TABLE_LEG_2_FACE_6;
    
    public GraphicFace POOL_TABLE_LEG_3_FACE_1;
    public GraphicFace POOL_TABLE_LEG_3_FACE_2;
    public GraphicFace POOL_TABLE_LEG_3_FACE_3;
    public GraphicFace POOL_TABLE_LEG_3_FACE_4;
    public GraphicFace POOL_TABLE_LEG_3_FACE_5;
    public GraphicFace POOL_TABLE_LEG_3_FACE_6;
    
    public GraphicFace POOL_TABLE_LEG_4_FACE_1;
    public GraphicFace POOL_TABLE_LEG_4_FACE_2;
    public GraphicFace POOL_TABLE_LEG_4_FACE_3;
    public GraphicFace POOL_TABLE_LEG_4_FACE_4;
    public GraphicFace POOL_TABLE_LEG_4_FACE_5;
    public GraphicFace POOL_TABLE_LEG_4_FACE_6;
    
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_1_FACE_1;
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_1_FACE_2;
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_1_FACE_3;
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_1_FACE_4;
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_1_FACE_5;
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_1_FACE_6;
    
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_2_FACE_1;
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_2_FACE_2;
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_2_FACE_3;
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_2_FACE_4;
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_2_FACE_5;
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_2_FACE_6;
    
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_3_FACE_1;
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_3_FACE_2;
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_3_FACE_3;
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_3_FACE_4;
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_3_FACE_5;
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_3_FACE_6;
    
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_4_FACE_1;
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_4_FACE_2;
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_4_FACE_3;
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_4_FACE_4;
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_4_FACE_5;
    public GraphicFace POOL_TABLE_MARGIN_SEGMENT_4_FACE_6;
   
    public GraphicFace POOL_TABLE_TOP_FACE_1;
    public GraphicFace POOL_TABLE_TOP_FACE_2;
    public GraphicFace POOL_TABLE_TOP_FACE_3;
    public GraphicFace POOL_TABLE_TOP_FACE_4;
    public GraphicFace POOL_TABLE_TOP_FACE_5;
    public GraphicFace POOL_TABLE_TOP_FACE_6;

    public PoolPositions(GL gl, GLUT glut) {
        this.setGl(gl);
        this.setGlut(glut);
    }
    
    public ArrayList<GraphicFace> createPoolTableTopFaces() {
        ArrayList<GraphicFace> faces = new ArrayList<>();
        
        this.POOL_TABLE_TOP_FACE_1 = new GraphicFace(gl, GraphicFace.FRONT_FACE_TYPE);
        this.POOL_TABLE_TOP_FACE_1.addPoint(new Point(0, 5, 0, 1));
        this.POOL_TABLE_TOP_FACE_1.addPoint(new Point(0, 4, 0, 1));
        this.POOL_TABLE_TOP_FACE_1.addPoint(new Point(6, 4, 0, 1));
        this.POOL_TABLE_TOP_FACE_1.addPoint(new Point(6, 5, 0, 1));
        
        this.POOL_TABLE_TOP_FACE_2 = new GraphicFace(gl, GraphicFace.BACK_FACE_TYPE);
        this.POOL_TABLE_TOP_FACE_2.addPoint(new Point(0, 5, 14, 1));
        this.POOL_TABLE_TOP_FACE_2.addPoint(new Point(0, 4, 14, 1));
        this.POOL_TABLE_TOP_FACE_2.addPoint(new Point(6, 4, 14, 1));
        this.POOL_TABLE_TOP_FACE_2.addPoint(new Point(6, 5, 14, 1));
        
        this.POOL_TABLE_TOP_FACE_3 = new GraphicFace(gl, GraphicFace.LEFT_FACE_TYPE);
        this.POOL_TABLE_TOP_FACE_3.addPoint(new Point(0, 5, 0, 1));
        this.POOL_TABLE_TOP_FACE_3.addPoint(new Point(0, 4, 0, 1));
        this.POOL_TABLE_TOP_FACE_3.addPoint(new Point(0, 4, 14, 1));
        this.POOL_TABLE_TOP_FACE_3.addPoint(new Point(0, 5, 14, 1));
        
        this.POOL_TABLE_TOP_FACE_4 = new GraphicFace(gl, GraphicFace.RIGHT_FACE_TYPE);
        this.POOL_TABLE_TOP_FACE_4.addPoint(new Point(6, 5, 0, 1));
        this.POOL_TABLE_TOP_FACE_4.addPoint(new Point(6, 4, 0, 1));
        this.POOL_TABLE_TOP_FACE_4.addPoint(new Point(6, 4, 14, 1));
        this.POOL_TABLE_TOP_FACE_4.addPoint(new Point(6, 5, 14, 1));
        
        this.POOL_TABLE_TOP_FACE_5 = new GraphicFace(gl, GraphicFace.TOP_FACE_TYPE);
        this.POOL_TABLE_TOP_FACE_5.addPoint(new Point(0, 5, 0, 1));
        this.POOL_TABLE_TOP_FACE_5.addPoint(new Point(6, 5, 0, 1));
        this.POOL_TABLE_TOP_FACE_5.addPoint(new Point(6, 5, 14, 1));
        this.POOL_TABLE_TOP_FACE_5.addPoint(new Point(0, 5, 14, 1));
        
        this.POOL_TABLE_TOP_FACE_6 = new GraphicFace(gl, GraphicFace.BOTTOM_FACE_TYPE);
        this.POOL_TABLE_TOP_FACE_6.addPoint(new Point(0, 4, 0, 1));
        this.POOL_TABLE_TOP_FACE_6.addPoint(new Point(6, 4, 0, 1));
        this.POOL_TABLE_TOP_FACE_6.addPoint(new Point(6, 4, 14, 1));
        this.POOL_TABLE_TOP_FACE_6.addPoint(new Point(0, 4, 14, 1));
        
        faces.add(POOL_TABLE_TOP_FACE_1);
        faces.add(POOL_TABLE_TOP_FACE_2);
        faces.add(POOL_TABLE_TOP_FACE_3);
        faces.add(POOL_TABLE_TOP_FACE_4);
        faces.add(POOL_TABLE_TOP_FACE_5);
        faces.add(POOL_TABLE_TOP_FACE_6);
        
        return faces;
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
