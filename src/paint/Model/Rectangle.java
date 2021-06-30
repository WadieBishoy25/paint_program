/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paint.Model;

import java.util.HashMap;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author wadiebishoy
 */
public class Rectangle extends AbstractShape {

     public Rectangle ()
    {
        properties = new HashMap<>() ;
        properties.put("width",0.0);
        properties.put("height",0.0);
    }
     
    @Override
    public Object clone() throws CloneNotSupportedException {
              AbstractShape returnObject;
        returnObject = new Rectangle ();
        
        returnObject.setPosition(this.position) ;
        returnObject.setColor(this.color)  ;
        returnObject.setFillColor(this.fillColor) ;
        
        returnObject.setProperties(this.properties);
        
        return returnObject ;
    }

    @Override
    public void draw(Object canvas) {
         ((GraphicsContext) canvas).setFill(javafx.scene.paint.Color.rgb(getFillColor().getRed(), getFillColor().getGreen(), getFillColor().getBlue()));
        ((GraphicsContext) canvas).fillRect((int) position.getX(),
                (int) position.getY(),
              (int) properties.get("width").intValue(),
               (int) properties.get("height").intValue());
        
          ((GraphicsContext) canvas).setLineWidth(2);

                ((GraphicsContext) canvas).setStroke(javafx.scene.paint.Color.rgb(getColor().getRed(), getColor().getGreen(), getColor().getBlue()));
        ((GraphicsContext) canvas).strokeRect((int) position.getX(),
                (int) position.getY(),
                (int) properties.get("width").intValue(),
                (int) properties.get("height").intValue());
    }
    
}
