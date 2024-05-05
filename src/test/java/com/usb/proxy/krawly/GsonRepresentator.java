package com.usb.proxy.krawly;

import com.google.gson.Gson;
import com.usb.proxy.krawly.model.GenericResponse;

import java.util.Date;

public class GsonRepresentator {

    private static final String RESP_ERROR = "{\"success\": false, \"error\": {\"level\": \"user\", " +
            "\"message\": \"User-friendly message\", \"type\": \"SomeErrorType\"}}";
    private static final String RESP_OK = "{\"retval\":{\"refreshingStatus\":{\"635770\":{\"time\":1439719470000,\"error\":\"Не удалось найти карту с последними цифрами 6707\",\"status\":0}}},\"success\":true}";

    public static void main(String[] args) {
        Gson gson = new Gson();

        System.out.println("GenericResponse:");
        GenericResponse errResp = gson.fromJson(RESP_ERROR, GenericResponse.class);
        System.out.println(errResp);

        GenericResponse okResp = gson.fromJson(RESP_OK, GenericResponse.class);
        System.out.println(okResp);
        System.out.println(gson.toJson(okResp));
    }

}
