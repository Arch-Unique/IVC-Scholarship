package com.osystems.ivcscholarship;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.osystems.ivcscholarship.IVCcontrollers.IVC;
import com.osystems.ivcscholarship.IVCcontrollers.IVCgetQuiz;
import com.osystems.ivcscholarship.IVCcontrollers.IVClevelController;
import com.osystems.ivcscholarship.IVCcontrollers.IVCquestions;
import com.osystems.ivcscholarship.IVCcontrollers.IVCquiz;

import java.util.ArrayList;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {
    IVClevelController ilc;
    IVCquestions[] ivCquestions;
    IVCquiz ivCquiz;
    private String ques, ans;
    private String[] choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        init();
        initQuestions();
        populate();
    }

    private void init(){
        //declarations goes here

        ilc = new IVClevelController();
        ivCquiz = new IVCquiz();
        ivCquestions = new IVCquestions[getQuestions().size()];
    }

    private ArrayList<? extends IVCgetQuiz> getQuestions(){
        return getIntent().getParcelableArrayListExtra("getquizTag");
    }

    private void initQuestions(){
        for (int i = 0; i < ivCquestions.length; i++) {
            ivCquestions[i] = new IVCquestions();
            ques = getQuestions().get(i).getQuestion();
            ans = getQuestions().get(i).getAns();
            choice = getQuestions().get(i).getChoices();

            ivCquestions[i].setIVCquestions(ques,choice,ans);
        }
        ivCquiz.setIVCquiz(ivCquestions);
    }

    private void populate(){
        if(ivCquiz.IVCquizEnded()){
            //TODO showScore() (next level function)
        }else{
            //show questions
            // TextView.setText(ivCquiz.getIVCquestionIndex().getQuestions());
            // setTimer();
            String choices[] = ivCquiz.getIVCquestionIndex().getChoices();
            if(choices != null){
                for (int i = 0; i < choices.length; i++) {
                    // Button[i].setText(choices[i]);
                    // guess(Button[i], choices[i]);
                }
            }
            //TODO showProgress();
        }
    }

    public void guess(View v, final String choice){
        if(choice.isEmpty() || v == null || choice == null){
            nextQuestion(choice);
        }else {
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    nextQuestion(choice);
                }
            });
        }
    }

    private void nextQuestion(String choice){
        ivCquiz.checkChoices(choice);
        populate();
    }

    private void setTimer(long time,final TextView v){
        new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long minutes = millisUntilFinished / 60 / 1000;
                long seconds = millisUntilFinished / 1000 % 60;
                String time = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
                v.setText(time);
            }

            @Override
            public void onFinish() {
                guess(null, null);
                //put function here
            }
        }.start();
    }

    /*
    For showScore()

    - get the score using getScore from the IVCquiz class
    - get the total score by doing some calculations with the time - beta
    - save score , currentLevel, total time used to finish, username etc  in the server

    For il.changeLevel()
    - if the total score > AVERAGE_SCORE ,
    - (Check for hacks >> compare currentLevel in the server with currentLevel(here) + 1
    - to see if it gives a diff of 1)
    - the method changeLevel with args[yes]
    - would be called else args[no] which will reset the current level to 0

    Finally call the method to receive the questions based on the current level
    - has to be static

     */

}
