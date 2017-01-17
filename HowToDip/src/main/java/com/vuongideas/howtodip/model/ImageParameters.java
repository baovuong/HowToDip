package com.vuongideas.howtodip.model;

import java.util.Base64;
import java.util.Map;

public class ImageParameters {
    private byte[] imageData;
    private Map<String, Object> parameters;
    
    public ImageParameters(byte[] imageData, Map<String, Object> parameters) {
        this.setImageData(imageData);
        this.setParameters(parameters);
    }
    
    public ImageParameters(String base64Encoded, Map<String, Object> parameters) {
        this(Base64.getDecoder().decode(base64Encoded), parameters);
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }
}
