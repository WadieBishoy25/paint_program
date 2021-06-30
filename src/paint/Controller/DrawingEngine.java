/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.Controller;

import Paint.Model.Shape;

/**
 *
 * @author wadiebishoy
 */
public interface DrawingEngine {
    
    public void refresh(Object canvas);

    public void addShape(Shape shape);
    public void removeShape(Shape shape);
    public void updateShape(Shape oldShape, Shape newShape);

    public Shape[] getShapes();
    
    public void undo();
    public void redo();
    
    public void save(String path);
    public void load(String path);
    
   // public java.util.List<Class<? extends Shape>> getSupportedShapes();
    
    //    public void installPluginShape(String jarPath);
}