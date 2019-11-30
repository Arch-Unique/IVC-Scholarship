package com.osystems.ivcscholarship.IVCcontrollers;

public class IVCquiz {
    private IVCquestions[] question;
    private int score;
    private int IVCquestionIndex;

    public void setIVCquiz(IVCquestions[] question){
        this.score = 0;
        this.IVCquestionIndex = 0;
        this.question = question;
    }

    public boolean IVCquizEnded(){
        return this.IVCquestionIndex == this.question.length;
    }

    public IVCquestions getIVCquestionIndex(){
        return this.question[this.IVCquestionIndex];
    }

    public void checkChoices(String choice){
        if(choice.isEmpty() || choice == null){
            IVCquestionIndex++;
        }else {
            if (this.getIVCquestionIndex().isCorrectAnswer(choice)) {
                score++;
            }
//        else{
//            score--;
//        } //Enables Negative Marking
            IVCquestionIndex++;
        }
    }

    public int getScore() {
        return score;
    }
}
