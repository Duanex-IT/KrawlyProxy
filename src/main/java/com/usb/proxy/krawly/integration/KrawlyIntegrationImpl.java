package com.usb.proxy.krawly.integration;

import com.usb.proxy.krawly.model.AbstractResponse;
import com.usb.proxy.krawly.model.GenericRequest;
import com.usb.proxy.krawly.model.GenericResponse;
import com.usb.proxy.krawly.util.KrawlyMethod;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class KrawlyIntegrationImpl implements KrawlyIntegration {

    private final static org.slf4j.Logger log = LoggerFactory.getLogger(KrawlyIntegrationImpl.class);

    @Autowired
    RestTemplate rest;

    @Value( "${krawly.url}" )
    private String url;

    @Override
    public GenericResponse genericCall(GenericRequest request) {
        log.debug("Calling generic "+url);
        return rest.postForObject(url, request, GenericResponse.class);
    }

    @Override
    public <T extends AbstractResponse> T genericCall(KrawlyMethod method, Map<String, Object> params, Class<T> responseClass) {
        log.debug("Calling generic "+url);
        return rest.postForObject(url, new GenericRequest(method.getMethodName(), params), responseClass);
    }

}
