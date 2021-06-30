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
import java.awt.Color;
import java.awt.Point;
import java.util.Map;

/**
 *
 * @author wadiebishoy
 */
public abstract class AbstractShape implements Shape {
    
    protected Point position ;
    protected Map<String, Double> properties ;
    protected Color color ;
    protected Color fillColor ;

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Map<String, Double> getProperties() {
        return properties;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        this.properties = properties;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    
    @Override
     public abstract Object clone() throws CloneNotSupportedException ;

}
