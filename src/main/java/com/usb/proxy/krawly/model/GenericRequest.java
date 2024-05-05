package com.usb.proxy.krawly.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class GenericRequest {

    String method;

    Map<String, Object> params;

    public GenericRequest() {
    }

    public GenericRequest(String method, Map<String, Object> params) {
        this.method = method;
        this.params = params;
    }

    public void addParam(String key, String value) {
        if (params==null) {
            params = new HashMap<>();
        }

        params.put(key,value);
    }

}
