package com.epam.engx.cleancode.naming.collection;

import com.epam.engx.cleancode.naming.thirdpartyjar.CollectionService;
import com.epam.engx.cleancode.naming.thirdpartyjar.Order;

class TrueCollectionServiceStub implements CollectionService {
    @Override
    public boolean isEligibleForCollection(Order order) {
        return true;
    }
}
