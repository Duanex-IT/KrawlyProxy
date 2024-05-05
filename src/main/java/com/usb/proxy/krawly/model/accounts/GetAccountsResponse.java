package com.usb.proxy.krawly.model.accounts;

import com.usb.proxy.krawly.model.AbstractErrorResponse;
import lombok.Data;

import java.util.List;

@Data
public class GetAccountsResponse extends AbstractErrorResponse {

    List<AccountDto> accounts;

    List<ProviderDto> providers;

}
