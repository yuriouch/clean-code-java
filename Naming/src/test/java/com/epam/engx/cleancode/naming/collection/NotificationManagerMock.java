package com.epam.engx.cleancode.naming.collection;

import com.epam.engx.cleancode.naming.thirdpartyjar.Message;
import com.epam.engx.cleancode.naming.thirdpartyjar.NotificationManager;

class NotificationManagerMock implements NotificationManager {

    Message message;
    int level;

    @Override
    public void notifyCustomer(Message message, int level) {
        this.message = message;
        this.level = level;
    }
}
