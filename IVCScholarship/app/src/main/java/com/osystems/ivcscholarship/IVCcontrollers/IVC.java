package com.osystems.ivcscholarship.IVCcontrollers;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

public class IVC {
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

    public static ArrayList<IVCgetQuiz> storeQuiz(JSONObject jsonObject){
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


}
