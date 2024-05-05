package com.usb.proxy.krawly.front;

import com.usb.proxy.krawly.model.GenericRequest;
import com.usb.proxy.krawly.model.GenericResponse;
import com.usb.proxy.krawly.service.GenericCallService;
import org.apache.cxf.feature.Features;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
@Features(features = "org.apache.cxf.feature.LoggingFeature")
@RestController("generic")
@RequestMapping("/generic")
public class GenericController {

    private final static org.slf4j.Logger log = LoggerFactory.getLogger(GenericController.class);

    @Autowired
    GenericCallService service;

    @WebMethod
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public GenericResponse genericCall(@RequestBody @WebParam(name = "request") GenericRequest req) {
        log.debug(req.toString());
        return service.genericCall(req);
    }

}
