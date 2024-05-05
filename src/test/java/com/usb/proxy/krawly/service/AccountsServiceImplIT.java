package com.usb.proxy.krawly.service;

import com.usb.proxy.krawly.App;
import com.usb.proxy.krawly.model.accounts.GetAccountsInputDto;
import com.usb.proxy.krawly.model.accounts.GetAccountsResponse;
import com.usb.proxy.krawly.util.SSLUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertNotNull;

//@RunWith(SpringJUnit4ClassRunner.class)//todo exclude web config
//@SpringApplicationConfiguration(classes = {AppConfig.class})
//@ComponentScan(excludeFilters = {
//        @ComponentScan.Filter(KrawlyWebConfig.class),
//        @ComponentScan.Filter(App.class),
//        @ComponentScan.Filter(pattern = "com.usb.proxy.krawly.front.**")})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
//@IntegrationTest({"server.port:0"})
public class AccountsServiceImplIT {

    @Autowired
    AccountsService service;

    @Before//todo to base test
    public void before() throws KeyManagementException, NoSuchAlgorithmException {
        SSLUtil.turnOffSslChecking();
    }

    @After
    public void after() throws NoSuchAlgorithmException, KeyManagementException {
        SSLUtil.turnOnSslChecking();
    }

    @Test
    public void testGetAccounts() {
        GetAccountsInputDto dto = new GetAccountsInputDto();
        dto.setUserName("testuser");

        GetAccountsResponse resp = service.getAccounts(dto);

        assertNotNull(resp);
        assertNotNull(resp.getAccounts());
        assertNotNull(resp.getProviders());
    }

}
