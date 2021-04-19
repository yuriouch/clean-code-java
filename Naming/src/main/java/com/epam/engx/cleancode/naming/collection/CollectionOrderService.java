package com.epam.engx.cleancode.naming.collection;

import com.epam.engx.cleancode.naming.OrderService;
import com.epam.engx.cleancode.naming.thirdpartyjar.CollectionService;
import com.epam.engx.cleancode.naming.thirdpartyjar.Message;
import com.epam.engx.cleancode.naming.thirdpartyjar.NotificationManager;
import com.epam.engx.cleancode.naming.thirdpartyjar.Order;

import static com.epam.engx.cleancode.naming.NotificationLevel.*;

public class CollectionOrderService implements OrderService {

    private CollectionService collectionService;
    private NotificationManager notificationManager;

    public void submitOrder(Order order) {
        if (collectionService.isEligibleForCollection(order)) {
            notificationManager.notifyCustomer(
                    Message.READY_FOR_COLLECT,
                    INFO_NOTIFICATION_LEVEL.getLevel());
        } else {
            notificationManager.notifyCustomer(
                    Message.IMPOSSIBLE_TO_COLLECT,
                    CRITICAL_NOTIFICATION_LEVEL.getLevel());
        }
    }

    public void setCollectionService(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    public void setNotificationManager(NotificationManager notificationManager) {
        this.notificationManager = notificationManager;
    }
}
