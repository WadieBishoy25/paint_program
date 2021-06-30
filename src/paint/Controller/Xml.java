/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.Controller;

import Paint.Model.Shape;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author wadiebishoy
 */
public class Xml extends AbstractStrategy {

    @Override
    public void Save(String Path) {
         XStream xstream = new XStream(new StaxDriver());
       ArrayList<Shape> A = new ArrayList<>();
        A = (ArrayList<Shape>) SingleArraylistOfShapes.getInstance().clone();
        String XML = xstream.toXML(A); 
        
        SaveFile(XML, Path); 
    }

    @Override
    public void Load(String Path) {
        XStream xstream = new XStream(new StaxDriver());
       ArrayList<Shape> A = new ArrayList<>();
        A = (ArrayList<Shape>) xstream.fromXML(new File(Path));
        SingleArraylistOfShapes.setInstance(A);
    }

    
    
}
