package com.usb.proxy.krawly.model.accounts;

public enum BalanceRefreshStatus {

    STABLE(0),//покоится,
    BEFORE_QUEUE(1),//перед постановкой в очередь
    IN_QUEUE(2),//в очереди
    REFRESHING(3),//обновляется
    INFO_NEEDED(4),//требует ввода доп. информации от пользователя
    STABLE_AFTER_ERROR(-1);//покоится после обновления с системной ошибкой

    private int value;

    BalanceRefreshStatus(int i) {
        value = i;
    }

    public int getValue() {
        return value;
    }
}
