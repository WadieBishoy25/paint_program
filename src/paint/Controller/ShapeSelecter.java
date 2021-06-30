/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.Controller;

import Paint.Model.Circle;
import Paint.Model.Shape;
import Paint.Model.ShapeDimentions;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author wadiebishoy
 */
public class ShapeSelecter {
    
    public Shape Select (double x, double y)
    {
        

        ShapeDimentions SD = new ShapeDimentions();
        Point p = new Point();
        p.setLocation(x, y);
        SD.setTarget(p);
        
        ArrayList<Shape> SList = SingleArraylistOfShapes.getInstance() ;
        
        for (int i = SList.size()-1 ; i>=0 ; i-- )
        {
            
            if ( SD.isSelected(SList.get(i)))
            {
                return SList.get(i) ;
            }

            
        }
        
        
        return null ;
    }
    
    
}
