/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.Controller;

import Paint.Model.Shape;
import java.util.ArrayList;

/**
 *
 * @author wadiebishoy
 */
public class UndoRedoControl {
    private CareTaker careTaker = SingleCareTaker.getInstance();
    private Originator originator =new Originator();
            ArrayList<Shape> A = new ArrayList<>();

    public void SaveState ()
    {
        A = (ArrayList<Shape>) SingleArraylistOfShapes.getInstance().clone();
        careTaker.add(originator.saveStateToMemento(A));
    }
        public void undo ()
    {
        
          A = (ArrayList<Shape>) originator.getStateFromMemento(careTaker.undo()).clone() ;
        SingleArraylistOfShapes.setInstance(A); 
        
              
    }
       public void redo ()
    {
         A = (ArrayList<Shape>) originator.getStateFromMemento(careTaker.redo()).clone() ;
        SingleArraylistOfShapes.setInstance(A); 
    }
}
