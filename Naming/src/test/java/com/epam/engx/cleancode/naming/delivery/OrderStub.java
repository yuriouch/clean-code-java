package com.epam.engx.cleancode.naming.delivery;

import com.epam.engx.cleancode.naming.thirdpartyjar.Order;
import com.epam.engx.cleancode.naming.thirdpartyjar.Product;

import java.util.Collections;
import java.util.List;

class OrderStub implements Order {

    private String name;

    public OrderStub(String name) {
        this.name = name;
    }

    @Override
    public List<Product> getProducts() {
        return Collections.<Product>singletonList(new Product() {
            @Override
            public String getName() {
                return name;
            }
        });
    }
}
