package com.usb.proxy.krawly.service;

import com.usb.proxy.krawly.integration.KrawlyIntegration;
import com.usb.proxy.krawly.model.GenericRequest;
import com.usb.proxy.krawly.model.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenericCallServiceImpl implements GenericCallService {

    @Autowired
    private KrawlyIntegration krawly;

    @Override
    public GenericResponse genericCall(GenericRequest req) {
        return krawly.genericCall(req);
    }
}
