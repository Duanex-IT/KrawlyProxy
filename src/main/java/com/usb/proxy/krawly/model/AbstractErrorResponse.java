package com.usb.proxy.krawly.model;

import lombok.Data;

@Data
public class AbstractErrorResponse extends AbstractResponse {

    KrawlyError error;

}
