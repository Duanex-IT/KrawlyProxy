package com.usb.proxy.krawly.model.accounts;

import lombok.Data;

import java.util.List;

@Data
public class GetAccountsInputDto {

    String userName;
    List<Integer> providerIds;
    List<Integer> accountIds;

}
