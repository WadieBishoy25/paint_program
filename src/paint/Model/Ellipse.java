/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paint.Model;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.HashMap;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author wadiebishoy
 */
public class Ellipse extends AbstractShape  {

    public Ellipse ()
    {
        properties = new HashMap<>() ;
        properties.put("radius1",0.0);
        properties.put("radius2",0.0); 
    }
    
    
        @Override
     public Object clone() throws CloneNotSupportedException
     {
       AbstractShape returnObject;
        returnObject = new Ellipse ();
        
        returnObject.setPosition(this.position) ;
        returnObject.setColor(this.color)  ;
        returnObject.setFillColor(this.fillColor) ;
        
        returnObject.setProperties(this.properties);
        
        return returnObject ;
     }
         @Override
    public void draw(Object canvas) {
        ((GraphicsContext) canvas).setFill(javafx.scene.paint.Color.rgb(getFillColor().getRed(), getFillColor().getGreen(), getFillColor().getBlue()));
        ((GraphicsContext) canvas).fillOval((int) position.getX(),
                (int) position.getY(),
              2*(int) properties.get("radius1").intValue(),
               2*(int) properties.get("radius2").intValue());

          ((GraphicsContext) canvas).setLineWidth(2);
        ((GraphicsContext) canvas).setStroke(javafx.scene.paint.Color.rgb(getColor().getRed(), getColor().getGreen(), getColor().getBlue()));
        ((GraphicsContext) canvas).strokeOval((int) position.getX(),
                (int) position.getY(),
                2*(int) properties.get("radius1").intValue(),
                2*(int) properties.get("radius2").intValue());
        

    }
}
