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
public interface Shape {
    
     public void setPosition (java.awt.Point position);
    public java.awt.Point getPosition ();
    
    public void setProperties(java.util.Map<String, Double> properties);
    public java.util.Map<String, Double> getProperties();
    
    public void setColor(java.awt.Color color);
    public java.awt.Color getColor();

    public void setFillColor(java.awt.Color color);
    public java.awt.Color getFillColor();
    
    public void draw(Object canvas);

    public Object clone() throws CloneNotSupportedException;
}
