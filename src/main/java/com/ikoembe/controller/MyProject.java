/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikoembe.controller;

import com.ikoembe.model.*;
import com.ikoembe.utilities.*;
import com.ikoembe.randomGame.RatselSpiel;
import com.ikoembe.slotMaschine.*;


/**
 *
 * @author ismailkoembe
 */
public class MyProject {

    public static void main(String[] args) throws InterruptedException {

            CashBox user = new CashBox();



        ATeam a1 = new ATeam("Hans", "Müller", 1000, 0);
            BTeam b1 = new BTeam("Thomas", "Mann", 400, 0);

        String antwort;


        do { // Buraya while do döngüsü eklenerek, yanlis isim girildiginde tekrar basa dönmesi saglandi.

            System.out.println("Who plays? " + a1.getName() + " or " + b1.getName());

            antwort = Reader.readString();
            if (antwort.equalsIgnoreCase(a1.getName())) {
                a1.whoPlays();
                a1.information(a1.getName(), a1.getSurname(), a1.getGeld());
                a1.playGame();

            } else if (antwort.equalsIgnoreCase(b1.getName())) {
                b1.whoPlays();
                b1.information(b1.getName(), b1.getSurname(), b1.getGeld());
                b1.playGame();
            } else {
                System.out.println("Invalid Entry. Please try again.");

            }
        }
        while (!(antwort.equalsIgnoreCase(a1.getName()) && antwort.equalsIgnoreCase(b1.getName())));

    }

    public static boolean playGame() throws InterruptedException {
        boolean flag=false;
            System.out.println("Do you want to play a game? '<Y>', '<N>'");
            String antw1 = Reader.readString();
         if (antw1.equalsIgnoreCase("n")){
             endGame(flag);
             playContinue(flag);
        }else if (antw1.equalsIgnoreCase("y")){
            flag =true; 
            playContinue(flag);           
        }else { 
            System.out.println("Check your answer");
            System.out.println("----------------------------");
    }    
         return flag;
    }         

    public static boolean playContinue (boolean flag ) throws InterruptedException {
      while(flag) {
            System.out.println("What game dou you want to play?");
            System.out.println("For Random Game enter <1>.");
            System.out.println("For Slot machine enter <2>");
            System.out.println("-------------------------------------");
            
            int antw2=Reader.readInt();
            if (antw2==1){
                RatselSpiel.run(3);
                break;
            }else if (antw2==2){
                SpielAutomat.run(flag);
                break;
            }else if (antw2!=2&&antw2!=1){
            System.out.println("Check your answer.");
            System.out.println("");
            }
        }
	return flag;
    }
    //überladene Methoden mit unterschiedliche eingabe
    public static boolean endGame(boolean flag) throws InterruptedException {
            System.out.println("+++++++++GAME OVER++++++++++");
            System.out.println("");
            
        return playContinue (false);
    }
    //überladene Methoden mit unterschiedliche eingabe
    public static boolean endGame(boolean flag, String ratsel) throws InterruptedException {
            System.out.println("+++++++++GAME OVER++++++++++");
            System.out.println(ratsel+"game is over");
            System.out.println("");

         
        return playContinue (false);
    }
    


    
}
  
