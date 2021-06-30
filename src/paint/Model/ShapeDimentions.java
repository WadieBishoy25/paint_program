/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paint.Model;

import java.awt.Point;

/**
 *
 * @author wadiebishoy
 */
public class ShapeDimentions {
    
    Point center = new Point();
    private Point Target ;

    public void setTarget(Point Target) {
        this.Target = Target;
    }
   
    public Boolean isSelected (Shape S)
    {
            if (S instanceof Circle)
            {
               center .setLocation(((Circle) S).getPosition().getX() + ((Circle) S).getProperties().get("radius"),((Circle) S).getPosition().getY()+ ((Circle) S).getProperties().get("radius")); 

               if (Target.distance(center) <= ((Circle) S).getProperties().get("radius"))
               {
                   return true ;
               }
              else
                   return false ;
            }
            if (S instanceof Square)
            {
                 if ((Target.getX()-((Square) S).getProperties().get("side") <= ((Square)S).getPosition().getX()) && Target.getX()>= ((Square)S).getPosition().getX()&& (Target.getY()-((Square) S).getProperties().get("side") <= ((Square)S).getPosition().getY()) && Target.getY()>= ((Square)S).getPosition().getY()  )
               {
                   return true ;
               }
                 return false ;
            }
            if (S instanceof Rectangle)
            {
                 if ((Target.getX()-((Rectangle) S).getProperties().get("width") <= ((Rectangle)S).getPosition().getX()) && Target.getX()>= ((Rectangle)S).getPosition().getX() && (Target.getY()-((Rectangle) S).getProperties().get("height") <= ((Rectangle)S).getPosition().getY()) &&  Target.getY()>= ((Rectangle)S).getPosition().getY() )
               {
                   return true ;
               }
                 return false ;
            }
            if (S instanceof Line)
            {
                // refrence
                // end point not center .. but to not make another point
                center.setLocation(((Line) S).getProperties().get("EndX"), ((Line) S).getProperties().get("EndY"));
                if ((int)Target.distance(center) + (int)Target.distance(((Line) S).getPosition()) -(int)center.distance(((Line) S).getPosition()) < 3 && (int)Target.distance(center) + (int)Target.distance(((Line) S).getPosition()) -(int)center.distance(((Line) S).getPosition()) > -3 )
                {
                   return true ;
               }
                 return false ;    
            }
            if (S instanceof Triangle)
            {
                
                // refrence https://www.geeksforgeeks.org/check-whether-a-given-point-lies-inside-a-triangle-or-not/
                
                Point p1 = new Point() ;
                Point p2 = new Point() ;
                Point p3 = new Point() ;

                p1.setLocation(((Triangle)S).getPosition());
                p2.setLocation(((Triangle)S).getProperties().get("x2") , ((Triangle)S).getProperties().get("y2"));
                p3.setLocation(((Triangle)S).getProperties().get("x3") , ((Triangle)S).getProperties().get("y3"));
                   if ( TriangleArea(p1, p2, p3) == ( TriangleArea(p1, p2, Target) + TriangleArea(p1, Target, p3) + TriangleArea(Target, p2, p3)) )
                {
                  return true ;
               }
                 return false ;    
            }
            if (S instanceof Ellipse)
            {
                // refrence
                 center .setLocation(((Ellipse) S).getPosition().getX() + ((Ellipse) S).getProperties().get("radius1"),((Ellipse) S).getPosition().getY()+ ((Ellipse) S).getProperties().get("radius2")); 

               if ((((Math.pow(Target.getX() - center.getX(), 2))/(Math.pow( ((Ellipse) S).getProperties().get("radius1"), 2)))+((Math.pow(Target.getY() - center.getY(), 2))/(Math.pow( ((Ellipse) S).getProperties().get("radius2"), 2)))) <= 1 )
               {
                   return true ;
               }
              else
                   return false ;
            }
            
            return false ;
    }
    
    
    public double TriangleArea ( Point p1 , Point p2 , Point p3 )
    {
        
        return  Math.abs(((p1.getX()*(p2.getY() - p3.getY())) + (p2.getX() *(p3.getY() - p1.getY())) + (p3.getX() * (p1.getY()- p2.getY())))/2.0 ) ; 

    }
    
}
