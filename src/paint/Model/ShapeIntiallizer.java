/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paint.Model;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wadiebishoy
 */
public class ShapeIntiallizer {
    
    ShapeFactory SF = new ShapeFactory();
    Shape S ;
    Map<String,Double> prop ;
    
    public Map<String,Double> setProperties (String Type ,double Length)
    {
        
        prop = new HashMap<>();
        
        if (Type != null)
        {
        switch (Type)
        {
            case "circle" :
            {
                prop.put("radius", Length) ;
                break ;
            }
            case "square" :
            {
                prop.put("side", Length) ;
                                break ;

            }
            
                    
        }
        }
        
        return prop ;
    }
    
     public Map<String,Double> setProperties (String Type ,double Length1 , double Length2)
    {
        
        prop = new HashMap<>();
        
        
        if (Type != null)
        {
        switch (Type)
        {
            case "rectangle" :
            {
                prop.put("width", Length1) ;
                prop.put("height", Length2) ;
                                break ;

            }
            case "ellipse" :
            {
                prop.put("radius1", Length1) ;
                prop.put("radius2", Length2) ;    
                                break ;

            }
              case "line" :
            {
              prop.put("EndX", Length1) ;
                prop.put("EndY", Length2) ;    
                                break ;

            }      
        }
        }
        
        return prop ;
    }
     
      public Map<String,Double> setProperties (String Type ,double x2 , double y2 , double x3 , double y3 )
      {
             prop = new HashMap<>();
        
        
        if (Type != null)
        {
        switch (Type)
        {
            case "triangle" :
            {
                prop.put("x2", x2) ;
                prop.put("x3", x3) ;
                prop.put("y2",y2) ;
                prop.put("y3", y3) ;
                                break ;

            }
        }
        }
         return prop ;

      }
     
    
    public Shape getShape (String Type ,Color color , Color fillColor , Point position , Map<String,Double> properties){
        
        S = SF.getType(Type);
        
        if (S!=null)
        {
        S.setColor(color);
        S.setFillColor(fillColor);
        S.setPosition(position);
        
        S.setProperties(properties);
       
        return S ;
        }
        
        return null;
    }
}
