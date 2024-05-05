package com.usb.proxy.krawly.model.accounts;

import lombok.Data;

@Data
public class BalanceInfoDto {

    Boolean personalized;
    Boolean balanceEnabled;
//    “balanceSettings”: {…},
    AllBalancesDifferenceDto balances;
    Integer refreshInterval;
    Integer lastRefreshTime;
    Integer lastErrorTime;
    String lastErrorMessage;
    BalanceRefreshStatus refreshStatus;


}
