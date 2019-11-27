package com.osystems.ivcscholarship.IVCcontrollers;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Locale;

public class IVCtimer {
    private TextView textView;

    void setTimer(long time,TextView v){
        this.textView = v;
        new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long minutes = millisUntilFinished / 60 / 1000;
                long seconds = millisUntilFinished / 1000 % 60;
                String time = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
                textView.setText(time);
            }

            @Override
            public void onFinish() {
                //put function here
            }
        }.start();
    }
}
