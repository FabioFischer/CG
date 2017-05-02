
package Controller;

import Utils.Point;
import Utils.Transformation;

public class ObjectTransformation {
        
    private Transformation mainMatrix = new Transformation();
    
    private Transformation translationMatrix = new Transformation();
    private Transformation invertedTranslationMatrix = new Transformation();
    private Transformation scaleMatrix = new Transformation();
    private Transformation globalMatrix = new Transformation();

    public ObjectTransformation() {
        
    }
    
    public void translate3D(double dx, double dy, double dz) {
        Transformation t = new Transformation();
        t.translate(dx, dy, dz);
        t.exibeMatriz();
        this.setMainMatrix(t.transformMatrix(this.getMainMatrix()));
    }
    
    public void scale2D(double sx, double sy) {
        Transformation t = new Transformation();
        t.scale(sx, sy, 1);
        this.setMainMatrix(t.transformMatrix(this.getMainMatrix()));        
    }
    
    public void scale3D(double sx, double sy, double sz) {
        Transformation t = new Transformation();
        t.scale(sx, sy, sz);
        this.setMainMatrix(t.transformMatrix(this.getMainMatrix()));
    }
    
    public void scaleStaticPoint(double scale, Point p) {
        this.getGlobalMatrix().setIdentity();
        
        this.getTranslationMatrix().translate(p.getX(), p.getY(), p.getZ());
        this.setGlobalMatrix(this.getTranslationMatrix().transformMatrix(this.getGlobalMatrix()));
        
        this.getScaleMatrix().scale(scale, scale, 1);
        this.setGlobalMatrix(this.getScaleMatrix().transformMatrix(this.getGlobalMatrix()));
        
        p.invert(p);
        this.getInvertedTranslationMatrix().translate(p.getX(), p.getY(), p.getZ());
        this.setGlobalMatrix(this.getInvertedTranslationMatrix().transformMatrix(this.getGlobalMatrix()));
    
        this.setMainMatrix(this.getMainMatrix().transformMatrix(this.getGlobalMatrix()));
    }
    
    public void rotateStaticPoint(double angle, Point p) {
        this.getGlobalMatrix().setIdentity();
        
        this.getTranslationMatrix().translate(p.getX(), p.getY(), p.getZ());
        this.setGlobalMatrix(this.getTranslationMatrix().transformMatrix(this.getGlobalMatrix()));
        
        this.getScaleMatrix().rotateZ(Transformation.DEG_TO_RAD * angle);
        this.setGlobalMatrix(this.getScaleMatrix().transformMatrix(this.getGlobalMatrix()));
        
        p.invert(p);
        this.getInvertedTranslationMatrix().translate(p.getX(), p.getY(), p.getZ());
        this.setGlobalMatrix(this.getInvertedTranslationMatrix().transformMatrix(this.getGlobalMatrix()));
    
        this.setMainMatrix(this.getMainMatrix().transformMatrix(this.getGlobalMatrix()));        
    }
    
    public void setIdentity() {
        this.getMainMatrix().setIdentity();
    }

    public Transformation getMainMatrix() {
        return mainMatrix;
    }

    public void setMainMatrix(Transformation mainMatrix) {
        this.mainMatrix = mainMatrix;
    }

    public Transformation getTranslationMatrix() {
        return translationMatrix;
    }

    public void setTranslationMatrix(Transformation translationMatrix) {
        this.translationMatrix = translationMatrix;
    }

    public Transformation getInvertedTranslationMatrix() {
        return invertedTranslationMatrix;
    }

    public void setInvertedTranslationMatrix(Transformation invertedTranslationMatrix) {
        this.invertedTranslationMatrix = invertedTranslationMatrix;
    }

    public Transformation getScaleMatrix() {
        return scaleMatrix;
    }

    public void setScaleMatrix(Transformation scaleMatrix) {
        this.scaleMatrix = scaleMatrix;
    }

    public Transformation getGlobalMatrix() {
        return globalMatrix;
    }

    public void setGlobalMatrix(Transformation globalMatrix) {
        this.globalMatrix = globalMatrix;
    }
}
