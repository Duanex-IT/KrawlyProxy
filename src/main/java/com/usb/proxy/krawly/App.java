package com.usb.proxy.krawly;

import com.usb.proxy.krawly.util.SSLUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException {
        SSLUtil.turnOffSslChecking();
        SpringApplication.run(App.class, args);
        SSLUtil.turnOnSslChecking();
    }
}