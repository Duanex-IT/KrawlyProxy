package com.usb.proxy.krawly.service;

import com.usb.proxy.krawly.integration.KrawlyIntegration;
import com.usb.proxy.krawly.model.accounts.GetAccountsInputDto;
import com.usb.proxy.krawly.model.accounts.GetAccountsResponse;
import com.usb.proxy.krawly.util.KrawlyMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountsServiceImpl implements AccountsService {

    @Autowired
    private KrawlyIntegration krawly;

    @Override
    public GetAccountsResponse getAccounts(GetAccountsInputDto dto) {
        Map<String, Object> params = new HashMap<>();
        params.put("userName", dto.getUserName());
        params.put("providerIds", dto.getProviderIds());
        params.put("accountIds", dto.getAccountIds());

        return krawly.genericCall(KrawlyMethod.ACC_GET, params, GetAccountsResponse.class);

    }
}
