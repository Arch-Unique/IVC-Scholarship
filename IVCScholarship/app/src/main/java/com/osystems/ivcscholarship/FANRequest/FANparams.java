package com.osystems.ivcscholarship.FANRequest;

public class FANparams {
    private String paramName;
    private String paramValue;

    /**
     *
     * @param paramName This is the name of the POST field which is located on the server
     * @param paramValue This is the value of the post field
     */
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
