package com.ikoembe.model;

public class CashBox {

    public double profit=0;
    
    public void information() {
    System.out.println("USER");
    
}
    public CashBox() {

    }
    
    public CashBox (double profit) {
        this.profit=profit;
    }
    public double profitCalc(double prof) {
        this.profit+=prof;
        System.out.println(" verdient "+profit+"€");
        return profit; 
        
}
}

    
