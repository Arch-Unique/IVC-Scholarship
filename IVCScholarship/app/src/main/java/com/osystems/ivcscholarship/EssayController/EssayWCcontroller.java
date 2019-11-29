package com.osystems.ivcscholarship.EssayController;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class EssayWCcontroller {
    private EditText essayEditText;
    private Context context;
    private String essayText;
    private static final long MAX_WORDS = 500;

    public EssayWCcontroller(Context context, EditText essayText){
        this.essayEditText = essayText;
        this.essayText = essayText.getText().toString();
        this.context = context;
    }

    public void checkWord(){
        essayEditText.addTextChangedListener(textWatcher());
        essayEditText.setOnKeyListener(keyListener());
    }

    private long wordCount(String s){
        long numWords = 0;
        int start = 0;
        boolean prevWhiteSpace = true;
        while (start < s.length()) {
            char c = s.charAt(start++);
            boolean currWhiteSpace = Character.isWhitespace(c);
            if (prevWhiteSpace && !currWhiteSpace) {
                numWords++;
            }
            prevWhiteSpace = currWhiteSpace;
        }
        return numWords;
    }

    private boolean isMaxWords(long a){
        return a > MAX_WORDS;
    }

    private TextWatcher textWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(isMaxWords(wordCount(charSequence.toString()))){
                    //stop editing
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }

    private View.OnKeyListener keyListener(){
        return new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(i == KeyEvent.KEYCODE_ENTER){
                    essayText += "\r\n\r\n";
                    return true;
                }
                return false;
            }
        };
    }

    public String getEssayText() {
        return essayText;
    } //Call only onSubmit
}
