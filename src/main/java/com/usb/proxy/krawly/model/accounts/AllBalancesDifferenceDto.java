package com.usb.proxy.krawly.model.accounts;

import lombok.Data;

@Data
public class AllBalancesDifferenceDto {

    BalanceDifferenceDto last;
    BalanceDifferenceDto day;
    BalanceDifferenceDto week;
    BalanceDifferenceDto monthPrev;
    BalanceDifferenceDto month;
    BalanceDifferenceDto year;

}
