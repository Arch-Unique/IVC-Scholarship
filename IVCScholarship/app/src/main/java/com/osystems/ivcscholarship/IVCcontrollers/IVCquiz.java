package com.osystems.ivcscholarship.IVCcontrollers;

public class IVCquiz {
    private IVCquestions[] question;
    private int score;
    private int IVCquestionIndex;

    void setIVCquiz(IVCquestions[] question){
        this.score = 0;
        this.IVCquestionIndex = 0;
        this.question = question;
    }

    boolean IVCquizEnded(){
        return this.IVCquestionIndex == this.question.length;
    }

    private IVCquestions getIVCquestionIndex(){
        return this.question[this.IVCquestionIndex];
    }

    void checkChoices(String choice){
        if(this.getIVCquestionIndex().isCorrectAnswer(choice)){
            score++;
        }
//        else{
//            score--;
//        } //Enables Negative Marking
        IVCquestionIndex++;
    }

    public int getScore() {
        return score;
    }
}
