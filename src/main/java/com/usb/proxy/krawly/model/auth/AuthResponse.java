package com.usb.proxy.krawly.model.auth;

import com.usb.proxy.krawly.model.AbstractResponse;
import lombok.Data;

@Data
public class AuthResponse extends AbstractResponse {

    AuthKrawlyError error;

/*
    public AuthResponse(GenericResponse generic) {
        setSuccess(generic.getSuccess());
        if (generic.getError() != null) {
            AuthKrawlyError error = new AuthKrawlyError();
            error.setRelogin(generic.getError().ge);
            error.setLevel(generic.getError().getLevel());
            error.setMessage(generic.getError().getMessage());
            error.setType(generic.getError().getType());
        }
    }
*/

}
