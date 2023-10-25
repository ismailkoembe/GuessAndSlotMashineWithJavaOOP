package com.ikoembe.model;
import com.ikoembe.controller.*;

public class BTeam extends ATeam {

public BTeam() {}

@Override
public void information() {
}

@Override
public void whoPlays() {
}

@Override
public void playGame() {
    MyProject.playGame();
}

public BTeam (String name, String surname, double geld, double profit) {
        super(name, surname, geld, profit);   
}



    
}
