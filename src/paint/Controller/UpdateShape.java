/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.Controller;

import Paint.Model.Shape;
import java.util.ArrayList;

/**
 *
 * @author wadiebishoy
 */
public class UpdateShape implements Command{

       private  Shape sOld , sNew ;

    public UpdateShape(Shape sOld, Shape sNew) {
        this.sOld = sOld;
        this.sNew = sNew;
    }

    @Override
    public ArrayList<Shape> execute(ArrayList<Shape> sList) {
         for (int i = 0 ; i<sList.size() ; i++ )
        {
           if (sList.get(i) == sOld)
           {
               sList.set(i, sNew);
               break;
           }
        }   
    
    return sList ;
    }

}
