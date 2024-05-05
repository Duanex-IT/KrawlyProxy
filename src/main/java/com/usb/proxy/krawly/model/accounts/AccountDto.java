package com.usb.proxy.krawly.model.accounts;

import lombok.Data;

@Data
public class AccountDto {

    Integer accountId;
    Integer providerId;
    AccountSettingsDto accountSettings;
    BalanceInfoDto balanceInfo;

}
