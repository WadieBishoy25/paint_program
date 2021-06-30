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
public class SingleCareTaker {
       private static CareTaker C = new CareTaker();


   private SingleCareTaker(){}

   public static CareTaker getInstance(){
      return C;
   }

}
