package com.usb.proxy.krawly.service;

import com.usb.proxy.krawly.model.GenericRequest;
import com.usb.proxy.krawly.model.GenericResponse;

public interface GenericCallService {

    GenericResponse genericCall(GenericRequest req);

}
