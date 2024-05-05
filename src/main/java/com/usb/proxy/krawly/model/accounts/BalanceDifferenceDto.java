package com.usb.proxy.krawly.model.accounts;

import lombok.Data;

@Data
public class BalanceDifferenceDto {

    Integer positive;
    Integer negative;
    //todo diff/abs

}
