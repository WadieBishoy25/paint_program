/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.Controller;

import Paint.Model.Shape;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wadiebishoy
 */
public class Jason extends AbstractStrategy {

    @Override
    public void Save(String Path) {
        XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
        ArrayList<Shape> A = new ArrayList<>();
        A = (ArrayList<Shape>) SingleArraylistOfShapes.getInstance().clone();
        String Json = xstream.toXML(A); 
        
        SaveFile(Json, Path); 
    }

    
    @Override
    public void Load(String Path) {
         
        XStream json = new XStream(new JettisonMappedXmlDriver());
        ArrayList<Shape> A = new ArrayList<>();
        File f = new File(Path);
        A = (ArrayList<Shape>) json.fromXML(f);
        SingleArraylistOfShapes.setInstance(A);
    }
    
}
