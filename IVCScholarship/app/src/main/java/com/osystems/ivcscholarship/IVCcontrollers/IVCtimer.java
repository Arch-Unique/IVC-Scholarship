package com.osystems.ivcscholarship.IVCcontrollers;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Locale;

public class IVCtimer {

    static void setTimer(long time,final TextView v){
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
                //put function here
            }
        }.start();
    }
}
