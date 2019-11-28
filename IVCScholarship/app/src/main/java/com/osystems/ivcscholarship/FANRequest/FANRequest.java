package com.osystems.ivcscholarship.FANRequest;

import android.content.Context;
import android.widget.ProgressBar;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ConnectionQuality;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ConnectionQualityChangeListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.UploadProgressListener;

import org.json.JSONObject;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FANRequest {
    private String FAN_URL;
    private Context context;
    private FANparams[] fparams;
    private ProgressBar progressBar;
    private FANupload faNupload;

    FANRequest(Context context, String Url, FANparams[] fparams){
        this.context = context;
        this.FAN_URL = Url;
        this.fparams = fparams;
    }

    FANRequest(Context context, String Url, FANupload faNupload, FANparams[] faNparams){
        this.context = context;
        this.FAN_URL = Url;
        this.faNupload = faNupload;
        this.fparams = faNparams;
    }

    void initialize(FANmethod type){
        AndroidNetworking.initialize(context);
        chooseMethod(type);
    }

    void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    private Map<String , String> getParams(FANparams[] faNparams){
        Map<String, String> params = new HashMap<>();

        for (FANparams faNparam : faNparams) {
            params.put(faNparam.getParamName(), faNparam.getParamValue());
        }

        Collection<String> values = params.values();
        values.removeAll(Collections.singleton(null));

        return params;
    }

    private Map<String, File> getUploadParams(FANupload faNupload){
        Map<String, File> uploadParams = new HashMap<>();
        uploadParams.put(faNupload.getFileKey(), faNupload.getFilename());
        return uploadParams;
    }


    private void post(){
        checkNetworkStatus();
        AndroidNetworking.post(FAN_URL)
                .addBodyParameter(getParams(fparams))
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //do something here
                    }

                    @Override
                    public void onError(ANError anError) {
                        //post error messages
                    }
                });

    }

    private void get(){
        checkNetworkStatus();
        AndroidNetworking.get(FAN_URL)
                .addQueryParameter(getParams(fparams))
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //do something here
                    }

                    @Override
                    public void onError(ANError anError) {
                        //post error messages
                    }
                });
    }

    private void upload(){
        checkNetworkStatus();
        AndroidNetworking.upload(FAN_URL)
                .addMultipartFile(getUploadParams(faNupload))
                .addMultipartParameter(getParams(fparams))
                .setPriority(Priority.HIGH)
                .build()
                .setUploadProgressListener(new UploadProgressListener() {
                    @Override
                    public void onProgress(long bytesUploaded, long totalBytes) {
                        progressBar.setProgress(getPercentageProgress(bytesUploaded, totalBytes));
                        //update progressbar
                    }
                })
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //do something here
                    }

                    @Override
                    public void onError(ANError anError) {
                        //post error messages
                    }
                });
    }

    private void checkNetworkStatus(){
        AndroidNetworking.setConnectionQualityChangeListener(new ConnectionQualityChangeListener() {
            @Override
            public void onChange(ConnectionQuality currentConnectionQuality, int currentBandwidth) {
                if(currentConnectionQuality == ConnectionQuality.UNKNOWN){
                    //cancel request
                    AndroidNetworking.forceCancelAll();
                    //toast a network connection error message
                }
            }
        });
    }

    private void chooseMethod(FANmethod type){
        switch (type){
            case POST:
                post();
                break;
            case GET:
                get();
                break;
            case UPLOAD:
                upload();
                break;
        }
    }

    private int getPercentageProgress(long a, long b){
        return ((int)(a/b) * 100);
    }
}
