package br.furb.main.controller;

import br.furb.main.utils.Color;
import br.furb.main.utils.Point;
import java.util.ArrayList;

/*
**   FURB - Bacharelado em Ciências da Computação
**   Computação Gráfica
**   Unidade 03
**
**   Fábio Luiz Fischer & Matheus Navarro Nienow
 */

public class GraphicWorld {
    
    private ArrayList<GraphicPolygon> objects;

    public GraphicWorld() {
        this.setObjects(new ArrayList<>());
    }

    public void addObject(GraphicPolygon obj) {
        if (obj != null
                && !this.getObjects().contains(obj)
                && !obj.getObjectPoints().isEmpty()) {
            this.getObjects().add(obj);
        }
    }

    public void deleteObject(GraphicPolygon obj) {
        if (obj != null) {
            for (GraphicPolygon object : this.getObjects()) {
                if (object == obj) {
                    this.removeObjectDependents(object);
                }
            }
        }
    }
    
    public void removeObjectDependents(GraphicPolygon obj) {
        if (this.getObjects().contains(obj)) {
            if (obj.getDependentObjects() != null) {
                for (GraphicPolygon dependent : obj.getDependentObjects()) {
                    if (this.getObjects().contains(dependent)) {
                        this.getObjects().remove(dependent);
                    }
                }
            }
            this.getObjects().remove(obj);
        }
    }

    public void drawObjects() {
        if (!this.getObjects().isEmpty()) {
            for (GraphicPolygon object : this.getObjects()) {
                object.drawObject();
            }
        }
    }

    public void translateWorld(double x, double y, double z) {
        for (GraphicPolygon object : objects) {
            object.translate(x, y, z);
        }
    }

    public void scaleWorld(double scale) {
        for (GraphicPolygon object : objects) {
            object.scale(scale);
        }
    }

    public void rotateStaticPointWorld(double angle) {
        for (GraphicPolygon object : objects) {
            object.rotate(angle);
        }
    }

    public GraphicPolygon getObjectByPosition(Point pos) {
        if (!this.getObjects().isEmpty()) {
            for (GraphicPolygon object : this.getObjects()) {
                if (object.getBondBox().isInside(pos)) {
                    if (object.scanLine(pos)) {
                        return object;
                    }
                }
                
                for (GraphicPolygon dependent : object.getDependentObjects()) {

                }
            }
        }
        return null;
    }

    public ArrayList<GraphicPolygon> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<GraphicPolygon> objects) {
        this.objects = objects;
    }
}
