
package Controller;

import Utils.Color;
import Utils.Point;
import java.util.ArrayList;

public class GraphicWorld {
    
    private ArrayList<GraphicObject> objects;
    
    public GraphicWorld() {
       this.setObjects(new ArrayList<>());
    }
    
    public void addObject(GraphicObject obj) {
        if (obj != null 
                && !this.getObjects().contains(obj) 
                && !obj.getObjectPoints().isEmpty()) {
            this.getObjects().add(obj);
        }
    }
    
    public void deleteObject(GraphicObject obj) {
        if (this.getObjects().contains(obj)) {
            this.getObjects().remove(obj);
        }
    }
    
    public void drawObjects() {
        if(!this.getObjects().isEmpty()) {
            for (GraphicObject object : this.getObjects()) {
                object.drawObject();
            }
        }
    }
    
    public void updateObjectColor(Color c, GraphicObject obj) {
        if (this.getObjects().contains(obj)) {
            this.getObjects().get(this.getObjects().indexOf(obj)).setColor(c);
        }        
    }
    
    public void updateObjectsColor(Color c) {        
        if(!this.getObjects().isEmpty()) {
            for (GraphicObject object : this.getObjects()) {
                object.setColor(c);
            }
        }
    }
    
    public GraphicObject getObjectByPosition(Point pos) {
        if(!this.getObjects().isEmpty()) {
            for (GraphicObject object : this.getObjects()) {
                if(object.getBondBox().isInside(pos)) {
                    if (object.scanLine(pos)) {
                        return object;
                    }
                }
            }
        }
        return null;
    }

    public ArrayList<GraphicObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<GraphicObject> objects) {
        this.objects = objects;
    }
}
