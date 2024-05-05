package com.usb.proxy.krawly.integration;

import com.usb.proxy.krawly.App;
import com.usb.proxy.krawly.model.GenericRequest;
import com.usb.proxy.krawly.model.GenericResponse;
import com.usb.proxy.krawly.util.SSLUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class KrawlyIntegrationImplTest {

    @Autowired
    private KrawlyIntegration krawlyIntegration;

    @Before
    public void turnOffSslCheck() throws KeyManagementException, NoSuchAlgorithmException {
        SSLUtil.turnOffSslChecking();
    }

    @After
    public void turnOnSslCheck() throws NoSuchAlgorithmException, KeyManagementException {
        SSLUtil.turnOnSslChecking();
    }

    @Test
    public void testGeneric() {
        GenericRequest req = new GenericRequest();
        req.setMethod("ChangeLang");
        req.addParam("userName", "testuser");
        req.addParam("lang", "ua");

        GenericResponse response = krawlyIntegration.genericCall(req);
        System.out.println(response);
    }

}
