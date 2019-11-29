package com.osystems.ivcscholarship.EssayController;

import android.content.Context;
import android.widget.EditText;

import com.osystems.ivcscholarship.IVCcontrollers.IVC;

public class EssayConversion {
    private String essayTextTitle;
    private String essayTextDescription;

    public EssayConversion(EditText essayTitle, EditText essayDescription) {
        this.essayTextTitle = essayTitle.getText().toString();
        this.essayTextDescription = essayDescription.getText().toString();
    }

    private String buildString(){
        return essayTextTitle + newLine() + essayTextDescription;
    }

    private String newLine(){
        return "\r\n\r\n";
    }

    void convertEssay(Context context, String username){
        IVC.saveFile(context, buildString(), username);
    }
}
