package com.epam.engx.cleancode.naming.collection;

import com.epam.engx.cleancode.naming.thirdpartyjar.Order;
import com.epam.engx.cleancode.naming.thirdpartyjar.Product;

import java.util.List;

class OrderDummy implements Order {
    @Override
    public List<Product> getProducts() {
        return null;
    }
}
