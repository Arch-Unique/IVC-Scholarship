package com.osystems.ivcscholarship.IVCcontrollers;

public class IVClevelController {
    private static final int AVERAGE_SCORE = 7;
    private static final int MAX_LEVEL = 5;
    private int current_level;

    void IVClevelController(){
        this.current_level = 0;
    }

    boolean confirmNextLevel(int score){
        return score == AVERAGE_SCORE;
    }

    void changeLevel(boolean yes){
        if(yes){
            if(isMaxLevel()){
                current_level = -1; //the level transitions to theory based questions
            }else{
                current_level++;    //the level increases
            }
        }else{
            current_level = 0;      //the level resets
        }
    }

    public int getCurrent_level() {
        return current_level;
    }

    private boolean isMaxLevel(){
        return current_level >= MAX_LEVEL;
    }
}
