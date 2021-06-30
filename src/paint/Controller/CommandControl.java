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
public class CommandControl {

    ArrayList<Shape> SList = SingleArraylistOfShapes.getInstance();
    
    private Command C ;
    public CommandControl(Command command) {
        C = command ;
    }
        
    public void Do ()
    {
        SList = C.execute(SList);
        SingleArraylistOfShapes.setInstance(SList);
    }
    
    
}
