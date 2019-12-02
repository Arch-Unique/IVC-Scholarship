package com.osystems.ivcscholarship.IVCcontrollers;

public class IVCtheoryQuiz {
    private IVCtheory[] question;
    private int IVCtheoryIndex;

    public void setIVCtheoryQuiz(IVCtheory[] question){
        this.IVCtheoryIndex = 0;
        this.question = question;
    }

    public boolean IVCtheoryQuizEnded(){
        return this.IVCtheoryIndex == this.question.length;
    }

    public IVCtheory getIVCtheoryQuestionIndex(){
        return this.question[this.IVCtheoryIndex];
    }
}
