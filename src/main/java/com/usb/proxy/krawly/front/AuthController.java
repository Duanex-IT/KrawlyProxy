package com.usb.proxy.krawly.front;

import com.usb.proxy.krawly.model.GenericResponse;
import com.usb.proxy.krawly.model.auth.AuthResponse;
import com.usb.proxy.krawly.service.AuthService;
import io.swagger.annotations.Api;
import org.apache.cxf.feature.Features;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
@Features(features = "org.apache.cxf.feature.LoggingFeature")
@Api(value = "auth", description = "Krawly authorization controller")
@RestController("auth")
@RequestMapping("/auth")
public class AuthController {

    private final static org.slf4j.Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    AuthService service;

    @WebMethod
    @RequestMapping(method = RequestMethod.PUT, value = "register/{login}")
    public AuthResponse register(@PathVariable("login") @WebParam(name = "login") String login) {
        return service.register(login);
    }

    @WebMethod
    @RequestMapping(method = RequestMethod.GET, value = "changeLanguage")
    public GenericResponse changeLanguage(@RequestParam @WebParam(name = "userName") String userName,
                                          @RequestParam @WebParam(name = "language") String language) {
        return service.changeLanguage(userName, language);
    }


}
