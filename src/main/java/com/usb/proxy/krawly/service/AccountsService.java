package com.usb.proxy.krawly.service;

import com.usb.proxy.krawly.model.accounts.GetAccountsInputDto;
import com.usb.proxy.krawly.model.accounts.GetAccountsResponse;

public interface AccountsService {

    GetAccountsResponse getAccounts(GetAccountsInputDto dto);

}
