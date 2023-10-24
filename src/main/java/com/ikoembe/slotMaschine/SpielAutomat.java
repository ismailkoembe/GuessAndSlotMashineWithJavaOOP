/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikoembe.slotMaschine;
import com.ikoembe.utilities.*;
import com.ikoembe.controller.*;
import com.ikoembe.model.*;
import java.util.Random;

/**
 *
 * @author ikoembe
 */
    public class SpielAutomat {

    static double amount;
    static double tAmount;
    static double tWinMoney;    
    
    public SpielAutomat() {
      
    }
    
    public static boolean run(boolean flag){

        while(flag) {
            System.out.println("Geben Sie den Geldbetrag ein, den Sie in "
                        + "den Spielautomaten stecken möchten.");
            
            amount=Reader.readDouble();  
            tAmount+=amount;        
            tWinMoney+= playTheGame(amount, tWinMoney);
                         
            playAgain(tWinMoney, tAmount);
         
            flag=false;
            MeinProject.playContinue(flag);
            break;
        }   
                
        return flag;
        
    }
                                            
    public static double playTheGame(double amountMethod, double tWinMethod) {
        CashBox user = new CashBox();
     
    String [] obst={"Kirschen", "Orangen", "Pflaumen","Glocken","Melonen","Birne"};
        
    String [] nummer= new String[3];
        
        int random;
        Random rn=new Random(); 
        
        for (int i=0;i<3;i++) {
            
            random = rn.nextInt(6);
            
            nummer[i]=obst[random];
            
            System.out.print(nummer[i]+"  ");   
        }
        
        System.out.println();

        if (nummer[0].equals(nummer[1]) && nummer[0].equals(nummer[2])) {
            System.out.println("Glückwunsch, Sie haben gewonnen : "
             + (3*amountMethod)+ " ");
            tWinMethod+=3*amountMethod;
            user.profitCalc(tWinMethod);
         
        }else if (nummer[0].equals(nummer[1]) || nummer[0].equals(nummer[2]) || nummer[1].equals(nummer[2])) {
            System.out.println("Glückwunsch, Sie haben gewonnen : "+ (2*amountMethod)+"€");
            tWinMethod+=2*amountMethod;
            user.profitCalc(tWinMethod);
   
        }else {
            System.out.println("Oooops! :( Sie verdienen kein Geld.");
            user.profitCalc(-amountMethod);
        }
        
        return tWinMethod;
    }
    
                                           
    public static boolean playAgain(double tWinMoney, double tAmountMethod) {
        boolean flag=false; 
        System.out.println("Wollen Sie noch mal spielen? '<J>', '<N>'");
        String antwort= Reader.readString();
        if (antwort.equalsIgnoreCase("n")) {
                                           
        System.out.println("Eingabe: " + tAmountMethod+" and Ausgabe "+ (tWinMoney)+
                " Differenz= "+ (tWinMoney-tAmountMethod));
        //kasada kalan parayı hesap et. dikkate al.
                         
        flag=false;
            MeinProject.endGame(flag);
                                
        } 
        if (antwort.equalsIgnoreCase("j")) { 

            flag=true;
        }   
            return run(flag);

        }
    
}