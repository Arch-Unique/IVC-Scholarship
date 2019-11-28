package com.osystems.ivcscholarship.FANRequest;

public class FANparams {
    private String paramName;
    private String paramValue;

    public FANparams(String paramName, String paramValue) {
        this.paramName = paramName;
        this.paramValue = paramValue;
    }

    String getParamName() {
        return paramName;
    }

    String getParamValue() {
        return paramValue;
    }
}
