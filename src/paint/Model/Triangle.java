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
public class Triangle extends AbstractShape {
    
      
     
      public Triangle ()
    {
        properties = new HashMap<>() ;
        properties.put("x2",0.0);
        properties.put("x3",0.0);
        properties.put("y2",0.0);
        properties.put("y3",0.0);
    }
     
    @Override
    public Object clone() throws CloneNotSupportedException {
              AbstractShape returnObject;
        returnObject = new Triangle ();
        
        returnObject.setPosition(this.position) ;
        returnObject.setColor(this.color)  ;
        returnObject.setFillColor(this.fillColor) ;
        
        returnObject.setProperties(this.properties);
        
        return returnObject ;
    }

    @Override
    public void draw(Object canvas) {
        
        double [] x = new double[3];
        double [] y = new double[3];
        x[0] = position.getX();
        y[0]= position.getY();
        x[1] = properties.get("x2");
        x[2] = properties.get("x3");
        y[1] = properties.get("y2");
        y[2] = properties.get("y3");
        
                ((GraphicsContext) canvas).setFill(javafx.scene.paint.Color.rgb(getFillColor().getRed(), getFillColor().getGreen(), getFillColor().getBlue()));
        ((GraphicsContext) canvas).fillPolygon(x, y,3);

          ((GraphicsContext) canvas).setLineWidth(2);
        ((GraphicsContext) canvas).setStroke(javafx.scene.paint.Color.rgb(getColor().getRed(), getColor().getGreen(), getColor().getBlue()));
        ((GraphicsContext) canvas).strokePolygon(x, y,3);
        
    }
    
    
}
