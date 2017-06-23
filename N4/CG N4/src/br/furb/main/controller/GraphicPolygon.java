package br.furb.main.controller;

import br.furb.main.utils.Color;
import br.furb.main.utils.Point;
import java.util.ArrayList;
import javax.media.opengl.GL;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 03
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public abstract class GraphicPolygon {

    private final int primitive = GL.GL_QUADS;

    private GL gl;
    private Color color;
    private boolean hasLight;
    
    private ArrayList<GraphicFace> objectFaces;
    private ArrayList<GraphicPolygon> dependentObjects;

    private ObjectTransformation objTransformation;

    public GraphicPolygon(GL gl, Color color, boolean hasLight) {
        this.setGl(gl);
        this.setColor(color);
        this.setObjectFaces(new ArrayList<>());
        this.setDependentObjects(new ArrayList<>());
        this.setLight(hasLight);

        this.setObjTransformation(new ObjectTransformation());
    }
    
    public GraphicPolygon(GL gl, Color color, boolean hasLight, ArrayList<GraphicFace> faces) {
        this.setGl(gl);
        this.setColor(color);
        this.setObjectFaces(faces);
        this.setDependentObjects(new ArrayList<>());
        this.setLight(hasLight);

        this.setObjTransformation(new ObjectTransformation());
    }
    
    public void drawObject() {
        this.getGl().glColor3d(this.getColor().getRed(), this.getColor().getGreen(), this.getColor().getBlue());
                
        if (this.hasLight()) {
            this.getGl().glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE, this.getColor().getColorArrayF(), 0);
            this.getGl().glEnable(GL.GL_LIGHTING);
        }
        
        this.getGl().glPushMatrix();
            this.getGl().glMultMatrixd(this.getObjTransformation().getMainMatrix().getMatrix(), 0);
            this.getGl().glBegin(this.getPrimitive());
                for (GraphicFace objectFace : this.getObjectFaces()) {
                    objectFace.drawFace();
                }
            this.getGl().glEnd();
        this.getGl().glPopMatrix();
        
        if (this.hasLight()) {
            this.getGl().glDisable(GL.GL_LIGHTING);
        }
    }
    
    public void addFace(GraphicFace face) {
        if (!this.getObjectFaces().contains(face)) {
            this.getObjectFaces().add(face);
        }
    }
    
    public void removeFace(GraphicFace face) {
        if(this.getObjectFaces().contains(face)) {
            this.getObjectFaces().remove(face);
        }
    }

    public void addDependent(GraphicPolygon obj) {
        if (obj != null) {
            this.getDependentObjects().add(obj);
        }
    }

    public void deleteDependent(GraphicPolygon obj) {
        if (obj != null && this.getDependentObjects().contains(obj)) {
            this.getDependentObjects().remove(obj);
        }
    }
//
//    public void translate(double dx, double dy, double dz) {
//        this.getObjTransformation().translate3D(dx, dy, dz);
//        this.getObjTransformation().getMainMatrix().exibeMatriz();
//        this.translateDependents(dx, dy, dz, this.getDependentObjects());
//    }
//    
//    public void translateDependents(double dx, double dy, double dz, ArrayList<GraphicPolygon> dependents) {
//        for (GraphicPolygon obj : dependents) {
//            obj.getObjTransformation().translate3D(dx, dy, dz);
//            this.translateDependents(dx, dy, dz, obj.getDependentObjects());
//        }
//    }
//
//    public void scale(double scale) {
//        this.getObjTransformation().scaleStaticPoint(scale, Point.invert(this.getBondBox().getCenterPoint()));
//        this.scaleDependents(scale, this.getDependentObjects());
//    }
//    
//    public void scaleDependents(double scale, ArrayList<GraphicPolygon> dependents) {
//        for (GraphicPolygon obj : dependents) {
//            obj.getObjTransformation().scaleStaticPoint(scale, Point.invert(obj.getBondBox().getCenterPoint()));
//            this.scaleDependents(scale, obj.getDependentObjects());
//        }
//    }
//
//    public void rotate(double angle) {
//        this.getObjTransformation().rotateStaticPoint(angle, Point.invert(this.getBondBox().getCenterPoint()));
//        this.rotateDependents(angle, this.getDependentObjects());
//    }
//    
//    public void rotateDependents(double angle, ArrayList<GraphicPolygon> dependents) {
//        for (GraphicPolygon obj : dependents) {
//            obj.getObjTransformation().rotateStaticPoint(angle, Point.invert(obj.getBondBox().getCenterPoint()));
//            this.rotateDependents(angle, obj.getDependentObjects());
//        }
//    }

    public boolean hasLight() {
        return hasLight;
    }

    public void setLight(boolean hasLight) {
        this.hasLight = hasLight;
    }

    public int getPrimitive() {
        return primitive;
    }

    public GL getGl() {
        return gl;
    }

    public void setGl(GL gl) {
        this.gl = gl;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ArrayList<GraphicPolygon> getDependentObjects() {
        return dependentObjects;
    }

    public void setDependentObjects(ArrayList<GraphicPolygon> dependentObjects) {
        this.dependentObjects = dependentObjects;
    }

    public ObjectTransformation getObjTransformation() {
        return objTransformation;
    }

    public void setObjTransformation(ObjectTransformation objTransformation) {
        this.objTransformation = objTransformation;
    }

    public ArrayList<GraphicFace> getObjectFaces() {
        return objectFaces;
    }

    public void setObjectFaces(ArrayList<GraphicFace> objectFaces) {
        this.objectFaces = objectFaces;
    }
    
    public void exibeVertices() {;
        for (GraphicFace face : this.getObjectFaces()) {
            System.out.println("\n------Face: " + face.getFaceType());
            face.exibeVertices();
        }
    }
}
