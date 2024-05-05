package com.usb.proxy.krawly.model.accounts;

import lombok.Data;

import java.util.List;

@Data
public class AccountSettingsDto {

    String name;
    List<String> counters;

}
