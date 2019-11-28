package com.osystems.ivcscholarship.IVCcontrollers;

import android.content.Context;
import android.content.SharedPreferences;

public class IVCspm {
        private static IVCspm spm;
        private Context context;
        private static final String SHARED_PREF_NAME = "myshared";
        private static final String KEY_USER = "user";
        private static final String KEY_USER_EMAIL = "usermail";
        private static final String KEY_USER_NICK = "usernick";
        private static final String KEY_USER_PHONE = "userphone";
        private static final String KEY_USER_DOB = "userdob";
        private static final String KEY_USER_LGA = "userlga";
        private static final String KEY_USER_STATE = "userstate";
        private static final String KEY_USER_GENDER = "usergender";
        private static final String KEY_USER_SCHOOL = "userschool";
        private static final String KEY_USER_ADDRESS = "useraddress";

        private IVCspm(Context contexty){
            context = contexty;
        }

        public static synchronized IVCspm getInstance(Context contextt){
            if(spm == null){
                spm = new IVCspm(contextt);
            }
            return spm;
        }

        boolean userlogin(String user,String usernick, String useremail, String phone, String dob, String lga, String state,
                          String gender, String school, String address){
            SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_USER,user);
            editor.putString(KEY_USER_EMAIL,useremail);
            editor.putString(KEY_USER_NICK,usernick);
            editor.putString(KEY_USER_PHONE,phone);
            editor.putString(KEY_USER_DOB,dob);
            editor.putString(KEY_USER_LGA,lga);
            editor.putString(KEY_USER_STATE,state);
            editor.putString(KEY_USER_GENDER,gender);
            editor.putString(KEY_USER_SCHOOL,school);
            editor.putString(KEY_USER_ADDRESS,address);

            editor.apply();
            return true;
        }

        boolean upadate_user(String user, String useremail, String phone){
            SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_USER,user);
            editor.putString(KEY_USER_EMAIL,useremail);
            editor.putString(KEY_USER_PHONE,phone);

            editor.apply();
            return true;
        }

        boolean isLoggedIn(){
            SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_USER_NICK, null) != null;
        }

        public boolean logout(){
            SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            return true;
        }

        String getKeyUser(){
            SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_USER, null);
        }

        String getKeyUserEmail(){
            SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_USER_EMAIL, "Email");
        }

        String getKeyUserNick(){
            SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_USER_NICK, "Display Name");

        }

        String getKeyUserPhone(){
            SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_USER_PHONE, "Phone");

        }

    String getKeyUserDob() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_DOB, "Date Of Birth");
    }

    String getKeyUserLga() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_LGA, "LGA");
    }

    String getKeyUserState() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_STATE, "State");
    }

    String getKeyUserGender() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_GENDER, "Gender");
    }

    String getKeyUserSchool() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_SCHOOL, "Current School");
    }

    String getKeyUserAddress() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_ADDRESS, "Residential Address");
    }
}
