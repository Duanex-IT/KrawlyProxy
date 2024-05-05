package com.usb.proxy.krawly.model.auth;

import com.usb.proxy.krawly.model.KrawlyError;
import lombok.Data;

@Data
public class AuthKrawlyError extends KrawlyError {

    Boolean relogin;

}
