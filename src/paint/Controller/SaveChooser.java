/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.Controller;

/**
 *
 * @author wadiebishoy
 */
public class SaveChooser {
        Strategy S ;
        
        public void DoSave (String Path)
        {
            if (Path.endsWith(".json") || Path.endsWith(".JSON"))
            {
                S = new Jason();
                S.Save(Path);
            }
             if (Path.endsWith(".xml") || Path.endsWith(".XML"))
            {
                S = new Xml();
                S.Save(Path);
            }
            
        }
        
        public void DoLoad (String Path)
        {
            if (Path.endsWith(".json") || Path.endsWith(".JSON"))
            {
                S = new Jason();
                S.Load(Path);
            }
             if (Path.endsWith(".xml") || Path.endsWith(".XML"))
            {
                S = new Xml();
                S.Load(Path);
            }
            
        }
        
}
