package com.epam.engx.cleancode.naming.collection;

import com.epam.engx.cleancode.naming.thirdpartyjar.CollectionService;
import com.epam.engx.cleancode.naming.thirdpartyjar.Submitable;

public class CollectionOrderServiceTestHelper {

    public CollectionOrderService getService(){
        return new CollectionOrderService();
    }

    public void submit(Submitable collectOrderService) {
        ((CollectionOrderService) collectOrderService).submitOrder(new OrderDummy());
    }

    public void setNotificationManager(NotificationManagerMock notificationManagerMock, Submitable collectOrderService) {
        ((CollectionOrderService) collectOrderService).setNotificationManager(notificationManagerMock);
    }

    public void setCollectionService(Submitable collectOrderService, CollectionService collectionServiceStub) {
        ((CollectionOrderService) collectOrderService).setCollectionService(collectionServiceStub);
    }
}
