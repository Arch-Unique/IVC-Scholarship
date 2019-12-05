package com.osystems.ivcscholarship.FANRequest;

import java.io.File;

public class FANupload {
    private String fileKey;
    private File filename;

    /**
     *
     * @param fileKey This is just how name of the file is going to be posted to the server
     * @param filename This is the file (NB: This is also the file's name) to be uploaded
     */
    public FANupload(String fileKey, File filename) {
        this.fileKey = fileKey;
        this.filename = filename;
    }

    String getFileKey() {
        return fileKey;
    }

    File getFilename() {
        return filename;
    }
}
