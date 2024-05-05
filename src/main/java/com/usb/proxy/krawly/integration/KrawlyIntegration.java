package com.usb.proxy.krawly.integration;

import com.usb.proxy.krawly.model.AbstractResponse;
import com.usb.proxy.krawly.model.GenericRequest;
import com.usb.proxy.krawly.model.GenericResponse;
import com.usb.proxy.krawly.util.KrawlyMethod;

import java.util.Map;

public interface KrawlyIntegration {

    GenericResponse genericCall(GenericRequest request);

    <T extends AbstractResponse> T genericCall(KrawlyMethod method, Map<String, Object> params, Class<T> responseClass);

}
