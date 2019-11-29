package com.osystems.ivcscholarship.IVCcontrollers;

import android.content.Context;

public class IVCuser {

    private String userName;
    private String userPhone;
    private String userEmail;
    private String userResidentialAddress;
    private String userDOB;
    private String userState;
    private String userLGA;
    private String userGender;
    private String userSchool;

    public IVCuser(Context context){
        this.userName = IVCspm.getInstance(context).getKeyUser();
        this.userEmail = IVCspm.getInstance(context).getKeyUserEmail();
        this.userPhone = IVCspm.getInstance(context).getKeyUserPhone();
        this.userDOB = IVCspm.getInstance(context).getKeyUserDob();
        this.userResidentialAddress = IVCspm.getInstance(context).getKeyUserAddress();
        this.userState = IVCspm.getInstance(context).getKeyUserState();
        this.userLGA = IVCspm.getInstance(context).getKeyUserLga();
        this.userGender = IVCspm.getInstance(context).getKeyUserGender();
        this.userSchool = IVCspm.getInstance(context).getKeyUserSchool();
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserResidentialAddress() {
        return userResidentialAddress;
    }

    public String getUserDOB() {
        return userDOB;
    }

    public String getUserState() {
        return userState;
    }

    public String getUserLGA() {
        return userLGA;
    }

    public String getUserGender() {
        return userGender;
    }

    public String getUserSchool() {
        return userSchool;
    }
}
