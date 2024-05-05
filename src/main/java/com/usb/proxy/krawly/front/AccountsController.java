package com.usb.proxy.krawly.front;

import com.usb.proxy.krawly.model.accounts.GetAccountsInputDto;
import com.usb.proxy.krawly.model.accounts.GetAccountsResponse;
import com.usb.proxy.krawly.service.AccountsService;
import io.swagger.annotations.Api;
import org.apache.cxf.feature.Features;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
@Features(features = "org.apache.cxf.feature.LoggingFeature")
@Api(value = "accounts", description = "Krawly accounts controller")
@RestController("accounts")
@RequestMapping("/accounts")
public class AccountsController {

    private final static org.slf4j.Logger log = LoggerFactory.getLogger(AccountsController.class);

    @Autowired
    AccountsService service;

    @WebMethod
    @RequestMapping(method = RequestMethod.POST, value = "getAccounts")
    public GetAccountsResponse getAccounts(GetAccountsInputDto dto) {
        return service.getAccounts(dto);
    }


}
