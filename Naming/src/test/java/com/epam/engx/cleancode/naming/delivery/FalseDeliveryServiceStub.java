package com.epam.engx.cleancode.naming.delivery;

import com.epam.engx.cleancode.naming.thirdpartyjar.DeliveryService;
import com.epam.engx.cleancode.naming.thirdpartyjar.Order;

public class FalseDeliveryServiceStub implements DeliveryService {
    @Override
    public boolean isDeliverable(Order order) {
        return false;
    }
}
