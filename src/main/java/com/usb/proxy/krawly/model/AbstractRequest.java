package com.usb.proxy.krawly.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class AbstractRequest {

    String method;

    Map<String, String> params;

    public void addParam(String key, String value) {
        if (params==null) {
            params = new HashMap<>();
        }

        params.put(key,value);
    }

}
