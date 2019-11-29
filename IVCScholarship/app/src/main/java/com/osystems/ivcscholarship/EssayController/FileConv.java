package com.osystems.ivcscholarship.EssayController;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static android.content.Context.MODE_PRIVATE;

public class FileConv {
    private File file;
    private String username;
    private Context context;

    FileConv(){ //When writing a new txt file

    }

    FileConv(Context context, File file, String username){ //When uploading a docx file
        this.file = file;
        this.context = context;
        this.username = username;
    }

    private String convertTxt(){
        String txt= "";
        //parse the file to a string
        //still searching for a library that can do that effectively
        return txt;
    }

    void saveFile(String txt){
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

    void checkWordCount(){
        BufferedReader reader;
        int wordCount = 0;
        try
        {
            reader = new BufferedReader(new FileReader(file));

            String currentLine = reader.readLine();

            while (currentLine != null)
            {
                String[] words = currentLine.split(" ");
                wordCount = wordCount + words.length;
                currentLine = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        if(wordCount > 500){
            //Dont save the file
        }else{
            //save file
            saveFile(convertTxt());
        }
    }
}
