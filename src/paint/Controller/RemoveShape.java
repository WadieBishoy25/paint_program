/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.Controller;

import Paint.Model.Shape;
import Paint.Model.ShapeFactory;
import java.util.ArrayList;

/**
 *
 * @author wadiebishoy
 */
public class RemoveShape implements Command{

   private  Shape s ;
    public RemoveShape(Shape shape) { 
        s= shape ;
    }

    @Override
    public ArrayList<Shape> execute(ArrayList<Shape> sList) {
        for (int i = 0 ; i<sList.size() ; i++ )
        {
           if (sList.get(i) == s)
           {
               sList.remove(i);
               break;
           }
        }
        return sList ;
    }
    
}
