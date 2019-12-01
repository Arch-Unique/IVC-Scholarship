package com.osystems.ivcscholarship.IVCcontrollers;

import android.content.Context;
import android.content.Intent;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ConnectionQuality;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ConnectionQualityChangeListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.osystems.ivcscholarship.QuizActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class IVC {

    private static ArrayList<IVCgetQuiz> gQuiz;

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

    private static ArrayList<IVCgetQuiz> storeQuiz(JSONObject jsonObject){
            JSONArray jsonArray;
            JSONObject innerJsonObject;
            String ans, ques;
            String[] choice;

            ArrayList<IVCgetQuiz> quiz = new ArrayList<>();
        try {
            jsonArray = jsonObject.getJSONArray("example");
            for (int i = 0; i < jsonArray.length(); i++) {
                innerJsonObject = jsonArray.getJSONObject(i);
                ques = innerJsonObject.getString("Question");
                ans = innerJsonObject.getString("Answer");
                choice = getChoice(innerJsonObject.getJSONArray("Options"));
                quiz.add(new IVCgetQuiz(ans, ques, choice));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return quiz;
    }

    private static String[] getChoice(JSONArray jsonArray){
        String[] choice = new String[4];
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                choice[i] = jsonArray.getString(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return choice;
    }

    public static ArrayList<IVCgetQuiz> getQuizServer(String level){

        AndroidNetworking.setConnectionQualityChangeListener(new ConnectionQualityChangeListener() {
            @Override
            public void onChange(ConnectionQuality currentConnectionQuality, int currentBandwidth) {
                if(currentConnectionQuality == ConnectionQuality.UNKNOWN){
                    //cancel request
                    AndroidNetworking.forceCancelAll();
                    //toast a network connection error message
                }
            }
        });
        AndroidNetworking.post("url") //put URL
        .addBodyParameter("level", level)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        gQuiz = storeQuiz(response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        //report error
                    }
                });
        return gQuiz;
    }

    public static void initGetQuizServer(Context context){
        context.startActivity(new Intent(context, QuizActivity.class).putExtra("getquizTag", getQuizServer("0")));
    }


}
