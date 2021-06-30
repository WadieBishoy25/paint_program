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
public class ShapeFactory {
    
    private Shape selected ;
    
    public Shape getType (String Type )
    {
        switch (Type)
        {
            case ("circle")  : 
            {
            selected = new Circle();
            break ;
            }
            case ("rectangle")  : 
            {
            selected = new Rectangle();
            break ;
            }
            case ("square")  : 
            {
            selected = new Square();
            break ;
            }
            case ("ellipse")  : 
            {
            selected = new Ellipse();
            break ;
            }
            case ("line")  : 
            {
            selected = new Line();
            break ;
            }    
             case ("triangle")  : 
            {
            selected = new Triangle();
            break ;
            }         
            default:
                return null;
        }
        
        return selected ;
    }
}
