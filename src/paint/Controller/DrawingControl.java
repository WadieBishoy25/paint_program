/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.Controller;

import Paint.Model.Shape;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
/**
 *
 * @author wadiebishoy
 */
public class DrawingControl implements DrawingEngine {
    CommandControl C ;
    UndoRedoControl UR = new UndoRedoControl();
    SaveChooser SC  = new SaveChooser();

    public DrawingControl() {
        UR.SaveState();
    }
    
    
    
    @Override
    public void refresh(Object canvas) {
        for (Shape S : SingleArraylistOfShapes.getInstance())
        {
            S.draw(canvas);
        }
        
    }

    @Override
    public void addShape(Shape shape) {
        C = new CommandControl(new AddShape(shape));
        C.Do();
        UR.SaveState();
    }

    @Override
    public void removeShape(Shape shape) {

        C = new CommandControl(new RemoveShape(shape));
        C.Do();
        UR.SaveState();

    }

    @Override
    public void updateShape(Shape oldShape, Shape newShape) {

        C = new CommandControl(new UpdateShape(oldShape, newShape));
        C.Do();
        UR.SaveState();

    }

    @Override
    public Shape[] getShapes() {
        
        Shape [] SA;
        SA = new Shape[1] ;
        SA = C.SList.toArray(SA);
        return SA ;
    }

    @Override
    public void undo() {
       UR.undo();
    }

    @Override
    public void redo() {
        UR.redo();
    }

    @Override
    public void save(String path) {
        SC.DoSave(path);
    }

    @Override
    public void load(String path) {
        SC.DoLoad(path);
    }
    
}
