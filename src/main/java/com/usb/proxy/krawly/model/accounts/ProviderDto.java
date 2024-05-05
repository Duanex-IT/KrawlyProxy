package com.usb.proxy.krawly.model.accounts;

import lombok.Data;

@Data
public class ProviderDto {

    Integer providerId;
    String name;
    String icon;
    String image;
    String description;
    Integer flags;
    String instructions;

//    “balanceDeclaration”: {…}
//    “balanceSettingsDeclaration”: {…},
//    “metaData”: {…}

}
