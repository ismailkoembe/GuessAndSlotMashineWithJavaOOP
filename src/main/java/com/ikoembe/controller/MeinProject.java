/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikoembe.controller;

import com.ikoembe.model.*;
import com.ikoembe.utilities.*;
import com.ikoembe.ratselGame.*;
import com.ikoembe.slotMaschine.*;


import java.util.Scanner;

/**
 *
 * @author ismailkoembe
 */
public class MeinProject {

   public static void main(String[] args) {


        CashBox user = new CashBox();
        ATeam a1 = new ATeam("Hans", "Müller", 1000,0);
        BTeam b1 = new BTeam("Thomas", "Mann", 400,0);



        Scanner scan=new Scanner(System.in);
        System.out.println("Wer spielt? " +"Enter 'h' für Hans  "+a1.getName()+" oder enter 't' für Thomas "+b1.getName()
        );

        String antwort=scan.nextLine();
        if (antwort.equalsIgnoreCase("h")){
            System.out.println("Hallo Hans Müller.\ngehören Sie ATeam");
            System.out.println( "geld: "+a1.getGeld() );
            a1.playGame();



        } else if (antwort.equalsIgnoreCase("t")) {
            System.out.println("Hallo Thomas Mann.\ngehören Sie BTeam");
            System.out.println("geld: "+b1.getGeld());
            b1.playGame();



        }else {
            System.out.println("Überprüfen Sie Ihre Antwort ");
        }

          antwort=Reader.readString();
            if (antwort.equalsIgnoreCase(a1.getName())){
           
                a1.whoPlays();
                a1.information(a1.getName(), a1.getSurname(), a1.getGeld());
                a1.playGame();
           
            }else if (antwort.equalsIgnoreCase(b1.getName())){ 
                b1.whoPlays();
                b1.information(b1.getName(), b1.getSurname(), b1.getGeld());
                b1.playGame();

        }
    }
    public static boolean playGame(){
        boolean flag=false;
            System.out.println("Wollen Sie ein Spiel spielen? '<J>', '<N>'");
            String antw1 = Reader.readString();
         if (antw1.equalsIgnoreCase("n")){
             endGame(flag);
             playContinue(flag);
        }else if (antw1.equalsIgnoreCase("j")){
            flag =true; 
            playContinue(flag);           
        }else { 
            System.out.println("Überprüfen Sie Ihre Antwort");
            System.out.println("----------------------------");
    }    
         return flag;
    }         

    public static boolean playContinue (boolean flag ){
      while(flag) {
            System.out.println("Welches Spiel wollen Sie spielen?");
            System.out.println("\n(1)_Geben Sie für Ratespiel ein.");
            System.out.println("\n(2)_Geben Sie für Spielautomat  ein");
            System.out.println("-------------------------------------");
            
            int antw2=Reader.readInt();
            if (antw2==1){
                RatselSpiel.run(3);
                break;
            }else if (antw2==2){
                SpielAutomat.run(flag);
                break;
            }else if (antw2!=2&&antw2!=1){
            System.out.println("Überprüfen Sie Ihre Antwort");
            System.out.println("");
            }
        }
	return flag;
    }
    //überladene Methoden mit unterschiedliche eingabe
    public static boolean endGame(boolean flag){
            System.out.println("S P I E L  I S T  A U S!");
            System.out.println("");
            
        return playContinue (false);
    }
    //überladene Methoden mit unterschiedliche eingabe
    public static boolean endGame(boolean flag, String ratsel) {
        System.out.println("S P I E L  I S T  A U S!");
        System.out.println(ratsel + " spiel beendet.");
        System.out.println("");

        return playContinue(false);


    }
    }
