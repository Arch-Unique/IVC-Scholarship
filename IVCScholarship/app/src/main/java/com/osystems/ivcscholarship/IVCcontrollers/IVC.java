package com.osystems.ivcscholarship.IVCcontrollers;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;

public class IVC {

    public static void setTimer(long time,final TextView v){
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

    public static void saveFile(Context context, String txt, String username){
        String filename = username + ".txt";
        FileOutputStream fOut;
        try {
            fOut = context.openFileOutput(filename, MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            osw.write(txt);
            osw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
