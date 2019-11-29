package com.osystems.ivcscholarship.EssayController;

import android.widget.EditText;

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

    void convertEssay(){
        new FileConv().saveFile(buildString());
    }
}
