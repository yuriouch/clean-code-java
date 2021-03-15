package com.epam.engx.cleancode.naming.collection;

import com.epam.engx.cleancode.naming.thirdpartyjar.CollectionService;
import com.epam.engx.cleancode.naming.thirdpartyjar.Order;

public class FalseCollectionServiceStub implements CollectionService {
    @Override
    public boolean isEligibleForCollection(Order order) {
        return false;
    }
}
