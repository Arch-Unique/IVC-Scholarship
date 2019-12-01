package com.osystems.ivcscholarship.IVCcontrollers;

import android.os.Parcel;
import android.os.Parcelable;

public class IVCgetQuiz implements Parcelable {
    private String ans, question;
    private String[] choice;

    IVCgetQuiz(String ans, String question, String[] choice) {
        this.ans = ans;
        this.question = question;
        this.choice = choice;
    }

    protected IVCgetQuiz(Parcel in) {
        ans = in.readString();
        question = in.readString();
        choice = in.createStringArray();
    }

    public static final Creator<IVCgetQuiz> CREATOR = new Creator<IVCgetQuiz>() {
        @Override
        public IVCgetQuiz createFromParcel(Parcel in) {
            return new IVCgetQuiz(in);
        }

        @Override
        public IVCgetQuiz[] newArray(int size) {
            return new IVCgetQuiz[size];
        }
    };

    public String getAns() {
        return ans;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getChoices() {
        return choice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(ans);
        parcel.writeString(question);
        parcel.writeStringArray(choice);
    }
}
