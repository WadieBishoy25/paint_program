/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.Controller;

import Paint.Model.Shape;
import Paint.Model.ShapeFactory;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author wadiebishoy
 */
public class AddShape implements Command{
 private  Shape s ;
    public AddShape(Shape shape) { 
        s= shape ;
    }
    

    @Override
    public ArrayList<Shape> execute(ArrayList<Shape> sList) {
       
        sList.add(s);
       
       return sList ;
    }
    
}
