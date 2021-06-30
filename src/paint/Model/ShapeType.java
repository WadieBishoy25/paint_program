/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paint.Model;

/**
 *
 * @author wadiebishoy
 */
public class ShapeType {
    
    public String getType (Shape s)
    {
        if (s instanceof Circle)
            return "circle" ;
        
        if (s instanceof Square)
            return "square" ;
        if (s instanceof Ellipse)
            return "ellipse" ;
        if (s instanceof Line)
            return "line" ;
        if (s instanceof Rectangle)
            return "rectangle" ;
        if (s instanceof Triangle)
            return "triangle" ;
        
        return null ;
    }
}
