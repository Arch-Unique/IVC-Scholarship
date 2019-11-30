package com.osystems.ivcscholarship.IVCcontrollers;

public class IVCgetQuiz {
    private String ans, question;
    private String[] choice;

    IVCgetQuiz(String ans, String question, String[] choice) {
        this.ans = ans;
        this.question = question;
        this.choice = choice;
    }

    public String getAns() {
        return ans;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getChoices() {
        return choice;
    }
}
