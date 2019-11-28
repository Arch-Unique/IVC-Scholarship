package com.osystems.ivcscholarship.FANRequest;

import java.io.File;

public class FANupload {
    private String fileKey;
    private File filename;

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
