package com.usb.proxy.krawly.model;

import lombok.Data;

@Data
public class GenericResponse extends AbstractErrorResponse {

    Object retval;

}
