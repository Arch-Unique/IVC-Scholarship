package com.osystems.ivcscholarship.IVCcontrollers;

public class IVCquestions {

    private String Questions, Answer;
    private String[] Choices;

    void setIVCquestions(String Question, String[] choices, String Answer){
        this.Questions = Question;
        this.Choices = choices;
        this.Answer = Answer;
    }

    boolean isCorrectAnswer(String choice){
        return choice.equals(this.Answer);
    }

    public String[] getChoices() {
        return shuffleChoices(Choices);
    }

    private String[] shuffleChoices(String[] choice){
        for (int i = 0; i < choice.length; i++) {
            int index = (int)(Math.random() * choice.length);

            String temp = choice[i];
            choice[i] = choice[index];
            choice[index] = temp;
        }
        return choice;
    }

    public String getQuestions() {
        return Questions;
    }
}
