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
    
    public static boolean run(boolean flag) throws InterruptedException {

        while(flag) {
            System.out.println("Enter the amount of money you want to put into the slot machine.");
            
            amount=Reader.readDouble();  
            tAmount+=amount;        
            tWinMoney+= playTheGame(amount, tWinMoney);
                         
            playAgain(tWinMoney, tAmount);
         
            flag=false;
            MyProject.playContinue(flag);
            break;
        }   
                
        return flag;
        
    }
                                            
    public static double playTheGame(double amountMethod, double tWinMethod) {
        CashBox user = new CashBox();
     
    String [] fruits={"Cherries", "Oranges", "Plums", "Bells", "Melons", "Pear"};
        
    String [] nummer= new String[3];
        
        int random;
        Random rn=new Random(); 
        
        for (int i=0;i<3;i++) {
            
            random = rn.nextInt(5);
            
            nummer[i]=fruits[random];
            
            System.out.print(nummer[i]+"  ");   
        }
        
        System.out.println();

        if (nummer[0].equals(nummer[1]) && nummer[0].equals(nummer[2])) {
            System.out.println("***********Congratulations***************"+"/nYou won "
             + (3*amountMethod)+ " ");
            tWinMethod+=3*amountMethod;
            user.profitCalc(tWinMethod);
         
        }else if (nummer[0].equals(nummer[1]) || nummer[0].equals(nummer[2]) || nummer[1].equals(nummer[2])) {
            System.out.println("**************Congratulations************"+"/nYou won  "+ (2*amountMethod)+"€");
            tWinMethod+=2*amountMethod;
            user.profitCalc(tWinMethod);
   
        }else {
            System.out.println("Oooops! :( You do not earn money.");
            user.profitCalc(-amountMethod);
        }
        
        return tWinMethod;
    }
    
                                           
    public static boolean playAgain(double tWinMoney, double tAmountMethod) throws InterruptedException {
        boolean flag=false; 
        System.out.println("Do you want to play again? '<Y>', '<N>'");
        String antwort= Reader.readString();
        if (antwort.equalsIgnoreCase("n")) {
                                           
        System.out.println("Input: " + tAmountMethod+" and output "+ tWinMoney+
                " Difference= "+ (tAmountMethod-tWinMoney));
                         
        flag=false;
            MyProject.endGame(flag);
                                
        } 
        if (antwort.equalsIgnoreCase("y")) {

            flag=true;
        }   
            return run(flag);

        }
    
}