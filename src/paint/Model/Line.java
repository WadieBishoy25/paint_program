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
public class Line extends AbstractShape {
    
     
      public Line ()
    {
        properties = new HashMap<>() ;
        properties.put("EndX",0.0);
        properties.put("EndY",0.0);
    }
     
    @Override
    public Object clone() throws CloneNotSupportedException {
              AbstractShape returnObject;
        returnObject = new Line ();
        
        returnObject.setPosition(this.position) ;
        returnObject.setColor(this.color)  ;
        returnObject.setFillColor(this.fillColor) ;
        
        returnObject.setProperties(this.properties);
        
        return returnObject ;
    }

    @Override
    public void draw(Object canvas) {
        
          ((GraphicsContext) canvas).setLineWidth(4);
        ((GraphicsContext) canvas).setStroke(javafx.scene.paint.Color.rgb(getColor().getRed(), getColor().getGreen(), getColor().getBlue()));
        ((GraphicsContext) canvas).strokeLine((int) position.getX(),
                (int) position.getY(),
               (int) properties.get("EndX").intValue(),
                (int) properties.get("EndY").intValue());
    }
    
    
}
