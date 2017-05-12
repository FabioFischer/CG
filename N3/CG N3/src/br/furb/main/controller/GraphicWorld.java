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
        if (obj != null) {
            for (GraphicObject object : objects) {
                if (object == obj) {
                    this.removeObjectDependents(object);
                }
            }
        }
    }
    
    public void removeObjectDependents(GraphicObject obj) {
        if (this.getObjects().contains(obj)) {
            if (obj.getDependentObjects() != null) {
                for (GraphicObject dependent : obj.getDependentObjects()) {
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
            for (GraphicObject object : this.getObjects()) {
                object.drawObject();
            }
        }
    }

    public void updateObjectColor(Color c, GraphicObject obj) {
        if (this.getObjects().contains(obj)) {
            this.getObjects().get(this.getObjects().indexOf(obj)).setCurrentColor(c);
        }
    }

    public void updateObjectsColor(Color c) {
        if (!this.getObjects().isEmpty()) {
            for (GraphicObject object : this.getObjects()) {
                object.setCurrentColor(c);
            }
        }
    }

    public void updateObjectsColorToDefault() {
        if (!this.getObjects().isEmpty()) {
            for (GraphicObject object : this.getObjects()) {
                object.setCurrentColor(object.getDefaultColor());
            }
        }
    }

    public void translateWorld(double x, double y, double z) {
        for (GraphicObject object : objects) {
            object.translate(x, y, z);
        }
    }

    public void scaleWorld(double scale) {
        for (GraphicObject object : objects) {
            object.scale(scale);
        }
    }

    public void rotateStaticPointWorld(double angle) {
        for (GraphicObject object : objects) {
            object.rotate(angle);
        }
    }

    public GraphicObject getObjectByPosition(Point pos) {
        if (!this.getObjects().isEmpty()) {
            for (GraphicObject object : this.getObjects()) {
                if (object.getBondBox().isInside(pos)) {
                    if (object.scanLine(pos)) {
                        return object;
                    }
                }
                
                for (GraphicObject dependent : object.getDependentObjects()) {

                }
            }
        }
        return null;
    }

    public Edge findEdgeByPosition(Point p, double distance) {
        for (GraphicObject object : this.getObjects()) {
            Point prevPoint = null;

            for (Point objectPoint : object.getObjectPoints()) {
                if (prevPoint != null) {
                    if (Edge.isPointOnEdgeLine(p, prevPoint, objectPoint)) {
                        return new Edge(object.getGl(), object.getCurrentColor(), object.getWidth(), prevPoint, objectPoint);
                    }
                } else {
                    prevPoint = objectPoint;
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
