/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author wadiebishoy
 */
public abstract class AbstractStrategy implements Strategy {
        
    public void SaveFile (String content , String Path)
    {
        File file = new File(Path);
         try {
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
