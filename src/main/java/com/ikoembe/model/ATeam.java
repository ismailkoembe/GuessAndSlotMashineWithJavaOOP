package com.ikoembe.model;

import com.ikoembe.controller.*;

public class ATeam extends CashBox{//inherited name from User class
private String name; //encapsulating
private String surname;
private double geld;

public ATeam () {}//Constructor

public void information(String name, String surname, double geld) {

    System.out.println(name+" "+surname+" has "+geld+"€");
}


public void whoPlays() {

    System.out.println(name+" is from A Team");
}

public void playGame() throws InterruptedException {
    MyProject.playGame();
}

public ATeam(String name, String surname, double geld,double profit) {
    super(profit);
    this.name=name;
    this.surname=surname;
    this.geld=geld;
 
}

    public String getName() {

    return name;
    }

    public void setName(String name) {
        this.name = name;
    }

public String getSurname() {
    return surname;
}
public void setSurname(String surname) {
    this.surname = surname;
}
public double getGeld() {
    return geld;
}
public void setGeld(double geld) {
    this.geld = geld;
}

}