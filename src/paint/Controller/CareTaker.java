/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.Controller;

import Paint.Model.Shape;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author wadiebishoy
 */
public class CareTaker {
    private Stack undoList = new Stack<>();
    private Stack redoList = new Stack<>();
    
   public void add(Memento state){
      undoList.push(state);
      redoList.clear();
   }
   
   public Memento undo(){
      
       if (undoList.size() >= 2)
       {
       redoList.push(undoList.pop());
       return (Memento) undoList.peek();
       }
       return (Memento) undoList.peek() ;
   }
   
      public Memento redo(){
     
          if (!redoList.empty())
          {
       Memento m ;
       m = (Memento) redoList.pop();
       undoList.push(m);
       return m ;
          }
          return (Memento) undoList.peek() ;
   }
      
      public void showUndolist ()
      {
        for (Object undoList1 : undoList) {
            
            System.out.println(undoList1.toString());
        }
                    System.out.println("");

      }
      
      public void showRedolist ()
      {
        for (Object undoList1 : redoList) {
            
            System.out.println(undoList1.toString());
        }
                    System.out.println("");

      }
}
