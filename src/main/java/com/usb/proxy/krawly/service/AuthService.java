package com.usb.proxy.krawly.service;

import com.usb.proxy.krawly.model.GenericResponse;
import com.usb.proxy.krawly.model.auth.AuthResponse;

public interface AuthService {

    AuthResponse register(String login);

    GenericResponse changeLanguage(String userName, String language);
}
