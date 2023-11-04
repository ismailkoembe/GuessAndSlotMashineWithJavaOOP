/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikoembe.randomGame;
import com.ikoembe.controller.*;
import com.ikoembe.model.*;
import com.ikoembe.utilities.*;


/**
 *
 * @author ikoembe
 */

    public class RatselSpiel {
    
    public RatselSpiel() {}
       
        public static boolean run(int chance) throws InterruptedException {
            CashBox user = new CashBox();
            ATeam a1 = new ATeam();
            boolean flag= true;
            System.out.println("+++++++++Welcome to the Random Game+++++++++");
            System.out.println(" Dial the number(1-20) and try to guess my number.");
            System.out.println("You can try only three times. Number: ???");
            int geheimnis =(int) (Math.random()*20+1);
            //System.out.println("-------"+geheimnis+"-----------");//for Testing
 
            do {
            int antw3=Reader.readInt();
        
            if (antw3==geheimnis) {

   
                System.out.println("**************CONGRATULATIONS************"+"/nYou won
                                    + "My Number was"+ geheimnis);
                user.profit=user.profitCalc(chance*geheimnis);
                flag=false;            
                MyProject.playGame();
                break;
            }
            else if(chance >= 1) {
                chance--;
                    if (chance==0) {        
                    flag =false;
                    System.out.println("My Number was "+geheimnis);
                    user.profit=chance*geheimnis;
                    user.profitCalc(chance*geheimnis);
                    MyProject.endGame(flag, "Random Game");
                    MyProject.playGame();
                    break;                
            }else
                System.out.println("Try again");
                System.out.println("You have only "+chance+ " Chances");
                
                }
            }while (flag);
            MyProject.playContinue(flag);
            return false;
        } 
  
}
 
