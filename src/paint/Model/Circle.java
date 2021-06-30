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
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author wadiebishoy
 */
public class Circle extends AbstractShape {
    
    public Circle ()
    {
        properties = new HashMap<>() ;
        properties.put("radius",0.0);
    }
    
        @Override
     public Object clone() throws CloneNotSupportedException
     {
       AbstractShape returnObject;
        returnObject = new Circle ();
        
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
              2*(int) properties.get("radius").intValue(),
               2*(int) properties.get("radius").intValue());

          ((GraphicsContext) canvas).setLineWidth(2);
        ((GraphicsContext) canvas).setStroke(javafx.scene.paint.Color.rgb(getColor().getRed(), getColor().getGreen(), getColor().getBlue()));
        ((GraphicsContext) canvas).strokeOval((int) position.getX(),
                (int) position.getY(),
                2*(int) properties.get("radius").intValue(),
                2*(int) properties.get("radius").intValue());
        

    }
}


