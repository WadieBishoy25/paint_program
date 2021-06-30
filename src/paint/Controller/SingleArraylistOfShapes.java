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
public class SingleArraylistOfShapes {
   private static ArrayList<Shape> sList = new ArrayList<>();


   private SingleArraylistOfShapes(){}

   public static ArrayList<Shape> getInstance(){
      return sList;
   }

   public static void setInstance(ArrayList<Shape> s ){
      sList = s  ;
   }
   

}
