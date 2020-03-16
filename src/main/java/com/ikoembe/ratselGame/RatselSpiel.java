/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikoembe.ratselGame;
import com.ikoembe.controller.*;
import com.ikoembe.model.*;
import com.ikoembe.utilities.*;


/**
 *
 * @author ikoembe
 */

    public class RatselSpiel {
    
    public RatselSpiel() {}
       
        public static boolean run(int chance){
            CashBox user = new CashBox();
            ATeam a1 = new ATeam();
            boolean flag= true;
            System.out.println("Willkommen Ratselspilen");
            System.out.println(" Wahlen Sie die Nummer(1-20) und versuchen Sie, "
                    + "meine Nummer zu erraten. ");
            System.out.println( "Sie konnen es nur dreimal versuchen. Nummer: ???");
            int geheimnis =(int) (Math.random()*20+1);
            //System.out.println("-------"+geheimnis+"-----------");//for Testing
 
            do {
            int antw3=Reader.readInt();
        
            if (antw3==geheimnis) {
                System.out.println("Glückwunsch, Sie haben gewonnen. "
                                    + "Mein Nummer war "+ geheimnis);
                user.profit=user.profitCalc(chance*geheimnis);
                flag=false;            
                MeinProject.playGame();
                break;
            }
            else if(chance >= 1) {
                chance--;
                    if (chance==0) {        
                    flag =false;
                    System.out.println("Mein Nummer war "+geheimnis);
                    user.profit=chance*geheimnis;
                    user.profitCalc(chance*geheimnis);
                    MeinProject.endGame(flag, "RatselSpiel");
                    MeinProject.playGame();
                    break;                
            }else
                System.out.println("Versuche es noch einmal");
                System.out.println("Sie haben "+chance+ " Chances");
                
                }
            }while (flag);
            MeinProject.playContinue(flag);
            return false;
        } 
  
}
 
