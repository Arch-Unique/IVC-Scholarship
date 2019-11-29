package com.osystems.ivcscholarship.EssayController;

import android.content.Context;

import com.osystems.ivcscholarship.IVCcontrollers.IVC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileConv {
    private File file;
    private String username;
    private Context context;

    public FileConv(){ //When writing a new txt file

    }

    public FileConv(Context context, File file, String username){ //When uploading a docx file
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

    public void checkWordCount(){
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
            IVC.saveFile(context, convertTxt(), username);
        }
    }
}
