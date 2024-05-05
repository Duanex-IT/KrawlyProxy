package com.usb.proxy.krawly.service;

import com.usb.proxy.krawly.integration.KrawlyIntegration;
import com.usb.proxy.krawly.model.GenericResponse;
import com.usb.proxy.krawly.model.auth.AuthResponse;
import com.usb.proxy.krawly.util.KrawlyMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private KrawlyIntegration krawly;

    @Override
    public AuthResponse register(String login) {
        Map<String, Object> params = new HashMap<>();
        params.put("login", login);

        return krawly.genericCall(KrawlyMethod.AUTH_REGISTER, params, AuthResponse.class);
    }

    @Override
    public GenericResponse changeLanguage(String userName, String language) {
        Map<String, Object> params = new HashMap<>();
        params.put("userName", userName);
        params.put("lang", language);

        return krawly.genericCall(KrawlyMethod.AUTH_CHANGE_LANG, params, GenericResponse.class);
    }
}
