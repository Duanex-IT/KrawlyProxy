package com.usb.proxy.krawly.util;

public enum KrawlyMethod {

    AUTH_REGISTER("register"),
    AUTH_CHANGE_LANG("changeLang"),

    ACC_GET("getAccounts");

    private String methodName;

    KrawlyMethod(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }
}
